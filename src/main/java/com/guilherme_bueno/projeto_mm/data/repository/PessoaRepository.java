package com.guilherme_bueno.projeto_mm.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme_bueno.projeto_mm.data.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
