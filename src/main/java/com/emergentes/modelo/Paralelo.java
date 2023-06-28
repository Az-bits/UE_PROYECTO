package com.emergentes.modelo;

import java.util.Date;

public class Paralelo {

    private String paralelo_nro;
    private String paralelo;

    public Paralelo() {
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
        return "Paralelo{" + "paralelo_nro=" + paralelo_nro + ", paralelo=" + paralelo + '}';
    }

}
