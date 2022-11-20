package com.lazareva.resourceController.mapper.impl;

import com.lazareva.resourceController.jpa.entities.VersionDataEntity;
import com.lazareva.resourceController.mapper.BaseMapper;
import com.lazareva.resourceController.models.ResourceModel;

public abstract class VersionDataResourceMapper implements BaseMapper<VersionDataEntity, ResourceModel> {


    @Override
    public VersionDataEntity toEntity(ResourceModel resourceModel) {
        return null;
    }

    @Override
    public ResourceModel toModel(VersionDataEntity versionDataEntity) {
        return null;
    }
}
