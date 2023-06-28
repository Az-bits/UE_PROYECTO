package com.emergentes.dao;

import com.emergentes.modelo.Tutor;
import com.emergentes.utiles.ConexionDataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TutorDAOimpl extends ConexionDataBase implements TutorDAO {

    @Override
    public void insert(Tutor tutor) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO tutor (parentesco,persona_nro) VALUES (?,?)");
            ps.setString(1, tutor.getParentesco());
            ps.setString(2, tutor.getPersona_nro());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error1: " + e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Tutor tutor) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE tutor SET parentesco=?, persona_nro=? WHERE tutor_nro=?");
            ps.setString(1, tutor.getParentesco());
            ps.setString(2, tutor.getPersona_nro());
            ps.setString(3, tutor.getTutor_nro());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error2: " + e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(String tutor_nro) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM tutor WHERE tutor_nro=?");
            ps.setString(1, tutor_nro);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error3: " + e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Tutor> getAll() throws Exception {
        List<Tutor> lista = null;
        try {
            this.conectar();
            String sql = "SELECT t.*, CONCAT(p.nombre,' ',p.paterno,' ',p.materno) tutor FROM tutor t left join persona p on p.persona_nro = t.persona_nro";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Tutor>();
            while (rs.next()) {
                Tutor u = new Tutor();
                u.setTutor_nro(rs.getString("tutor_nro"));
                u.setParentesco(rs.getString("parentesco"));
                u.setTutor(rs.getString("tutor"));
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
    public Tutor getById(String tutor_nro) throws Exception {
        Tutor u = new Tutor();
        try {
            this.conectar();
            String sql = "select * from tutor where tutor_nro=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, tutor_nro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u.setTutor_nro(rs.getString("tutor_nro"));
                u.setParentesco(rs.getString("parentesco"));
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
    public List<Tutor> buscar(String texto) throws Exception {
        List<Tutor> lista = new ArrayList<>();
        String sql = "select * from tutor where cod_usr like '%" + texto + "%' or nombre like '%" + texto + "%' or apellidos like '%" + texto + "%' or tutor like '%" + texto + "%' or tipo_tutor like '%" + texto + "%' ";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                Tutor u = new Tutor();
                u.setTutor_nro(rs.getString("tutor_nro"));
                u.setPersona_nro(rs.getString("tutor_nro"));
                lista.add(u);
            }
        } catch (Exception e) {
        }
        return lista;
    }

}
