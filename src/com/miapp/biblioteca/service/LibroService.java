package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class LibroService {
    public static Object Prestamo;
    private static ArrayList<Libro> biblioteca;

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
    public void actualizarAtributoLibro(String ISBN, String atributo, String nuevoValor) {
        boolean encontrado = false;
        for (Libro libro : biblioteca) {
            if (libro.getISBN().equals(ISBN)) {
                encontrado = true;
                switch (atributo) {
                    case "titulo":
                        libro.setTitulo(nuevoValor);
                        break;
                    case "autor":
                        libro.setAutor(nuevoValor);
                        break;
                    case "genero":
                        libro.setGenero(nuevoValor);
                        break;
                    default:
                        System.out.println("Atributo no válido.");
                        return;
                }
                break;
            }
        }
        if (!encontrado) {
            System.out.println("El libro con ISBN " + ISBN + " no se encontró en la biblioteca.");
        }
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
    public static Libro libroPorISBN(String ISBN) {
        for (Libro libro : biblioteca) { // Agrega el nombre del tipo de objeto "Libro" antes de "libro"
            if (libro.getISBN().equals(ISBN)) {
                return libro;
            }
        }
        return null;
    }



    public void devolverLibro(Usuario usuario, Libro libro){

        if (usuario.getLibrosPrestados().contains(libro)){
            usuario.getLibrosPrestados().remove(libro);
            libro.setDisponible(true);
        } else {
            System.out.println("el libro no correspone al usuario");
        }

    }



    public  void pestarLibro(Usuario usuario, Libro libro){
        if(libro.isDisponible()){

            usuario.getLibrosPrestados().add(libro);
            libro.setDisponible(false);
        } else {
            System.out.println("no estadisponible");
        }
    }

    /*
    public void Prestamo(String ISBN){
        boolean encontrado = false;
        for (Libro libro : biblioteca) {
            if (libro.getISBN().equals(ISBN)){
                libro.setDisponible(false);
                System.out.println(libro.toString());
            }

        }

    }
    public void Devolucion(String ISBN){
        boolean encontrado = false;
        for (Libro libro : biblioteca) {
            if (libro.getISBN().equals(ISBN) && !libro.isDisponible() ){
                libro.setDisponible(true);
                System.out.println(libro.toString());
            }

        }

    }

    */

    //public List<Libro> mostrarDispobibles(){
    //    //filtra libros disponibles y los muestra
    //    return biblioteca.stream().filter(libro -> libro.isDisponible() == true).toList();
    //}

    public List<Libro> mostrarDispobibles() {
        List<Libro> librosDisponibles = biblioteca.stream()
                    .filter(libro -> libro.isDisponible())
                    .collect(Collectors.toList());
        if (((List<?>) librosDisponibles).isEmpty()) {
            System.out.println("No hay libros disponibles");
        }
        return librosDisponibles;
    }

    public static boolean verificarDisponibilidad(Libro libro) {
        return libro.isDisponible();
    }
}
