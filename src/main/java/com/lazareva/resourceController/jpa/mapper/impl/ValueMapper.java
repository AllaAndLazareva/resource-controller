package com.lazareva.resourceController.jpa.mapper.impl;

import com.lazareva.resourceController.jpa.entities.ValueEntity;
import com.lazareva.resourceController.jpa.mapper.BaseMapper;
import com.lazareva.resourceController.jpa.models.ValueModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ValueMapper extends BaseMapper<ValueEntity, ValueModel> {
}
