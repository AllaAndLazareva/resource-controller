package com.lazareva.resourceController.jpa.entities;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Класс описывающий конкретную конфигурацию.
 */
@Table(name = "resource")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ResourceEntity {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "resource_key")
    @NotNull
    private String key;

    @ManyToMany(mappedBy = "resources")
    @ToString.Exclude
    private List<ApplicationEntity> applications;

    @ToString.Exclude
    @Column(name = "current_value")
    private String currentValue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ResourceEntity that = (ResourceEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public boolean containsApplication(String id) {
        return applications != null && applications
                .stream()
                .anyMatch(applicationEntity -> applicationEntity.getId().equals(id));
    }

    public void addApplications(ApplicationEntity applicationEntity) {
        applicationEntity.addResource(this);
        if (applications != null) {
            applications.add(applicationEntity);
        } else {
            applications = Arrays.asList(applicationEntity);
        }
    }

    public void setApplications(List<ApplicationEntity> applications) {
        applications.forEach(this::addApplications);
    }
}
