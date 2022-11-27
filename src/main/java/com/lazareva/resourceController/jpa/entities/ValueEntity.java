package com.lazareva.resourceController.jpa.entities;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "value")
@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
public class ValueEntity {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "value_key", unique = true)
    private String value;


    private String data;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ValueEntity that = (ValueEntity) o;
        return value != null && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
