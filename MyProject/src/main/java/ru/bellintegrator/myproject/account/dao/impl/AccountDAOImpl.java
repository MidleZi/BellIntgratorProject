package ru.bellintegrator.myproject.account.dao.impl;

import org.springframework.stereotype.Repository;
import ru.bellintegrator.myproject.account.dao.AccountDAO;
import ru.bellintegrator.myproject.account.model.Account;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private final EntityManager em;

    public AccountDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Account> getAllAccounts() {
        TypedQuery<Account> query = em.createNamedQuery("Account.findAll", Account.class);
        List<Account> result = query.getResultList();

        return result;
    }

    @Override
    public void register(Account account) {
        em.persist(account);
    }

    @Override
    public Account loadByLogin(String login) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Account> criteria = builder.createQuery(Account.class);

        Root<Account> account = criteria.from(Account.class);
        criteria.where(builder.equal(account.get("login"), login));

        TypedQuery<Account> query = em.createQuery(criteria);
        return query.getSingleResult();
    }

    @Override
    public Account loadByActivationCode(String activationCode) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Account> criteria = builder.createQuery(Account.class);

        Root<Account> account = criteria.from(Account.class);
        criteria.where(builder.equal(account.get("activationCode"), activationCode));

        TypedQuery<Account> query = em.createQuery(criteria);
        return query.getSingleResult();
    }
}
