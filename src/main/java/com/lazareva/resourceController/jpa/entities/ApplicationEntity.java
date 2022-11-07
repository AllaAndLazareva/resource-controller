package com.lazareva.resourceController.jpa.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;


/**
 * Класс описывающий конфигурации конкретное приложение
 * Пример: Экономическое судопроизводство
 */
@Entity
@Table(name = "application")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ApplicationEntity {
    @Id
    @EqualsAndHashCode.Include
    private String id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "realm", referencedColumnName = "id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private RealmEntity realm;

    @Column
    @ManyToMany
    @JoinTable(name = "application_resources",
            joinColumns = @JoinColumn(name = "application_id"),
            inverseJoinColumns = @JoinColumn(name = "resources_id"))
    private List<ResourceEntity> resources;
}
