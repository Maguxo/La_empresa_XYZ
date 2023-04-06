package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	Connection cn= null;
	
	public Connection conectar() {
		try {
			Class.forName("org.sqlite.JDBC");
			cn= DriverManager.getConnection("jdbc:sqlite:Sistema.db");
			System.out.println("Conección exitosa");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
	
		}
		return cn;
	}
	
	public void Closed() {
		
	  try {
		  cn.close();
	    } catch (SQLException e) {
		e.printStackTrace();
	  }
	}
	/*public static  void main(String args[]) {
		
		Conexion con= new Conexion();
		con.conectar();
	}*/
}
