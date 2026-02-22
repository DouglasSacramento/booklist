package br.com.dsacramento.booklist.repository;

import br.com.dsacramento.booklist.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
}
