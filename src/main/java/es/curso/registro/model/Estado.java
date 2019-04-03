package es.curso.registro.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idEstado")
	private Integer idEstado;

	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "estado")
	private List<Pedido> pedido;

	/**
	 * @param nombre
	 */
	public Estado(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 */
	public Estado() {
	}

	/**
	 * @param idEstado
	 * @param nombre
	 */
	public Estado(Integer idEstado, String nombre) {
		this.idEstado = idEstado;
		this.nombre = nombre;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

}
