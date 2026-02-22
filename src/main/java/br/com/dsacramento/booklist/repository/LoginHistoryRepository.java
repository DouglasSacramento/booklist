package br.com.dsacramento.booklist.repository;

import br.com.dsacramento.booklist.entity.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {

}
