package com.medicline.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medicline.spring.dao.UsuarioDao;
import com.medicline.spring.models.AuthResponse;
import com.medicline.spring.models.Usuario;
import com.medicline.spring.utils.JWTUtil;

import io.jsonwebtoken.SignatureException;

@CrossOrigin(origins = "http://localhost:3002/")
@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {

        Usuario usuarioLogeado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        if (usuarioLogeado != null) {

            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogeado.getId()), usuarioLogeado.getEmail());
            return tokenJwt;
        }
        return "Fail";
    }

   
    @RequestMapping(value = "api/auth", method = RequestMethod.GET)
    public Object auth(HttpServletRequest request) {
        String token = request.getHeader("token");

        if (token == null) {
            return "No hay token en la petición";
        }

       
        String tokenFormato = "^[A-Za-z0-9-_]+\\.[A-Za-z0-9-_]+\\.[A-Za-z0-9-_]*$";
        if (!token.matches(tokenFormato)) {
            return "El token no cumple con el formato especificado";
        }

        try {
            String usuarioId = jwtUtil.getKey(token);

            if (usuarioId == null) {
                return "Fail";
            }

            Usuario usuario = usuarioDao.getByIdUsuarios(Long.parseLong(usuarioId));
            if (usuario != null) {
                AuthResponse response = new AuthResponse(token, usuario);
                return response;
            }

            return "Fail";
        } catch (SignatureException e) {
            return "Token inválido";
        }
    }

}
