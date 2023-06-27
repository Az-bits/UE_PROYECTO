package com.emergentes.dao;

import com.emergentes.modelo.Usuario;
import java.util.List;

public interface UsuarioDAO {
    public void insert(Usuario usuario) throws Exception;
    public void update(Usuario usuario) throws Exception;
    public void delete(String usuario_nro) throws Exception;
    public List<Usuario> getAll() throws Exception;
    public Usuario getById(String usuario_nro) throws Exception;
    public List<Usuario> buscar (String texto) throws Exception;
}
