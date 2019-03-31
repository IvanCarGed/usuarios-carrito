package es.curso.registro.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.registro.model.Order;
import es.curso.registro.model.OrderLine;
import es.curso.registro.repository.OrderRepository;
import es.curso.registro.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Override
	public List<Order> getAll() {
		return orderRepository.findAll();
	}

	@Override
	public Order getOrderById(Integer idOrder) {
		return orderRepository.getOne(idOrder);
	}

	@Override
	public void addOrder(Double precioFinal, String direccion, String estado, String comentario,
			Set<OrderLine> orderLines) {
		Order order = new Order(precioFinal, direccion, estado, comentario, orderLines);
		orderRepository.save(order);
	}

	@Override
	public void addOrder(Order order) {
		orderRepository.save(order);

	}

	@Override
	public void updateOrder(Order order) {
		orderRepository.save(order);

	}

}
