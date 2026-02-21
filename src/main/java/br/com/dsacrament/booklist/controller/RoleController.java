package br.com.dsacrament.booklist.controller;

import br.com.dsacrament.booklist.entity.Role;
import br.com.dsacrament.booklist.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(roleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(roleService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Role> save(@RequestBody Role role){
        return ResponseEntity.status(HttpStatus.CREATED).body(roleService.save(role));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        roleService.delete(id);
    }
}
