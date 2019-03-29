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
@Table
public class Product {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "idProduct")
    private Integer idProduct;
    
    @Column (name = "nombre")
    private String nombre;
    
    @Column (name = "descripcion")
    private String descripcion;
    
    @Column (name = "marca")
    private String marca;
    
    @Column (name = "precio")
    private float precio;
    
    @OneToMany(mappedBy = "producto")
    private Set<OrderLine> orderLines;
    
	public Product() {

	}
    
	public Product(String nombre, String descripcion, String marca, float precio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.marca = marca;
		this.precio = precio;
	}
	

	
	public Integer getIdProduct() {
		return idProduct;
	}
	public void setId(Integer idProduct) {
		this.idProduct = idProduct;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}	

}
