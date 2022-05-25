package com.RokuEng.dao;

import com.RokuEng.entity.hero.Warrior;
import com.RokuEng.util.EMFUtil;

import javax.persistence.EntityManager;

public class WarriorDao implements Dao<Warrior, Integer>{
    @Override
    public Warrior findById(Integer id) {
        return useEntityManager(entityManager -> entityManager.find(Warrior.class, id));
    }
}
