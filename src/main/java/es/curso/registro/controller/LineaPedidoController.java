package es.curso.registro.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.curso.registro.model.LineaPedido;
import es.curso.registro.model.Pedido;
import es.curso.registro.model.Product;
import es.curso.registro.service.LineaPedidoService;
import es.curso.registro.service.ProductService;

@Controller
public class LineaPedidoController {

	private int cantidad = 1;

	@Autowired
	LineaPedidoService lineaPedidoService;

	@Autowired
	ProductService productService;

	@GetMapping(value = "/addOrderLine")
	public String addOrderLine(Model model, @RequestParam Integer idProduct, HttpSession session) {
		List<LineaPedido> lineasPedido = (List<LineaPedido>) session.getAttribute("orderLines");
		Product producto = productService.getProductById(idProduct);
		model.addAttribute("producto", new Product());
		model.addAttribute("addOk", Boolean.TRUE);

		for (int i = 0; i < lineasPedido.size(); i++) {
			if (lineasPedido.get(i).getProducto().getIdProduct().equals(idProduct)) {
				lineasPedido.get(i).setCantidad(lineasPedido.get(i).getCantidad() + 1);
				model.addAttribute("listaProductos", productService.getAll());				
				return "list-productos";
			}
		}

		
		LineaPedido lp = new LineaPedido(cantidad, producto);
		lineasPedido.add(lp);
		
		model.addAttribute("listaProductos", productService.getAll());
		session.setAttribute("orderLines", lineasPedido);
		return "list-productos";
	}
	
	@PostMapping(value = "/addOrderLine")
	public String addOrderLine(Model model, Integer quantity, Product producto, Pedido pedido) {
		model.addAttribute("producto", new Product());
		lineaPedidoService.addLineaPedido(cantidad, producto, pedido);
		return "redirect:/list-productos";
	}

}
