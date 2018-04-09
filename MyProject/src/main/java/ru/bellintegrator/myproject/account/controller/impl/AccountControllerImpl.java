package ru.bellintegrator.myproject.account.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.myproject.account.controller.AccountController;
import ru.bellintegrator.myproject.account.service.AccountService;
import ru.bellintegrator.myproject.account.service.impl.AccountServiceImpl;
import ru.bellintegrator.myproject.account.view.AccountView;
import ru.bellintegrator.myproject.utils.Response;
import ru.bellintegrator.myproject.utils.ResponseViewData;
import ru.bellintegrator.myproject.utils.ResponseViewError;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class AccountControllerImpl implements AccountController {

    private final AccountService accountService;
    private final AccountService activationService;

    @Autowired
    public AccountControllerImpl(AccountServiceImpl accountService, AccountServiceImpl activationService) {
        this.accountService = accountService;
        this.activationService = activationService;
    }

    @Override
    @RequestMapping(value = "/register", method = {POST})
    public Response register(@RequestBody AccountView view) {
        try{
            accountService.register(view);
            return ResponseViewData.newBuilder()
                    .setData("success")
                    .build();
        }catch(Throwable e) {
            return ResponseViewError.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }
    }

    @Override
    @RequestMapping(value = "/activation", method = {GET})
    public Response activation(@RequestParam("code") String code) {
        try{
            activationService.activation(code);
            return ResponseViewData.newBuilder()
                    .setData("success")
                    .build();
        }catch(Throwable e) {
            return ResponseViewError.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }
    }

    @Override
    @RequestMapping(value = "/login", method = {POST})
    public Response login(@RequestBody AccountView view) {
        try{
            accountService.login(view);
            return ResponseViewData.newBuilder()
                    .setData("success")
                    .build();
        }catch(Throwable e) {
            return ResponseViewError.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }
    }
}
