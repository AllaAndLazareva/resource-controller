package com.lazareva.resourceController.jpa.entities;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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

        if (!(o instanceof ValueEntity)) return false;

        ValueEntity that = (ValueEntity) o;

        return new EqualsBuilder().append(getValue(), that.getValue()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getValue()).toHashCode();
    }
}
