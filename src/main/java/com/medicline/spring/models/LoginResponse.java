package com.medicline.spring.models;

public class LoginResponse {
    private String nombre;
    private String apellido;
    private String email;
    private String tokenJwt;

    public LoginResponse(String nombre, String apellido, String email, String tokenJwt) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tokenJwt = tokenJwt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getTokenJwt() {
        return tokenJwt;
    }

    public void setTokenJwt(String tokenJwt) {
        this.tokenJwt = tokenJwt;
    }
}
