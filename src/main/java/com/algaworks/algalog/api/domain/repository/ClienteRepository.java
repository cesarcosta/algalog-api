package com.algaworks.algalog.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algalog.api.domain.model.Cliente;

/**
 * @author César Rangel - cesarrangelfonseca@gmail.com
 * @since 30/07/2022
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}