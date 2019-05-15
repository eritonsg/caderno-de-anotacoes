package com.workjava.cadernodeanotacoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workjava.cadernodeanotacoes.model.Anotacao;
import com.workjava.cadernodeanotacoes.repository.AnotacaoRepository;

@Service
public class AnotacaoService {
	
	@Autowired
	private AnotacaoRepository repo;
	
	public void salvar(Anotacao anotacao) {
		repo.save(anotacao);
	}
	
	public List<Anotacao> buscarTodos() {
		return repo.findAll();
	}

}
