package com.lazareva.resourceController.jpa.mapper.impl;

import com.lazareva.resourceController.jpa.entities.RealmEntity;
import com.lazareva.resourceController.jpa.mapper.BaseMapper;
import com.lazareva.resourceController.jpa.models.RealmModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RealmMapper extends BaseMapper<RealmEntity, RealmModel> {
}
