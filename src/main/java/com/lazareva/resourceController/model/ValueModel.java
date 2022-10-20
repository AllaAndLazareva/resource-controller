package com.lazareva.resourceController.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link com.lazareva.resourceController.jpa.entities.ValueEntity} entity
 */
@Data
@NoArgsConstructor
public class ValueModel implements Serializable
{
    private String key;
    private String data;
}