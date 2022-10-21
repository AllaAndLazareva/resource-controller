package com.lazareva.resourceController.jpa.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ApplicationModel implements Serializable {

    private String id;
    private String name;
    private String description;
}
