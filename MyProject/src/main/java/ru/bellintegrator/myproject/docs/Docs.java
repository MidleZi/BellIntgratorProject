package ru.bellintegrator.myproject.docs;


import javax.persistence.*;

@Entity
@Table(name = "docs")
@NamedQuery(name = "Docs.findAll", query = "SELECT p FROM Docs p")
public class Docs {

    @Id
    @Basic(optional = false)
    @Column(name = "code")
    private String code;

    @Version
    private Integer version;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public Docs(){}


    public Docs(String name){
        this.name = name;
    }


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
