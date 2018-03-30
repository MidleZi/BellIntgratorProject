package ru.bellintegrator.myproject.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.bellintegrator.myproject.countries.model.Countries;
import ru.bellintegrator.myproject.office.model.Office;
import ru.bellintegrator.myproject.userdocs.model.UserDocs;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "officeid")
    private Office office;

    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstName;

    @Basic(optional = false)
    @Column(name = "secondname")
    private String secondName;

    @Basic(optional = false)
    @Column(name = "middlename")
    private String midlleName;

    @Basic(optional = false)
    @Column(name = "position")
    private String position;

    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;

    @MapsId
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private UserDocs userDocs;

    @MapsId
    @OneToOne(fetch = FetchType.EAGER/*, mappedBy = "users"*/)
    @JoinColumn(name = "citizenshipcode")
    private Countries countries;

    @Basic(optional = false)
    @Column(name = "isidentified")
    private Boolean isIdentified;

    public User(){ }


    public User(Long id) {
        this.id =id;
    }

    public User(Long id, Office office, String firstName, String secondName, String midleName, String position,
                String phone,UserDocs userDocs, Countries countries, Boolean isIdentified) {
        this.id =id;
        this.office = office;
        this.firstName = firstName;
        this.secondName = secondName;
        this.midlleName = midleName;
        this.position = position;
        this.phone = phone;
        this.userDocs = userDocs;
        this.countries = countries;
        this.isIdentified = isIdentified;
    }

    public User(String firstName, String secondName, String midleName, String position, String phone, Boolean isIdentified) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.midlleName = midleName;
        this.position = position;
        this.phone = phone;
        this.isIdentified = isIdentified;
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
          builder.append(";midlleName:");
          builder.append(getMidlleName());
          builder.append(";position:");
          builder.append(getPosition());
          builder.append(";phone:");
          builder.append(getPhone());
          builder.append(";userDoc:");
          builder.append(getUserDocs());
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

    public String getMidlleName() {
        return midlleName;
    }

    public String getPosition() {
        return position;
    }

    public String getPhone() {
        return phone;
    }

    public UserDocs getUserDocs(){ return userDocs;}

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

    public void setOffice(Office office) {
        this.office = office;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setMidlleName(String midlleName) {
        this.midlleName = midlleName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserDocs(UserDocs userDocs) {
        this.userDocs = userDocs;
    }

    public void setCountries(Countries countries) {
        this.countries = countries;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }
}
