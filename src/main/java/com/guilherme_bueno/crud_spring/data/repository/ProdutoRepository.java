package com.guilherme_bueno.crud_spring.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme_bueno.crud_spring.data.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
