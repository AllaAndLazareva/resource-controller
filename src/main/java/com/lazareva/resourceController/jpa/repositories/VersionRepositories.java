package com.lazareva.resourceController.jpa.repositories;

import com.lazareva.resourceController.jpa.entities.VersionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VersionRepositories extends JpaRepository<VersionEntity, String> {

    List<VersionEntity> getAllBy();

  //  Optional<VersionEntity> getAllByVersion();
}
