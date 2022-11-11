package com.lazareva.resourceController.jpa.entities;

import lombok.*;
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
    @Column(name = "version_id", unique = true)
    private String version;

    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VersionEntity that = (VersionEntity) o;
        return version != null && Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
