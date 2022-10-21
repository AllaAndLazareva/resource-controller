package com.lazareva.resourceController.jpa.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ValueModel implements Serializable {

    private String valueKey;
    private String data;
}
