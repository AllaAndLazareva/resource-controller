package com.lazareva.resourceController.provider.impl;

import com.lazareva.resourceController.jpa.entities.ResourceEntity;
import com.lazareva.resourceController.jpa.repositories.ResourceRepositories;
import com.lazareva.resourceController.mapper.BaseMapper;
import com.lazareva.resourceController.models.ResourceModel;
import com.lazareva.resourceController.provider.ResourceProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JPAResourceProvider implements ResourceProvider {

    private final ResourceRepositories resourceRepositories;
    private final BaseMapper<ResourceEntity, ResourceModel> mapper;

    @Override
    public ResourceModel getResourceById(String id) {
        ResourceEntity resourceEntity = resourceRepositories.getResourceEntityById(id)
                .orElseThrow();
        return mapper.toModel(resourceEntity);
    }

    @Override
    public List<ResourceModel> getResourceByApplicationId(String applicationId) {
        return resourceRepositories.getResourceEntitiesByApplicationsId(applicationId)
                .stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<ResourceModel> getResourceByApplicationName(String applicationName) {
        return resourceRepositories.getResourceEntitiesByApplicationsName(applicationName)
                .stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

  /*  @Override
    public ResourceModel getResourceByCurrentValue(String currentValue) {
        ResourceEntity resourceEntity = resourceRepositories.getResourceEntityByCurrentValueId(currentValue)
                .orElseThrow();

        return mapper.toModel(resourceEntity);
    }

    @Override
    public ResourceModel getResourceByValue(String value) {
        ResourceEntity resourceEntity = resourceRepositories.getResourceEntityByValueId(value)
                .orElseThrow();
        return mapper.toModel(resourceEntity);
    }*/

    @Override
    public ResourceModel save(ResourceModel resourceModel) {
        ResourceEntity resourceEntity = mapper.toEntity(resourceModel);
        if (resourceModel.getId() != null) {
            throw new RuntimeException("Only new resource. Current resource has id " + resourceModel.getId());
        }
        resourceEntity.setId(UUID.randomUUID().toString());
        return mapper.toModel(resourceRepositories.save(resourceEntity));
    }

    @Override
    public void update(ResourceModel resourceModel) {
        if (resourceModel.getId() == null) {
            throw new RuntimeException("Only existing model. Current model doesn't have id.");
        }
        resourceRepositories.save(mapper.toEntity(resourceModel));

    }
}
