package com.emergentes.dao;

import com.emergentes.modelo.Tutor;
import java.util.List;

public interface TutorDAO {
    public void insert(Tutor tutor) throws Exception;
    public void update(Tutor tutor) throws Exception;
    public void delete(String tutor_nro) throws Exception;
    public List<Tutor> getAll() throws Exception;
    public Tutor getById(String tutor_nro) throws Exception;
    public List<Tutor> buscar (String texto) throws Exception;
}
