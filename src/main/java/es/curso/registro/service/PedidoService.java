package es.curso.registro.service;

import java.util.List;

import es.curso.registro.model.Estado;
import es.curso.registro.model.LineaPedido;
import es.curso.registro.model.Pedido;

public interface PedidoService {
	
	List<Pedido> getAll();
	
	Pedido getPedidoById(Integer idPedido);
	
	void addPedido(Double precioFinal, String direccion, Estado estado, String comentario);
	
	void addPedido(Double precioFinal, String direccion, Estado estado, String comentario,
			List<LineaPedido> lineasPedido);
	
	Pedido addPedido(Pedido pedido);
	
	void updatePedido(Pedido pedido);
	
	List<Pedido> buscar (Pedido pedido);

}
