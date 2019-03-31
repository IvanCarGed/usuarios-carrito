package es.curso.registro.service;

import java.util.List;
import java.util.Set;

import es.curso.registro.model.Order;
import es.curso.registro.model.OrderLine;

public interface OrderService {
	
	List<Order> getAll();
	
	Order getOrderById(Integer idOrder);
	
	void addOrder (Double precioFinal, String direccion, String estado, String comentario, Set<OrderLine> orderLines);
	
	void addOrder (Order order);
	
	void updateOrder (Order order);

}
