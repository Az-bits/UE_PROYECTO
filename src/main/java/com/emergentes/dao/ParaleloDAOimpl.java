package com.emergentes.dao;

import com.emergentes.modelo.Paralelo;
import com.emergentes.utiles.ConexionDataBase;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class ParaleloDAOimpl extends ConexionDataBase implements ParaleloDAO {

    @Override
    public void insert(Paralelo paralelo) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO paralelo (paralelo) values (?)");
            ps.setString(1, paralelo.getParalelo());
            
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Paralelo paralelo) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE paralelo SET paralelo=? WHERE paralelo_nro=?");

            ps.setString(1, paralelo.getParalelo());
            ps.setString(4, paralelo.getParalelo_nro());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public void delete(String paralelo_nro) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM paralelo WHERE paralelo_nro=?");
            ps.setString(1, paralelo_nro);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Paralelo> getAll() throws Exception {
        List<Paralelo> lista = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM paralelo";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Paralelo>();
            while (rs.next()) {
                Paralelo tur = new Paralelo();

                tur.setParalelo_nro(rs.getString("paralelo_nro"));
                tur.setParalelo(rs.getString("paralelo"));

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

    public Paralelo getById(String paralelo_nro) throws Exception {
        Paralelo tur = new Paralelo();
        try {
            this.conectar();
            String sql = "select * from paralelo where paralelo_nro=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, paralelo_nro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tur.setParalelo_nro(rs.getString("paralelo_nro"));
                tur.setParalelo(rs.getString("paralelo"));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
        return tur;
    }

    @Override
    public List<Paralelo> buscar(String texto) throws Exception {
        List<Paralelo> lista = new ArrayList<>();
        String sql = "select e.* , CONCAT(p.nombre,' ',p.apellidos) as nombre_ppff from paralelos e ,ppff p WHERE (e.rude like '%" + texto + "%' or e.ci like '%" + texto + "%' or e.nombre like '%" + texto + "%' or e.apellidos like '%" + texto + "%' or e.fecha_nacimiento like '%" + texto + "%' or e.direccion like '%" + texto + "%' or e.estado like '%" + texto + "%' or p.nombre like '%" + texto + "%' or p.apellidos like '%" + texto + "%') and e.cod_ppff = p.cod_ppff ";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                Paralelo tur = new Paralelo();

            }
        } catch (Exception e) {
        }
        return lista;
    }
}
