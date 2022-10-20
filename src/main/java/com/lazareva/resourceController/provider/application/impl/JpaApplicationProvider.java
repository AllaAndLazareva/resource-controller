package com.lazareva.resourceController.provider.application.impl;

import com.lazareva.resourceController.jpa.entities.ApplicationEntity;
import com.lazareva.resourceController.jpa.repositories.ApplicationRepositories;
import com.lazareva.resourceController.mapper.BaseMapper;
import com.lazareva.resourceController.model.ApplicationModel;
import com.lazareva.resourceController.provider.application.ApplicationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class JpaApplicationProvider implements ApplicationProvider
{
    private final ApplicationRepositories applicationRepositories;
    private final BaseMapper<ApplicationEntity, ApplicationModel> mapper;

    @Override
    public List<ApplicationModel> getAll()
    {
        return applicationRepositories.getAllBy().stream()
                                      .map(mapper::toModel)
                                      .collect(Collectors.toList());
    }

    @Override
    public ApplicationModel save(ApplicationModel model)
    {
        ApplicationEntity applicationEntity = mapper.toEntity(model);
        if (model.getId() != null)
        {
            throw new RuntimeException("only new model. Current model hase id " + model.getId());
        }
        applicationEntity.setId(UUID.randomUUID().toString());
        return mapper.toModel(applicationRepositories.save(applicationEntity));
    }

    public void update(ApplicationModel model)
    {
        if (model.getId() == null)
        {
            throw new RuntimeException("only existing model. Current model hasn't id ");
        }
        applicationRepositories.save(mapper.toEntity(model));
    }


}

