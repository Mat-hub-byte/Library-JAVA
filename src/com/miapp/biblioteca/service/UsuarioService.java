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
    public void actualizarUsuarui(String newnombre, String newid){
        for(Usuario usuario: usuario){ //consultar esto no se si es correcto
            if (usuario.getId().equals(newid)){
                usuario.setNombre(newnombre);
                usuario.setId(newid);
            }
        }

    }

    //ELIMINAR UN USUARIO POR SU ID
    public void eliminarUsuario(String id) {
        usuario.removeIf(usuario -> usuario.getId().equals(id));
    }

    //BUSCAR UN USUARIO POR SU ID
    public Usuario LibroPorID(String id) {
        for (Usuario usuario : usuario) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }
}
