package com.lazareva.resourceController.jpa.repositories;

import com.lazareva.resourceController.jpa.entities.VersionDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VersionDataRepositories extends JpaRepository<VersionDataEntity, String> {

    Optional<VersionDataEntity> getVersionDataEntityByValue(String valueKey);

    Optional<VersionDataEntity> getVersionDataEntityById(String id);


}
