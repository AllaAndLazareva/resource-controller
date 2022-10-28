package com.lazareva.resourceController.provider.impl;

import com.lazareva.resourceController.jpa.entities.VersionDataEntity;
import com.lazareva.resourceController.jpa.repositories.VersionDataRepositories;
import com.lazareva.resourceController.mapper.BaseMapper;
import com.lazareva.resourceController.models.VersionDataModel;
import com.lazareva.resourceController.provider.VersionDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JPAVersionDataProvider implements VersionDataProvider {
    private final VersionDataRepositories versionDataRepositories;
    private final BaseMapper<VersionDataEntity, VersionDataModel> mapper;

    @Override
    public VersionDataModel getVersionDataById(String id) {
        VersionDataEntity versionDataEntity = versionDataRepositories.getVersionDataEntityById(id)
                .orElseThrow();
        return mapper.toModel(versionDataEntity);
    }


    @Override
    public VersionDataModel save(VersionDataModel versionDataModel) {
        VersionDataEntity versionDataEntity = mapper.toEntity(versionDataModel);
        if (versionDataModel.getId() != null) {
            throw new RuntimeException("Only new versionData. Current versionData has id " + versionDataModel.getId());
        }
        versionDataEntity.setId(UUID.randomUUID().toString());
        return mapper.toModel(versionDataRepositories.save(versionDataEntity));
    }

    @Async
    public void update(VersionDataModel versionDataModel) {
        if (versionDataModel.getId() == null) {
            throw new RuntimeException("Only existing versionData. Current versionData doesn't have id.");
        }
        versionDataRepositories.save(mapper.toEntity(versionDataModel));
    }
}
