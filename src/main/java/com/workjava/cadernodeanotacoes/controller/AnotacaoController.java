package com.workjava.cadernodeanotacoes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.workjava.cadernodeanotacoes.model.Anotacao;
import com.workjava.cadernodeanotacoes.service.AnotacaoService;

@Controller
@RequestMapping(value = "/anotacoes")
public class AnotacaoController {
	
	@Autowired
	private AnotacaoService anotacaoService;

	@GetMapping("/nova")
	public ModelAndView nova(Anotacao anotacao) {
		ModelAndView mv = new ModelAndView("anotacoes/anotacoes-cadastro");
		mv.addObject("anotacao", anotacao);
		return mv;
	}

	@PostMapping("/nova")
	public ModelAndView criar(@Valid Anotacao anotacao, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return nova(anotacao);
		}
		
		anotacaoService.salvar(anotacao);
		
		redirectAttributes.addFlashAttribute("mensagem", "Anotação criada com sucesso!");
		
		return new ModelAndView("redirect:/anotacoes/nova");
	}

	@GetMapping
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("anotacoes/anotacoes-listar");
		mv.addObject("anotacoes", anotacaoService.buscarTodos());
		return mv;
	}

}
