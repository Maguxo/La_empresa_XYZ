package DAO;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;
import Modelo.usuarios;
import Vista.Presentacion;
import Vista.ventanaUsuario;
import Vista.vistaUsuario;

public class Coordinar {

	private ventanaUsuario ventanaUsuario;
	private vistaUsuario vistaUsuario;
	private daoUsuario dao= new daoUsuario();
	private GestionaCelda celda;
	private ModeloTabla modelo6;
	private Presentacion presenta;
	
	public Coordinar() {}
	public void setPresentaUsuario(Presentacion presenta) {
		this.presenta=presenta;
	}
	public void setVentanaUsuario(ventanaUsuario ventana) {
		this.ventanaUsuario= ventana;
	}
	public void setVistaUsuario(vistaUsuario vista) {
		this.vistaUsuario= vista;
	}
	public void setDaoUsuario(daoUsuario dao) {
		this.dao= dao;
	}
	public void setGestionarCelda(GestionaCelda celda) {
	   this.celda=celda;	
	}
	public void setModeloTabla(ModeloTabla tabla) {
		   this.modelo6=tabla;	
	}	
	public void mostrarVentanaUsuario() {
		ventanaUsuario.setVisible(true);
	}
	public void mostrarVistaUsuario() {
		
		presenta.setVisible(true); 
		Timer tiempo= new Timer();
	
		TimerTask t= new TimerTask() {
			@Override
			public void run() {
				vistaUsuario.setVisible(true);
                presenta.getFocusCycleRootAncestor().setVisible(false);

	}};
	     tiempo.schedule(t, 6000);
	}
	public void quitarVistaUsuario() {
		vistaUsuario.setVisible(false);
	}
	
	public boolean insertarUsuario(usuarios usuario) {
		return dao.insertarUsuario(usuario);
	}
	public ArrayList<usuarios> consultarUsuario() {
	return dao.consultaUsuario();
	}
	public void eliminaUsuario(Integer id) {
		try {
		dao.eliminarUsuario(id);
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "algo pasa al eliminar");
	}}
	public void buscarUsuario(String dato) {
		dao.buscarUsuario(dato);
	}
	public void construyeTabla() {
		vistaUsuario.construirTabla();
	}
	public void visibleBAceptar() {
		ventanaUsuario.getAceptar().setEnabled(true);;
	}
	public void noVisibleBAceptar() {
		ventanaUsuario.getAceptar().setEnabled(false);
	}
	public void viisibleBModificar() {
		ventanaUsuario.getModifica().setEnabled(true);;
	}
	public void noVisibleBModifica() {
		ventanaUsuario.getModifica().setEnabled(false);
	}
	public void documento(usuarios user) {
		ventanaUsuario.gettDocumento().setText(user.getDocumento());
	}
	public void nombre(usuarios user) {
		ventanaUsuario.gettNombre().setText(user.getNombres());
	}public void apellido(usuarios user) {
		ventanaUsuario.gettApellido().setText(user.getApellidos());
	}public void usuario(usuarios user) {
		ventanaUsuario.gettUsuario().setText(user.getUsuarios());
	}public void telefono(usuarios user) {
		ventanaUsuario.gettTelefono().setText(user.getTelefono());
	}public void correo(usuarios user) {
		ventanaUsuario.gettCorreo().setText(user.getCorreo());
	}public void estado(usuarios user) {
		ventanaUsuario.gettEstado().setText(user.getEstado());
	}
   public void limpio() {
	   ventanaUsuario.limpiar();
   }
   public usuarios usuarioC() {
	  return  vistaUsuario.usuario;
   }
}
