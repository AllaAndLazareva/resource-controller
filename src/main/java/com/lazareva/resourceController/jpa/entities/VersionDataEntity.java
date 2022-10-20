package com.lazareva.resourceController.jpa.entities;

import lombok.Getter;

import javax.persistence.*;

@Table(name = "version_data")
@Entity
@Getter
public class VersionDataEntity
{
    @Id
    private String version_id;

    private String id;

    private String version;

    private String description;

    @OneToOne
    @JoinColumn(name = "value", referencedColumnName = "id")
    private ValueEntity value;

    @OneToOne
    @JoinColumn(name = "version", referencedColumnName = "version")
    private VersionEntity version;


}
