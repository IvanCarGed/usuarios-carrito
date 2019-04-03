package es.curso.registro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.registro.model.Product;
import es.curso.registro.repository.ProductRepository;
import es.curso.registro.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	@Override
	public void addProduct(String nombre, String descripcion, String marca, float precio) {
		Product producto = new Product(nombre, descripcion, marca, precio);
		productRepository.save(producto);

	}

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);

	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);

	}

	@Override
	public void deleteProduct(Integer idProduct) {
		Optional<Product> producto = productRepository.findById(idProduct);
		if (producto.isPresent()) {
			productRepository.deleteById(idProduct);
		}
	}

	@Override
	public Product getProductById(Integer id) {		
		return productRepository.findById(id).get();
	}

	@Override
	public List<Product> buscar(Product product) {
		if (product.getPrecio() > 0.0) {
			return productRepository.filtrar1(product.getNombre(), product.getDescripcion(), product.getPrecio());
		} else {
			return productRepository.filtrar2(product.getNombre(), product.getDescripcion());
		}

	}

}
