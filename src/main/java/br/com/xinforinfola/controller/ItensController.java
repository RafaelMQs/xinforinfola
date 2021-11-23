package br.com.xinforinfola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.xinforinfola.beans.Itens;
import br.com.xinforinfola.dao.ItensDAO;


@Controller
public class ItensController {
	
	@Autowired
	private ItensDAO dao;
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Itens> itens = dao.findAll();
		mv.addObject("itens", itens);
		return mv;
	}
	
	@RequestMapping("/indexUpdate/{userId}")
	public ModelAndView index(@PathVariable("userId") int id) {
		ModelAndView mv = new ModelAndView("indexUpdate");
		Iterable<Itens> itens = dao.findAll();
		mv.addObject("itens", itens);
		Itens item = dao.findById(id);
		mv.addObject("itens", itens);
		mv.addObject("item", item);
		return mv;
	}
	
	@PostMapping("/item/add/")
	public ResponseEntity<Itens> getSave(@RequestBody Itens itens) {
		try {
			dao.save(itens);
			return ResponseEntity.ok(itens);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(404).build();
		}
	}
	
	@GetMapping("/remover/{userId}")
	public String deleteById(@PathVariable("userId") int id) {
		Itens itens = dao.findById(id);
		dao.delete(itens);
		return "redirect:/index";
	}
	
	@PutMapping("/atualizar")
	public String updateItem(@RequestBody Itens itens) {
		Itens itemExistente = dao.findById(itens.getId());
		itemExistente.setNome(itens.getNome());
		itemExistente.setQuantidade(itens.getQuantidade());
		itemExistente.setUrlImg(itens.getUrlImg());
		dao.save(itemExistente);
		return "redirect:/indexUpdate";
	}
	

}
