package com.lazareva.resourceController.jpa.entities;

import lombok.Getter;

import javax.persistence.Column;
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
    private String id;

    @Column
    @OneToOne
    private VersionEntity version;

    @Column
    @OneToOne
    private ValueEntity value;


}
