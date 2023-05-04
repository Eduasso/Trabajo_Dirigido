package com.trabajo_dirigido.dirigido.Usuario;

import com.trabajo_dirigido.dirigido.qualifiers.DAOMap;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped @DAOMap
public class UsuarioDAOMap implements UsuarioDAO, Serializable {
    private Map<String, Usuario> usuarios = null;
    public UsuarioDAOMap(){
        if (usuarios == null){
            usuarios = new HashMap<>();
            usuarios.put("66666666Z", new Usuario("Carlos","Alcaraz","66666666Z", "953535353", "C/ Ilustrador de Zaragoza","calcaraz@gmail.com","12345678910.,"));
        }
    }
    @Override
    public Usuario buscaUsuario(String dni){
        return usuarios.get(dni);
    }
    @Override
    public List<Usuario> buscaTodos(){
        return usuarios.values().stream().collect(Collectors.toList());
    }

    public int numUsuarios(){
        return usuarios.size();
    }
    @Override
    public void crea(Usuario usuario) {
        usuarios.put(usuario.getDni(), usuario);
    }

    /*
    @Override
    public boolean comprobar_asistencia(Usuario usuario){
        boolean sesion = false;
        for (Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
            if (entry.getValue().getCorreo().equals(usuario.getCorreo())){
                if(entry.getValue().getPassword().equals(usuario.getPassword())){
                    sesion = true;
                    lastDNI = entry.getKey();
                }
            }
        }
        return sesion;
    }

     */
}
