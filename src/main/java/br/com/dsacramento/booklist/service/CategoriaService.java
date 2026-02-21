package br.com.dsacramento.booklist.service;

import br.com.dsacramento.booklist.entity.Categoria;
import br.com.dsacramento.booklist.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long id){
        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria save(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public void delete(Long id){
        categoriaRepository.deleteById(id);
    }
}
