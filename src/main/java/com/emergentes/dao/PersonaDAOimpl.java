package com.emergentes.dao;

import com.emergentes.modelo.Persona;
import com.emergentes.utiles.ConexionDataBase;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class PersonaDAOimpl extends ConexionDataBase implements PersonaDAO {

    @Override
    public void insert(Persona persona) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO persona (ci,nombre,paterno,materno,fecha_nac,direccion,telefono) values (?,?,?,?,?,?,?)");
            ps.setString(1, persona.getCi());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getPaterno());
            ps.setString(4, persona.getMaterno());
            ps.setString(5, persona.getFecha_nac());
            ps.setString(6, persona.getDireccion());
            ps.setInt(7, persona.getTelefono());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Persona persona) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE persona SET ci=?, nombre=? , paterno=? , materno=?,fecha_nac=?,direccion=?,telefono=? WHERE persona_nro=?");

            ps.setString(1, persona.getCi());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getPaterno());
            ps.setString(4, persona.getMaterno());
            ps.setString(5, persona.getFecha_nac());
            ps.setString(6, persona.getDireccion());
            ps.setInt(7, persona.getTelefono());
            ps.setString(8, persona.getPersona_nro());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public void delete(String persona_nro) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM persona WHERE persona_nro=?");
            ps.setString(1, persona_nro);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Persona> getAll() throws Exception {
        List<Persona> lista = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM persona";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Persona>();
            while (rs.next()) {
                Persona per = new Persona();

                per.setPersona_nro(rs.getString("persona_nro"));
                per.setCi(rs.getString("ci"));
                per.setNombre(rs.getString("nombre"));
                per.setPaterno(rs.getString("paterno"));
                per.setMaterno(rs.getString("materno"));
                per.setFecha_nac(rs.getString("fecha_nac"));
                per.setDireccion(rs.getString("direccion"));
                per.setTelefono(rs.getInt("telefono"));

                lista.add(per);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

    public Persona getById(String persona_nro) throws Exception {
        Persona per = new Persona();
        try {
            this.conectar();
            String sql = "select * from persona where persona_nro=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, persona_nro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                per.setPersona_nro(rs.getString("persona_nro"));
                per.setCi(rs.getString("ci"));
                per.setNombre(rs.getString("nombre"));
                per.setPaterno(rs.getString("paterno"));
                per.setMaterno(rs.getString("materno"));
                per.setFecha_nac(rs.getString("fecha_nac"));
                per.setDireccion(rs.getString("direccion"));
                per.setTelefono(rs.getInt("telefono"));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
        return per;
    }

    @Override
    public List<Persona> buscar(String texto) throws Exception {
        List<Persona> lista = new ArrayList<>();
        String sql = "select e.* , CONCAT(p.nombre,' ',p.apellidos) as nombre_ppff from personas e ,ppff p WHERE (e.rude like '%" + texto + "%' or e.ci like '%" + texto + "%' or e.nombre like '%" + texto + "%' or e.apellidos like '%" + texto + "%' or e.fecha_nacimiento like '%" + texto + "%' or e.direccion like '%" + texto + "%' or e.estado like '%" + texto + "%' or p.nombre like '%" + texto + "%' or p.apellidos like '%" + texto + "%') and e.cod_ppff = p.cod_ppff ";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                Persona per = new Persona();
                per.setPersona_nro(rs.getString("persona_nro"));
                per.setCi(rs.getString("ci"));
                per.setNombre(rs.getString("nombre"));
                per.setPaterno(rs.getString("paterno"));
                per.setMaterno(rs.getString("materno"));
                per.setFecha_nac(rs.getString("fecha_nac"));
                per.setDireccion(rs.getString("direccion"));
                per.setTelefono(rs.getInt("telefono"));
                lista.add(per);
            }
        } catch (Exception e) {
        }
        return lista;
    }
}
