package com.lazareva.resourceController.jpa.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "version")
@Entity
@Data
@NoArgsConstructor
public class VersionEntity {
    @Id
    @Column(name = "version_id")
    private String version;

    private String description;


}
