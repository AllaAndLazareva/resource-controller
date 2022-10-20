package com.lazareva.resourceController.jpa.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;


/**
 * Класс описывающий конфигурации конкретное приложение
 * Пример: Экономическое судопроизводство
 */
@Entity
@Table(name = "application")
@Getter
@Setter
@NoArgsConstructor
public class ApplicationEntity
{
    @Id
    private String id;

    private String name;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "realm_id")
    private RealmEntity realm;

    /**
     * Лист всех конфигурации которые есть у текущего приложения
     * @ManyToMany - т.к одной конфигурация может быть у разных приложений.
     * Связь в таблице должна быть через кросс таблицу.
     */
    @Column
    @ManyToMany
    private List<ResourceEntity> resources;
}
