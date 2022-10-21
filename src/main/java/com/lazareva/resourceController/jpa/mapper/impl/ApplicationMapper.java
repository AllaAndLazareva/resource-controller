package com.lazareva.resourceController.jpa.mapper.impl;

import com.lazareva.resourceController.jpa.entities.ApplicationEntity;
import com.lazareva.resourceController.jpa.mapper.BaseMapper;
import com.lazareva.resourceController.jpa.models.ApplicationModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationMapper extends BaseMapper<ApplicationEntity, ApplicationModel> {
}
