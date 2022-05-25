package com.RokuEng.dao;

import com.RokuEng.entity.hero.Mage;
import com.RokuEng.util.EMFUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class MageDao implements Dao<Mage, Integer> {
    @Override
    public Mage findById(Integer integer) {
        return useEntityManager(entityManager -> entityManager.find(Mage.class, integer));
    }

    public List<Mage> findByTasksNotEmpty() {
        return useEntityManager(entityManager ->
                entityManager.createNamedQuery("exists tasks query", Mage.class).getResultList()
        );
    }

    public List<Mage> findByHealthGreaterMoreThat(Float health) {
        return useEntityManager(entityManager ->
                entityManager.createNamedQuery("health more that", Mage.class).setParameter("health", health).getResultList()
        );
    }
}
