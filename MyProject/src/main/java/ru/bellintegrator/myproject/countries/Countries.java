package ru.bellintegrator.myproject.countries;


import javax.persistence.*;


@Entity
@Table(name = "countries")
@NamedQuery(name = "Countries.findAll", query = "SELECT p FROM Countries p")
public class Countries {

    @Id
    @Column(name = "code")
    private String code;

    @Version
    private Integer version;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public Countries(){}

    public Countries(String code, String name){
        this.code = code;
        this. name = name;
    }

    public Countries(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }
}
