package es.curso.registro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.curso.registro.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("select p from Product p where p.nombre like %?1% and p.descripcion like %?2% and p.precio like ?3")	
	List<Product> filtrar1(String nombre, String descripcion, float precio);

	@Query("select p from Product p where p.nombre like %?1% and p.descripcion like %?2%")	
	List<Product> filtrar2(String nombre, String descripcion);

}
