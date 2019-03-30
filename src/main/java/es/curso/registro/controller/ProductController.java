package es.curso.registro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.curso.registro.model.Product;
import es.curso.registro.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping (value = "/addProduct")
	public String addProduct (Model model) {
		model.addAttribute("producto1", new Product ());
		return "producto";
		
	}
	
	@GetMapping (value = "/deleteProduct")
	public String deleteProduct (Model model, @RequestParam Integer idProduct) {
		productService.deleteProduct(idProduct);
		return "redirect:/list-productos";
		
	}
	
	@GetMapping (value = "/updateProduct")
	public String updateProduct (Model model, @RequestParam Integer idProduct) {
		Product producto = productService.getProductById(idProduct);
		model.addAttribute("producto", producto);
		return "producto";
		
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
