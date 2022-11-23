package com.lazareva.resourceController.provider.impl;

import com.lazareva.resourceController.jpa.entities.ApplicationEntity;
import com.lazareva.resourceController.jpa.repositories.ApplicationRepositories;
import com.lazareva.resourceController.mapper.BaseMapper;
import com.lazareva.resourceController.models.ApplicationModel;
import com.lazareva.resourceController.provider.ApplicationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JPAApplicationProvider implements ApplicationProvider {

    private final ApplicationRepositories applicationRepositories;
    private final BaseMapper<ApplicationEntity, ApplicationModel> mapper;

    @Override
    public List<ApplicationModel> getAllByRealmId(String realmId) {
        return applicationRepositories.findApplicationEntitiesByRealmId(realmId)
                .stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public ApplicationModel save(ApplicationModel model) {
        ApplicationEntity applicationEntity = mapper.toEntity(model);
        if (model.getId() == null) {
            applicationEntity.setId(UUID.randomUUID().toString());
        }
        return mapper.toModel(applicationRepositories.save(applicationEntity));
    }

    @Async
    public void update(ApplicationModel model) {
        if (model.getId() == null) {
            throw new RuntimeException("Only existing model. Current model doesn't have id.");
        }
        applicationRepositories.save(mapper.toEntity(model));
    }
}
