package com.lazareva.resourceController.mapper.impl;

import com.lazareva.resourceController.jpa.entities.ApplicationEntity;
import com.lazareva.resourceController.jpa.entities.ResourceEntity;
import com.lazareva.resourceController.jpa.repositories.ApplicationRepositories;
import com.lazareva.resourceController.jpa.repositories.ResourceRepositories;
import com.lazareva.resourceController.mapper.BaseMapper;
import com.lazareva.resourceController.models.ResourceModel;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
@RequiredArgsConstructor
public abstract class ResourceMapper implements BaseMapper<ResourceEntity, ResourceModel> {

    private final ApplicationRepositories appRepositories;

    private final ResourceRepositories resourceRepositories;

    // FIXME: 20.11.22 Нейкая лажа... но на что хватило мозги
    @Override
    public ResourceEntity toEntity(ResourceModel resourceModel) {
        if (Strings.isNotBlank(resourceModel.getId())) {
            ResourceEntity reference = resourceRepositories.getReferenceById(resourceModel.getId());
            addResourceToApplication(resourceModel, reference);
        }

    }

    private void addResourceToApplication(ResourceModel resourceModel, ResourceEntity reference) {
        if (reference.getApplications() != null && resourceModel.getApplicationId() != null) {
            boolean containsApplication = reference.getApplications()
                    .stream()
                    .anyMatch(applicationEntity -> applicationEntity.getId().equals(resourceModel.getId()));
            if (!containsApplication) {
                ApplicationEntity application = appRepositories.getReferenceById(resourceModel.getId());
                application.getResources().add(reference);
                reference.getApplications().add(application);
            }
        }
    }


    @Override
    public abstract ResourceModel toModel(ResourceEntity resourceEntity);
}
