package ru.bellintegrator.myproject.users.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.myproject.users.dao.UsersDAO;
import ru.bellintegrator.myproject.users.model.Users;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UsersDAOImpl implements UsersDAO {

    private final EntityManager em;

    @Autowired
    public UsersDAOImpl(EntityManager em) {
        this.em = em;
    }

    public List<Users> all(){
        TypedQuery<Users> query = em.createQuery("SELECT h FROM House h", Users.class);
        return query.getResultList();

    }

    public Users getUsersById(Long id){
        return em.find(Users.class, id);
    }

    public void update(Users users){
        em.persist(users);
    }

    public void save(Users users) {
        em.persist(users);
    }

    public void delete(Users users) {
        em.persist(users);
    }
}
