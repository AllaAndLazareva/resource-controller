package com.lazareva.resourceController.jpa.mapper.impl;

import com.lazareva.resourceController.jpa.entities.VersionDataEntity;
import com.lazareva.resourceController.jpa.mapper.BaseMapper;
import com.lazareva.resourceController.jpa.models.VersionDataModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VersionDataMapper extends BaseMapper<VersionDataEntity, VersionDataModel> {
}
