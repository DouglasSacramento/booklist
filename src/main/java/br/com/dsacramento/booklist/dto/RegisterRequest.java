package br.com.dsacramento.booklist.dto;

import java.time.LocalDate;

public record RegisterRequest(
        String nome,
        String email,
        String senha,
        LocalDate dataNasc,
        String cpf
) {
}
