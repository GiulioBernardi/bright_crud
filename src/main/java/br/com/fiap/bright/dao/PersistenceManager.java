package br.com.fiap.bright.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

public class PersistenceManager {
    private static PersistenceManager instance = null;

    private EntityManagerFactory entityManagerFactory;

    public PersistenceManager() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("FIAP_CHALLENGE_BRIGHT");
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static PersistenceManager getInstance() {
        if (instance == null) {
            instance = new PersistenceManager();
        }
        return instance;
    }
}