package com.lazareva.resourceController.provider.impl;

import com.lazareva.resourceController.jpa.entities.ApplicationEntity;
import com.lazareva.resourceController.jpa.entities.VersionEntity;
import com.lazareva.resourceController.jpa.repositories.ApplicationRepositories;
import com.lazareva.resourceController.jpa.repositories.VersionRepositories;
import com.lazareva.resourceController.mapper.BaseMapper;
import com.lazareva.resourceController.models.VersionModel;
import com.lazareva.resourceController.provider.VersionProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JPAVersionProvider implements VersionProvider {
    private final VersionRepositories versionRepositories;
    private final BaseMapper<VersionEntity, VersionModel> mapper;

    private final ApplicationRepositories applicationRepositories;

    @Override
    @Transactional
    public VersionModel save(VersionModel versionModel) {
        ApplicationEntity applicationEntity = applicationRepositories.getReferenceById(versionModel.getApplicationId());
        applicationEntity.getResources().stream().filter(resourceEntity -> resourceEntity.getKey().equals(versionModel.getResourceId()));
        VersionEntity versionEntity = mapper.toEntity(versionModel);
        if (versionModel.getVersionId() != null) {
            throw new RuntimeException("Only new version. Current version has versionId " + versionModel.getVersionId());
        }
        versionEntity.setVersion(UUID.randomUUID().toString());
        return mapper.toModel(versionRepositories.save(versionEntity));
    }

    @Async
    public void update(VersionModel versionModel) {
        if (versionModel.getVersionId() == null) {
            throw new RuntimeException("Only existing version. Current version doesn't have id.");
        }
        versionRepositories.save(mapper.toEntity(versionModel));

    }
}
