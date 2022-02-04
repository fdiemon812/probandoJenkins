package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	private String user;
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "apellidos", nullable = false)
	private String apellidos;
	@Column(name = "direccion", nullable = false)
	private String direccion;
	@Column(name = "mail", nullable = false)
	private String mail;
	@Column(name = "tlf", nullable = false)
	private int tlf;
	@Column(name = "password", nullable = false)
	private String password;
	
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Pedido> listaPedidos;
	
	
	
	/**
	 * Constructor vacio
	 */
	public Usuario() {
		
	}
	
	/**
	 * Constructor con parametros nickname y contraseña
	 */
	public Usuario(String user, String password ) {
		this.user=user;
		this.password=password;
	}

	/**
	 *  Constructor con todos los parametros
	 * @param user
	 * @param nombre
	 * @param apellidos
	 * @param password
	 * @param direccion
	 * @param tlf
	 * @param mail
	 */
	public Usuario(String user, String nombre, String apellidos,
			String password, String direccion, int tlf, String mail) {
		
	super();
	this.user=user;
	this.direccion=direccion;
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.password = password;
	this.mail=mail;
	this.tlf=tlf;
	this.listaPedidos=new ArrayList<>();
	
	}

	/**
	 * Devuelve un String con el mail del Usuario
	 * @return String mail
	 */
	public String getMail() {
		return mail;
	}

	
	/**
	 * Recibe un string con el mail a modificar
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	
	/**
	 * Devuelve un entero con el tlf del usuario
	 * @return int 
	 */
	public int getTlf() {
		return tlf;
	}

	/**
	 * Recibe un entero y modifica el tlf del usuario
	 * @param tlf
	 */
	public void setTlf(int tlf) {
		this.tlf = tlf;
	}

	
	/**
	 * Muestra un string con el nbombre del usuario
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Recibe un nombre string, modifica el nombre del usuario.
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Muestra un string con los apellidos del usuario
	 * @return
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * Recibe un strin con los apellidos del usuario y los modifica
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	
	/**
	 * Muestra un string con la contraseña del usuario
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	
	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	/**
	 * Reecibe un string y modifica la contraseña 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Devuelve la lista de pedidos de un usuario.
	 * @return
	 */
	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	
	/**
	 * Añade un pedido a la lista de pedidos del usuario. Recibe un pedido 
	 * @param pedido
	 */
	public void addListaPedidos(Pedido pedido) {
		listaPedidos.add(0, pedido);
	}

	
	/**
	 * Muestra un string con la direccion del usuario. 
	 * @return
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Muestra un string con el nickname del usuario. 
	 * @return
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Recibe un string con el nickname y lo modifica en el usuario
	 * @param user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Recibe un stirng con la direccion del usuario y la modifica.
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Genera el codigo hash de un usuario según su nickname
	 */
	@Override
	public int hashCode() {
		return Objects.hash(user);
	}
	
	/**
	 * Recibe un objecto y lo compara con el usuario. Si son iguales devuelve true. 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(user, other.user);
	}
	
	
	
}
