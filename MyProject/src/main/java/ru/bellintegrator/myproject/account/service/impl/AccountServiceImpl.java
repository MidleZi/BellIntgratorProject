package ru.bellintegrator.myproject.account.service.impl;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.myproject.account.dao.AccountDAO;
import ru.bellintegrator.myproject.account.model.Account;
import ru.bellintegrator.myproject.account.service.AccountService;
import ru.bellintegrator.myproject.account.view.AccountView;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    private final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final AccountDAO dao;

    @Autowired
    public AccountServiceImpl(AccountDAO dao) {
        this.dao = dao;
    }

    @Override
    public void register(AccountView view) {

        Account newAccount = new Account();
        String password = encode(view.password);
        String activationCode = generateString();

        newAccount.setLogin(view.login);
        newAccount.setPassword(password);
        newAccount.setActivationCode(activationCode);

        dao.register(newAccount);

    }

    @Override
    public void activation(String activationCode) {
        String hashForActivationCode = encode(activationCode);
        Account account = dao.loadByActivationCode(hashForActivationCode);

        if(account != null) account.setActivationStatus(true);

    }

    @Override
    public void login(AccountView view) {
        Account login = dao.loadByLogin(view.login);
        if(login == null) throw new ServiceException("Логин не существует");

        String enteringPasswordHash = encode(view.password);
        String truePasswordHash = login.getPassword();

        if(enteringPasswordHash != truePasswordHash) throw new ServiceException("Неверный пароль");
    }

    @Override
    public String encode(String stringForEncode) {
        byte[] digest = null;
        try {
            MessageDigest encoder = MessageDigest.getInstance("SHA-256");
            digest = encoder.digest(stringForEncode.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            log.info(ex.getMessage(), ex);
        }

        return new String(Base64.getEncoder().encode(digest));
    }

    @Override
    public String generateString() {
        String generatedString = UUID.randomUUID().toString();
        return generatedString;
    }
}
