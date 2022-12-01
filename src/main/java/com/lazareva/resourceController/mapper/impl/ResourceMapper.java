package com.lazareva.resourceController.mapper.impl;

import com.lazareva.resourceController.jpa.entities.ApplicationEntity;
import com.lazareva.resourceController.jpa.entities.ResourceEntity;
import com.lazareva.resourceController.jpa.repositories.ApplicationRepositories;
import com.lazareva.resourceController.jpa.repositories.ResourceRepositories;
import com.lazareva.resourceController.mapper.BaseMapper;
import com.lazareva.resourceController.models.ResourceModel;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = {Collections.class, ApplicationEntity.class})
public abstract class ResourceMapper implements BaseMapper<ResourceEntity, ResourceModel> {

    @Getter
    @Autowired
    private ApplicationRepositories applicationRepositories;

    @Autowired
    private ResourceRepositories resourceRepositories;

    @Override
    @Mapping(target = "key", source = "resourceKey")
    @Mapping(target = "currentValue", source = "resourceValue")
    @Mapping(target = "applications", expression = "java(applicationsReferences(resourceModel))")
    public abstract ResourceEntity toEntity(ResourceModel resourceModel);

    @Mapping(target = "resourceValue", source = "currentValue")
    @Mapping(target = "resourceKey", source = "key")
    @Mapping(target = "applicationIds", expression = "java(resourceEntity.getApplications()!=null?resourceEntity.getApplications().stream().map(ApplicationEntity::getId).toList():Collections.emptyList())")
    @Override
    public abstract ResourceModel toModel(ResourceEntity resourceEntity);


    protected List<ApplicationEntity> applicationsReferences(ResourceModel resourceModel) {
        List<String> applicationIds = resourceModel.getApplicationIds() != null ? resourceModel.getApplicationIds() : Collections.emptyList();
        if (Strings.isNotBlank(resourceModel.getId())) {
            return applicationsReferencesFromCurrentResource(resourceModel, applicationIds);
        }
        return applicationsReferencesForCurrentResources(applicationIds);
    }

    private List<ApplicationEntity> applicationsReferencesFromCurrentResource(ResourceModel resourceModel, List<String> applicationIds) {
        ResourceEntity resource = resourceRepositories.getReferenceById(resourceModel.getId());
        applicationIds.stream().filter(id -> !resource.containsApplication(id)).forEach(id -> {
            resource.addApplications(applicationRepositories.getReferenceById(id));
        });
        return resource.getApplications();
    }

    private List<ApplicationEntity> applicationsReferencesForCurrentResources(List<String> applicationIds) {
        return applicationIds.stream().map(id -> applicationRepositories.getReferenceById(id)).toList();
    }
}