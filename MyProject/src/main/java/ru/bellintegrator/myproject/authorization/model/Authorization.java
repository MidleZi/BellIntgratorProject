package ru.bellintegrator.myproject.authorization.model;

import javax.persistence.*;


@Entity
@Table(name = "user")
public class Authorization {

    @Id
    @Column(name = "login")
    private String login;


    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    public Authorization(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }
}
