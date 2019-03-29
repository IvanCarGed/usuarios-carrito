package es.curso.registro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.curso.registro.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
