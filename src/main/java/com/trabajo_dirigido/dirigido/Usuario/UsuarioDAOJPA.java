package com.trabajo_dirigido.dirigido.Usuario;

import com.trabajo_dirigido.dirigido.qualifiers.DAOJpa;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository("usuarioJPA")
@Transactional
public class UsuarioDAOJPA implements UsuarioDAO{
    private final Logger logger = Logger.getLogger(UsuarioDAOJPA.class.getName());
    @PersistenceContext
    private EntityManager em;

    public UsuarioDAOJPA(){

    }

    @Override
    public Usuario buscaUsuario(String dni) {
        Usuario u = null;
        try{
            u = em.find(Usuario.class, dni);
        }catch (Exception ex){
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return u;
    }

    @Override
    public List<Usuario> buscaTodos(){
        List<Usuario> lu = null;
        try {
            Query q = em.createQuery("Select u from Usuario u", Usuario.class);
            lu = (List<Usuario>)q.getResultList();
        }catch(Exception ex){
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lu;
    }

    @Override
    public void crea(Usuario usuario) {
        try {
            em.persist(usuario);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    /*
    @Override
    public boolean comprobar_asistencia(Usuario usuario){
        return false;
    }

     */
}
