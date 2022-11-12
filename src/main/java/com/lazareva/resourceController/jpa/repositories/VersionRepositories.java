package com.lazareva.resourceController.jpa.repositories;

import com.lazareva.resourceController.jpa.entities.VersionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionRepositories extends JpaRepository<VersionEntity, String> {
}
