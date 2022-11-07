package com.lazareva.resourceController.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class RealmModel implements Serializable {

    private String id;
    private String description;
    private String name;

}
