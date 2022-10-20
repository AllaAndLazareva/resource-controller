package com.lazareva.resourceController.mapper.impl;

import com.lazareva.resourceController.jpa.entities.RealmEntity;
import com.lazareva.resourceController.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RealmMapper extends BaseMapper<RealmEntity,RealmEntity>
{
}
