package com.lazareva.resourceController.jpa.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data@NoArgsConstructor
public class VersionDataModel implements Serializable {

    private String id;
    private VersionModel version;
    private ValueModel value;
}
