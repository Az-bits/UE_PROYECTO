
package com.emergentes.dao;

import com.emergentes.modelo.Turno;
import java.util.List;


public interface TurnoDAO {
    public void insert(Turno turno) throws Exception;
    public void update(Turno turno) throws Exception;
    public void delete(String turno_nro) throws Exception;
    public List<Turno> getAll() throws Exception;
    public Turno getById(String turno_nro) throws Exception;
    public List<Turno> buscar (String texto) throws Exception;
}
