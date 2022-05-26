package com.RokuEng.dao;

import com.RokuEng.entity.hero.Hero;
import com.RokuEng.entity.hero.Mage;
import com.RokuEng.util.EMFUtil;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.Subgraph;
import javax.persistence.criteria.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class MageDao implements Dao<Mage, Integer> {
    @Override
    public Mage findById(Integer integer) {
        return useEntityManager(entityManager -> entityManager.find(Mage.class, integer));
    }

    public Mage findByIdWithHero(Integer id) {
        return useEntityManager(entityManager -> {

            EntityGraph<Mage> entityGraph = entityManager.createEntityGraph(Mage.class);
            entityGraph.addAttributeNodes("hero");
            entityGraph.addSubgraph("hero");

            Subgraph<Hero> subgraph = entityGraph.addSubgraph("hero");
            subgraph.addAttributeNodes("tasks");

            Map<String, Object> p = new HashMap<>();

            p.put("javax.persistence.loadgraph", entityGraph);
            return entityManager.find(Mage.class, id, p);
        });
    }

    public List<Mage> findByNameAndAndDamage(String pattern, Float health, Float damage) {
        return useEntityManager(em -> {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Mage> query = cb.createQuery(Mage.class);

            Root<Mage> from = query.from(Mage.class);
            Join<Mage, Hero> join = from.join("hero");

            query.where(cb.like(join.get("name"), pattern), cb.greaterThan(join.get("health"), health), cb.greaterThan(join.get("damage"), damage));

            return em.createQuery(query).getResultList();
        });
    }

//    public List<Mage> findByTasksNotEmpty() {
//        return useEntityManager(entityManager ->
//                entityManager.createNamedQuery("exists tasks query", Mage.class).getResultList()
//        );
//    }
//
//    public List<Mage> findByHealthGreaterMoreThat(Float health) {
//        return useEntityManager(entityManager ->
//                entityManager.createNamedQuery("health more that", Mage.class).setParameter("health", health).getResultList()
//        );
//    }
}
