package com.lazareva.resourceController.jpa.entities;


import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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
@Setter
@NoArgsConstructor
@ToString
public class RealmEntity {
    /**
     * Все id во всех классах должны быть UUID
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    @EqualsAndHashCode.Include
    private String id;

    @Column
    private String description;
    @Column
    private String name;

    /**
     * Пример: приложения Экономическое судопроизводство, Административное судопроизводство.
     * Нужно связать так что бы таблица application хранила поле realm_id. Таблица realm не должна хранить никаких связей с application
     */
    @OneToMany(mappedBy = "realm")
    @Column
    private List<ApplicationEntity> applications;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RealmEntity that = (RealmEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

