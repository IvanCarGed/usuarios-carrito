package registro.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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


	@Test
	public void testAddProductProduct() {
		
		Integer sizeBefore = productService.getAll().size();
		productService.addProduct(productoSim);
		Integer sizeAfterInsertion = productService.getAll().size();

		assertTrue(sizeAfterInsertion == sizeBefore + 1);
	}

//	@Test
//	public void testUpdateProduct() {
//		productService.addProduct(productoSim);
//		String cambioDescripcion = "Cambio en descipción para testing.";
//		Product paraUpdate = productService.getProductById(productoSim.getIdProduct());
//		paraUpdate.setDescripcion(cambioDescripcion);
//		productService.updateProduct(paraUpdate);
//		
//		assertEquals(productService.getProductById(paraUpdate.getIdProduct()), cambioDescripcion);
//	}

//	@Test
//	public void testDeleteProduct() {
//		
//		productService.addProduct(4, "descripcion producto Test 004", "marca Test 004", "nombre producto Test 004", 2.5);
//		Integer sizeBefore = productService.getAll().size();
//		productService.deleteProduct(4);
//		Integer sizeAfterDelete = productService.getAll().size();
//		
//		assertTrue(sizeBefore == sizeAfterDelete + 1);
//	}

	@Test
	public void testGetProductById() {
		
		assertNotNull(productService.getProductById(1));
		assertEquals(productService.getProductById(1).getDescripcion(), "descripcion producto Test 001");
	}

	@Test
	public void testBuscar() {
		Product paraBuscar = new Product("nombre producto Test 001", "", "", 0);
		Product paraBuscar2 = new Product("", "descripcion producto Test 002", "", 0);
		Product paraBuscar3 = new Product("", "", "", 33);
		
		List<Product> buscado = productService.buscar(paraBuscar);
		List<Product> buscado2 = productService.buscar(paraBuscar2);
		List<Product> buscado3 = productService.buscar(paraBuscar3);
		assertNotNull(buscado);
		assertEquals(buscado.get(0).getNombre(), paraBuscar.getNombre());
		assertNotNull(buscado2);
		assertEquals(buscado2.get(0).getDescripcion(), paraBuscar2.getDescripcion());
		assertNotNull(buscado3);
		assertTrue(buscado3.get(0).getPrecio() == paraBuscar3.getPrecio());
	}

}
