package com.lazareva.resourceController.jpa.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "value")
@Entity
@Data
@NoArgsConstructor
public class ValueEntity {
    @Id
    @Column(name = "value_key")
    private String value;

    private String data;


}
