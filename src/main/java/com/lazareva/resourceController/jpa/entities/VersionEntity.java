package com.lazareva.resourceController.jpa.entities;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "version")
@Entity
@Getter
public class VersionEntity
{
    @Id
    private String version;

    private String description;
}
