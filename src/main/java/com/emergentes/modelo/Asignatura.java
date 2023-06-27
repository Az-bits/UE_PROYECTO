package com.emergentes.modelo;

import java.util.Date;

public class Asignatura {

    private String asignatura_nro;
    private String descripcion;
    private String sigla;

    public Asignatura() {
    }

    public String getAsignatura_nro() {
        return asignatura_nro;
    }

    public void setAsignatura_nro(String asignatura_nro) {
        this.asignatura_nro = asignatura_nro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "asignatura_nro=" + asignatura_nro + ", descripcion=" + descripcion + ", sigla=" + sigla + '}';
    }

}
