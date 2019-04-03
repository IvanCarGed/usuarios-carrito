package registro.controller;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import es.curso.registro.Application;
import es.curso.registro.controller.MainController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
public class MainControllerTest {
	
	private MainController mainController;
	
	Model model = null;
	
	HttpSession session;

	@Before
	public void setup() {
		mainController = new MainController();
	}
	
	@Test
	public void testRoot() {
		assertEquals("index", mainController.root());
	}

//	@Test
//	public void testLogin() {
//		assertEquals("login", mainController.login(model));
//	}
//
//	
//	@Test
//	public void testListProductos() {
//		assertEquals("list-productos", mainController.listProductos(model, session));
//	}
//
//	@Test
//	public void testListPedidos() {
//		fail("Not yet implemented");
//	}
//
	@Test
	public void testUserIndex() {
		assertEquals("user/index", mainController.userIndex());
	}

	@Test
	public void testUserIndex2() {
		assertEquals("index", mainController.userIndex2());
	}
//
//	@Test
//	public void testListaUsuarios() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testQuitarPrivilegiosAdmin() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDarPrivilegiosAdmin() {
//		fail("Not yet implemented");
//	}



}
