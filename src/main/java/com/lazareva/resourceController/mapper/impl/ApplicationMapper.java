package com.lazareva.resourceController.mapper.impl;

import com.lazareva.resourceController.jpa.entities.ApplicationEntity;
import com.lazareva.resourceController.jpa.repositories.RealmRepositories;
import com.lazareva.resourceController.mapper.BaseMapper;
import com.lazareva.resourceController.models.ApplicationModel;
import lombok.Getter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ApplicationMapper implements BaseMapper<ApplicationEntity, ApplicationModel> {

    @Getter
    @Autowired
    private RealmRepositories repositories;

    @Mapping(target = "realm", expression = "java(getRepositories().findById(applicationModel.getRealmId()).get())")
    public abstract ApplicationEntity toEntity(ApplicationModel applicationModel);

    @Mapping(target = "realmId", source = "realm.id")
    public abstract ApplicationModel toModel(ApplicationEntity applicationEntity);
}
