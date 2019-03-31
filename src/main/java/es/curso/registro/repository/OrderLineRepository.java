package es.curso.registro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.curso.registro.model.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer>{

}
