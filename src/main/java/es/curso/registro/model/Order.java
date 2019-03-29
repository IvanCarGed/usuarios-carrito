package es.curso.registro.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idOrder")
	private Integer idOrder;

	@Column(name = "precioFinal")
	private Double precioFinal;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "estado")
	private String estado;

	@Column(name = "comentario")
	private String comentario;

	@OneToMany(mappedBy = "pedido")
	private Set<OrderLine> orderLines;

	/**
	 * @param precioFinal
	 * @param direccion
	 * @param estado
	 * @param comentario
	 * @param orderLines
	 */
	public Order(Double precioFinal, String direccion, String estado, String comentario, Set<OrderLine> orderLines) {
		this.precioFinal = precioFinal;
		this.direccion = direccion;
		this.estado = estado;
		this.comentario = comentario;
		this.orderLines = orderLines;
	}

	/**
	 * 
	 */
	public Order() {
	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public Double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(Double precioFinal) {
		this.precioFinal = precioFinal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Set<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(Set<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

}
