package com.ualace36.designpatternspring.repository;

import com.ualace36.designpatternspring.model.ClienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteEntity, Long> {
}
