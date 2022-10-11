package com.ualace36.designpatternspring.service.impl;

import com.ualace36.designpatternspring.model.ClienteEntity;
import com.ualace36.designpatternspring.service.ClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    //TODO Singleton: Injeta os componentes do Spring com @Autorwired
    //TODO Strategy: Implementa os métodos definidos na interface
    //TODO  Facade: Abstrai integrações com subsistemas, promovendo uma interface simples

    @Override
    public Iterable<ClienteEntity> getAll() {
        return null;
    }

    @Override
    public ClienteEntity getPorId(Long id) {
        return null;
    }

    @Override
    public void inserir(ClienteEntity clienteEntity) {

    }

    @Override
    public void atualizar(Long id, ClienteEntity clienteEntity) {

    }

    @Override
    public void deletar(Long id) {

    }
}
