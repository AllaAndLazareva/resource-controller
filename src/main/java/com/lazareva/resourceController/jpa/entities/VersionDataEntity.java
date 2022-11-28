package com.lazareva.resourceController.jpa.entities;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "version_data")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class VersionDataEntity {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String id;


    @OneToOne
    @ToString.Exclude
    @JoinColumn(name = "version", referencedColumnName = "version_id")
    private VersionEntity version;


    @OneToOne
    @ToString.Exclude
    @JoinColumn(name = "value", referencedColumnName = "value_key")
    private ValueEntity value;

    @ToString.Exclude
   // @OneToOne(mappedBy = "currentValue")
   // private ResourceEntity currentResource;
    private String currentResource;

    //@ManyToOne
    @ToString.Exclude
    /*@JoinTable(name = "resource_versiondata",
            joinColumns = @JoinColumn(name = "value"),
            inverseJoinColumns = @JoinColumn(name = "resource_id"))
    private ResourceEntity resource;*/
    private String resource;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof VersionDataEntity)) return false;

        VersionDataEntity that = (VersionDataEntity) o;

        return new EqualsBuilder().append(getId(), that.getId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).toHashCode();
    }
}
