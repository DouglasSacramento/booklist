package br.com.dsacramento.booklist.service;

import br.com.dsacramento.booklist.entity.Categoria;
import br.com.dsacramento.booklist.entity.Livro;
import br.com.dsacramento.booklist.entity.Pessoa;
import br.com.dsacramento.booklist.repository.CategoriaRepository;
import br.com.dsacramento.booklist.repository.LivroRepository;
import br.com.dsacramento.booklist.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;
    private final PessoaRepository pessoaRepository;
    private final CategoriaRepository categoriaRepository;

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro findById(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado!"));
    }

    @Transactional
    public Livro save(Livro livro) {

        if (livro.getPessoa() != null && livro.getPessoa().getId() != null) {
            Pessoa pessoa = pessoaRepository.findById(livro.getPessoa().getId())
                    .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com o ID informado!"));

            livro.setPessoa(pessoa);
        } else {
            throw new RuntimeException("O livro precisa estar obrigatoriamente vinculado a uma pessoa!");
        }

        if (livro.getCategorias() != null && !livro.getCategorias().isEmpty()) {

            Set<Categoria> categorias = new HashSet<>();

            for (Categoria categoriaRequest : livro.getCategorias()) {
                if (categoriaRequest.getId() != null) {
                    Categoria categoria = categoriaRepository.findById(categoriaRequest.getId())
                            .orElseThrow(() -> new RuntimeException("Categoria ID " + categoriaRequest.getId() + " não encontrada!"));

                    categorias.add(categoria);
                }
            }
            livro.setCategorias(categorias);
        }

        return livroRepository.save(livro);
    }

    @Transactional
    public void delete(Long id) {
        Livro livro = findById(id);
        livroRepository.delete(livro);
    }
}