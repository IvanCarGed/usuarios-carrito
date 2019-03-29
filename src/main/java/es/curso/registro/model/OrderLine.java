package es.curso.registro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderLine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idOrderLine")
	private Integer idOrderLine;

	@Column(name = "quantity")
	private Integer quantity;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "idProduct", nullable = false)
	private Product producto;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "idOrder", nullable = false)
	private Order pedido;

	/**
	 * @param quantity
	 * @param producto
	 * @param pedido
	 */
	public OrderLine(Integer quantity, Product producto, Order pedido) {
		this.quantity = quantity;
		this.producto = producto;
		this.pedido = pedido;
	}

	/**
	 * 
	 */
	public OrderLine() {
	}

	public Integer getIdOrderLine() {
		return idOrderLine;
	}

	public void setIdOrderLine(Integer idOrderLine) {
		this.idOrderLine = idOrderLine;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProducto() {
		return producto;
	}

	public void setProducto(Product producto) {
		this.producto = producto;
	}

	public Order getPedido() {
		return pedido;
	}

	public void setPedido(Order pedido) {
		this.pedido = pedido;
	}

}
