package br.com.dsacrament.booklist.controller;

import br.com.dsacrament.booklist.entity.Role;
import br.com.dsacrament.booklist.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @ResponseBody
    @PostMapping("**/salvar-role")
    public ResponseEntity<Role> salvarRole(@RequestBody Role role){
        Role roleSalva = roleService.save(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(roleSalva);
    }
}
