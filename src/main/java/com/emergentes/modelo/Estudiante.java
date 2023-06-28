package com.emergentes.modelo;

public class Estudiante {

    private String estudiante_nro;
    private int rude;
    private String persona_nro;
    private String estudiante;
    private String tutor;
    private String tutor_nro;

    public Estudiante() {
    }

    public String getEstudiante_nro() {
        return estudiante_nro;
    }

    public void setEstudiante_nro(String estudiante_nro) {
        this.estudiante_nro = estudiante_nro;
    }

    public int getRude() {
        return rude;
    }

    public void setRude(int rude) {
        this.rude = rude;
    }

    public String getPersona_nro() {
        return persona_nro;
    }

    public void setPersona_nro(String persona_nro) {
        this.persona_nro = persona_nro;
    }

    public String getTutor_nro() {
        return tutor_nro;
    }

    public void setTutor_nro(String tutor_nro) {
        this.tutor_nro = tutor_nro;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "estudiante_nro=" + estudiante_nro + ", rude=" + rude + ", persona_nro=" + persona_nro + ", tutor_nro=" + tutor_nro + '}';
    }

}
