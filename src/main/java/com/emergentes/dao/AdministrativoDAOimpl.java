package com.emergentes.dao;

import com.emergentes.modelo.Administrativo;
import com.emergentes.utiles.ConexionDataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministrativoDAOimpl extends ConexionDataBase implements AdministrativoDAO {

    @Override
    public void insert(Administrativo administrativo) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO administrativo (cargo,persona_nro) VALUES (?,?)");
            ps.setString(1, administrativo.getCargo());
            ps.setString(2, administrativo.getPersona_nro());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error1: " + e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Administrativo administrativo) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE administrativo SET cargo=?, persona_nro=? WHERE administrativo_nro=?");
            ps.setString(1, administrativo.getCargo());
            ps.setString(2, administrativo.getPersona_nro());
            ps.setString(3, administrativo.getAdministrativo_nro());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error2: " + e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(String administrativo_nro) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM administrativo WHERE administrativo_nro=?");
            ps.setString(1, administrativo_nro);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error3: " + e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Administrativo> getAll() throws Exception {
        List<Administrativo> lista = null;
        try {
            this.conectar();
            String sql = "SELECT a.*, CONCAT(p.nombre,' ',p.paterno,' ',p.materno) administrativo FROM administrativo a left join persona p on p.persona_nro = a.persona_nro";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            lista = new ArrayList<Administrativo>();
            while (rs.next()) {
                Administrativo u = new Administrativo();

                u.setAdministrativo_nro(rs.getString("administrativo_nro"));
                u.setCargo(rs.getString("cargo"));
                u.setAdministrativo(rs.getString("administrativo"));
                u.setPersona_nro(rs.getString("persona_nro"));
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
    public Administrativo getById(String administrativo_nro) throws Exception {
        Administrativo u = new Administrativo();
        try {
            this.conectar();
            String sql = "select * from administrativo where administrativo_nro=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, administrativo_nro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u.setAdministrativo_nro(rs.getString("administrativo_nro"));
                u.setCargo(rs.getString("cargo"));
                u.setPersona_nro(rs.getString("persona_nro"));
            }
        } catch (SQLException e) {
            System.out.println("error5: " + e);
        } finally {
            this.desconectar();
        }
        return u;
    }

    @Override
    public List<Administrativo> buscar(String texto) throws Exception {
        List<Administrativo> lista = new ArrayList<>();
        String sql = "select * from administrativos where cod_usr like '%" + texto + "%' or nombre like '%" + texto + "%' or apellidos like '%" + texto + "%' or administrativo like '%" + texto + "%' or tipo_administrativo like '%" + texto + "%' ";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                Administrativo u = new Administrativo();
                u.setAdministrativo_nro(rs.getString("administrativo_nro"));
                u.setPersona_nro(rs.getString("administrativo_nro"));
                lista.add(u);
            }
        } catch (Exception e) {
        }
        return lista;
    }

}
