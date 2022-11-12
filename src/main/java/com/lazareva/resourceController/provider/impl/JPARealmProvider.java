package com.lazareva.resourceController.provider.impl;

import com.lazareva.resourceController.jpa.entities.RealmEntity;
import com.lazareva.resourceController.jpa.repositories.RealmRepositories;
import com.lazareva.resourceController.mapper.BaseMapper;
import com.lazareva.resourceController.models.RealmModel;
import com.lazareva.resourceController.provider.RealmProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JPARealmProvider implements RealmProvider {
    private final RealmRepositories realmRepositories;
    private final BaseMapper<RealmEntity, RealmModel> mapper;

    @Override
    public List<RealmModel> allRealms() {
        return realmRepositories.findAll()
                .stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public RealmModel save(RealmModel realmModel) {
        RealmEntity realmEntity = mapper.toEntity(realmModel);
        if (realmModel.getId() != null) {
            throw new RuntimeException("Only new realm. Current realm has id " + realmModel.getId());
        }
        realmEntity.setId(UUID.randomUUID().toString());
        return mapper.toModel(realmRepositories.save(realmEntity));
    }

    @Async
    public void update(RealmModel realmModel) {
        if (realmModel.getId() == null) {
            throw new RuntimeException("Only existing model. Current model doesn't have id.");
        }
        realmRepositories.save(mapper.toEntity(realmModel));
    }
}
