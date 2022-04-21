package br.com.fiap.bright.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class HibernateGenericDAO <T extends Serializable, PK extends Serializable> implements GenericDAO<T, PK>{

    public Class<T> type;

    public HibernateGenericDAO(Class<T> type){
        this.type = type;
    }

    @Override
    public void salvar(T entidade, EntityManager entityManager) {
        entityManager.persist(entidade);
    }

    @Override
    public void atualizar(T entidade, EntityManager entityManager) {
        entityManager.merge(entidade);
    }

    @Override
    public void remover(PK id, EntityManager entityManager) {
        T entidade = obterPorId(id, entityManager);
        entityManager.remove(entidade);
    }

    @Override
    public T obterPorId(PK id, EntityManager entityManager) {
        return entityManager.find(type, id);
    }

    @Override
    public List<T> listar(EntityManager entityManager) {
        Query consulta = entityManager.createQuery("SELECT u FROM " + type.getName()+ " u");
        return consulta.getResultList();
    }
}