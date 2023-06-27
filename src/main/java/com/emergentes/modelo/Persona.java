package com.emergentes.modelo;

import java.util.Date;

public class Persona {

    private String persona_nro;
    private String ci;
    private String nombre;
    private String paterno;
    private String materno;
    private String fecha_nac;
    private String direccion;
    private int telefono;

    public Persona() {
    }

    public String getPersona_nro() {
        return persona_nro;
    }

    public void setPersona_nro(String persona_nro) {
        this.persona_nro = persona_nro;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "persona_nro=" + persona_nro + ", ci=" + ci + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", fecha_nac=" + fecha_nac + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
}
