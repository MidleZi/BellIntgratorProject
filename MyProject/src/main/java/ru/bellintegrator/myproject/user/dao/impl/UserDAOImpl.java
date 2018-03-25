package ru.bellintegrator.myproject.user.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.myproject.organization.model.Organization;
import ru.bellintegrator.myproject.user.dao.UserDAO;
import ru.bellintegrator.myproject.user.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManager em;

    @Autowired
    public UserDAOImpl(EntityManager em) {
        this.em = em;
    }

    public List<User> all(){
        TypedQuery<User> query = em.createQuery("SELECT h FROM user h", User.class);
        return query.getResultList();

    }
    @Override
    public User getUserById(String id){
        return em.find(User.class, id);
    }

    public void update(User user){
        em.merge(user);
    }

    public void save(User user) {
        em.persist(user);
    }

    public void delete(User user) {
        em.remove(user);
    }
}
