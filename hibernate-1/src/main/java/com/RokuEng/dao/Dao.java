package com.RokuEng.dao;

import com.RokuEng.entity.Persistent;
import com.RokuEng.util.EMFUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.function.Function;

public interface Dao<T extends Persistent, ID> {
    T findById(ID id);

    default T save(T t) {
        EntityManager entityManager = EMFUtil.entityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        if (t.getId() == null) {
            entityManager.persist(t);
            entityManager.getTransaction().commit();
            entityManager.close();
            return t;
        } else {
            entityManager.getTransaction().commit();
            T merge = entityManager.merge(t);
            entityManager.close();
            return merge;
        }
    }

    default <T> T useEntityManager(Function<EntityManager, T> function) {
        EntityManager entityManager = EMFUtil.entityManagerFactory().createEntityManager();
        T result = function.apply(entityManager);
//        entityManager.close();
        return result;
    }
}
