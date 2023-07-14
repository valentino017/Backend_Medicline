package com.medicline.spring.dao;

import java.util.List;

import com.medicline.spring.models.Usuario;

public interface UsuarioDao {
    List<Usuario> getUsuarios();

    void eliminar(Long id);

    void crear(Usuario usuario);

    Usuario getByIdUsuarios(Long id);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
