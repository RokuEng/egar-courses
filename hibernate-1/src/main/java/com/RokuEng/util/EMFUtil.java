package com.RokuEng.util;

import lombok.experimental.UtilityClass;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@UtilityClass
public class EMFUtil {

    private EntityManagerFactory emf;

    public EntityManagerFactory entityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("RPGPersistence");
        }
        return emf;
    }
}
