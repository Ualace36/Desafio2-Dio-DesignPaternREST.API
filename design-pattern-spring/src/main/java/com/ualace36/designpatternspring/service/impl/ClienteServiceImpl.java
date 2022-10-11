package com.ualace36.designpatternspring.service.impl;

import com.ualace36.designpatternspring.model.ClienteEntity;
import com.ualace36.designpatternspring.model.EnderecoEntity;
import com.ualace36.designpatternspring.repository.ClienteRepository;
import com.ualace36.designpatternspring.repository.EnderecoRepository;
import com.ualace36.designpatternspring.service.ClienteService;
import com.ualace36.designpatternspring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    // Singleton: Injeta os componentes do Spring com @Autorwired
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository endenderecoRepository;
   @Autowired
    private ViaCepService viaCepService;
    // Strategy: Implementa os métodos definidos na interface
    //  Facade: Abstrai integrações com subsistemas, promovendo uma interface simples

    @Override
    public Iterable<ClienteEntity> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteEntity getPorId(Long id) {
        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(id);
        return clienteEntity.get();
    }

    @Override
    public void inserir(ClienteEntity clienteEntity) {
        //FIXME verificar se o Endereco do Cliente já existe (pelo CEP).
        String cep = clienteEntity.getEndereco().getCep();
        EnderecoEntity enderecoEntity = endenderecoRepository.findById(cep).orElseGet(() -> {
            //FIXME Caso não exista, integra com a ViaCEP e persista o retorno

            EnderecoEntity novoEndereco = viaCepService.consultarCep(cep);
            endenderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        clienteEntity.setEnderecoEntity(enderecoEntity);
        //FIXME inserir Cliente, vinculando o Endereco (novo ou existente)
        clienteRepository.save(clienteEntity);
    }

    @Override
    public void atualizar(Long id, ClienteEntity clienteEntity) {
        //FIXME buscar Cliente po ID, caso exista:
        Optional<ClienteEntity> clientebd = clienteRepository.findById(id);
        if (clientebd.isPresent()) {
            String cep = clienteEntity.getEndereco().getCep();
            EnderecoEntity enderecoEntity = endenderecoRepository.findById(cep).orElseGet(() -> {
                //FIXME Caso não exista, integra com a ViaCEP e persista o retorno

                EnderecoEntity novoEndereco = viaCepService.consultarCep(cep);
                endenderecoRepository.save(novoEndereco);
                return novoEndereco;
            });
            clienteEntity.setEnderecoEntity(enderecoEntity);
            //FIXME inserir Cliente, vinculando o Endereco (novo ou existente)
            clienteRepository.save(clienteEntity);
        }
    }

        @Override
        public void deletar (Long id){
         //FIXME Deletar Cliente po ID
         clienteRepository.deleteById(id);
        }


    private void salvarClienteComCep(ClienteEntity clienteEntity) {
        //Verifica se o Endereco de Cliente já exista (pelo CEP)
        String cep = clienteEntity.getEndereco().getCep();
        EnderecoEntity enderecoEntity = endenderecoRepository.findById(cep).orElseGet(() -> {
            //FIXME Caso não exista, integra com a ViaCEP e persista o retorno

            EnderecoEntity novoEndereco = viaCepService.consultarCep(cep);
            endenderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        clienteEntity.setEnderecoEntity(enderecoEntity);
        //Inserir Cliente, vinculando o Endereco (novo ou existente)
        clienteRepository.save(clienteEntity);

    }
}
