package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Libro;

import java.util.ArrayList;
import java.util.Iterator;

public class LibroService {
    private ArrayList<Libro> biblioteca;

    public LibroService(ArrayList<Libro> biblioteca){
        this.biblioteca = biblioteca;
    }

    //METODOS CRUD


    //CREATED
    public void crearLibro(String titulo, String autor, String ISBN, String genero){
        Libro nuevoLibro = new Libro(titulo, autor, ISBN, genero);
        biblioteca.add(nuevoLibro);
    }

    //READ ALL
    public ArrayList<Libro> obtenerTodaBiblioteca(){
        return biblioteca;
    }

    //UPDATE
    public void actualizarLibro(String newtitulo, String newautor, String ISBN, String newgenero){
        boolean encontrado = false;
        for(Libro libro: biblioteca){
            if (libro.getISBN().equals(ISBN)){
                libro.setTitulo(newtitulo);
                libro.setAutor(newautor);
                libro.setGenero(newgenero);
                encontrado = true; // linea para indicar que se encontro el libro
                break; // Finalizar la iteración una vez que se modifica el libro
            }
        }
        if (!encontrado) {System.out.println("El libro con ISBN " + ISBN + " no se encontró en la biblioteca.");}
    }

    //DELETE
    public void eliminarLibro(String ISBN) {
        Iterator<Libro> iterator = biblioteca.iterator();
        // verifica que cada elemento haya sido validado en iterator, la condicion es true cuando faltan elementos que recorrer y false significa que no hay elementos para recorrer
        while (iterator.hasNext()) {
            Libro libro = iterator.next(); //Se corre al siguiente elemento
            if (libro.getISBN().equals(ISBN)) { //condicion if para saber si hay coincidencia
                iterator.remove();
                break;
            }
        }
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
