package org.example;

public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private String ISBN;
    private int cantidadDisponible;
    private boolean disponible;

    public Libro(String titulo, String autor, String genero, String isbn, int cantidadDisponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.ISBN = isbn;
        this.cantidadDisponible = cantidadDisponible;
        this.disponible = cantidadDisponible > 0;

    }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo() {
            this.titulo = this.titulo;
        }

        public String getAutor() {
            return this.autor;
        }

        public void setAutor() {
            this.autor = this.autor;
        }

        public String getGenero() {
            return this.genero;
        }

        public void setGenero() {
            this.genero = this.genero;
        }

        public String getISBN() {
            return ISBN;
        }

        public void setISBN() {
            this.ISBN = ISBN;
        }

        public int getcantidadDisponible() {
            return cantidadDisponible;
        }

        public void setCantidadDisponible(int i) {
            this.cantidadDisponible = cantidadDisponible;
            this.disponible = cantidadDisponible > 0;
        }

        public boolean isDisponible() {
            return disponible;
        }

        public void setDisponible() {
            this.disponible = disponible;
        }

        public void prestar() {
            if (cantidadDisponible > 0) {
                cantidadDisponible--;
                if (cantidadDisponible == 0) {
                    disponible = false;
                }
                System.out.println("Prestamo exitoso: " + titulo);
            } else {
                System.out.println("No se encuentra disponible: " + titulo);
            }
        }
        public void devolver() {
                cantidadDisponible++;
                disponible = true;
                System.out.println("Devolucion exitosa: " + titulo);
            }

        public void mostrarInfo() {
                System.out.println("titulo: " + titulo);
                System.out.println("autor: " + autor);
                System.out.println("genero: " + genero);
                System.out.println("ISBN: " + ISBN);
                System.out.println("Cantidad disponible: " + cantidadDisponible);
                System.out.println("Disponible: " + disponible);
            }
        }




