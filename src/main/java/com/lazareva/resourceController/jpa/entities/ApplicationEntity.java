package com.lazareva.resourceController.jpa.entities;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "application")
@Getter
public class ApplicationEntity
{
    @Id
    private String name;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "realm_id", referencedColumnName = "realm_id")
    private RealmEntity realm;

    @Column
    @ManyToMany
    @JoinTable(name = "application_resources",
    joinColumns = @JoinColumn(name = "application_name"),
    inverseJoinColumns = @JoinColumn(name = "resource_key"))
    private List<ResourceEntity> resources;
}
