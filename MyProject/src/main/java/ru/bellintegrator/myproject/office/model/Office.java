package ru.bellintegrator.myproject.office.model;

import javax.persistence.*;

@Entity
@Table(name = "office")
public class Office {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private String id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "orgId")
    private String orgId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "adress")
    private String adress;

    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;

    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;

    public Office(){

    }
    public Office(String name, String adress) {
        this.name=name;
        this.adress=adress;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{id:");
        builder.append(getId());
        builder.append("{orgId:");
        builder.append(getOrgID());
        builder.append(";name:");
        builder.append(getName());
        builder.append(";adress:");
        builder.append(getAdress());
        builder.append(";phone:");
        builder.append(getPhone());
        builder.append(";isActive:");
        builder.append(getActive());
       /* if (orgId != null) {
            builder.append(";Organization:");
            builder.append(orgId.getName());
        }*/
        builder.append("}");

        return builder.toString();
    }

    public String getId() {
        return id;
    }

    public String getOrgID() {
        return orgId;
    }

    public String getName(){
        return name;
    }

    public String getAdress(){
        return adress;
    }

    public String getPhone() {
        return phone;
    }

    public boolean getActive() {
        return isActive;
    }

    public void setOrgId(String id) {
        orgId = id;
    }

    public void setName (String setName){
        name = setName;
    }

    public void setAdress (String setAdress) {
        adress = setAdress;
    }

    public void setPhone (String setPhone){
        phone = setPhone;
    }

    public void setActive (boolean setActive){
        isActive = setActive;
    }
}
