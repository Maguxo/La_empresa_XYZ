package Modelo;

public class usuarios {
	
	private int id;
	private String Documento;
	private String Nombres;
	private String Apellidos;
	private String Usuarios;
	private String Telefono;
	private String Correo;
	private String Estado;
	
	public usuarios(String documento, String nombres, String apellidos, String usuarios, String telefono, String correo,
			String estado, int id) {
		this.Documento = documento;
		this.Nombres = nombres;
		this.Apellidos = apellidos;
		this.Usuarios = usuarios;
		this.Telefono = telefono;
		this.Correo = correo;
		this.Estado = estado;
		this.id = id;
	}
	
	public usuarios() {}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDocumento() {
		return Documento;
	}
	public void setDocumento(String documento) {
		Documento = documento;
	}
	public String getNombres() {
		return Nombres;
	}
	public void setNombres(String nombres) {
		Nombres = nombres;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getUsuarios() {
		return Usuarios;
	}
	public void setUsuarios(String usuarios) {
		Usuarios = usuarios;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	
}
