package com.lazareva.resourceController.jpa.entities;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "realm")
@Getter
public class RealmEntity
{
    @Id
    @Column(name = "realm_id")
    private String id;

    @Column
    private String description;

    @OneToMany(mappedBy = "realm")
    @Column
    private List<ApplicationEntity> applications;

}

