package com.monkyinc.myweb.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
    @NamedQuery(name="pedidoById",
        query="select p from Pedido p where p.id = :idParam")
})
public class Pedido {
	
	
	private long id;
	private Usuario usuario;
	private int cantidad;
	private int precio;
	private List<Producto> productos;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id_pedido) {
		this.id = id_pedido;
	}

	@ManyToMany(targetEntity=Producto.class, fetch=FetchType.EAGER)
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	@ManyToOne(targetEntity=Usuario.class)
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
}
