package br.com.dsacramento.booklist.controller;

import br.com.dsacramento.booklist.entity.Livro;
import br.com.dsacramento.booklist.enums.StatusLivro;
import br.com.dsacramento.booklist.security.CustomUserDetails;
import br.com.dsacramento.booklist.service.LivroService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Livros")
@RestController
@CrossOrigin(origins = "*")
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

    @GetMapping("/status/{statusLivro}")
    public ResponseEntity<List<Livro>> findByStatus(@PathVariable StatusLivro statusLivro){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.findByStatus(statusLivro));
    }

    @PostMapping
    public ResponseEntity<Livro> save(@RequestBody Livro livro , @AuthenticationPrincipal CustomUserDetails user){
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.save(livro, user.getId()));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        livroService.delete(id);
    }
}
