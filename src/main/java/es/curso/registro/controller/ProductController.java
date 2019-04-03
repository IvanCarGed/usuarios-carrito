package es.curso.registro.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import es.curso.registro.model.Product;
import es.curso.registro.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping (value = "/addProduct")
	public String addProduct (Model model) {
		model.addAttribute("producto", new Product ());
		return "producto";
		
	}
	
	@GetMapping (value = "/deleteProduct/{idProduct}")
	public String deleteProduct (Model model, @PathVariable("idProduct") Integer idProduct) {
		productService.deleteProduct(idProduct);
		return "redirect:/list-productos";
		
	}
	
	
    @GetMapping(value = "/updateProduct/{idProduct}")
	public String updateProduct (Model model, @PathVariable("idProduct") Integer idProduct) {
		Product producto = productService.getProductById(idProduct);
		model.addAttribute("updateProduct", producto);
		return "updateProduct";
    }
	
	@PostMapping (value = "/addProduct")
	public String addProduct (Model model, String nombre, String descripcion, String marca, float precio) {
		productService.addProduct(nombre, descripcion, marca, precio);
		return "redirect:/list-productos";
		
	}
	
	@PostMapping (value = "/updateProduct")
	public String updateProduct (Model model, Product producto) {
		productService.updateProduct(producto);
		return "redirect:/list-productos";
		
	}
	

}
