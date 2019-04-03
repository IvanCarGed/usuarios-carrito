package es.curso.registro.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.curso.registro.model.LineaPedido;
import es.curso.registro.model.Pedido;
import es.curso.registro.model.Role;
import es.curso.registro.model.User;
import es.curso.registro.service.EstadoService;
import es.curso.registro.service.PedidoService;
import es.curso.registro.service.ProductService;
import es.curso.registro.service.UserService;
import es.curso.registro.util.Constantes;

@Controller
public class MainController {

	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	PedidoService pedidoService;
	
	@Autowired
	EstadoService estadoService;
	
	private List<LineaPedido> orderLines = new ArrayList<LineaPedido>();
	
    @GetMapping("/")
    public String root() {
    	
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    
    @GetMapping("/list-productos")
    public String listProductos(Model model, HttpSession session) {
    	session.setAttribute("orderLines", orderLines);
    	model.addAttribute("listaProductos", productService.getAll());
        return "list-productos";
    }
    
    @GetMapping("/list-pedidos")
    public String listPedidos(Model model, HttpSession session) {
    	model.addAttribute("pedido", new Pedido());
    	model.addAttribute("estados", estadoService.getAll());
    	model.addAttribute("listaPedidos", pedidoService.getAll());
    	
    	return "list-pedidos";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
  
    @GetMapping("/index")
    public String userIndex2() {
        return "index";
    }
    @GetMapping("/admin/home")
    public String listaUsuarios(Model model) {
        model.addAttribute("listaUsuarios" , userService.getAll() );
        return "listaUsuarios";
    }
    
    @GetMapping("/admin/quitarPrivilegios/{id}")
    public String quitarPrivilegiosAdmin(Model model, 
    		@PathVariable("id") Long id) {
        User user =  userService.findById(id);
        Role roleToDelete = userService.getRoleWithName(Constantes.ROLE_ADMIN);
        userService.deleteRolesWithRoleIdUserId(roleToDelete.getId(), id);
        userService.update(user);
        return "index";
    }

    @GetMapping("/admin/darPrivilegios/{id}")
    public String darPrivilegiosAdmin(Model model, 
    		@PathVariable("id") Long id) {
        User user =  userService.findById(id);
        Role roleToAdd = userService.getRoleWithName(Constantes.ROLE_ADMIN);
        user.getRoles().add(roleToAdd);
        userService.update(user);
        return "index";
    }

}
