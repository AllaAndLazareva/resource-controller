package com.lazareva.resourceController.jpa.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


/**
 * Класс описывающий конфигурации конкретное приложение
 * Пример: Экономическое судопроизводство
 */
@Entity
@Table(name = "application")
@Data
@NoArgsConstructor
public class ApplicationEntity {
    @Id
    private String id;

    private String name;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "realm", referencedColumnName = "id")
    private RealmEntity realm;

    /**
     * Лист всех конфигурации которые есть у текущего приложения
     *
     * @ManyToMany - т.к одной конфигурация может быть у разных приложений.
     * Связь в таблице должна быть через кросс таблицу.
     */
    @Column
    @ManyToMany
    @JoinTable(name = "application_resources",
            joinColumns = @JoinColumn(name = "application_id"),
            inverseJoinColumns = @JoinColumn(name = "resources_id"))
    private List<ResourceEntity> resources;
}
