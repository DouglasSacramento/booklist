package br.com.dsacramento.booklist.service;

import br.com.dsacramento.booklist.entity.Livro;
import br.com.dsacramento.booklist.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    public List<Livro> findAll(){
        return livroRepository.findAll();
    }

    public Livro findById(Long id){
        return livroRepository.findById(id).orElse(null);
    }

    public Livro save(Livro livro){
        return livroRepository.save(livro);
    }

    public void delete(Long id){
        livroRepository.deleteById(id);
    }
}
