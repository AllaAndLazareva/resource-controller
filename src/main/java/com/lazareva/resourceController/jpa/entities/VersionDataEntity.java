package com.lazareva.resourceController.jpa.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "version_data")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class VersionDataEntity {
    @Id
    private String id;


    @OneToOne
    @JoinColumn(name = "version_id", referencedColumnName = "version_id")
    private VersionEntity version;


    @OneToOne
    @JoinColumn(name = "value", referencedColumnName = "value_key")
    private ValueEntity value;

    @OneToOne(mappedBy = "currentValue")
    @JoinColumn(name = "current_resource")
    private ResourceEntity currentResource;


    @ManyToOne()
    @JoinTable(name = "resource_versiondata",
            joinColumns = @JoinColumn(name = "value"),
            inverseJoinColumns = @JoinColumn(name = "resource_id"))
    private ResourceEntity resource;
}
