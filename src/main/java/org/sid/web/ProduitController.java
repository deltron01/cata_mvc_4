package org.sid.web;

import java.util.List;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository produitRepository;

	@RequestMapping(value="/index")
	public String index(Model model, @RequestParam(name="page", defaultValue="0") int p, 
			                         @RequestParam(name="size", defaultValue="5") int s,
			                         @RequestParam(name="motCle", defaultValue="") String mc){
		//Page<Produit> pageProduits = produitRepository.findAll(new PageRequest(p,s));
		Page<Produit> pageProduits = produitRepository.chercher("%"+mc+"%", new PageRequest(p,s));
		model.addAttribute("listproduits", pageProduits.getContent());
		int[] pages = new int[pageProduits.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle", mc);
		return "produits";
	}
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(Long id){
		produitRepository.delete(id);
		return "redirect:/index";
	}
}
