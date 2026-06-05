package ru.zelmex.landresources247.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "land_plots")
public class LandPlot {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private LandCategory category;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private LandOwner owner;

    @Column(name = "area")
    private BigDecimal area;

    @Column(name = "cadastral_number", unique = true)
    private String cadastralNumber;

    // Геттеры и сеттеры
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LandCategory getCategory() {
        return category;
    }

    public void setCategory(LandCategory category) {
        this.category = category;
    }

    public LandOwner getOwner() {
        return owner;
    }

    public void setOwner(LandOwner owner) {
        this.owner = owner;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(String areaText) {
        if (areaText != null && !areaText.isEmpty() && areaText.matches("^[0-9]+([.,][0-9]+)?$")) {
            BigDecimal area = BigDecimal.valueOf(Double.parseDouble(areaText.replace(",", ".")));
            if (area.compareTo(BigDecimal.valueOf(0)) == 1) {
                this.area = area;
            } else {
                throw new IllegalArgumentException("Площадь должна быть больше 0!");
            }
        } else {
            throw new IllegalArgumentException("Площадь должна быть числом!");
        }
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public String getCadastralNumber() {
        return cadastralNumber;
    }

    public void setCadastralNumber(String cadastralNumber) {
        if (cadastralNumber != null && !cadastralNumber.isEmpty()) {
            this.cadastralNumber = cadastralNumber;
        } else {
            throw new IllegalArgumentException("Кадастровый номер не может быть пустым!");
        }
    }

    @Override
    public String toString() {
        return "LandPlot{" +
                "id=" + id +
                ", category=" + (category != null ? category.getName() : null) +
                ", owner=" + (owner != null ? owner.getFullName() : null) +
                ", area=" + area +
                ", cadastralNumber='" + cadastralNumber + '\'' +
                '}';
    }
}