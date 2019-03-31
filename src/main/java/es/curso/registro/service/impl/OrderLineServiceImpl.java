package es.curso.registro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.registro.model.Order;
import es.curso.registro.model.OrderLine;
import es.curso.registro.model.Product;
import es.curso.registro.repository.OrderLineRepository;
import es.curso.registro.service.OrderLineService;

@Service
public class OrderLineServiceImpl implements OrderLineService {

	@Autowired
	OrderLineRepository orderLineRepository;

	@Override
	public List<OrderLine> getAll() {
		return orderLineRepository.findAll();
	}

	@Override
	public void addOrderLine(Integer quantity, Product producto, Order pedido) {
		OrderLine orderLine = new OrderLine(quantity, producto, pedido);
		orderLineRepository.save(orderLine);
	}

	@Override
	public void addOrderLine(OrderLine orderLine) {
		orderLineRepository.save(orderLine);
	}

}
