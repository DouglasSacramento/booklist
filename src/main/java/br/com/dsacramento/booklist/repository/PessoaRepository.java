package br.com.dsacramento.booklist.repository;

import br.com.dsacramento.booklist.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
