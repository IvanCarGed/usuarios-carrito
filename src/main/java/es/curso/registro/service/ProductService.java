package es.curso.registro.service;

import java.util.List;
import es.curso.registro.model.Product;

public interface ProductService {

	List<Product> getAll();
	
	Product getProductById(Integer idProduct);
	
	void addProduct(String nombre, String descripcion, String marca, float precio);
	
	void addProduct(Product product);
	
	void updateProduct(Product product);
	
	void deleteProduct(Integer idProduct);
	
	List<Product> buscar(Product product);
}
