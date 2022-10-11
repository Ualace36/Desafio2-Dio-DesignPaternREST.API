package com.ualace36.designpatternspring.controller;

import com.ualace36.designpatternspring.model.ClienteEntity;
import com.ualace36.designpatternspring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;


    @GetMapping
    public ResponseEntity<Iterable<ClienteEntity>> getAll(){
        return ResponseEntity.ok(clienteService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> getPorId(@PathVariable Long id ){
        return ResponseEntity.ok(clienteService.getPorId(id));
    }
    @PostMapping
    public ResponseEntity<ClienteEntity> inserir(@RequestBody ClienteEntity clienteEntity){
        clienteService.inserir(clienteEntity);
        return ResponseEntity.ok(clienteEntity);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ClienteEntity> atualizar(@PathVariable Long id, @RequestBody ClienteEntity clienteEntity){
        clienteService.atualizar(id, clienteEntity);
        return ResponseEntity.ok(clienteEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id ){
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
