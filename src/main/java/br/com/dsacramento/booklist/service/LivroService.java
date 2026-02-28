package br.com.dsacramento.booklist.service;

import br.com.dsacramento.booklist.entity.Categoria;
import br.com.dsacramento.booklist.entity.Livro;
import br.com.dsacramento.booklist.entity.Usuario;
import br.com.dsacramento.booklist.enums.StatusLivro;
import br.com.dsacramento.booklist.repository.CategoriaRepository;
import br.com.dsacramento.booklist.repository.LivroRepository;
import br.com.dsacramento.booklist.repository.UsuarioRepository;
import br.com.dsacramento.booklist.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;
    private final CategoriaRepository categoriaRepository;

    public List<Livro> findAll() {
        return livroRepository.findByUsuarioId(getUsuarioLogado().getId());
    }

    public Livro findById(Long id) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado!"));

        if (!livro.getUsuario().getId().equals(getUsuarioLogado().getId())){
            throw new RuntimeException("Acesso negado a este livro!");
        }
        return livro;
    }

    public List<Livro> findByStatus(StatusLivro statusLivro) {
        Long usuarioId = getUsuarioLogado().getId();

        return livroRepository.findByStatusLivroAndUsuarioId(statusLivro, usuarioId);
    }

    @Transactional
    public Livro save(Livro livro, Long usuarioId) {

        Usuario usuarioLogado = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        livro.setUsuario(usuarioLogado);

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

        CustomUserDetails userDetails =(CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (!livro.getUsuario().getId().equals(userDetails.getId())){
            throw new RuntimeException("Você não tem permmissão para deletar este livro!");
        }

        livroRepository.delete(livro);
    }

    private CustomUserDetails getUsuarioLogado() {
        return (CustomUserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }
}