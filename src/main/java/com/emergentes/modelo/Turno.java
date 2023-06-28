package com.emergentes.modelo;

import java.util.Date;

public class Turno {

    private String turno_nro;
    private String turno;
    private String entrada;
    private String salida;

    public Turno() {
    }

    public String getTurno_nro() {
        return turno_nro;
    }

    public void setTurno_nro(String turno_nro) {
        this.turno_nro = turno_nro;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    @Override
    public String toString() {
        return "Turno{" + "turno_nro=" + turno_nro + ", turno=" + turno + ", entrada=" + entrada + ", salida=" + salida + '}';
    }
}
