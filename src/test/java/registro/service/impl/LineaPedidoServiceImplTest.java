package registro.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
import es.curso.registro.service.LineaPedidoService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
public class LineaPedidoServiceImplTest {

	private EmbeddedDatabase db;
	@Autowired
	private LineaPedidoService lineaPedidoService;

	private static int cantidad = 18;
	private static Double precioFinal = 999.99;

	private Estado estadoSim = new Estado(999, "Estado Sim");
	private Pedido pedidoSim = new Pedido(999, "comentario Sim", "direccion Sim", estadoSim, precioFinal);
	private Pedido pedidoSim2 = new Pedido(998, "comentario Sim2", "direccion Sim2", estadoSim, precioFinal);
	private Product productoSim = new Product(999, "descripcion Sim", "marca Sim", "nombre Sim", 999);
	private Product productoSim2 = new Product(998, "descripcion Sim2", "marca Sim2", "nombre Sim2", 999);
	private LineaPedido lineaPedidoSim = new LineaPedido(999, cantidad, pedidoSim, productoSim);
	private LineaPedido lineaPedidoSim2 = new LineaPedido(998, cantidad, pedidoSim2, productoSim2);
	private List<LineaPedido> finded = new ArrayList<LineaPedido>();

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

		assertNotNull(lineaPedidoService.getAll());
		assertEquals(lineaPedidoService.getAll().get(0).getClass(), lineaPedidoSim.getClass());
	}

	@Test
	public void testAddLineaPedidoLineaPedido() {
		Integer sizeBefore = lineaPedidoService.getAll().size();
		lineaPedidoService.addLineaPedido(lineaPedidoSim);
		Integer sizeAfterInsertion = lineaPedidoService.getAll().size();

		assertTrue(sizeAfterInsertion == sizeBefore + 1);
	}

	@Test
	public void testFindByPedido() {
		
		assertNotNull(lineaPedidoService.findByPedido(pedidoSim.getIdPedido()));
		assertEquals(lineaPedidoService.findByPedido(pedidoSim.getIdPedido()).getClass(), finded.getClass());
	}

	@Test
	public void testAddAll() {
		List<LineaPedido> lineas = new ArrayList<LineaPedido>();
		
		lineas.add(lineaPedidoSim);
		lineas.add(lineaPedidoSim2);
		
		Integer sizeBefore = lineaPedidoService.getAll().size();
		
		lineaPedidoService.addAll(lineas);
		
		Integer sizeAfterInsertion = lineaPedidoService.getAll().size();

		assertTrue(sizeAfterInsertion == sizeBefore + lineas.size());

	}

}
