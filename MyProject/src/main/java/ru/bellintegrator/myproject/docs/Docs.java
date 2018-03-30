package ru.bellintegrator.myproject.docs;


import javax.persistence.*;

@Entity
@Table(name = "docs")
public class Docs {

    @Id
    @Basic(optional = false)
    @Column(name = "code")
    //@OneToOne(fetch = FetchType.EAGER, mappedBy = "docs")
    private String code;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public Docs(){}

    public Docs(String code, String name){
        this.code = code;
        this. name = name;
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
