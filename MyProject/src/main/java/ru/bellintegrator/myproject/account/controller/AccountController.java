package ru.bellintegrator.myproject.account.controller;

import ru.bellintegrator.myproject.account.view.AccountView;
import ru.bellintegrator.myproject.utils.Response;

public interface AccountController {

    Response register(AccountView view);

    Response activation(String code);

    Response login(AccountView view);
}
