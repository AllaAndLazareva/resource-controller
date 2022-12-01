package com.lazareva.resourceController.mapper.impl;

import com.lazareva.resourceController.jpa.entities.RealmEntity;
import com.lazareva.resourceController.mapper.BaseMapper;
import com.lazareva.resourceController.models.RealmModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RealmMapper extends BaseMapper<RealmEntity, RealmModel> {
}
