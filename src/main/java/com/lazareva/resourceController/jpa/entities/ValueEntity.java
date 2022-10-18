package com.lazareva.resourceController.jpa.entities;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "value")
@Entity
@Getter
public class ValueEntity
{
    @Id
    private String id;

    private String data;

}
