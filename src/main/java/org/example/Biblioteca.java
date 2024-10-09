package org.example;

import org.example.Libro;

import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> libros;

    // Constructor
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }

    // Método agregarLibro
    public void agregarLibro(Libro libro) {
        Libro libroExistente = buscarPorISBN(libro.getISBN());
        if (libroExistente != null) {
            libroExistente.setCantidadDisponible(libroExistente.getcantidadDisponible() + libro.getcantidadDisponible());
            System.out.println("El libro ya existe. Se actualizó la cantidad disponible de: " + libroExistente.getTitulo());
        } else {
            libros.add(libro);
            System.out.println("Libro agregado exitosamente: " + libro.getTitulo());
        }
    }

    // Método mostrarLibrosDisponibles
    public void mostrarLibrosDisponibles() {
        System.out.println("Libros Disponibles en la Biblioteca '" + nombre + "':");
        boolean hayDisponibles = false;
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                libro.mostrarInfo();
                hayDisponibles = true;
            }
        }
        if (!hayDisponibles) {
            System.out.println("No hay libros disponibles en este momento.");
        }
    }

    // Método buscarLibroPorTitulo
    public Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    // Método buscarLibrosPorAutor
    public ArrayList<Libro> buscarLibrosPorAutor(String autor) {
        ArrayList<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    // Método eliminarLibro
    public void eliminarLibro(String titulo) {
        Libro libro = buscarLibroPorTitulo(titulo);
        if (libro != null) {
            if (libro.getcantidadDisponible() == 0) {
                libros.remove(libro);
                System.out.println("Libro eliminado exitosamente: " + libro.getTitulo());
            } else {
                System.out.println("No se puede eliminar el libro '" + titulo + "' porque aún hay copias disponibles.");
            }
        } else {
            System.out.println("Libro con título '" + titulo + "' no encontrado.");
        }
    }

    // Método prestarLibro
    public void prestarLibro(String titulo) {
        Libro libro = buscarLibroPorTitulo(titulo);
        if (libro != null) {
            libro.prestar();
        } else {
            System.out.println("Libro con título '" + titulo + "' no encontrado.");
        }
    }

    // Método devolverLibro
    public void devolverLibro(String titulo) {
        Libro libro = buscarLibroPorTitulo(titulo);
        if (libro != null) {
            libro.devolver();
        } else {
            System.out.println("Libro con título '" + titulo + "' no encontrado.");
        }
    }

    // Método privado para buscar por ISBN
    private Libro buscarPorISBN(String ISBN) {
        for (Libro libro : libros) {
            if (libro.getISBN().equalsIgnoreCase(ISBN)) {
                return libro;
            }
        }
        return null;
    }

    // Método para mostrar todos los libros (opcional)
    public void mostrarTodosLosLibros() {
        System.out.println("Todos los Libros en la Biblioteca '" + nombre + "':");
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }
        for (Libro libro : libros) {
            libro.mostrarInfo();
        }
    }
}
