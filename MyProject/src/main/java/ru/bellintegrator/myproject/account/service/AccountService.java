package ru.bellintegrator.myproject.account.service;

import ru.bellintegrator.myproject.account.view.AccountView;

public interface AccountService {

    void register(AccountView view);

    void activation(String code);

    void login(AccountView view);

    String encode(String stringForEncode);

    String generateString();
}
