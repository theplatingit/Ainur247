package ru.zelmex.landresources247.model;

import jakarta.persistence.*;

@Entity
@Table(name = "land_owners")
public class LandOwner {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tax_id", nullable = false, unique = true)
    private String taxId;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        if (taxId != null && !taxId.isEmpty()) {
            this.taxId = taxId;
        } else {
            throw new IllegalArgumentException("ИНН/Паспорт не может быть пустым!");
        }
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName != null && !fullName.isEmpty()) {
            this.fullName = fullName;
        } else {
            throw new IllegalArgumentException("ФИО/Название не может быть пустым!");
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone != null && !phone.isEmpty() && phone.length() <= 20) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Телефон не может быть пустым или содержать более 20 символов!");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address != null && !address.isEmpty()) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Адрес не может быть пустым!");
        }
    }

    @Override
    public String toString() {
        return fullName;
    }
}