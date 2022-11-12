package com.lazareva.resourceController.jpa.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "version")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class VersionEntity {
    @Id
    @Column(name = "version_id")
    private String version;

    private String description;

    @OneToOne(mappedBy = "version")
    private VersionDataEntity versionData;

}
