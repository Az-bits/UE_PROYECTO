package com.emergentes.dao;

import com.emergentes.modelo.Administrativo;
import java.util.List;

public interface AdministrativoDAO {
    public void insert(Administrativo administrativo) throws Exception;
    public void update(Administrativo administrativo) throws Exception;
    public void delete(String administrativo_nro) throws Exception;
    public List<Administrativo> getAll() throws Exception;
    public Administrativo getById(String administrativo_nro) throws Exception;
    public List<Administrativo> buscar (String texto) throws Exception;
}
