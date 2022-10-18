package com.lazareva.resourceController.jpa.entities;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "version_data")
@Entity
@Getter
public class VersionDataEntity
{
    @Id
    private String version_id;

    private String version;

    private String description;

    @OneToOne
    private ValueEntity value;
}
