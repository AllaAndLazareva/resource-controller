package com.lazareva.resourceController.jpa.entities;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
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
    @ToString.Exclude
    private List<ApplicationEntity> applications;

    /**
     * Поля хранящее список версий и значение параметра
     * Принцип такой:
     * 1)Когда пользователь будет создавать параметр с ключом reg_rec_host и значением localHost:8080 ему присвоиться версия 1.0
     * и засетится в поля currentValue все приложения которым нужен параметр reg_rec_host будут получать его из поля currentValue (localHost:8080)
     * Если пользователь зайдет и поменяет параметр reg_rec_host на localHost:999999 то будет создан новый reg_rec_host с версией 1.1 засетится в currentValue все приложения начнут получать localHost:999999
     * но мы всегда сможем переключить на версию 1.0. т.к она не удаляется, а хранится в списке.
     */
    @Column
    @ToString.Exclude
    //@OneToMany(mappedBy = "resource")
   //private List<VersionDataEntity> value;
    private String versionDataValue;            //Здесь должна быть коллекция, но компилятор не принимает её

   // @OneToOne
    @ToString.Exclude
    //@JoinColumn(name = "current_value", referencedColumnName = "id")
   //private VersionDataEntity currentValue;
    private String VersionDataCurrentValue;

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
}
