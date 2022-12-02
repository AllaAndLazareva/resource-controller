package com.lazareva.resourceController.jpa.entities;

import com.sun.istack.NotNull;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
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

public class ResourceEntity {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String id;

    /**
     * Ключ к параметру не может быть пустым
     * пример: reg_rec_host
     * По данному ключу будет выполниться запрос и получения параметра.
     */
    @Column(name = "resource_key")    //1.пользователь вводит ключ
    @NotNull
    private String key;

    /**
     * Скорее всего это го поля здесь не должно быть. Связь будет через кросс таблицу.
     */
    @ManyToMany(mappedBy = "resources")
    private List<ApplicationEntity> applications;

    @Column(name = "current_value")
    private String currentValue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ResourceEntity)) return false;

        ResourceEntity that = (ResourceEntity) o;

        return new EqualsBuilder().append(getId(), that.getId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).toHashCode();
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
