package com.ualace36.designpatternspring.repository;

import com.ualace36.designpatternspring.model.EnderecoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<EnderecoEntity, String> {
}
