package com.medicline.spring.models;

public class AuthResponse {
    private String tokenJwt;
    private Usuario usuario;

    public AuthResponse(String tokenJwt, Usuario usuario) {
        this.tokenJwt = tokenJwt;
        this.usuario = usuario;
    }

    public String getTokenJwt() {
        return tokenJwt;
    }

    public void setTokenJwt(String tokenJwt) {
        this.tokenJwt = tokenJwt;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
