package Usuarios;

public class Cocinero extends Empleado{
	
	
	public Cocinero (String login, String password, int edad, float altura, String labor) {
		super(login, password, edad, altura, "cocinero", labor);
	}
	
	public void prepararPlato(String plato) {
		System.out.print("Se preparó "+plato+"plato");
	}
}
