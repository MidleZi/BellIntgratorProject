package ru.bellintegrator.myproject.user.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.myproject.user.dao.UserDAO;
import ru.bellintegrator.myproject.user.model.User;
import ru.bellintegrator.myproject.user.view.UserFilterView;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManager em;
    private final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

    @Autowired
    public UserDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<User> getAllUser(){
        TypedQuery<User> query = em.createQuery("User.findAll", User.class);
        List<User> result =  query.getResultList();
        return result;
    }

    @Override
    public List<User> list(UserFilterView filter){
        UserDAOImpl.UserCriteriaConverter converter = new UserDAOImpl.UserCriteriaConverter(filter);
        CriteriaQuery cq = converter.getCriteriaQuery();
        Root<User> user = converter.getRoot();
        List<Predicate> predicates = converter.getPredicates();

        cq.select(user)
                .where(predicates.toArray(new Predicate[]{}));

        logger.info("Geted List" + em.createQuery(cq).getResultList() );

        return em.createQuery(cq).getResultList();
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
    public void delete(Long id) {
        User user = em.find(User.class, id);
        logger.info("User deleted ID:" + user.getId());
        em.remove(user);
        //logger.info("User deleted ID:" + user.getId());
    }

    private class UserCriteriaConverter {
        private final UserFilterView filter;

        private final List<Predicate> predicates = new ArrayList<>();
        private Root<User> user;
        private CriteriaQuery criteriaQuery;

        public UserCriteriaConverter(UserFilterView filter) {
            this.filter = filter;
            makePredicates();
        }

        private void makePredicates() {
            String officeId = filter.officeId;
            String firstName = filter.firstName;
            String secondName = filter.secondName;
            String midleName = filter.midleName;
            String position = filter.position;
            String docCode = filter.docCode;
            String citizenshipCode = filter.citizenshipCode;

            CriteriaBuilder qb = em.getCriteriaBuilder();
            criteriaQuery = qb.createQuery();
            user = criteriaQuery.from(User.class);

            if(officeId != null){
                predicates.add(
                        qb.equal(user.get("office").get("id"), officeId));
            }

            if (firstName != null) {
                predicates.add(
                        qb.like(user.<String>get("firstName"), "%" + firstName + "%"));
            }
            if (secondName != null) {
                predicates.add(
                        qb.equal(user.<String>get("secondName"), secondName));
            }
            if (midleName != null) {
                predicates.add(
                        qb.equal(user.get("midleName"), midleName));
            }
            if (position != null) {
                predicates.add(
                        qb.equal(user.get("position"), position));
            }
            if (docCode != null) {
                predicates.add(
                        qb.equal(user.get("docs").get("code"), docCode));
            }
            if (citizenshipCode != null) {
                predicates.add(
                        qb.equal(user.get("countries").get("code"), citizenshipCode));
            }
        }


        public List<Predicate> getPredicates() {
            return predicates;
        }

        public Root<User> getRoot() {
            return user;
        }

        public CriteriaQuery getCriteriaQuery() {
            return criteriaQuery;
        }

    }
}
