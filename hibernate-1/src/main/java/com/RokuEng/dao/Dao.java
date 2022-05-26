package com.RokuEng.dao;

import com.RokuEng.entity.Persistent;
import com.RokuEng.util.EMFUtil;

import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import java.util.function.Function;

public interface Dao<E extends Persistent<? extends ID>, ID> {
    E findById(ID id);

    default E save(E e) {
        EntityManager entityManager = EMFUtil.entityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        if (e.getId() == null) {
            entityManager.persist(e);
            entityManager.getTransaction().commit();
            return e;
        } else {
            E merge = entityManager.merge(e);
            entityManager.getTransaction().commit();
            return merge;
        }
    }

    default <T> T useEntityManager(FetchType fetchType, Function<EntityManager, T> function) {
        EntityManager entityManager = EMFUtil.entityManagerFactory().createEntityManager();
        T result = function.apply(entityManager);

        if (fetchType == FetchType.EAGER) {
            entityManager.close();
        }

        return result;
    }

    default <T> T useEntityManager(Function<EntityManager, T> function) {
        EntityManager entityManager = EMFUtil.entityManagerFactory().createEntityManager();
        T result = function.apply(entityManager);
        return result;
    }
}
