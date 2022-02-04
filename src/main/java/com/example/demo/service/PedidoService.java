package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LineaPedido;
import com.example.demo.model.Pedido;
import com.example.demo.model.Producto;
import com.example.demo.model.Usuario;
import com.example.demo.repository.LineaPedidoRepository;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.repository.ProductoRepository;

@Service
public class PedidoService {

	@Autowired
	private ProductoRepository produRepo;

	@Autowired
	private PedidoRepository pedidoRepo;

	@Autowired
	private LineaPedidoRepository lineaRepo;

	@Autowired
	private UsuarioService usuServ;


	/**
	 * Recibe la posicion de un producto en la BBDD o ID, el pedido donde lo vas a
	 * add y la cantidad que quieres add de ese producto.
	 * 
	 * @param posicion
	 * @param pedido
	 * @param cantidad
	 */
	public void addPedido(int posicion, Pedido pedido, int cantidad) {

		LineaPedido nuevaLinea = new LineaPedido(produRepo.findAll().get(posicion - 1), pedido);

		ArrayList<LineaPedido> lineasPedido = (ArrayList<LineaPedido>) pedido.getListaLineaPedido();

		if (lineasPedido.contains(nuevaLinea)) {

			int indice = lineasPedido.indexOf(nuevaLinea);
			int cantidadOld = lineasPedido.get(indice).getCantidad();
			int cantidadNueva = cantidadOld + cantidad;
			lineasPedido.get(indice).setCantidad(cantidadNueva);
		} else {
			nuevaLinea.setCantidad(cantidad);
			lineasPedido.add(nuevaLinea);
			lineaRepo.save(nuevaLinea);

		}

	}

	/**
	 * Recibe un pedido y devuelve el precio total.
	 * 
	 * @param pedido
	 * @return Double precioToptal
	 */
	public Double calculaPrecioTotal(Pedido pedido) {
		Double result = 0.0;

		for (LineaPedido linea : pedido.getListaLineaPedido()) {

			result += (linea.getProducto().getPrecio()) * linea.getCantidad();

		}

		return result;

	}

	/**
	 * Recibe un usuario y un id de pedido. Borra el pedido con dicho ID del usuario
	 * recibido.
	 * 
	 * @param usuario
	 * @param id
	 */
	public void borrarPedido(Usuario usuario, int id) {

		Pedido pedido = pedidoRepo.getById(id);
		List<Pedido> pedidos = usuario.getListaPedidos();
		pedido.getListaLineaPedido().clear();
		usuario.getListaPedidos().remove(pedido);
		usuServ.saveUser(usuario);
		pedidoRepo.delete(pedido);

	}

	/**
	 * Recibe un id de pedido y un usuario. Devuelve el pedido dentro del usuario,
	 * con dicho ID.
	 * 
	 * @param id
	 * @param usuario
	 * @return Pedido
	 */
	public Pedido findPedido(int id, Usuario usuario) {
		Pedido pedido = new Pedido(id);
		ArrayList<Pedido> listaPedidos = new ArrayList<>(usuario.getListaPedidos());

		return listaPedidos.get(listaPedidos.indexOf(pedido));
	}

	/**
	 * Recibe un usuario. Devuelve su ultimo pedido.
	 * 
	 * @param usuario
	 * @return
	 */
	public Pedido findPedido(Usuario usuario) {
		return usuario.getListaPedidos().get(0);

	}
	

	/**
	 * Devuelve los productos recogidos en la BBDD
	 * 
	 * @return
	 */
	public ArrayList<Producto> findAll() {

		
		return  (ArrayList<Producto>) produRepo.findAll();

	}
	/**
	 * Recibe un pedido. Guarda o actualiza un pedido en la BBDD
	 * @param pedido
	 */
	public void savePedido(Pedido pedido) {
		pedidoRepo.save(pedido);
	}


}
