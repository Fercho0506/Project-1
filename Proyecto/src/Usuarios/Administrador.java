package Usuarios;

public class Administrador extends Usuario{
	public Administrador(String login, String password, int edad, float altura) {
		super(login, password, "administrador", edad, altura);
	}
}
