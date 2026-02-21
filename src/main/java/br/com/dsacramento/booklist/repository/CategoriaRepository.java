package br.com.dsacramento.booklist.repository;

import br.com.dsacramento.booklist.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
