package ru.bellintegrator.myproject.userdocs.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bellintegrator.myproject.user.service.impl.UserServiceImpl;
import ru.bellintegrator.myproject.userdocs.dao.UserDocsDAO;
import ru.bellintegrator.myproject.userdocs.model.UserDocs;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDocsDAOImpl implements UserDocsDAO {

  /*  private EntityManager em;
    private final Logger logger = LoggerFactory.getLogger(UserDocsDAOImpl.class);

    public UserDocsDAOImpl(EntityManager em) {
        this.em = em;
    }

    public UserDocsDAOImpl() {
    }
    @Override
    public List<UserDocs> list(){
        TypedQuery<UserDocs> query = em.createQuery("SELECT h FROM user h", UserDocs.class);
        return query.getResultList();
    }
    @Override
    public UserDocs getUserDocsById(Long id){
        logger.info("Userdocs get ID:" + id);
        return em.find(UserDocs.class, id);
    }
    @Override
    public void update(UserDocs userDocs){
        em.merge(userDocs);
        logger.info("Userdocs update " + userDocs.toString());

    }
    @Override
    public void save(UserDocs userDocs){
        em.persist(userDocs);
        logger.info("Userdocs save " + userDocs.toString());

    }
    @Override
    public void delete(UserDocs userDocs){
        em.remove(userDocs);
        logger.info("Userdocs deleted ID:" + userDocs.getId());


    }*/


}
