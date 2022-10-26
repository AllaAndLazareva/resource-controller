package com.lazareva.resourceController.jpa.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Класс описывающий конкретную конфигурацию.
 */
@Table(name = "resource")
@Entity
@Data
@NoArgsConstructor
public class ResourceEntity {
    @Id
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

    /**
     * Поля хранящее список версий и значение параметра
     * Принцип такой:
     * 1)Когда пользователь будет создавать параметр с ключом reg_rec_host и значением localHost:8080 ему присвоиться версия 1.0
     * и засетится в поля currentValue все приложения которым нужен параметр reg_rec_host будут получать его из поля currentValue (localHost:8080)
     * Если пользователь зайдет и поменяет параметр reg_rec_host на localHost:999999 то будет создан новый reg_rec_host с версией 1.1 засетится в currentValue все приложения начнут получать localHost:999999
     * но мы всегда сможем переключить на версию 1.0. т.к она не удаляется, а хранится в списке.
     */
    @Column
    @OneToMany(mappedBy = "resource")
    private List<VersionDataEntity> value;

    @OneToOne
    @JoinColumn(name = "current_value", referencedColumnName = "id")
    private VersionDataEntity currentValue;

}
