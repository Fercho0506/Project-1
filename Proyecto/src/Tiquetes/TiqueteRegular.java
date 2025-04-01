package Tiquetes;

import Usuarios.Usuario;

public class TiqueteRegular extends Tiquete{
	
	public TiqueteRegular(String exclusividad, Usuario usuario, int precio) {
		super(exclusividad, usuario, precio, "regular");
	}
}
