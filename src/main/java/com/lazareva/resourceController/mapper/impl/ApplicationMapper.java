package com.lazareva.resourceController.mapper.impl;

import com.lazareva.resourceController.jpa.entities.ApplicationEntity;
import com.lazareva.resourceController.mapper.BaseMapper;
import com.lazareva.resourceController.models.ApplicationModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationMapper extends BaseMapper<ApplicationEntity, ApplicationModel> {
}
