package ru.bellintegrator.myproject.countries.model;


import javax.persistence.*;


@Entity
@Table(name = "countries")
public class Countries {

    @Id
    @Basic(optional = false)
    @JoinColumn(name = "code")
    private Long code;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public Countries(){}

    public Countries(Long code, String name){
        this.code = code;
        this. name = name;
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
