package com.lazareva.resourceController.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ApplicationModel implements Serializable {

    private String id;
    private String name;
    private String description;
    private String realmId;
}
