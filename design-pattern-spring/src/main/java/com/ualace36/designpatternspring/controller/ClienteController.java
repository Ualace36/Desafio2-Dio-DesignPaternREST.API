package com.ualace36.designpatternspring.controller;

import com.ualace36.designpatternspring.model.ClienteEntity;
import com.ualace36.designpatternspring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String welcome(){
        return "Bem-vindos ao Desafio 2 da dio";
    }
    @GetMapping
    @PreAuthorize("hasAnyRole('MANAGERS', 'USER' )")
    public ResponseEntity<Iterable<ClienteEntity>> getAll(){
        return ResponseEntity.ok(clienteService.getAll());
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('MANAGERS')")
    public ResponseEntity<ClienteEntity> getPorId(@PathVariable Long id ){
        return ResponseEntity.ok(clienteService.getPorId(id));
    }
    @PostMapping
  @PreAuthorize("hasAnyRole('MANAGERS', 'USER')")
    public ResponseEntity<ClienteEntity> inserir(@RequestBody ClienteEntity clienteEntity){
        clienteService.inserir(clienteEntity);
        return ResponseEntity.ok(clienteEntity);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('MANAGERS')")
    public ResponseEntity<ClienteEntity> atualizar(@PathVariable Long id, @RequestBody ClienteEntity clienteEntity){
        clienteService.atualizar(id, clienteEntity);
        return ResponseEntity.ok(clienteEntity);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('MANAGERS')")
    public ResponseEntity<Void> deletar(@PathVariable Long id ){
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
