package com.lazareva.resourceController.jpa.entities;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Данный класс будет хранить и связывать приложения в одном окружении
 * т.е имеющие, что-то общие конфигурации которые можно использовать в раздиных приложениях
 * Пример: приложения Экономическое судопроизводство, Административное судопроизводство. Оба эти приложения имеют много одинаковых конфигураций.
 * Но есть конфигурации и различные - о которых не должны знать эти приложения.
 * Те конфигурации которые общие при изменении у одного приложения автоматически должны меняться в другом.
 */
@Entity
@Table(name = "realm")
@Getter

public class RealmEntity
{
    /**
     * Все id во всех классах должны быть UUID
     */
    @Id
    @Column(name = "realm_id")
    private String id;

    @Column
    private String description;

    /**
     * Пример: приложения Экономическое судопроизводство, Административное судопроизводство.
     * Нужно связать так что бы таблица application хранила поле realm_id. Таблица realm не должна хранить никаких связей с application
     */
    @OneToMany(mappedBy = "realm")
    @Column
    private List<ApplicationEntity> applications;

}

