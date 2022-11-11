package com.lazareva.resourceController.provider.impl;

import com.lazareva.resourceController.jpa.entities.ValueEntity;
import com.lazareva.resourceController.jpa.repositories.ValueRepositories;
import com.lazareva.resourceController.mapper.BaseMapper;
import com.lazareva.resourceController.models.ValueModel;
import com.lazareva.resourceController.provider.ValueProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JPAValueProvider implements ValueProvider {
    private final ValueRepositories valueRepositories;
    private final BaseMapper<ValueEntity, ValueModel> mapper;

    @Override
    public List<ValueModel> getAllBy() {
        return valueRepositories.findAll()
                .stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public ValueModel getAllByValue(String valueKey) {
        ValueEntity valueEntity = valueRepositories.getValueEntityByValue(valueKey)
                .orElseThrow();
        return mapper.toModel(valueEntity);

    }

    @Override
    public ValueModel save(ValueModel valueModel) {
        ValueEntity valueEntity = mapper.toEntity(valueModel);
        if (valueModel.getValueKey() != null) {
            throw new RuntimeException("Only new value. Current value has key " + valueModel.getValueKey());
        }
        valueEntity.setValue(UUID.randomUUID().toString());
        return mapper.toModel(valueRepositories.save(valueEntity));
    }

    @Async
    public void update(ValueModel valueModel) {
        if (valueModel.getValueKey() == null) {
            throw new RuntimeException("Only existing model. Current model doesn't have id.");
        }
        valueRepositories.save(mapper.toEntity(valueModel));

    }
}
