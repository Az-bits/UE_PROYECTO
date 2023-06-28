package com.emergentes.modelo;

public class Tutor {

    private String tutor_nro;
    private String parentesco;
    private String persona_nro;
    private String tutor;

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public Tutor() {
    }

    public String getTutor_nro() {
        return tutor_nro;
    }

    public void setTutor_nro(String tutor_nro) {
        this.tutor_nro = tutor_nro;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getPersona_nro() {
        return persona_nro;
    }

    public void setPersona_nro(String persona_nro) {
        this.persona_nro = persona_nro;
    }

    @Override
    public String toString() {
        return "Tutor{" + "tutor_nro=" + tutor_nro + ", parentesco=" + parentesco + ", persona_nro=" + persona_nro + '}';
    }

}
