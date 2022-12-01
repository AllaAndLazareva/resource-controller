package com.lazareva.resourceController.models;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
public class ResourceModel implements Serializable {

    private String id;
    private List<String> applicationIds;
    private String resourceKey;
    private String resourceValue;
}
