package ru.bellintegrator.myproject.account.view;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountView {

    public String login;

    public String password;

    public String email;
}
