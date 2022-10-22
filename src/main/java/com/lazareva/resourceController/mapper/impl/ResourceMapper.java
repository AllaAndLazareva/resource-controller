package com.lazareva.resourceController.mapper.impl;

import com.lazareva.resourceController.jpa.entities.ResourceEntity;
import com.lazareva.resourceController.mapper.BaseMapper;
import com.lazareva.resourceController.models.ResourceModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResourceMapper extends BaseMapper<ResourceEntity, ResourceModel> {
}
