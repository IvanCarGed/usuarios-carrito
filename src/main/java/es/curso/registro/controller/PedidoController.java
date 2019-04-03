package es.curso.registro.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.curso.registro.model.LineaPedido;
import es.curso.registro.model.Pedido;
import es.curso.registro.model.Product;
import es.curso.registro.service.EstadoService;
import es.curso.registro.service.LineaPedidoService;
import es.curso.registro.service.PedidoService;
import es.curso.registro.util.mail.model.Mail;
import es.curso.registro.util.mail.service.EmailService;

@Controller
public class PedidoController {

	@Autowired
	PedidoService pedidoService;

	@Autowired
	LineaPedidoService lineaPedidoService;

	@Autowired
	EstadoService estadoService;
	
    @Autowired
    private EmailService emailService;

	@GetMapping(value = "/addOrder")
	public String addOrder(Model model, HttpSession session) {
		model.addAttribute("orderLines", (List<Product>) session.getAttribute("ordeLines"));
		model.addAttribute("order", new Pedido());
		return "order";
	}

	@GetMapping(value = "/updatePedido")
	public String updatePedido(Model model, @RequestParam Integer idPedido) {
		model.addAttribute("pedido", pedidoService.getPedidoById(idPedido));
		model.addAttribute("estados", estadoService.getAll());

		return "updatePedido";
	}

	@PostMapping(value = "/addOrder")
	public String addOrder(Model model, String direccion, String comentario, HttpSession session) {

		List<LineaPedido> lineasPedido = (List<LineaPedido>) session.getAttribute("orderLines");
		Double precio = 0.0;

		Pedido nuevoPedido = new Pedido(precio, direccion, estadoService.findById(1), comentario);

		nuevoPedido = pedidoService.addPedido(nuevoPedido);
		for (int i = 0; i < lineasPedido.size(); i++) {
			lineasPedido.get(i).setPedido(nuevoPedido);
			precio = precio
					+ (double) (lineasPedido.get(i).getCantidad() * lineasPedido.get(i).getProducto().getPrecio());
		}

		lineaPedidoService.addAll(lineasPedido);
		nuevoPedido.setPrecioFinal(precio);
		pedidoService.updatePedido(nuevoPedido);

		return "redirect:/index";
	}

	@PostMapping(value = "/updatePedido")
	public String updatePedido(Model model, Pedido pedido) {

		pedidoService.updatePedido(pedido);
		

        Mail mail = new Mail();
        mail.setFrom("no-reply@tuaplicaciondepedidos.com");
        mail.setTo("ivancarged@gmail.com");
        mail.setSubject("Pedido Actualizado");
        mail.setContent("Hemos actualizado el estado de tu pedido a "+pedido.getEstado().getNombre());

        emailService.sendSimpleMessage(mail);
		return "redirect:/list-pedidos";
	}
	
	@PostMapping (value ="/buscar-pedido")
	public String buscarPedido (Model model, Pedido pedido){
		
		model.addAttribute("pedido", new Pedido());
		model.addAttribute("listaPedidos", pedidoService.buscar(pedido));
		model.addAttribute("estados", estadoService.getAll());
		return "list-pedidos";
		
	}

}
