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

@Table(name = "resources")
@Entity
@Getter
public class ResourceEntity
{
    @Id
    private String resource_key; //1. пользователь вводит ключ

    @OneToMany (mappedBy = "value") //2.пользватель вводит value (localhost:8080)
    private List<VersionDataEntity> values;

    @OneToMany (mappedBy = "version_id") //3. присваивается версия напр. 1.0
    private List<VersionDataEntity> versions;

    @OneToOne //4. устанавливается текущая версия
    @JoinColumn(name = "current_version", referencedColumnName = "version")
    private VersionDataEntity currentVersion;

    @ManyToMany(mappedBy ="resources" )
    private List<ApplicationEntity> applications;

    @Column
    @OneToMany(mappedBy = "id")
    private List<ValueEntity> resources;





}
