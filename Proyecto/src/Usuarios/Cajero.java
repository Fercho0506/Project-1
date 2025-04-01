package Usuarios;

import Atracciones.Atraccion;
import Atracciones.AtraccionCultural;
import Atracciones.AtraccionMecanica;
import LugarServicios.LugarServicio;
import Tiquetes.Entrada;
import Tiquetes.Tiquete;
import Tiquetes.TiqueteRegular;
import Tiquetes.TiqueteTemporada;

public class Cajero extends Empleado{
	private Atraccion atraccion;
	private LugarServicio lugar;
	
	public Cajero(String login, String password, int edad, float altura, 
			String labor) {
		super(login, password, edad, altura, "cajero", labor);
		this.atraccion=null;
		this.lugar=null;
	}
	
	public Atraccion getAtraccion() {
		return atraccion;
	}
	
	public LugarServicio getLugar() {
		return lugar;
	}
	
	public void setAtraccion(Atraccion Atraccion) {
		this.atraccion= Atraccion;
		this.lugar= null;
	}
	
	public void setLugar(LugarServicio lugar) {
		this.atraccion= null;
		this.lugar= lugar;
	}
	
	public boolean validarTiquete(Tiquete tiquete, String fechaHoy) {
		if (atraccion.getTipo()=="mecanica") {
			AtraccionMecanica atract= (AtraccionMecanica)atraccion;
			if (tiquete.getUsuario().getAltura()<atract.getAlturaMax() && 
					tiquete.getUsuario().getAltura()<atract.getAlturaMin()) {
				if (!tiquete.getUsado()) {
					if(tiquete.getTipo() == "temporada") {
						return validarTemporada(tiquete, fechaHoy);
					}
					if (tiquete.getTipo() == "entrada") {
						return validarEntrada(tiquete);
					}
					else if (tiquete.getTipo() == "regular") {
						return validarExclusividad(tiquete);
					}
				}
			}
		}
		else {
			AtraccionCultural atract= (AtraccionCultural)atraccion;
			if (atract.getEdadMin()<= tiquete.getUsuario().getEdad()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean validarTemporada(Tiquete tiquete, String fechaHoy) {
		TiqueteTemporada tiquet= (TiqueteTemporada) tiquete;
		int i1= fechaHoy.compareTo(tiquet.getInicio());
		int i2= tiquet.getFin().compareTo(fechaHoy);
		if (i1==1 && i2==1) {
			return validarExclusividad(tiquete);
		}
		return false;
	}
	
	public boolean validarEntrada(Tiquete tiquete) {
		Entrada ticket= (Entrada) tiquete;
		if (ticket.getAtraccion()== atraccion){
			ticket.usarTiquete();
			return true;
		}
		return false;
	}
	
	public boolean validarExclusividad(Tiquete tiquete) {
		String exclusividad= tiquete.getExclusividad();
		if (atraccion.getExclusividad() == exclusividad) {
			return true;
		}
		else if (exclusividad == "diamante") {
			return true;
		}
		else if(exclusividad == "oro" && atraccion.getExclusividad()== "familiar") {
			return true;
		}
		return false;		
	}
	
}
