package com.emergentes.dao;

import com.emergentes.modelo.Turno;
import com.emergentes.utiles.ConexionDataBase;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class TurnoDAOimpl extends ConexionDataBase implements TurnoDAO {

    @Override
    public void insert(Turno turno) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO turno (turno,entrada,salida) values (?,?,?)");
            ps.setString(1, turno.getTurno());
            ps.setString(2, turno.getEntrada());
            ps.setString(3, turno.getSalida());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Turno turno) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE turno SET turno=?, entrada=?, salida=? WHERE turno_nro=?");

            ps.setString(1, turno.getTurno());
            ps.setString(2, turno.getEntrada());
            ps.setString(3, turno.getSalida());
            ps.setString(4, turno.getTurno_nro());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public void delete(String turno_nro) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM turno WHERE turno_nro=?");
            ps.setString(1, turno_nro);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Turno> getAll() throws Exception {
        List<Turno> lista = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM turno";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Turno>();
            while (rs.next()) {
                Turno tur = new Turno();

                tur.setTurno_nro(rs.getString("turno_nro"));
                tur.setTurno(rs.getString("turno"));
                tur.setEntrada(rs.getString("entrada"));
                tur.setSalida(rs.getString("salida"));

                lista.add(tur);
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

    public Turno getById(String turno_nro) throws Exception {
        Turno tur = new Turno();
        try {
            this.conectar();
            String sql = "select * from turno where turno_nro=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, turno_nro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tur.setTurno_nro(rs.getString("turno_nro"));
                tur.setTurno(rs.getString("turno"));
                tur.setEntrada(rs.getString("entrada"));
                tur.setSalida(rs.getString("salida"));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
        return tur;
    }

    @Override
    public List<Turno> buscar(String texto) throws Exception {
        List<Turno> lista = new ArrayList<>();
        String sql = "select e.* , CONCAT(p.nombre,' ',p.apellidos) as nombre_ppff from turnos e ,ppff p WHERE (e.rude like '%" + texto + "%' or e.ci like '%" + texto + "%' or e.nombre like '%" + texto + "%' or e.apellidos like '%" + texto + "%' or e.fecha_nacimiento like '%" + texto + "%' or e.direccion like '%" + texto + "%' or e.estado like '%" + texto + "%' or p.nombre like '%" + texto + "%' or p.apellidos like '%" + texto + "%') and e.cod_ppff = p.cod_ppff ";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                Turno tur = new Turno();

            }
        } catch (Exception e) {
        }
        return lista;
    }
}
