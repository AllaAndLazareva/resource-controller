package com.lazareva.resourceController.mapper.impl;

import com.lazareva.resourceController.jpa.entities.VersionEntity;
import com.lazareva.resourceController.mapper.BaseMapper;
import com.lazareva.resourceController.models.VersionModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VersionMapper extends BaseMapper<VersionEntity, VersionModel> {
}
