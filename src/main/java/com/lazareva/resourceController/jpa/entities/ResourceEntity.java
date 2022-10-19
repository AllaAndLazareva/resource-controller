package com.lazareva.resourceController.jpa.entities;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

/**
 * Класс описывающий конкретную конфигурацию.
 */
@Table(name = "resource")
@Entity
@Getter
public class ResourceEntity
{
    @Id
    private String id;

    /**
     * Ключь к параметру не может быть пустым
     * пример: reg_rec_host
     * По данному ключу будет выполниться запрос и получения параметра.
     */
    @Column
    private String key;

    /**
     * Скорее всего это го поля здесь не должно быть. Связь будет через кросс таблицу.
     */
    @ManyToMany
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
    @OneToMany
    private List<VersionDataEntity> values;

    @OneToOne
    @JoinColumn(name = "current_value")
    private VersionDataEntity currentValue;

}
