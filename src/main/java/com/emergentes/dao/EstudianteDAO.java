package com.emergentes.dao;

import com.emergentes.modelo.Estudiante;
import java.util.List;

public interface EstudianteDAO {
    public void insert(Estudiante estudiante) throws Exception;
    public void update(Estudiante estudiante) throws Exception;
    public void delete(String estudiante_nro) throws Exception;
    public List<Estudiante> getAll() throws Exception;
    public Estudiante getById(String estudiante_nro) throws Exception;
    public List<Estudiante> buscar (String texto) throws Exception;
}
