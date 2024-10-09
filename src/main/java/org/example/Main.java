package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");

        Libro libro1 = new Libro ("Cien Años de Soledad", "Gabriel García Márquez", "Realismo Mágico", "ISBN001", 3);
        Libro libro2 = new Libro ("Don Quijote de la Mancha", "Miguel de Cervantes", "Novela", "ISBN002", 2);
        Libro libro3 = new Libro("La Sombra del Viento", "Carlos Ruiz Zafón", "Misterio", "ISBN003", 1);
        Libro libro4 = new Libro("El Amor en los Tiempos del Cólera", "Gabriel García Márquez", "Novela", "ISBN004", 2);

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);

        // 3. Mostrar la lista de libros disponibles
        System.out.println("\n--- Lista de Libros Disponibles ---");
        biblioteca.mostrarLibrosDisponibles();

        // 4. Prestar un libro y volver a mostrar la lista de libros disponibles
        System.out.println("\n--- Prestando 'Cien Años de Soledad' ---");
        biblioteca.prestarLibro("Cien Años de Soledad");

        System.out.println("\n--- Lista de Libros Disponibles Después del Préstamo ---");
        biblioteca.mostrarLibrosDisponibles();

        // 5. Devolver un libro y mostrar nuevamente la lista de libros disponibles
        System.out.println("\n--- Devolviendo 'Cien Años de Soledad' ---");
        biblioteca.devolverLibro("Cien Años de Soledad");

        System.out.println("\n--- Lista de Libros Disponibles Después de la Devolución ---");
        biblioteca.mostrarLibrosDisponibles();

        // 6. Buscar un libro por su título
        System.out.println("\n--- Buscando el Libro 'Don Quijote de la Mancha' ---");
        Libro buscado = biblioteca.buscarLibroPorTitulo("Don Quijote de la Mancha");
        if (buscado != null) {
            buscado.mostrarInfo();
        } else {
            System.out.println("Libro no encontrado.");
        }

        // 7. Buscar libros de un autor específico
        System.out.println("\n--- Buscando Libros de 'Gabriel García Márquez' ---");
        ArrayList<Libro> librosPorAutor = biblioteca.buscarLibrosPorAutor("Gabriel García Márquez");
        if (!librosPorAutor.isEmpty()) {
            for (Libro libro : librosPorAutor) {
                libro.mostrarInfo();
            }
        } else {
            System.out.println("No se encontraron libros de ese autor.");
        }

        // 8. Eliminar un libro de la biblioteca y mostrar la lista actualizada de libros
        System.out.println("\n--- Eliminando 'La Sombra del Viento' ---");
        biblioteca.eliminarLibro("La Sombra del Viento");

        // Mostrar la lista final de libros
        System.out.println("\n--- Lista Final de Libros en la Biblioteca ---");
        biblioteca.mostrarTodosLosLibros();
    }
}
