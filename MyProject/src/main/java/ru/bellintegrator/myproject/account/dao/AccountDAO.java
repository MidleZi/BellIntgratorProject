package ru.bellintegrator.myproject.account.dao;

import ru.bellintegrator.myproject.account.model.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> getAllAccounts();

    void register(Account account);

    Account loadByLogin(String login);

    Account loadByActivationCode(String activationCode);


}
