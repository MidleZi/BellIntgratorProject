package ru.bellintegrator.myproject.organization.model;

import javax.persistence.*;


@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "fullName")
    private String fullName;

    @Basic(optional = false)
    @Column(name = "inn")
    private String inn;

    @Basic(optional = false)
    @Column(name = "kpp")
    private String kpp;

    @Basic(optional = false)
    @Column(name = "adress")
    private String adress;

    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;

    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;

    public Organization (){

    }

    public Organization(String name, String inn){
        this.name = name;
        this.inn = inn;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{id:");
        builder.append(getId());
        builder.append(";name:");
        builder.append(getName());
        builder.append(";fullName:");
        builder.append(getFullName());
        builder.append(";INN:");
        builder.append(getInn());
        builder.append(";KPP:");
        builder.append(getKpp());
        builder.append(";adress:");
        builder.append(getAdress());
        builder.append(";phone:");
        builder.append(getPhone());
        builder.append(";isActive:");
        builder.append(getActive());
        builder.append("}");

        return builder.toString();
    }

    public long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getInn() {
        return inn;
    }

    public String getKpp() {
        return kpp;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhone() {
        return phone;
    }

    public boolean getActive() {
        return isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
