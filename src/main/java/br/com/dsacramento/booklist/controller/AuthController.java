package br.com.dsacramento.booklist.controller;

import br.com.dsacramento.booklist.dto.JwtResponse;
import br.com.dsacramento.booklist.dto.LoginRequest;
import br.com.dsacramento.booklist.dto.RegisterRequest;
import br.com.dsacramento.booklist.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Auth")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(request));
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrar(@RequestBody RegisterRequest request) {
        authService.register(request);
        return ResponseEntity.status((HttpStatus.CREATED)).build();
    }
}
