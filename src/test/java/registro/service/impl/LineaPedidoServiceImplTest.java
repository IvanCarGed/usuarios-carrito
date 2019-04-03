package registro.service.impl;

import static org.junit.Assert.assertNull;

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
@SpringBootTest(classes={Application.class})
public class LineaPedidoServiceImplTest {

	@Autowired
	private LineaPedidoService lineaPedidoService;
    private EmbeddedDatabase db;

	private LineaPedido lineaPedidoSim;
	private Product productoSim;
	private Pedido pedidoSim;
	private Estado estadoSim;
	private static Double precioFinal=999.99;
	private static int cantidad = 18;
	
	@Before
	public void setup() {
//		estadoSim = new Estado(999, "Estado Sim");
//		productoSim = new Product(999, "descripcion Sim", "marca Sim", "nombre Sim", 999);
//		pedidoSim = new Pedido(999, "comentario Sim", "direccion Sim", estadoSim, precioFinal);
//		lineaPedidoSim = new LineaPedido(999, cantidad, pedidoSim, productoSim);
//		lineaPedidoService.addLineaPedido(lineaPedidoSim);
		
		
    	db = new EmbeddedDatabaseBuilder()
        		.setType(EmbeddedDatabaseType.H2)
        		.addScript("create-db.sql")
        		.addScript("insert-data.sql")
        		.build();

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
