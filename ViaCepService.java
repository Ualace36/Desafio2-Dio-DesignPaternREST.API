package com.ualace36.designpatternspring.service;


import com.ualace36.designpatternspring.model.EnderecoEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping("/{cep}/json")
    EnderecoEntity consultarCep(@PathVariable("cep")String cep);
}
