package registro.service.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertNull;

import es.curso.registro.model.Estado;
import es.curso.registro.model.LineaPedido;
import es.curso.registro.model.Pedido;
import es.curso.registro.model.Product;
import es.curso.registro.service.LineaPedidoService;

public class LineaPedidoServiceImplTest {

	private LineaPedidoService lineaPedidoService;
	private LineaPedido lineaPedidoSim;
	private Product productoSim;
	private Pedido pedidoSim;
	private Estado estadoSim;
	private static Double precioFinal=999.99;
	private static int cantidad = 18;
	
	@Before
	public void setup() {
		estadoSim = new Estado(999, "Estado Sim");
		productoSim = new Product(999, "descripcion Sim", "marca Sim", "nombre Sim", 999);
		pedidoSim = new Pedido(999, "comentario Sim", "direccion Sim", estadoSim, precioFinal);
		lineaPedidoSim = new LineaPedido(999, cantidad, pedidoSim, productoSim);
		lineaPedidoService.addLineaPedido(lineaPedidoSim);
	}
	
	@Test
	public void testGetAll() {

		assertNull(lineaPedidoService.getAll());
	}
//
//	@Test
//	public void testAddLineaPedidoIntegerProductPedido() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAddLineaPedidoLineaPedido() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFindByPedido() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAddAll() {
//		fail("Not yet implemented");
//	}

}
