package es.curso.registro.service;

import java.util.List;

import es.curso.registro.model.Order;
import es.curso.registro.model.OrderLine;
import es.curso.registro.model.Product;

public interface OrderLineService {

	List<OrderLine> getAll();
	
	void addOrderLine (Integer quantity, Product producto, Order pedido);
	
	void addOrderLine (OrderLine orderLine);
	
}
