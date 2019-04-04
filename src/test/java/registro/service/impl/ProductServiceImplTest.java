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
import es.curso.registro.model.Product;
import es.curso.registro.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
public class ProductServiceImplTest {
	
	private EmbeddedDatabase db;
	
	@Autowired
	ProductService productService;
	

	private Product productoSim = new Product(999, "descripcion Sim", "marca Sim", "nombre Sim", 999);
	private Product productoSim2 = new Product(998, "descripcion Sim2", "marca Sim2", "nombre Sim2", 999);
	
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
		assertNotNull(productService.getAll());
		assertEquals(productService.getAll().get(0).getClass(), Product.class);
	}


//	@Test
//	public void testAddProductProduct() {
//		Integer sizeBefore = productService.getAll().size();
//		productService.addProduct(productoSim);
//		Integer sizeAfterInsertion = productService.getAll().size();
//
//		assertTrue(sizeAfterInsertion == sizeBefore + 1);
//	}

//	@Test
//	public void testUpdateProduct() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteProduct() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetProductById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testBuscar() {
//		fail("Not yet implemented");
//	}

}
