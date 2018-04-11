package ru.bellintegrator.myproject.docs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class DocsDAO {

    private final EntityManager em;

    @Autowired
    public DocsDAO(EntityManager em) {
        this.em = em;
    }


    public List<Docs> allDocs() {
        TypedQuery<Docs> query = em.createNamedQuery("Docs.findAll", Docs.class);
        List<Docs> result = query.getResultList();

        return result;
    }


    public Docs getDocumentByName(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Docs> criteria = builder.createQuery(Docs.class);

        Root<Docs> account = criteria.from(Docs.class);
        criteria.where(builder.equal(account.get("name"), name));

        TypedQuery<Docs> query = em.createQuery(criteria);
        return query.getSingleResult();
    }

    public Docs getDocumentByCode(String code) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Docs> criteria = builder.createQuery(Docs.class);

        Root<Docs> account = criteria.from(Docs.class);
        criteria.where(builder.equal(account.get("code"), code));

        TypedQuery<Docs> query = em.createQuery(criteria);
        return query.getSingleResult();
    }


   public  void save(Docs docs){
        em.persist(docs);

    }
}
