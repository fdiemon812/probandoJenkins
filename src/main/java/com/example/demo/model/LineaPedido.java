package com.example.demo.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="lineapedido")
public class LineaPedido{
	
	
	@ManyToOne(cascade = CascadeType.ALL,fetch= FetchType.EAGER)
	@JoinColumn(name="pedido_id")
	private Pedido pedido;
	
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="producto_id")
	private Producto producto;
	
	private static int contador=1;
	
	@Id
	private int id;
	
	@Column(name = "cantidad", nullable = false)
	int cantidad=0;


	/**
	 * Constructor vacio
	 */
	public LineaPedido() {
		
		this.id=contador;
		contador++;
	}
	
	/**
	 * Constructor que recibe un poroducto y un pedido
	 * @param producto
	 * @param pedido
	 */
	public LineaPedido(Producto producto, Pedido pedido) {
		
		this.producto=producto;
		this.pedido=pedido;
		this.id=contador;
		contador++;
	}

	/**
	 * Devuelve el pedido
	 * @return
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * Modifica el pedido
	 * @param pedido
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	/**
	 * Devuelve el producto
	 * @return
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * Modifica el producto
	 * @param producto
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/**
	 * Devuelve la cantidad
	 * @return
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Modifica la cantidad
	 * @param cantidad
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Asigna el codigo hash
	 */
	@Override
	public int hashCode() {
		return Objects.hash(pedido, producto);
	}

	/**
	 * Compara dos lineas pedido segun su id. 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineaPedido other = (LineaPedido) obj;
		return Objects.equals(pedido, other.pedido) && Objects.equals(producto, other.producto);
	}


	

}
