package br.com.dsacrament.booklist.service;

import br.com.dsacrament.booklist.entity.Role;
import br.com.dsacrament.booklist.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role save(Role role){
        return roleRepository.save(role);
    }
}
