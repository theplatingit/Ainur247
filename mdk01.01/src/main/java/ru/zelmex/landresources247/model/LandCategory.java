package ru.zelmex.landresources247.model;

import jakarta.persistence.*;

@Entity
@Table(name = "land_categories")
public class LandCategory {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "restrictions")
    private String restrictions;

    @Column(name = "permitted_use", nullable = false)
    private String permittedUse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Название категории не может быть пустым!");
        }
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public String getPermittedUse() {
        return permittedUse;
    }

    public void setPermittedUse(String permittedUse) {
        if (permittedUse != null && !permittedUse.isEmpty()) {
            this.permittedUse = permittedUse;
        } else {
            throw new IllegalArgumentException("Разрешенное использование не может быть пустым!");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}