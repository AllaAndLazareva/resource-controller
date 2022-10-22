package com.lazareva.resourceController.mapper.impl;

import com.lazareva.resourceController.jpa.entities.ValueEntity;
import com.lazareva.resourceController.mapper.BaseMapper;
import com.lazareva.resourceController.models.ValueModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ValueMapper extends BaseMapper<ValueEntity, ValueModel> {
}
