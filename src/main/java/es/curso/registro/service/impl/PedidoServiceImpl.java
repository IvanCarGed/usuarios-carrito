package es.curso.registro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.registro.model.Estado;
import es.curso.registro.model.LineaPedido;
import es.curso.registro.model.Pedido;
import es.curso.registro.repository.PedidoRepository;
import es.curso.registro.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	@Override
	public List<Pedido> getAll() {
		return pedidoRepository.findAll();
	}

	@Override
	public Pedido getPedidoById(Integer idPedido) {
		return pedidoRepository.getOne(idPedido);
	}

	@Override
	public void addPedido(Double precioFinal, String direccion, Estado estado, String comentario) {
		Pedido pedido = new Pedido(precioFinal, direccion, estado, comentario);
		pedidoRepository.save(pedido);
	}

	@Override
	public void addPedido(Double precioFinal, String direccion, Estado estado, String comentario,
			List<LineaPedido> lineasPedido) {
		Pedido pedido = new Pedido(precioFinal, direccion, estado, comentario, lineasPedido);
		pedidoRepository.save(pedido);
	}



	@Override
	public Pedido addPedido(Pedido pedido) {
		return pedidoRepository.saveAndFlush(pedido);

	}

	@Override
	public void updatePedido(Pedido pedido) {
		pedidoRepository.save(pedido);
	}

	@Override
	public List<Pedido> buscar(Pedido pedido) {
		return pedidoRepository.filtrar(pedido.getEstado());
	}



}
