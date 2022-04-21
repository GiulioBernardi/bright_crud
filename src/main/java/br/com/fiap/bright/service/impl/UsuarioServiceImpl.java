package br.com.fiap.bright.service.impl;

import br.com.fiap.bright.dao.impl.UsuarioDAOImpl;
import br.com.fiap.bright.model.Usuario;
import br.com.fiap.bright.service.GenericService;

import java.util.List;

public class UsuarioServiceImpl extends GenericService<Usuario, Long> {

    private static UsuarioServiceImpl instance = null;
    private UsuarioDAOImpl usuarioDAO;

    private UsuarioServiceImpl(){
        this.usuarioDAO = UsuarioDAOImpl.getInstance();
    }

    public static UsuarioServiceImpl getInstance(){
        if(instance == null){
            instance = new UsuarioServiceImpl();
        }
        return instance;
    }

    @Override
    public void cadastrar(Usuario entidade) {
        try{
            usuarioDAO.salvar(entidade, getEntityManager());
        }catch (Exception e){
            getEntityManager().getTransaction().rollback();
            System.out.println("Problema ao salvar usuário");
            e.printStackTrace();
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(Usuario entidade) {
        try{
            usuarioDAO.atualizar(entidade, getEntityManager());
        }catch (Exception e){
            getEntityManager().getTransaction().rollback();
            System.out.println("Problema ao atualizar usuário");
            e.printStackTrace();
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public void remover(Long id) {
        try{
            usuarioDAO.remover(id, getEntityManager());
        }catch (Exception e){
            getEntityManager().getTransaction().rollback();
            System.out.println("Problema ao remover usuário");
            e.printStackTrace();
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public Usuario obter(Long id) {
        Usuario usuario = null;
        try{
            usuarioDAO.obterPorId(id, getEntityManager());
        }catch (Exception e){
            System.out.println("Problema ao obter usuário");
            e.printStackTrace();
        }finally {
            closeEntityManager();
        }
        return usuario;
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = null;
        try{
            usuarios = usuarioDAO.listar(getEntityManager());
        }catch (Exception e){
            System.out.println("Problema ao obter lista de usuários cadastrados");
            e.printStackTrace();
        }finally {
            closeEntityManager();
        }
        return usuarios;
    }
}
