package es.curso.registro.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.registro.model.LineaPedido;
import es.curso.registro.model.Pedido;
import es.curso.registro.model.Product;
import es.curso.registro.repository.LineaPedidoRepository;
import es.curso.registro.service.LineaPedidoService;

@Service
public class LineaPedidoServiceImpl implements LineaPedidoService {

	@Autowired
	LineaPedidoRepository lineaPedidoRepository;

	@Override
	public List<LineaPedido> getAll() {
		return lineaPedidoRepository.findAll();
	}

	@Override
	public void addLineaPedido(Integer cantidad, Product producto, Pedido pedido) {
		LineaPedido lineaPedido = new LineaPedido(cantidad, producto, pedido);
		lineaPedidoRepository.save(lineaPedido);
	}

	@Override
	public void addLineaPedido(LineaPedido lineaPedido) {
		lineaPedidoRepository.save(lineaPedido);
	}

	@Override
	public List<LineaPedido> findByPedido(Integer idPedido) {
		List<LineaPedido> lineasDevueltas = new ArrayList<LineaPedido>();
		for (LineaPedido lp : getAll()) {
			if (lp.getPedido().equals(idPedido)){
				lineasDevueltas.add(lp);
				}
			}
		return lineasDevueltas;
	}
	
	@Override
	public void addAll(List<LineaPedido> lineasPedido) {
		lineaPedidoRepository.saveAll(lineasPedido);
	}
}


