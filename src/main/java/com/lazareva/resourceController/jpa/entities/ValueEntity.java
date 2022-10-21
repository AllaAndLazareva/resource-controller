package com.lazareva.resourceController.jpa.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "value")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class ValueEntity {
    @Id
    @Column(name = "value_key")
    private String value;

    private String data;




}
