package com.emergentes.dao;

import com.emergentes.modelo.Grado;
import com.emergentes.utiles.ConexionDataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradoDAOimpl extends ConexionDataBase implements GradoDAO {

    @Override
    public void insert(Grado grado) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO grado (descripcion,nivel,paralelo_nro) VALUES (?,?,?)");
            ps.setString(1, grado.getDescripcion());
            ps.setString(2, grado.getNivel());
            ps.setString(3, grado.getParalelo_nro());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error1: " + e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Grado grado) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE grado SET descripcion=?, nivel=?, paralelo_nro=? WHERE grado_nro=?");
            ps.setString(1, grado.getDescripcion());
            ps.setString(2, grado.getNivel());
            ps.setString(3, grado.getParalelo_nro());
            ps.setString(4, grado.getGrado_nro());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error2: " + e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(String grado_nro) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM grado WHERE grado_nro=?");
            ps.setString(1, grado_nro);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error3: " + e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Grado> getAll() throws Exception {
        List<Grado> lista = null;
        try {
            this.conectar();
            String sql = "SELECT g.*, paralelo FROM grado g"
                    + " left join paralelo p on p.paralelo_nro = g.paralelo_nro";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            lista = new ArrayList<Grado>();
            while (rs.next()) {
                Grado u = new Grado();

                u.setGrado_nro(rs.getString("grado_nro"));
                u.setDescripcion(rs.getString("descripcion"));
                u.setNivel(rs.getString("nivel"));
                u.setParalelo(rs.getString("paralelo"));
                u.setParalelo_nro(rs.getString("paralelo_nro"));
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
    public Grado getById(String grado_nro) throws Exception {
        Grado u = new Grado();
        try {
            this.conectar();
            String sql = "select * from grado where grado_nro=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, grado_nro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u.setGrado_nro(rs.getString("grado_nro"));
                u.setDescripcion(rs.getString("descripcion"));
                u.setNivel(rs.getString("nivel"));
                u.setParalelo_nro(rs.getString("paralelo_nro"));
            }
        } catch (SQLException e) {
            System.out.println("error5: " + e);
        } finally {
            this.desconectar();
        }
        return u;
    }

    @Override
    public List<Grado> buscar(String texto) throws Exception {
        List<Grado> lista = new ArrayList<>();
        String sql = "select * from grados where cod_usr like '%" + texto + "%' or nombre like '%" + texto + "%' or apellidos like '%" + texto + "%' or grado like '%" + texto + "%' or tipo_grado like '%" + texto + "%' ";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                Grado u = new Grado();
                u.setGrado_nro(rs.getString("grado_nro"));
                
                lista.add(u);
            }
        } catch (Exception e) {
        }
        return lista;
    }

}
