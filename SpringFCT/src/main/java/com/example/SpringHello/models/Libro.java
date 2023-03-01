package com.example.SpringHello.models;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
@Data
@Entity
@Table(name = "libros")
public class Libro implements Serializable {
    @Id
    @Column(name = "Isbn")
    private String isbn;
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    @Column(name = "Titulo")
    private String titulo;
    @Column(name = "Autor")
    private String autor;
    @Column(name = "Categoria")
    private String categoria;
    @Column(name = "Edicion")
    private String edicion;
}
