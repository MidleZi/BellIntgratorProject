package ru.bellintegrator.myproject.users.model;

import ru.bellintegrator.myproject.office.model.Office;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class Users {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    private Office office;

    @Basic(optional = false)
    @Column(name = "firstName")
    private String firstName;

    @Basic(optional = false)
    @Column(name = "secondName")
    private String secondName;

    @Basic(optional = false)
    @Column(name = "middleName")
    private String midlleName;

    @Basic(optional = false)
    @Column(name = "position")
    private String position;

    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;

    @Basic(optional = false)
    @Column(name = "docName")
    private String docName;

    @Basic(optional = false)
    @Column(name = "docNumber")
    private String docNumber;

    @Basic(optional = false)
    @Column(name = "docDate")
    private String docDate;

    @Basic(optional = false)
    @Column(name = "citizenshipName")
    private String citizenshipName;

    @Basic(optional = false)
    @Column(name = "citizenshipCode")
    private String citizenshipCode;

    @Basic(optional = false)
    @Column(name = "isIdentified")
    private boolean isIdentified;

    public Users(){

    }

    public Users(String firstName, String secondName, String midlleName){
        this.firstName = firstName;
        this.secondName = secondName;
        this.midlleName = midlleName;
    }

    public Users(String firstName, String secondName) {
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
        builder.append(";docName:");
        builder.append(getDocName());
        builder.append(";docNumber:");
        builder.append(getDocNumber());
        builder.append(";docDate:");
        builder.append(getDocDate());
        builder.append(";citizenshipName:");
        builder.append(getCitizenshipName());
        builder.append(";citizenshipCode:");
        builder.append(getCitizenshipCode());
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

    public String getDocName() {
        return docName;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public String getDocDate() {
        return docDate;
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    public boolean isIdentified() {
        return isIdentified;
    }

    public void setOfficeId(Long officeId) {
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

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }

    public void setCitizenshipCode(String citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public void setIdentified(boolean identified) {
        isIdentified = identified;
    }
}