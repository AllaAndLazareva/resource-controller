package com.lazareva.resourceController.jpa.mapper.impl;

import com.lazareva.resourceController.jpa.entities.VersionEntity;
import com.lazareva.resourceController.jpa.mapper.BaseMapper;
import com.lazareva.resourceController.jpa.models.VersionModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VersionMapper extends BaseMapper<VersionEntity, VersionModel> {
}
