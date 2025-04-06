package Modelo;

import Usuarios.Usuario;

public abstract class Compra {
	private float precio;
	private int codigo;
	private Usuario comprador;
	
	public Compra(int codigo, Usuario comprador) {
		this.precio=0;
		this.codigo=codigo;
		this.comprador=comprador;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public Usuario getComprador() {
		return comprador;
	}
	
	public void setPrecio(float i) {
		precio=i;
	}
	
	public void agregarProducto(float i) {
		precio +=i;
	}
}
