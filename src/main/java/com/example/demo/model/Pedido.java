package com.example.demo.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;



@Entity
@Table(name = "pedidos")
public class Pedido {
	

    
	@OneToMany(cascade = CascadeType.ALL,fetch= FetchType.EAGER, orphanRemoval = true)
	@NotFound(action=NotFoundAction.IGNORE)
	public List<LineaPedido> listaLineaPedido;
    
	
	
	private static int contador=1;
	
	@Id
	private int id;
	@Column(name = "fecha", nullable = true)
	private Date fecha;
    @Column(name = "precioEnvio", nullable = true)
	private int precioEnvio;
    @Column(name = "totalPedido", nullable = true)
	private Double totalPedido;
    @Column(name = "nombre", nullable = true)
	private String nombre;
    @Column(name = "apellidos", nullable = true)
	private String apellidos;
	
    @Column(name = "direccion", nullable = true)
	private String direccion;
    @Column(name = "mail", nullable = true)
	private String mail;
	
    @Column(name = "telefono", nullable = true)
	private String tlf;
	

	/**
	 * Constructor vacio
	 */
	public Pedido() {
		
		this.listaLineaPedido = new  ArrayList<>();
		this.id=contador;
		contador++;
		this.fecha=new Date();
		
		
	}
	
	
	
	
	/**
	 * Constructor con parametro id
	 * @param id
	 */
	public Pedido(int id) {
		this.id=id;
	
	}



	/**
	 * Devuelve el coste total del pedido
	 * @return
	 */
	public Double getTotalPedido() {
		return totalPedido;
	}




	/**
	 * Modifica el coste total del pedido
	 * @param totalPedido
	 */
	public void setTotalPedido(Double totalPedido) {
		this.totalPedido = totalPedido;
	}








	/**
	 * Devuelve el id del pedido
	 * @return
	 */
	public int getId() {
		return id;
	}




	/**
	 * Modifica el id del pedido
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}




	/**
	 * Devuelve la fecha en la que se realizo el pedido
	 * @return
	 */
	public String getFecha() {
		
		
		Date objDate = new Date(); // Sistema actual La fecha y la hora se asignan a objDate 
		 
        
        String strDateFormat = "dd-MM-yy"; // El formato de fecha está especificado  
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); 
		
		
		return objSDF.format(objDate);
	}








	/**
	 * Se obtiene el precio del envio
	 * @return
	 */
	public int getPrecioEnvio() {
		return precioEnvio;
	}
	
	
	
	
	/**
	 * Modifica el precio del envio
	 * @param precioEnvio
	 */
	public void setPrecioEnvio(int precioEnvio) {
		this.precioEnvio = precioEnvio;
	}

	
	/**
	 * Devuelve la lista de productos de un pedido
	 * @return HashMap<Producto, Integer>
	 */
	public  List<LineaPedido> getListaLineaPedido() {
		return listaLineaPedido;
	}

	

	/**
	 * Devuelve el nombre del pedido
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}




	/**
	 * Modifica el nombre del usuario del pedido
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	/**
	 * Devuelve los apellidos del usuario del pedido
	 * @return
	 */
	public String getApellidos() {
		return apellidos;
	}




	/**
	 * Modifica el apellido del usuario del pedido
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	
	/**
	 * Obtiene la direccion del pedido
	 * @return
	 */
	public String getDireccion() {
		return direccion;
	}




	/**
	 * Modifica la dirección del pedido
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}




	/**
	 * Obtiene el mail del usuario del pedido
	 * @return
	 */
	public String getMail() {
		return mail;
	}



	
	/**
	 * Modifica el correo del pedido
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}




	/**
	 * Obtiene el telefono del pedido
	 * @return
	 */
	public String getTlf() {
		return tlf;
	}




	/**
	 * Modifica el telefono del pedido
	 * @param tlf2
	 */
	public void setTlf(String tlf2) {
		this.tlf = tlf2;
	}





	




	/**
	 * Devuelve el codigo hash del pedido
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}




	/**
	 * Devuelve true si el pedido recibido es igual 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return id == other.id;
	}


	

	
	
	
}

