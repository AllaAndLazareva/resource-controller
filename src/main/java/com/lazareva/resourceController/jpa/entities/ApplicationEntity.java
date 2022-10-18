package com.lazareva.resourceController.jpa.entities;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
    @JoinColumn(name = "realm_id")
    private RealmEntity realm;

    @Column
    @ManyToMany
    private List<ResourceEntity> resources;
}
