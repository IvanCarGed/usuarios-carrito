package es.curso.registro.service;

import java.util.List;

import es.curso.registro.model.LineaPedido;
import es.curso.registro.model.Pedido;
import es.curso.registro.model.Product;

public interface LineaPedidoService {
	
	List<LineaPedido> getAll();
	
	void addLineaPedido(Integer cantidad, Product producto, Pedido pedido);
	
	void addLineaPedido(LineaPedido lineaPedido);
	
	List<LineaPedido> findByPedido(Integer idPedido);
	
	void addAll(List<LineaPedido> lineasPedido);

}
