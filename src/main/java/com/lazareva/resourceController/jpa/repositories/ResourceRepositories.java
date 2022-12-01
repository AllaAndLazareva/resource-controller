package com.lazareva.resourceController.jpa.repositories;

import com.lazareva.resourceController.jpa.entities.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepositories extends JpaRepository<ResourceEntity, String> {

    List<ResourceEntity> getResourceEntitiesByApplicationsId(String applicationId);
}
