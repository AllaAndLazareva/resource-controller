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
    private VersionEntity version;


    @OneToOne
    private ValueEntity value;

    @ManyToOne
    @JoinColumn(name = "resource_id", referencedColumnName = "id")
    private ResourceEntity resource;
}
