package br.com.fiap.bright.dao.impl;

import br.com.fiap.bright.dao.HibernateGenericDAO;
import br.com.fiap.bright.model.Usuario;

public class UsuarioDAOImpl extends HibernateGenericDAO<Usuario, Long> {

    private static UsuarioDAOImpl instance = null;

    public UsuarioDAOImpl() {
        super(Usuario.class);
    }

    public static UsuarioDAOImpl getInstance(){
        if(instance == null){
            instance = new UsuarioDAOImpl();
        }
        return instance;
    }
}