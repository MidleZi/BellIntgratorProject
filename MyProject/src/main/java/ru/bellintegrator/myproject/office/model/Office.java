package ru.bellintegrator.myproject.office.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.bellintegrator.myproject.organization.model.Organization;

import javax.persistence.*;

@Entity
@Table(name = "office")
@NamedQuery(name = "Office.findAll", query = "SELECT p FROM Office p")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Office {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Version
    private Integer version = 0;

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
    @Column(name = "is_active")
    //@JsonProperty(value = "isActive")
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

    public Office(Long id) {
        this.id = id;
    }

    public Office(String name) {
        this.name = name;
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

    public void setId(Long id) {
        this.id = id;
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
