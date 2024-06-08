package com.eskcti.gft_bootcamp_deploy.resources;

import com.eskcti.gft_bootcamp_deploy.domain.model.User;
import com.eskcti.gft_bootcamp_deploy.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "User", description = "Endpoints para gerenciamento de usuários")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Busca usuário por ID")
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Cria um novo usuário")
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreate) {
        var userCreate = userService.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path(("/{id}"))
                .buildAndExpand(userCreate.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreate);
    }

    @Operation(summary = "Atualiza um usuário")
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User userToUpdate) {
        var updatedUser = userService.update(id, userToUpdate);
        return ResponseEntity.ok(updatedUser);
    }

    @Operation(summary = "Deleta um usuário")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Busca todos os usuários")
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        var users = userService.findAll();
        return ResponseEntity.ok(users);
    }
}
