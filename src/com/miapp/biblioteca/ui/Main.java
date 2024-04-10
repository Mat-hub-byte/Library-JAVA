package com.miapp.biblioteca.ui;
import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;
import com.miapp.biblioteca.service.LibroService;
import com.miapp.biblioteca.service.UsuarioService;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(
                      "    |____________________________________________________|\n" +
                      "    |____________________________________________________|\n" +
                      "    | __     __   ____   ___ ||  ____    ____     _  __  |\n" +
                      "    ||  |__ |--|_| || |_|   |||_|**|*|__|+|+||___| ||  | |\n" +
                      "    ||==|^^||--| |=||=| |=*=||| |~~|~|  |=|=|| | |~||==| |\n" +
                      "    ||  |##||  | | || | |JRO|||-|  | |==|+|+||-|-|~||__| |\n" +
                      "    ||__|__||__|_|_||_|_|___|||_|__|_|__|_|_||_|_|_||__|_|\n" +
                      "    ||_______________________||__________________________|\n" +
                      "    | _____________________  ||      __   __  _  __    _ |\n" +
                      "    ||=|=|=|=|=|=|=|=|=|=|=| __..\\/ |  |_|  ||#||==|  / /|\n" +
                      "    || | | | | | | | | | | |/\\ \\  \\\\|++|=|  || ||==| / / |\n" +
                      "    ||_|_|_|_|_|_|_|_|_|_|_/_/\\_.___\\__|_|__||_||__|/_/__|\n" +
                      "    |____________________ /\\~()/()~//\\ __________________|\n" +
                      "    | __   __    _  _     \\_  (_ .  _/ _    ___     _____|\n" +
                      "    ||~~|_|..|__| || |_ _   \\ //\\\\ /  |=|__|~|~|___| | | |\n" +
                      "    ||--|+|^^|==|1||2| | |__/\\ __ /\\__| |==|x|x|+|+|=|=|=|\n" +
                      "    ||__|_|__|__|_||_|_| /  \\ \\  / /  \\_|__|_|_|_|_|_|_|_|\n" +
                      "    |_________________ _/    \\/\\/\\/    \\_ _______________|\n" +
                      "    | _____   _   __  |/      \\../      \\|  __   __   ___|\n" +
                      "    ||_____|_| |_|##|_||   |   \\/ __|   ||_|==|_|++|_|-|||\n" +
                      "    ||______||=|#|--| |\\   \\   o    /   /| |  |~|  | | |||\n" +
                      "    ||______||_|_|__|_|_\\   \\  o   /   /_|_|__|_|__|_|_|||\n" +
                      "    |_________ __________\\___\\____/___/___________ ______|\n" +
                      "    |__    _  /    ________     ______           /| _ _ _|\n" +
                      "    |\\ \\  |=|/   //    /| //   /  /  / |        / ||%|%|%|\n" +
                      "    | \\/\\ |*/  .//____//.//   /__/__/ (_)      /  ||=|=|=|\n" +
                      "    |  \\/\\|/   /(____|/ //                    /  /||~|~|~|\n" +
                      "    |___\\_/   /________//   ________         /  / ||_|_|_|\n" +
                      "    |___ /   (|________/   |\\_______\\       /  /| |______|\n" +
                      "    |___ /                  \\|________)     /  / | | _____\n" +
                      "    ------------------------------------------------------\n" +
                      "                                                        \n"+
                      "                _ _ _ _                         \n"   +
                      "                | (*) |                         \n"   +
                      "                | | | |__  _ __ __ _ _ __ _   _ \n" +
                      "                | | | '_ \\| '__/ _` | '__| | | |\n"+
                      "                | | | |_) | | | (_| | |  | |_| |\n"+
                      "                |_|_|_.__/|_|  \\__,_|_|   \\__, | \n"+
                      "                                           __/ | \n"+
                      "                                          |___/  "
        );


            // Crear una lista para almacenar los libros
            ArrayList<Libro> biblioteca = new ArrayList<>();

            // Crear una lista para almacenar los usuarios
            ArrayList<Usuario> usuarios = new ArrayList<>();

            // Crear un servicio de libro con la lista de libros
            LibroService libroService = new LibroService(biblioteca);

            // Crear un servicio de usuario con la lista de usuarios
            UsuarioService usuarioService = new UsuarioService(usuarios);

            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\n--- MENÚ PRINCIPAL ---");
                System.out.println("1.  Crear usuario");
                System.out.println("2.  Crear libro");
                System.out.println("3.  Mostrar todos los libros");
                System.out.println("4.  Mostrar todos los usuarios");
                System.out.println("5.  Actualizar libro por ISBN");
                System.out.println("6.  Eliminar libro por ISBN");
                System.out.println("7.  Actualizar usuario por ID");
                System.out.println("8.  Eliminar usuario por ID");
                System.out.println("9.  Prestar libro");
                System.out.println("10. Devolucion de libro");
                System.out.println("11. Mostrar libros disponibles");
                System.out.println("0.  Salir");
                System.out.println("----------------------------------");
                System.out.print("Seleccione una opción: ");

                // Leer la opción seleccionada por el usuario
                opcion = scanner.nextInt();
                scanner.nextLine();

                // Realizar la acción correspondiente según la opción seleccionada
                switch (opcion) {
                    case 1:
                        // Crear un nuevo usuario
                        System.out.print("Ingrese el nombre del usuario: ");
                        String nombreUsuario = scanner.nextLine();
                        System.out.print("Ingrese el ID del usuario: ");
                        String idUsuario = scanner.nextLine();
                        usuarioService.crearUsuario(nombreUsuario, idUsuario);
                        break;
                    case 2:
                        // Crear un nuevo libro
                        System.out.print("Ingrese el título del libro: ");
                        String tituloLibro = scanner.nextLine();
                        System.out.print("Ingrese el autor del libro: ");
                        String autorLibro = scanner.nextLine();
                        System.out.print("Ingrese el ISBN del libro: ");
                        String isbnLibro = scanner.nextLine();
                        System.out.print("Ingrese el género del libro: ");
                        String generoLibro = scanner.nextLine();
                        libroService.crearLibro(tituloLibro, autorLibro, isbnLibro, generoLibro);
                        break;
                    case 3:
                        // Mostrar todos los libros
                        System.out.println("--- LIBROS EN LA BIBLIOTECA ---");
                        for (Libro libro : libroService.obtenerTodaBiblioteca()) {
                            System.out.println(libro);
                        }
                        break;
                    case 4:
                        // Mostrar todos los usuarios
                        System.out.println("--- USUARIOS EN LA BIBLIOTECA ---");
                        for (Usuario usuario : usuarioService.obtenerTodosLosUsuario()) {
                            System.out.println(usuario);
                        }
                        break;
                    case 5:
                        // Actualizar un libro por ISBN
                        System.out.print("Ingrese el ISBN del libro que desea actualizar: ");
                        String isbnActualizar = scanner.nextLine();

                        // Verificar si el libro existe
                        Libro libroActualizar = libroService.libroPorISBN(isbnActualizar);

                        if (libroActualizar != null) {
                            System.out.println("Libro encontrado: " + libroActualizar);

                            // Mostrar opciones para actualizar
                            System.out.println("Seleccione el atributo que desea actualizar:");
                            System.out.println("1. Título");
                            System.out.println("2. Autor");
                            System.out.println("3. Género");
                            int opcionActualizar = scanner.nextInt();
                            scanner.nextLine(); // Limpiar el buffer de entrada

                            // Realizar la actualización según la opción seleccionada
                            switch (opcionActualizar) {
                                case 1:
                                    System.out.print("Ingrese el nuevo título del libro: ");
                                    String nuevoTitulo = scanner.nextLine();
                                    libroService.actualizarAtributoLibro(isbnActualizar, "titulo", nuevoTitulo);
                                    break;
                                case 2:
                                    System.out.print("Ingrese el nuevo autor del libro: ");
                                    String nuevoAutor = scanner.nextLine();
                                    libroService.actualizarAtributoLibro(isbnActualizar, "autor", nuevoAutor);
                                    break;
                                case 3:
                                    System.out.print("Ingrese el nuevo género del libro: ");
                                    String nuevoGenero = scanner.nextLine();
                                    libroService.actualizarAtributoLibro(isbnActualizar, "genero", nuevoGenero);
                                    System.out.println("Se Acutualizo el libro con exito");
                                    break;
                                default:
                                    System.out.println("Opción inválida. No se realizará ninguna actualización.");
                                    break;

                            }
                        } else {
                            System.out.println("No se encontró ningún libro con el ISBN proporcionado.");
                        }
                        break;
                    case 6:
                        // Eliminar un libro por ISBN
                        System.out.print("Ingrese el ISBN del libro que desea eliminar: ");
                        String isbnEliminar = scanner.nextLine();
                        libroService.eliminarLibro(isbnEliminar);
                        System.out.print("Libro eliminado con exito");
                        break;
                    case 7:
                        // Actualizar un usuario por ID
                        System.out.print("Ingrese el ID del usuario que desea actualizar: ");
                        String idActualizar = scanner.nextLine();
                        System.out.print("Ingrese el nuevo nombre del usuario: ");
                        String nuevoNombre = scanner.nextLine();
                        usuarioService.actualizarUsuarui(nuevoNombre, idActualizar);
                        System.out.print("Libro actualizado con exito");
                        break;
                    case 8:
                        // Eliminar un usuario por ID
                        System.out.print("Ingrese el ID del usuario que desea eliminar: ");
                        String idEliminar = scanner.nextLine();
                        usuarioService.eliminarUsuario(idEliminar);
                        System.out.print("Usuario eliminado con exito");
                        break;
                    case 9:
                        //Prestamo de libro
                        System.out.print("Ingrese el ID del usuario al que quiere prestar ");
                        idUsuario = scanner.nextLine();
                        Usuario usuarioPrestamo1 = usuarioService.buscarUsuarioUnico(idUsuario);
                            if (usuarioPrestamo1 != null) {
                                System.out.println("Ingrese el ISBN del libro a prestar");
                                String isbnPrestamo = scanner.nextLine();
                                Libro libroPrestamo = LibroService.libroPorISBN(isbnPrestamo);
                                if (libroPrestamo != null) {

                                    if (usuarioService.verificarDisponibilidad(libroPrestamo)) {
                                        usuarioPrestamo1.pestarLibro(usuarioPrestamo1, libroPrestamo);
                                    } else {
                                        System.out.println("No correspondo el usuario");
                                    }
                                } else {
                                    System.out.println("el usuario no se encontro");
                                }
                            }
                            break;
                    case 10:
                        // Lógica para gestionar la devolución de libros
                        System.out.print("Ingrese el ID del usuario que quiere devolver un libro: ");
                        idUsuario = scanner.nextLine();
                        Usuario usuarioDevolucion = usuarioService.buscarUsuarioUnico(idUsuario);
                        if (usuarioDevolucion != null) {
                            // Mostrar los libros prestados al usuario
                            System.out.println("Libros prestados al usuario:");
                            for (Libro libro : usuarioDevolucion.getLibrosPrestados()) {
                                System.out.println(libro.getTitulo());
                            }
                            System.out.print("Ingrese el ISBN del libro que desea devolver: ");
                            String isbnDevolucion = scanner.nextLine();
                            Libro libroDevolucion = LibroService.libroPorISBN(isbnDevolucion);
                            if (libroDevolucion != null) {
                                // Verificar si el libro pertenece al usuario y devolverlo
                                if (usuarioDevolucion.getLibrosPrestados().contains(libroDevolucion)) {
                                    libroService.devolverLibro(usuarioDevolucion, libroDevolucion);
                                    System.out.println("El libro se ha devuelto con éxito.");
                                } else {
                                    System.out.println("El libro no corresponde al usuario.");
                                }
                            } else {
                                System.out.println("El libro no se encontró.");
                            }
                        } else {
                            System.out.println("El usuario no se encontró.");
                        }
                    break;
                    case 11:
                        //Mostrar de libros
                        System.out.print("Libros disponibles");
                        System.out.println(libroService.mostrarDispobibles());
                        break;
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                        break;
                    }
                }
                while (opcion != 0) ;

                scanner.close();
            }
    }