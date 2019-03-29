package es.curso.registro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.curso.registro.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
}
