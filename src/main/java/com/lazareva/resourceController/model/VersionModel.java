package com.lazareva.resourceController.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link com.lazareva.resourceController.jpa.entities.VersionEntity} entity
 */
@Data
@NoArgsConstructor
public class VersionModel implements Serializable
{
    private String version;
    private String description;
}