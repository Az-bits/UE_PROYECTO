
package com.emergentes.dao;

import com.emergentes.modelo.Asignatura;
import java.util.List;


public interface AsignaturaDAO {
    public void insert(Asignatura asignatura) throws Exception;
    public void update(Asignatura asignatura) throws Exception;
    public void delete(String asignatura_nro) throws Exception;
    public List<Asignatura> getAll() throws Exception;
    public Asignatura getById(String asignatura_nro) throws Exception;
    public List<Asignatura> buscar (String texto) throws Exception;
}
