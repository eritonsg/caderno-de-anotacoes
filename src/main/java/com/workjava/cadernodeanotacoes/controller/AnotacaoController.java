package com.workjava.cadernodeanotacoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.workjava.cadernodeanotacoes.repository.AnotacaoRepository;

@Controller
@RequestMapping(value = "/anotacoes")
public class AnotacaoController {

	@Autowired
	private AnotacaoRepository repo;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("anotacoes/anotacoes-listar");
		mv.addObject("anotacoes", repo.findAll());
		return mv;
	}

}
