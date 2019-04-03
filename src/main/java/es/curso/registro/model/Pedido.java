package es.curso.registro.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idPedido")
	private Integer idPedido;

	@Column(name = "precioFinal")
	private Double precioFinal;

	@Column(name = "direccion")
	private String direccion;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "idEstado", nullable = false)
	private Estado estado;
	
	@Column(name = "comentario")
	private String comentario;

	@OneToMany(mappedBy = "pedido")
	private List<LineaPedido> lineasPedido;

	/**
	 * @param precioFinal
	 * @param direccion
	 * @param estado
	 * @param comentario
	 */
	public Pedido(Double precioFinal, String direccion, Estado estado, String comentario) {
		this.precioFinal = precioFinal;
		this.direccion = direccion;
		this.estado = estado;
		this.comentario = comentario;
	}
	

	/**
	 * @param precioFinal
	 * @param direccion
	 * @param estado
	 * @param comentario
	 * @param lineasPedido
	 */
	public Pedido(Double precioFinal, String direccion, Estado estado, String comentario,
			List<LineaPedido> lineasPedido) {
		this.precioFinal = precioFinal;
		this.direccion = direccion;
		this.estado = estado;
		this.comentario = comentario;
		this.lineasPedido = lineasPedido;
	}


	/**
	 * 
	 */
	public Pedido() {
	}





	/**
	 * @param idPedido
	 * @param precioFinal
	 * @param direccion
	 * @param estado
	 * @param comentario
	 */
	public Pedido(Integer idPedido, String comentario, String direccion, Estado estado, Double precioFinal) {
		this.idPedido = idPedido;
		this.precioFinal = precioFinal;
		this.direccion = direccion;
		this.estado = estado;
		this.comentario = comentario;
	}


	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
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


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public List<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}

	public void setLineasPedido(List<LineaPedido> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}

}
