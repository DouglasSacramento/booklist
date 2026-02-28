package br.com.dsacramento.booklist.repository;

import br.com.dsacramento.booklist.entity.Livro;
import br.com.dsacramento.booklist.enums.StatusLivro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByUsuarioId(Long usuarioId);

    List<Livro> findByStatusLivroAndUsuarioId(StatusLivro statusLivro, Long usuarioId);
}