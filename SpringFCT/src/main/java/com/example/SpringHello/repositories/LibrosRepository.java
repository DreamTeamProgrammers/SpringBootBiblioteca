package com.example.SpringHello.repositories;

import com.example.SpringHello.models.Libro;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.yaml.snakeyaml.events.Event.ID;

/**
 *
 * @author anton
 */
public interface LibrosRepository extends JpaRepository<Libro, String> {

    List<Libro> findByCategoria(String Categoria);
    List<Libro> findByAutor(String Autor);
}
