package org.sid;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Produit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CataMvc4Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CataMvc4Application.class, args);
		ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
		/*produitRepository.save(new Produit("BMW X1", 520000, 2));
		produitRepository.save(new Produit("Mercedes E", 480000, 1));
		produitRepository.save(new Produit("Modem 4G ZTE", 630, 3));
		produitRepository.save(new Produit("Grundig TV Old", 1200, 1));*/
		
		produitRepository.findAll().forEach(p->System.out.println(p.getDesignation()));
	}
}
