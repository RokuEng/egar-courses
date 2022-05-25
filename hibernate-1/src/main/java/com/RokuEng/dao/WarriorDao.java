package com.RokuEng.dao;

import com.RokuEng.entity.Warrior;
import com.RokuEng.util.EMFUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

public class WarriorDao {
    private final EntityManagerFactory emf = EMFUtil.entityManagerFactory();

    public Warrior findById(Integer id) {
        return emf.createEntityManager().find(Warrior.class, id);
    }

    public Warrior save(Warrior w) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        if (w.getId() == null) {
            entityManager.persist(w);
            entityManager.getTransaction().commit();
            return w;
        } else {
            entityManager.getTransaction().commit();
            return entityManager.merge(w);
        }
    }
}
