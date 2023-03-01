package com.example.SpringHello.controllers;

import com.example.SpringHello.models.Libro;
import com.example.SpringHello.models.LibroDTO;
import com.example.SpringHello.repositories.LibrosRepository;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author anton
 */
@RestController
@RequestMapping("/libros")
public class LibrosController {

    @Autowired
    LibrosRepository repo;

    @GetMapping()
    public List<Libro> list(){
        return repo.findAll();
    }
    
    @GetMapping("/detalle")
    public List<LibroDTO> listDetailed() {
    List<Libro> libros = repo.findAll();
    List<LibroDTO> librosDTO = new ArrayList<>();
    for (Libro libro : libros) {
        LibroDTO dto = new LibroDTO(libro.getTitulo(), libro.getAutor());
        librosDTO.add(dto);
    }
    return librosDTO;
    }

    /*Listar el detalle de un libro concreto*/
    @GetMapping("/{isbn}")
    public ResponseEntity<Libro> get(@PathVariable String isbn) {
        if (repo.existsById(isbn)) {
            return new ResponseEntity<>(repo.findById(isbn).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/categoria/{categoria}")
    public List<Libro> getByCategoria(@PathVariable String categoria) {

        return repo.findByCategoria(categoria);
    }
    
    @GetMapping("/autor/{autor}")
    public List<Libro> getByAutor(@PathVariable String autor) {

        return repo.findByAutor(autor);
    }

    @PostMapping
    public ResponseEntity<Libro> post(@RequestBody Libro input) {
        repo.save(input);
        System.out.println(input.getTitulo());
        return new ResponseEntity<>(input, HttpStatus.CREATED);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Libro input) {
        repo.delete(input);
        return new ResponseEntity<>(input, HttpStatus.OK);
    }
    
//    @DeleteMapping("/{isbn}")
//    public ResponseEntity<?> delete(@PathVariable String isbn) {
//        repo.deleteById(isbn);
//        return new ResponseEntity<>("Borrado con exito", HttpStatus.OK);
//    }
}
