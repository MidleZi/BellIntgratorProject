package ru.bellintegrator.myproject.user.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.myproject.organization.model.Organization;
import ru.bellintegrator.myproject.user.dao.UserDAO;
import ru.bellintegrator.myproject.user.model.User;
import ru.bellintegrator.myproject.user.service.impl.UserServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManager em;
    private final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

    @Autowired
    public UserDAOImpl(EntityManager em) {
        this.em = em;
    }

    public List<User> list(){
        TypedQuery<User> query = em.createQuery("SELECT h FROM user h", User.class);
        return query.getResultList();

    }

    @Override
    public User getUserById(Long id){
        logger.info("User get ID:" + id);
        return em.find(User.class, id);
    }
    @Override
    public void update(User user){
        em.merge(user);
        logger.info("User update " + user.toString());
    }
    @Override
    public void save(User user) {
        em.persist(user);
        logger.info("User save " + user.toString());
    }
    @Override
    public void delete(User user) {
        em.remove(user);
        logger.info("User deleted ID:" + user.getId());
    }
}
