package br.com.dsacramento.booklist.service;

import br.com.dsacramento.booklist.entity.Pessoa;
import br.com.dsacramento.booklist.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public List<Pessoa> findAll(){
        return pessoaRepository.findAll();
    }

    public Pessoa findById(Long id){
        return pessoaRepository.findById(id).orElse(null);
    }

    public Pessoa save(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public void delete(Long id){
        pessoaRepository.deleteById(id);
    }
}
