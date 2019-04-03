package es.curso.registro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "linea_pedido")
public class LineaPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idLineaPedido")
	private Integer idLineaPedido;

	@Column(name = "cantidad")
	private Integer cantidad;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "idProduct", nullable = false)
	private Product producto;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "idPedido", nullable = false)
	private Pedido pedido;

	/**
	 * @param cantidad
	 * @param producto
	 * @param pedido
	 */
	public LineaPedido(Integer cantidad, Product producto, Pedido pedido) {
		this.cantidad = cantidad;
		this.producto = producto;
		this.pedido = pedido;
	}

	/**
	 * @param cantidad
	 * @param producto
	 */
	public LineaPedido(Integer cantidad, Product producto) {
		this.cantidad = cantidad;
		this.producto = producto;
	}

	/**
	 * 
	 */
	public LineaPedido() {
	}

	/**
	 * @param idLineaPedido
	 * @param cantidad
	 * @param producto
	 * @param pedido
	 */
	public LineaPedido(Integer idLineaPedido, Integer cantidad, Pedido pedido, Product producto) {
		this.idLineaPedido = idLineaPedido;
		this.cantidad = cantidad;
		this.producto = producto;
		this.pedido = pedido;
	}

	public Integer getIdLineaPedido() {
		return idLineaPedido;
	}

	public void setIdLineaPedido(Integer idLineaPedido) {
		this.idLineaPedido = idLineaPedido;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Product getProducto() {
		return producto;
	}

	public void setProducto(Product producto) {
		this.producto = producto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
