package com.example.SpringHello.models;

/**
 *
 * @author anton
 */
public class LibroDTO {
    private String titulo;
    private String autor;

    public LibroDTO(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}

