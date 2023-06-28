package com.emergentes.modelo;

public class Administrativo {
    private String administrativo_nro;
    private String cargo;
    private String persona_nro;

    public String getAdministrativo() {
        return administrativo;
    }

    public void setAdministrativo(String administrativo) {
        this.administrativo = administrativo;
    }
    private String administrativo;

    public Administrativo() {
    }

    public String getAdministrativo_nro() {
        return administrativo_nro;
    }

    public void setAdministrativo_nro(String administrativo_nro) {
        this.administrativo_nro = administrativo_nro;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPersona_nro() {
        return persona_nro;
    }

    public void setPersona_nro(String persona_nro) {
        this.persona_nro = persona_nro;
    }

    @Override
    public String toString() {
        return "Administrativo{" + "administrativo_nro=" + administrativo_nro + ", cargo=" + cargo + ", persona_nro=" + persona_nro + '}';
    }

   
    
}
