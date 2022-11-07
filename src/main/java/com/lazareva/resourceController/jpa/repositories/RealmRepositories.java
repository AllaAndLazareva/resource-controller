package com.lazareva.resourceController.jpa.repositories;

import com.lazareva.resourceController.jpa.entities.RealmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RealmRepositories extends JpaRepository<RealmEntity, String> {

    @Deprecated
    @Query("select r from RealmEntity r inner join r.applications applications where applications.id = ?1")
    Optional<RealmEntity> getRealmEntityByApplicationsId(String applicationId);
}
