package com.RokuEng.dao;

import com.RokuEng.entity.Persistent;
import com.RokuEng.util.EMFUtil;
import com.RokuEng.util.TriFunction;

import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.function.BiFunction;
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
        EntityManager em = EMFUtil.entityManagerFactory().createEntityManager();
        T result = function.apply(em);

        if (fetchType == FetchType.EAGER) {
            em.close();
        }

        return result;
    }

    default <T> T useEntityManager(Function<EntityManager, T> function) {
        return useEntityManager(FetchType.LAZY, function);
    }

//    default List<E> useCriteriaQuery(Class<E> clazz, BiFunction<CriteriaBuilder, CriteriaQuery<E>, CriteriaQuery<E>> function) {
//        return useEntityManager(em ->
//        {
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<E> query = cb.createQuery(clazz);
//            query = function.apply(cb, query);
//            return em.createQuery(query).getResultList();
//        });
//    }

    default List<E> useCriteriaQuery(Class<E> clazz, TriFunction<CriteriaBuilder, CriteriaQuery<E>, Root<E>, CriteriaQuery<E>> function) {
        return useEntityManager(em ->
        {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<E> query = cb.createQuery(clazz);
            Root<E> root = query.from(clazz);
            query = function.apply(cb, query, root);
            return em.createQuery(query).getResultList();
        });
    }
}
