package com.lazareva.resourceController.jpa.repositories;

import com.lazareva.resourceController.jpa.entities.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepositories extends JpaRepository<ResourceEntity, String> {

    Optional<ResourceEntity> getResourceEntityById(String id);


    @Query("select r from ResourceEntity r inner join r.applications applications where applications.id = ?1")
    List<ResourceEntity> getResourceEntitiesByApplicationsId(String applicationId);

    @Query("select r from ResourceEntity r inner join r.applications applications where applications.name = ?1")
    List<ResourceEntity> getResourceEntitiesByApplicationsName(String applicationName);

    @Query("select r from ResourceEntity r inner join r.currentValue versionData where versionData.id = ?1")
    Optional<ResourceEntity> getResourceEntityByCurrentValueId(String currentValue);

    @Query("select r from ResourceEntity r inner join r.value versionData where versionData.id = ?1")
    Optional<ResourceEntity> getResourceEntityByValueId(String value);


}
