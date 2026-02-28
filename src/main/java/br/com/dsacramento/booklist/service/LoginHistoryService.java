package br.com.dsacramento.booklist.service;

import br.com.dsacramento.booklist.entity.LoginHistory;
import br.com.dsacramento.booklist.repository.LoginHistoryRepository;
import br.com.dsacramento.booklist.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginHistoryService {

    private final LoginHistoryRepository loginHistoryRepository;

    public void save(CustomUserDetails user, String token){
        LoginHistory history = new LoginHistory();
        history.setUserId(user.getId());
        history.setEmail(user.getEmail());
        history.setAccessToken(token);
        loginHistoryRepository.save(history);
    }
}
