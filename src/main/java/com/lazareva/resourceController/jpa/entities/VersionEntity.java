package com.lazareva.resourceController.jpa.entities;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "version")
@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
public class VersionEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "version_id", unique = true)
    private String version;


    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof VersionEntity)) return false;

        VersionEntity that = (VersionEntity) o;

        return new EqualsBuilder().append(getId(), that.getId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).toHashCode();
    }
}
