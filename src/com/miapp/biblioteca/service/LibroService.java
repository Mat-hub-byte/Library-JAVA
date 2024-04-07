package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Libro;

import java.util.ArrayList;

public class LibroService {
    private ArrayList<Libro> biblioteca;

    public LibroService(ArrayList<Libro> biblioteca){
        this.biblioteca = biblioteca;
    }

    //METODOS
    //CRUD

    //METODO CREATED

    public void crearLibro(String titulo, String autor, String ISBN, String genero){
        Libro nuevoLibro = new Libro(titulo, autor, ISBN, genero);
        biblioteca.add(nuevoLibro);
    }

    //READ
    public ArrayList<Libro> obtenerTodaBiblioteca(){
        return biblioteca;
    }

    //UPDATE

    public void actualizarLibro(String newtitulo, String newautor, String ISBN, String newgenero){
        for(Libro libro: biblioteca){
            if (libro.getISBN().equals(ISBN)){
                libro.setTitulo(newtitulo);
                libro.setAutor(newautor);
                libro.setGenero(newgenero);
            }
        }
    }

    //DELETE
    public  void eliminar(String ISBN){
        biblioteca.removeIf(libro -> libro.getISBN().equals(ISBN));
    }

    //BUSCAR POR ISBN

    public Libro libroPorISBN(String ISBN) {
        for (Libro libro : biblioteca) { // Agrega el nombre del tipo de objeto "Libro" antes de "libro"
            if (libro.getISBN().equals(ISBN)) {
                return libro;
            }
        }
        return null;
    }


}
