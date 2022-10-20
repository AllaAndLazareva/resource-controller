package com.lazareva.resourceController.jpa.repositories;

import com.lazareva.resourceController.jpa.entities.RealmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealmRepositories extends JpaRepository<RealmEntity,String>
{
}
