package com.emergentes.dao;

import com.emergentes.modelo.Asignatura;
import com.emergentes.utiles.ConexionDataBase;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class AsignaturaDAOimpl extends ConexionDataBase implements AsignaturaDAO {

    @Override
    public void insert(Asignatura asignatura) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO asignatura (descripcion,sigla) values (?,?)");
            ps.setString(1, asignatura.getDescripcion());
            ps.setString(2, asignatura.getSigla());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Asignatura asignatura) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE asignatura SET descripcion=?, sigla=? WHERE asignatura_nro=?");

            ps.setString(1, asignatura.getDescripcion());
            ps.setString(2, asignatura.getSigla());
            ps.setString(3, asignatura.getAsignatura_nro());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public void delete(String asignatura_nro) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM asignatura WHERE asignatura_nro=?");
            ps.setString(1, asignatura_nro);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Asignatura> getAll() throws Exception {
        List<Asignatura> lista = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM asignatura";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Asignatura>();
            while (rs.next()) {
                Asignatura per = new Asignatura();

                per.setAsignatura_nro(rs.getString("asignatura_nro"));
                per.setDescripcion(rs.getString("descripcion"));
                per.setSigla(rs.getString("sigla"));
                
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

    public Asignatura getById(String asignatura_nro) throws Exception {
        Asignatura per = new Asignatura();
        try {
            this.conectar();
            String sql = "select * from asignatura where asignatura_nro=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, asignatura_nro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                per.setAsignatura_nro(rs.getString("asignatura_nro"));
                per.setDescripcion(rs.getString("descripcion"));
                per.setSigla(rs.getString("sigla"));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
        return per;
    }

    @Override
    public List<Asignatura> buscar(String texto) throws Exception {
        List<Asignatura> lista = new ArrayList<>();
        String sql = "select e.* , CONCAT(p.nombre,' ',p.apellidos) as nombre_ppff from asignaturas e ,ppff p WHERE (e.rude like '%" + texto + "%' or e.ci like '%" + texto + "%' or e.nombre like '%" + texto + "%' or e.apellidos like '%" + texto + "%' or e.fecha_nacimiento like '%" + texto + "%' or e.direccion like '%" + texto + "%' or e.estado like '%" + texto + "%' or p.nombre like '%" + texto + "%' or p.apellidos like '%" + texto + "%') and e.cod_ppff = p.cod_ppff ";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                Asignatura per = new Asignatura();
              
            }
        } catch (Exception e) {
        }
        return lista;
    }
}
