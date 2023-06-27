package com.emergentes.dao;

import com.emergentes.modelo.Usuario;
import com.emergentes.utiles.ConexionDataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOimpl extends ConexionDataBase implements UsuarioDAO {

    @Override
    public void insert(Usuario usuario) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO usuario (persona_nro,usuario,contraseña,tipo_usuario,correo_electronico) VALUES (?,?,?,?,?)");
            ps.setString(1, usuario.getPersona_nro());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getContraseña());
            ps.setString(4, usuario.getTipo_usuario());
            ps.setString(5, usuario.getCorreo_electronico());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error1: " + e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Usuario usuario) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE usuario SET persona_nro=?, usuario=?, contraseña=?, tipo_usuario=?, correo_electronico=? WHERE usuario_nro=?");
            ps.setString(1, usuario.getPersona_nro());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getContraseña());
            ps.setString(4, usuario.getTipo_usuario());
            ps.setString(5, usuario.getCorreo_electronico());
            ps.setString(6, usuario.getUsuario_nro());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error2: " + e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(String usuario_nro) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM usuario WHERE usuario_nro=?");
            ps.setString(1, usuario_nro);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error3: " + e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Usuario> getAll() throws Exception {
        List<Usuario> lista = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM usuario";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            lista = new ArrayList<Usuario>();
            while (rs.next()) {
                Usuario u = new Usuario();

                u.setUsuario_nro(rs.getString("usuario_nro"));
                u.setPersona_nro(rs.getString("persona_nro"));
                u.setUsuario(rs.getString("usuario"));
                u.setContraseña(rs.getString("contraseña"));
                u.setTipo_usuario(rs.getString("tipo_usuario"));
                u.setCorreo_electronico(rs.getString("correo_electronico"));
                lista.add(u);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("error4: " + e);
        } finally {
            this.desconectar();
        }
        return lista;
    }

    @Override
    public Usuario getById(String usuario_nro) throws Exception {
        Usuario u = new Usuario();
        try {
            this.conectar();
            String sql = "select * from usuario where usuario_nro=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, usuario_nro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u.setUsuario_nro(rs.getString("usuario_nro"));
                u.setPersona_nro(rs.getString("persona_nro"));
                u.setUsuario(rs.getString("usuario"));
                u.setContraseña(rs.getString("contraseña"));
                u.setTipo_usuario(rs.getString("tipo_usuario"));
                u.setCorreo_electronico(rs.getString("correo_electronico"));
            }
        } catch (SQLException e) {
            System.out.println("error5: " + e);
        } finally {
            this.desconectar();
        }
        return u;
    }

    @Override
    public List<Usuario> buscar(String texto) throws Exception {
        List<Usuario> lista = new ArrayList<>();
        String sql = "select * from usuarios where cod_usr like '%" + texto + "%' or nombre like '%" + texto + "%' or apellidos like '%" + texto + "%' or usuario like '%" + texto + "%' or tipo_usuario like '%" + texto + "%' ";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setUsuario_nro(rs.getString("usuario_nro"));
                u.setPersona_nro(rs.getString("persona_nro"));
                u.setUsuario(rs.getString("usuario"));
                u.setContraseña(rs.getString("contraseña"));
                u.setTipo_usuario(rs.getString("tipo_usuario"));
                u.setCorreo_electronico(rs.getString("correo_electronico"));
                lista.add(u);
            }
        } catch (Exception e) {
        }
        return lista;
    }

}
