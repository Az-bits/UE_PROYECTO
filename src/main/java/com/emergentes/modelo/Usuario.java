package com.emergentes.modelo;

public class Usuario {
    private String usuario_nro;
    private String persona_nro;
    private String usuario;

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    private String nombre_usuario;
    private String contraseña;
    private String tipo_usuario;
    private String correo_electronico;

    public String getUsuario_nro() {
        return usuario_nro;
    }

    public void setUsuario_nro(String usuario_nro) {
        this.usuario_nro = usuario_nro;
    }

    public String getPersona_nro() {
        return persona_nro;
    }

    public void setPersona_nro(String persona_nro) {
        this.persona_nro = persona_nro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario_nro=" + usuario_nro + ", persona_nro=" + persona_nro + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + ", tipo_usuario=" + tipo_usuario + ", correo_electronic=" + correo_electronico + '}';
    }
    
}
