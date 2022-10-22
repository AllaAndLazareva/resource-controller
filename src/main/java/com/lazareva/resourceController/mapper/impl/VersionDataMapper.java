package com.lazareva.resourceController.mapper.impl;

import com.lazareva.resourceController.jpa.entities.VersionDataEntity;
import com.lazareva.resourceController.mapper.BaseMapper;
import com.lazareva.resourceController.models.VersionDataModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VersionDataMapper extends BaseMapper<VersionDataEntity, VersionDataModel> {
}
