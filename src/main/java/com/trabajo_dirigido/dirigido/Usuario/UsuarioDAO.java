package com.trabajo_dirigido.dirigido.Usuario;

import java.util.List;


public interface UsuarioDAO {
    public Usuario buscaUsuario(String dni);
    public List<Usuario> buscaTodos();
    public void crea(Usuario usuario);
    //public boolean comprobar_asistencia(Usuario usuario);

}
