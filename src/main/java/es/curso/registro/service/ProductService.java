package es.curso.registro.service;

import java.util.List;
import java.util.Optional;

import es.curso.registro.model.Product;

public interface ProductService {

	List<Product> getAll();
	
	Optional<Product> findEstadoById(Integer idProduct);
	
	void addProduct(String nombre, String descripcion, String marca, float precio);
	
	void addProduct(Product product);
	
	void updateProduct(Product product);
	
	void deleteProduct(Integer idProduct);
	
	List<Product> find(Product product);
}
