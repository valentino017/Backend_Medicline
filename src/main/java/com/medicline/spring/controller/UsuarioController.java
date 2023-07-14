package com.medicline.spring.controller;

 
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.medicline.spring.dao.UsuarioDao;
import com.medicline.spring.models.Usuario;
import com.medicline.spring.utils.JWTUtil;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3002/")
@RestController
public class UsuarioController {

    @Autowired 
    private UsuarioDao usuarioDao; 

    @Autowired
    private JWTUtil jwtUtil;
    @RequestMapping(value = "api/usuarios/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        return usuarioDao.getByIdUsuarios(id);
    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(@RequestHeader(value="Authorization")String token) {

    /*    String usuarioId = jwtUtil.getKey(token); */

       if (!validarToken(token)){
             return  null;
       }
        return  usuarioDao.getUsuarios();
    }

    public boolean validarToken(String token){
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }
    @RequestMapping(value = "api/usuario",method = RequestMethod.POST)
    public void crearUsuario(@RequestBody Usuario usuario) {
        //* Encriptar contraseña
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash= argon2.hash(1,1024,1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.crear(usuario);
    }

    @RequestMapping(value = "api/usuario789")
    public Usuario editarUsuario() {
        Usuario usuario = new Usuario();
    
        return usuario;
    }

    @RequestMapping(value = "api/usuarios/{id}",method = RequestMethod.DELETE)
    public void eliminarUsuario(@RequestHeader(value="Authorization")String token,
                                @PathVariable Long id) {
        if (!validarToken(token)){
            return ;
        }
        usuarioDao.eliminar(id);
    }



}