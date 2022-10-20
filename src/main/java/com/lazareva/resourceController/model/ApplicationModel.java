package com.lazareva.resourceController.model;

import com.lazareva.resourceController.jpa.entities.ApplicationEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link ApplicationEntity} entity
 */
@Getter
@Setter
@NoArgsConstructor
public class ApplicationModel implements Serializable
{
    private String id;
    private String name;
    private String description;
}