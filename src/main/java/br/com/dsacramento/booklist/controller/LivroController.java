package br.com.dsacramento.booklist.controller;

import br.com.dsacramento.booklist.entity.Livro;
import br.com.dsacramento.booklist.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Livro> save(@RequestBody Livro livro){
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.save(livro));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        livroService.delete(id);
    }
}
