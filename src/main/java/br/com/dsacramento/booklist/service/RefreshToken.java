package br.com.dsacramento.booklist.service;

import br.com.dsacramento.booklist.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshToken {

    private final RefreshTokenRepository refreshTokenRepository;


}
