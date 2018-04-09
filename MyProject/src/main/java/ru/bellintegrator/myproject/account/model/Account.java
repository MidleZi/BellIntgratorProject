package ru.bellintegrator.myproject.account.model;

import javax.persistence.*;


@Entity
@Table(name = "account")
@NamedQuery(name = "Account.findAll", query = "SELECT p FROM Account p")
public class Account {


    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Version
    @Column(name = "version")
    private Integer version;

    @Column(name = "name")
    private String name;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "activation_code")
    private String activationCode;

    @Column(name = "activation_status")
    private Boolean activationStatus;

    public Account(){}

    public Account(String login, String password){
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public Boolean getActivationStatus() {
        return activationStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public void setActivationStatus(Boolean activationStatus) {
        this.activationStatus = activationStatus;
    }
}
