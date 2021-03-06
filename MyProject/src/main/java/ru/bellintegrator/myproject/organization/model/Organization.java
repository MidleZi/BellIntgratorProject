package ru.bellintegrator.myproject.organization.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.bellintegrator.myproject.office.model.Office;
import ru.bellintegrator.myproject.organization.view.OrganizationView;
import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "organization")
@NamedQuery(name = "Organization.findAll", query = "SELECT p FROM Organization p")
public class Organization {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Version
    private Integer version = 0;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "organization", cascade = {CascadeType.ALL})
    private Set<Office> office;

    @Basic(optional = false)
    @Column(name = "fullname")
    private String fullname;

    @Basic(optional = false)
    @Column(name = "inn")
    private String inn;

    @Basic(optional = false)
    @Column(name = "kpp")
    private String kpp;

    @Basic(optional = false)
    @Column(name = "address")
    private String address;

    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;

    @Basic(optional = false)
    @Column(name = "isactive")
    private Boolean isActive;

    public Organization() {}

    public Organization(Long id, String name, String fullname, String inn, String kpp, String address, String phone, Boolean isActive){
        this.id = id;
        this.name= name;
        this.fullname = fullname;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;

    }

    public Organization(String name, String fullname, String inn, String kpp, String address, String phone, Boolean isActive) {
        this.name = name;
        this.fullname = fullname;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;

    }

    public Organization(Long id) {
        this.id = id;
    }

    public Organization(String name) {
        this.name = name;
    }

    public OrganizationView convertOrgToView() {
        OrganizationView view = new OrganizationView();

        view.id = id;
        view.name = name;
        view.fullname = fullname;
        view.inn = inn;
        view.kpp = kpp;
        view.address = address;
        view.phone = phone;
        view.isActive = isActive;

        return view;
    }

    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Office> getOffice() {
        return office;
    }

    public String getFullname() {
        return fullname;
    }

    public String getInn() {
        return inn;
    }

    public String getKpp() {
        return kpp;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @JsonProperty(value = "isActive")
    public Boolean getActive() {
        return isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOffice(Set<Office> office) {
        this.office = office;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";fullname:" + fullname + ";INN:" + inn + ";KPP:" + kpp +
                ";address" + address + ";phone:" + phone + ";isActive : " + isActive + "}";
    }
}

