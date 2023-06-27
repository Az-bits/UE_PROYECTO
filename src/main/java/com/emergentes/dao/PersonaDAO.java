
package com.emergentes.dao;

import com.emergentes.modelo.Persona;
import java.util.List;


public interface PersonaDAO {
    public void insert(Persona persona) throws Exception;
    public void update(Persona persona) throws Exception;
    public void delete(String persona_nro) throws Exception;
    public List<Persona> getAll() throws Exception;
    public Persona getById(String persona_nro) throws Exception;
    public List<Persona> buscar (String texto) throws Exception;
}
