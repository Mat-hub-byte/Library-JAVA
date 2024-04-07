package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Libro;

import java.util.ArrayList;

public class LibroService {
    private ArrayList<Libro> biblioteca;

    public LibroService(ArrayList<Libro> biblioteca){
        this.biblioteca = biblioteca;
    }
}
