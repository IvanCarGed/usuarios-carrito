package es.curso.registro.service;

import java.util.List;

import es.curso.registro.model.Order;

public interface OrderService {
	
	List<Order> getAll();
	
	Order getOrderById(Integer idOrder);
	
	void addOrder (Double precioFinal, String direccion, String estado, String comentario);
	
	void addOrder (Order order);
	
	void updateOrder (Order order);

}
