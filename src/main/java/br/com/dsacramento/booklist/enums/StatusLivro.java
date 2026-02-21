package br.com.dsacrament.booklist.enums;

import lombok.Getter;

@Getter
public enum StatusLivro {

    LIDO("Lido"),
    LENDO("Lendo"),
    QUERO_LER("Quero ler");

    private final String descricao;

    private StatusLivro(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
