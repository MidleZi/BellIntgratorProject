package ru.bellintegrator.myproject.countries;


import javax.persistence.*;


@Entity
@Table(name = "countries")
@NamedQuery(name = "Countries.findAll", query = "SELECT p FROM Countries p")
public class Countries {

    @Id
    @Column(name = "code")
    private Long code;

    @Version
    private Integer version;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public Countries(){}

    public Countries(Long code, String name){
        this.code = code;
        this. name = name;
    }

    public Countries(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }
}
