package com.lazareva.resourceController.jpa.entities;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;



@Entity
@Table(name = "application")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ApplicationEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "realm", referencedColumnName = "id")
    @ToString.Exclude
    private RealmEntity realm;

    @Column
    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "application_resources",
            joinColumns = @JoinColumn(name = "application_id"),
            inverseJoinColumns = @JoinColumn(name = "resources_id"))
    private List<ResourceEntity> resources;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ApplicationEntity)) return false;

        ApplicationEntity that = (ApplicationEntity) o;

        return new EqualsBuilder().append(getId(), that.getId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).toHashCode();
    }

    public void addResource(ResourceEntity resourceEntity) {
        if (resources != null) {
            resources.add(resourceEntity);
        } else {
            resources = Arrays.asList(resourceEntity);
        }
    }
}
