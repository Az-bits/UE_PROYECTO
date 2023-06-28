package com.emergentes.dao;

import com.emergentes.modelo.Estudiante;
import com.emergentes.utiles.ConexionDataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAOimpl extends ConexionDataBase implements EstudianteDAO {

    @Override
    public void insert(Estudiante estudiante) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO estudiante (rude,persona_nro,tutor_nro) VALUES (?,?,?)");
            ps.setInt(1, estudiante.getRude());
            ps.setString(2, estudiante.getPersona_nro());
            ps.setString(3, estudiante.getTutor_nro());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error1: " + e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Estudiante estudiante) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE estudiante SET rude=?, persona_nro=?, tutor_nro=? WHERE estudiante_nro=?");
            ps.setInt(1, estudiante.getRude());
            ps.setString(2, estudiante.getPersona_nro());
            ps.setString(3, estudiante.getTutor_nro());
            ps.setString(4, estudiante.getEstudiante_nro());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error2: " + e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(String estudiante_nro) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM estudiante WHERE estudiante_nro=?");
            ps.setString(1, estudiante_nro);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error3: " + e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Estudiante> getAll() throws Exception {
        List<Estudiante> lista = null;
        try {
            this.conectar();
            String sql = "SELECT a.*, CONCAT(p.nombre,' ',p.paterno,' ',p.materno) estudiante FROM estudiante a left join persona p on p.persona_nro = a.persona_nro";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            lista = new ArrayList<Estudiante>();
            while (rs.next()) {
                Estudiante u = new Estudiante();

                u.setEstudiante_nro(rs.getString("estudiante_nro"));
                u.setCargo(rs.getString("cargo"));
                u.setEstudiante(rs.getString("estudiante"));
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
    public Estudiante getById(String estudiante_nro) throws Exception {
        Estudiante u = new Estudiante();
        try {
            this.conectar();
            String sql = "select * from estudiante where estudiante_nro=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, estudiante_nro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u.setEstudiante_nro(rs.getString("estudiante_nro"));
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
    public List<Estudiante> buscar(String texto) throws Exception {
        List<Estudiante> lista = new ArrayList<>();
        String sql = "select * from estudiantes where cod_usr like '%" + texto + "%' or nombre like '%" + texto + "%' or apellidos like '%" + texto + "%' or estudiante like '%" + texto + "%' or tipo_estudiante like '%" + texto + "%' ";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                Estudiante u = new Estudiante();
                u.setEstudiante_nro(rs.getString("estudiante_nro"));
                u.setPersona_nro(rs.getString("estudiante_nro"));
                lista.add(u);
            }
        } catch (Exception e) {
        }
        return lista;
    }

}
