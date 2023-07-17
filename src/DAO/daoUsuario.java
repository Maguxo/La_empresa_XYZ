package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Conexion.Conexion;
import Modelo.usuarios;
import Vista.ventanaUsuario;
import Vista.vistaUsuario;

public class daoUsuario {

	private Conexion cx;
	private Coordinar cordina;
		
	public void setCoordinar(Coordinar coordina) {
		this.cordina=coordina;
	}
		public 	daoUsuario() {
			cx= new Conexion();	
			
		}
		public ArrayList<usuarios> buscarUsuario(String dato){  //busca lista de usuario
			ArrayList<usuarios> lista= new ArrayList<usuarios>();
			PreparedStatement ps = null;
			ResultSet rs= null;
			try {
				ps= cx.conectar().prepareStatement("SELECT * FROM usuarios WHERE  id LIKE '%"+ dato +"%' OR  Nombres LIKE '%"+ dato +"%'" );
			     rs= ps.executeQuery();
			     while(rs.next()) {
			    	 usuarios user= new usuarios();
			    	 user.setId(rs.getInt("id"));
			    	 user.setDocumento(rs.getString("Documento"));
			    	 user.setNombres(rs.getString("Nombres"));
			    	 user.setApellidos(rs.getString("Apellidos"));
			    	 user.setUsuarios(rs.getString("Usuarios"));
			    	 user.setTelefono(rs.getString("Telefono"));
			    	 user.setCorreo(rs.getString("Correo"));
			    	 user.setEstado(rs.getString("Estado"));
			    	 lista.add(user);
			     }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return lista;
		} 
		public boolean modificarUsuario(usuarios user) {
			int n=0;
			PreparedStatement ps=null;
			try {		
				ps= cx.conectar().prepareStatement("UPDATE usuarios SET Documento=?, Nombres=?, Apellidos=?, Usuarios=?, Telefono=?, Correo=?, Estado=? WHERE  id=?");
				ps.setString(1, user.getDocumento());
			    ps.setString(2, user.getNombres());
			    ps.setString(3, user.getApellidos());
			    ps.setString(4, user.getUsuarios());
			    ps.setString(5, user.getTelefono());
			    ps.setString(6, user.getCorreo());
			    ps.setString(7, user.getEstado());
			    ps.setInt(8, user.getId());
			    ps.executeUpdate();
			    cx.Closed();
			    return true;		    
			} catch (SQLException e) {
				e.printStackTrace();
				return false; 
	}}
       public boolean eliminarUsuario( Integer id) {
			
			PreparedStatement ps=null;
			try {
				ps= cx.conectar().prepareStatement("DELETE FROM usuarios WHERE id=?");
				ps.setInt(1,id);
			    ps.executeUpdate();
			    cx.Closed();
			    return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}}	
		public boolean insertarUsuario(usuarios user) {
			PreparedStatement ps=null;
			try {
				
				ps= cx.conectar().prepareStatement("INSERT INTO usuarios VALUES(null, ?,?,?,?,?,?,?)");
				ps.setString(1, user.getDocumento());
			    ps.setString(2, user.getNombres());
			    ps.setString(3, user.getApellidos());
			    ps.setString(4, user.getUsuarios());
			    ps.setString(5, user.getTelefono());
			    ps.setString(6, user.getCorreo());
			    ps.setString(7, user.getEstado());
			    ps.executeUpdate();
			    cx.Closed();
			    return true;
		    
			} catch (SQLException e) {
				e.printStackTrace();
				return false; 
	}}
		public ArrayList<usuarios> consultaUsuario(){
			ArrayList<usuarios> lista= new ArrayList<usuarios>();
			PreparedStatement ps = null;
			ResultSet rs= null;
			try {
				ps= cx.conectar().prepareStatement("SELECT * FROM usuarios ");
			     rs= ps.executeQuery();
			     while(rs.next()) {
			    	 usuarios user= new usuarios();
			    	 user.setId(rs.getInt("id"));
			    	 user.setDocumento(rs.getString("Documento"));
			    	 user.setNombres(rs.getString("Nombres"));
			    	 user.setApellidos(rs.getString("Apellidos"));
			    	 user.setUsuarios(rs.getString("Usuarios"));
			    	 user.setTelefono(rs.getString("Telefono"));
			    	 user.setCorreo(rs.getString("Correo"));
			    	 user.setEstado(rs.getString("Estado"));
			    	 lista.add(user);
			     }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return lista;
		}  
}
