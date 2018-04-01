package ru.bellintegrator.myproject.docs;

import org.springframework.beans.factory.annotation.Autowired;
import ru.bellintegrator.myproject.user.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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


   public  void save(Docs docs){
        em.persist(docs);

    }
}
