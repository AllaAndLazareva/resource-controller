package com.lazareva.resourceController.jpa.repositories;

import com.lazareva.resourceController.jpa.entities.ValueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ValueRepositories extends JpaRepository<ValueEntity, String> {

List<ValueEntity> getAllBy ();

Optional<ValueEntity> getAllByValue(String valueKey);
}