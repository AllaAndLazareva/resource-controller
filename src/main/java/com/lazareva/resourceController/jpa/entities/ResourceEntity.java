package com.lazareva.resourceController.jpa.entities;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Table(name = "resource")
@Entity
@Getter
public class ResourceEntity
{
    @Id
    private String key;

    @ManyToMany
    private List<ApplicationEntity> applications;

    @Column
    @OneToMany
    private List<ValueEntity> resources;

    @OneToMany
    private List<VersionDataEntity> versions;

    @OneToOne
    @JoinColumn(name = "current_version")
    private VersionDataEntity currentVersion;

}
