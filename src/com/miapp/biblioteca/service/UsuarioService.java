package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Usuario;

import java.util.ArrayList;

public class UsuarioService {

    //ATRIBUTOS

    public ArrayList<Usuario> usuario;

    //CONSTRUCTOR

    public UsuarioService(ArrayList<Usuario> usuario) {
        this.usuario = usuario;
    }

    //METODOS CRUD

    //CREAR USUARIO

    public void crearUsuario(String nombre, String id) {
        Usuario nuevoUsuario = new Usuario(nombre, id);
        usuario.add(nuevoUsuario);
    }

    //LEER TODOS LOS USUARIOS DE LA BIBLIOTECA
    public ArrayList<Usuario> obtenerTodosLosUsuario() {
        return usuario;
    }
    //ACTUALIZAR UN USUARIO POR SU ID

    //ELIMINAR UN USUARIO POR SU ID

    //BUSCAR UN USUARIO POR SU ID
}
