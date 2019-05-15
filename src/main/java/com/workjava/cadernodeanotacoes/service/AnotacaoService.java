package com.workjava.cadernodeanotacoes.service;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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

	public Anotacao buscarPorID(Long id) {
		return repo.getOne(id);
	}

	public void atualizar(Long id, Anotacao anotacao) {
		Anotacao anotacaoSalva = repo.getOne(id);
		BeanUtils.copyProperties(anotacao, anotacaoSalva, "id", "cadastro");
		repo.save(anotacaoSalva);
	}

}
