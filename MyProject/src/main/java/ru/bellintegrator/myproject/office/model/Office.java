package ru.bellintegrator.myproject.office.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.bellintegrator.myproject.organization.model.Organization;

import javax.persistence.*;

@Entity
@Table(name = "office")
public class Office {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orgid")
    private Organization organization;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "address")
    private String address;

    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;

    @Basic(optional = false)
    @Column(name = "isactive")
    private Boolean isActive;

    public Office(){}

    public Office(Long id, String name, String address, String phone, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public Office(String name,String address, String phone, Boolean isActive) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{id:");
        builder.append(getId());
        builder.append("{orgId:");
        builder.append(getOrganization());
        builder.append(";name:");
        builder.append(getName());
        builder.append(";address:");
        builder.append(getAddress());
        builder.append(";phone:");
        builder.append(getPhone());
        builder.append(";isActive:");
        builder.append(getActive());
        if (organization != null) {
            builder.append(";Organization:");
            builder.append(organization.getName());
        }
        builder.append("}");

        return builder.toString();
    }

    public Long getId() {
        return id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @JsonProperty(value = "isActive")
    public Boolean getActive() {
        return isActive;
    }

    public void setOrganization(Organization id) {
        organization = id;
    }

    public void setName (String setName){
        name = setName;
    }

    public void setAddress (String setAddress) {
        address = setAddress;
    }

    public void setPhone (String setPhone){
        phone = setPhone;
    }

    public void setActive (Boolean setActive){
        isActive = setActive;
    }
}
