package com.lazareva.resourceController.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link com.lazareva.resourceController.jpa.entities.RealmEntity} entity
 */
@Data
@NoArgsConstructor
public class RealmModel implements Serializable
{
    private String id;
    private String description;
}