package com.lazareva.resourceController.model;

import com.lazareva.resourceController.jpa.entities.ResourceEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link ResourceEntity} entity
 */
@Data
@NoArgsConstructor
public class ResourceModel implements Serializable
{
    private String id;
    private String key;
    private List<VersionDataModel> values;
    private VersionDataModel currentValue;
}