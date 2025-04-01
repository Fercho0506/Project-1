package Modelo;

import Usuarios.Usuario;

public abstract class Compra {
	private int precio;
	private int codigo;
	private Usuario comprador;
	
	public Compra(int codigo, Usuario comprador) {
		this.precio=0;
		this.codigo=codigo;
		this.comprador=comprador;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public Usuario getComprador() {
		return comprador;
	}
	
	public void setPrecio(int i) {
		precio=i;
	}
	
	public void agregarProducto(int i) {
		precio +=i;
	}
}
