package Tiquetes;

import Usuarios.Usuario;

public abstract class Tiquete {
	private String exclusividad;
	private String tipoTiquete;
	private boolean usado;
	private Usuario usuario;
	private int precio;

	public Tiquete(String exclusividad, Usuario usuario, int precio, String tipo) {
		this.exclusividad=exclusividad;
		this.usuario= usuario;
		this.precio=precio;
		this.tipoTiquete=tipo;
		this.usado= false;
	}
	
	public String getExclusividad() {
		return exclusividad;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public boolean getUsado() {
		return usado;
	}
	
	public String getTipo() {
		return tipoTiquete;
	}
	
	public void setExcllusividad(String excl) {
		exclusividad=excl;
	}
	
	public void setPrecio(int price) {
		precio=price;
	}
	
	public void usarTiquete() {
		usado= true;
		usuario.UsarTiquete(this);
	}
}
