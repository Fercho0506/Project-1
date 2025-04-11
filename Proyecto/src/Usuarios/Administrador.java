package Usuarios;

public class Administrador extends Usuario{
	private static final long serialVersionUID = 1L;
	public Administrador(String login, String password, int edad, float altura) {
		super(login, password, "administrador", edad, altura);
	}
}
