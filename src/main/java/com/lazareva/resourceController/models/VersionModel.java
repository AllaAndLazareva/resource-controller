package com.lazareva.resourceController.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class VersionModel implements Serializable {

    private String applicationId;
    private String resourceId;
    private String versionId;
    private String description;
    private String value;
}
