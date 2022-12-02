package com.lazareva.resourceController.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class ResourceModel implements Serializable {

    private String id;
    private List<String> applicationIds;
    private String resourceKey;
    private String resourceValue;
}
