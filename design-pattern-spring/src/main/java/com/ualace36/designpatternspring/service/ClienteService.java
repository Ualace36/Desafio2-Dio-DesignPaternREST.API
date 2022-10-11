package com.ualace36.designpatternspring.service;

import com.ualace36.designpatternspring.model.ClienteEntity;


public interface ClienteService {

    Iterable<ClienteEntity> getAll();
    ClienteEntity getPorId(Long id);
    void inserir(ClienteEntity clienteEntity);
    void atualizar(Long id, ClienteEntity clienteEntity);
    void deletar(Long id);
}
