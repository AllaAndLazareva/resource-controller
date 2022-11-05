package com.lazareva.resourceController.mapper.impl;

import com.graphql.model.Realm;
import com.lazareva.resourceController.jpa.entities.RealmEntity;
import com.lazareva.resourceController.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FullRealmEntityMapper extends BaseMapper<RealmEntity, Realm> {
}
