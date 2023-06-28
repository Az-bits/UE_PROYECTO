package com.emergentes.modelo;

public class Grado {

    private String grado_nro;
    private String descripcion;
    private String nivel;
    private String paralelo_nro;
    private String paralelo;


    public Grado() {
    }

    public String getGrado_nro() {
        return grado_nro;
    }

    public void setGrado_nro(String grado_nro) {
        this.grado_nro = grado_nro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getParalelo_nro() {
        return paralelo_nro;
    }

    public void setParalelo_nro(String paralelo_nro) {
        this.paralelo_nro = paralelo_nro;
    }

    public String getParalelo() {
        return paralelo;
    }

    public void setParalelo(String paralelo) {
        this.paralelo = paralelo;
    }

    @Override
    public String toString() {
        return "Grado{" + "grado_nro=" + grado_nro + ", descripcion=" + descripcion + ", nivel=" + nivel + ", paralelo_nro=" + paralelo_nro + ", paralelo=" + paralelo + '}';
    }
    

    

}
