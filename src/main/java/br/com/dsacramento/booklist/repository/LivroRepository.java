package br.com.dsacramento.booklist.repository;

import br.com.dsacramento.booklist.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}