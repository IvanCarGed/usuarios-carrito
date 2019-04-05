package registro.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.junit4.SpringRunner;

import es.curso.registro.Application;
import es.curso.registro.model.Estado;
import es.curso.registro.model.LineaPedido;
import es.curso.registro.model.Pedido;
import es.curso.registro.model.Product;
import es.curso.registro.service.PedidoService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
public class PedidoServiceImplTest {

	private EmbeddedDatabase db;
	@Autowired
	private PedidoService pedidoService;

	private static int cantidad = 18;
	private static Double precioFinal = 999.99;

	private Estado estadoSim = new Estado(999, "Estado Sim");
	private Pedido pedidoSim = new Pedido(999, "comentario Sim", "direccion Sim", estadoSim, precioFinal);
	private Pedido pedidoSim2 = new Pedido(998, "comentario Sim2", "direccion Sim2", estadoSim, precioFinal);
	private Product productoSim = new Product(999, "descripcion Sim", "marca Sim", "nombre Sim", 999);
	private Product productoSim2 = new Product(998, "descripcion Sim2", "marca Sim2", "nombre Sim2", 999);
	private LineaPedido lineaPedidoSim = new LineaPedido(999, cantidad, pedidoSim, productoSim);
	private LineaPedido lineaPedidoSim2 = new LineaPedido(998, cantidad, pedidoSim2, productoSim2);
	private Pedido finded = new Pedido();

	@Before
	public void setup() {

		db = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("create-db.sql")
				.addScript("insert-data.sql").build();
	}

	@After
	public void delete() {
		db = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("drop-db.sql").build();
	}

	@Test
	public void testGetAll() {
		assertNotNull(pedidoService.getAll());
		assertEquals(pedidoService.getAll().get(0).getClass(), Pedido.class);
	}

//	@Test
//	public void testGetPedidoById() {
//
//		Pedido p = pedidoService.getPedidoById(1);
//		assertNotNull(pedidoService.getPedidoById(1).toString());
//		assertEquals(pedidoService.getPedidoById(1).getPrecioFinal(), precioFinal);
//	}

	@Test
	public void testAddPedidoPedido() {

		Integer sizeBefore = pedidoService.getAll().size();
		pedidoService.addPedido(pedidoSim);
		Integer sizeAfterInsertion = pedidoService.getAll().size();

		assertTrue(sizeAfterInsertion == sizeBefore + 1);
	}

	@Test
	public void testUpdatePedido() {
		
		pedidoService.addPedido(pedidoSim);
		Pedido paraUpdate = pedidoService.getPedidoById(pedidoSim.getIdPedido());
		String cambioEnComentario = "Comentario cambiado para testear.";
		paraUpdate.setComentario(cambioEnComentario);
		pedidoService.updatePedido(paraUpdate);

		assertEquals(paraUpdate.getComentario(), "Comentario cambiado para testear.");
	}

//	@Test
//	public void testBuscar() {
//		assertNotNull(pedidoService.buscar(pedidoSim));
//		assertEquals(pedidoService.buscar(pedidoSim).get(0).getClass(), LineaPedido.class);
//	}

}
