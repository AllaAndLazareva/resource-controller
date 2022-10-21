package com.lazareva.resourceController.jpa.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class VersionModel implements Serializable {

    private String versionId;
    private String description;
}
