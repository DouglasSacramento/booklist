package br.com.dsacramento.booklist.service;

import br.com.dsacramento.booklist.entity.Role;
import br.com.dsacramento.booklist.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public Role findById(Long id){
        return roleRepository.findById(id).orElse(null);
    }

    public Role save(Role role){
        return roleRepository.save(role);
    }

    public void delete(Long id){
        roleRepository.deleteById(id);
    }
}
