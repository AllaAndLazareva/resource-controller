package com.lazareva.resourceController.jpa.entities;


import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "realm")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class RealmEntity {

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


    @OneToMany(mappedBy = "realm")
    @Column
    private List<ApplicationEntity> applications;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof RealmEntity)) return false;

        RealmEntity that = (RealmEntity) o;

        return new EqualsBuilder().append(getId(), that.getId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).toHashCode();
    }
}

