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
        return mapper.toModel(resourceRepositories.getReferenceById(id));
    }

    @Override
    public List<ResourceModel> getResourceByApplicationId(String applicationId) {
        return resourceRepositories.getResourceEntitiesByApplicationsId(applicationId)
                .stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public ResourceModel save(ResourceModel resourceModel) {
        return mapper.toModel(resourceRepositories.save(mapper.toEntity(resourceModel)));
    }
}
