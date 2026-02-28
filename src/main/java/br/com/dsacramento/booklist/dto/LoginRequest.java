package br.com.dsacramento.booklist.dto;

public record LoginRequest(
        String email,
        String senha
) {
}
