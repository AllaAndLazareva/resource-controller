package com.lazareva.resourceController.jpa.mapper.impl;

import com.lazareva.resourceController.jpa.entities.ResourceEntity;
import com.lazareva.resourceController.jpa.mapper.BaseMapper;
import com.lazareva.resourceController.jpa.models.ResourceModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResourceMapper extends BaseMapper<ResourceEntity, ResourceModel> {
}
