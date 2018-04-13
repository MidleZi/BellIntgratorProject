package ru.bellintegrator.myproject.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.bellintegrator.myproject.countries.Countries;
import ru.bellintegrator.myproject.docs.Docs;
import ru.bellintegrator.myproject.office.model.Office;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAll", query = "SELECT p FROM User p")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "officeid")
    private Office office;

    @Version
    private Integer version = 0;

    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstName;

    @Basic(optional = false)
    @Column(name = "secondname")
    private String secondName;

    @Basic(optional = false)
    @Column(name = "middlename")
    private String midleName;

    @Basic(optional = false)
    @Column(name = "position")
    private String position;

    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;

    @Column(name = "docnumber")
    private String docNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "docdate")
    private Date docDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctype")
    private Docs docs;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "citizenshipcode")
    private Countries countries;

    @Basic(optional = false)
    @Column(name = "isidentified")
    private Boolean isIdentified;

    public User(){ }


    public User(Long id) {
        this.id =id;
    }

    public User(Long id, String firstName, String secondName, String midleName, String position,
                String phone,Docs docs, Countries countries, Boolean isIdentified) {
        this.id =id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.midleName = midleName;
        this.position = position;
        this.phone = phone;
        this.docs = docs;
        this.countries = countries;
        this.isIdentified = isIdentified;
    }

    public User(String firstName, String secondName, String midleName, String position, String phone, Docs docs,
                Countries countries, Boolean isIdentified) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.midleName = midleName;
        this.position = position;
        this.phone = phone;
        this.docs = docs;
        this.countries = countries;
        this.isIdentified = isIdentified;
    }

    public User(String firstName) {
        this.firstName = firstName;
    }

    public String toString() {
          StringBuilder builder = new StringBuilder();
          builder.append("{id:");
          builder.append(getId());
          builder.append(";officeId:");
          builder.append(getOffice());
          builder.append(";firstName:");
          builder.append(getFirstName());
          builder.append(";secondName:");
          builder.append(getSecondName());
          builder.append(";midleName:");
          builder.append(getMidleName());
          builder.append(";position:");
          builder.append(getPosition());
          builder.append(";phone:");
          builder.append(getPhone());
          builder.append(";doctype:");
          builder.append(getDocs());
          builder.append(";countries:");
          builder.append(getCountries());
          builder.append(";isIdentified:");
          builder.append(isIdentified());
          builder.append("}");

          return builder.toString();
      }

    public Long getId() {
        return id;
    }

    public Office getOffice() {
        return office;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getMidleName() {
        return midleName;
    }

    public String getPosition() {
        return position;
    }

    public String getPhone() {
        return phone;
    }

    public Docs getDocs(){
        return docs;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public Countries getCountries() {
        return countries;
    }

    public Boolean getIdentified() {
        return isIdentified;
    }

    @JsonProperty(value = "isIdentified")
    public Boolean isIdentified() {
        return isIdentified;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setMidleName(String midleName) {
        this.midleName = midleName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDocs(Docs docs) {
        this.docs = docs;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public void setCountries(Countries countries) {
        this.countries = countries;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }
}
