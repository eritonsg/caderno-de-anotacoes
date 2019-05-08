package com.workjava.cadernodeanotacoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workjava.cadernodeanotacoes.model.Anotacao;

public interface AnotacaoRepository extends JpaRepository<Anotacao, Long> {

}
