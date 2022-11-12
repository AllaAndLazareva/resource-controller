package com.lazareva.resourceController.jpa.repositories;

import com.lazareva.resourceController.jpa.entities.ApplicationEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepositories extends JpaRepository<ApplicationEntity, String> {
    @EntityGraph(attributePaths = {"resources.currentValue"})
    List<ApplicationEntity> findApplicationEntitiesByRealmId(String realmId);

}
