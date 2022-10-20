package com.lazareva.resourceController.model;

import com.lazareva.resourceController.jpa.entities.VersionDataEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link VersionDataEntity} entity
 */
@Data
@NoArgsConstructor
public class VersionDataModel implements Serializable
{
    private String id;
    private VersionModel version;
    private ValueModel value;
}