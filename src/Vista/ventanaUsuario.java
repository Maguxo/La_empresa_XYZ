package Vista;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import DAO.Coordinar;
import DAO.daoUsuario;
import Modelo.usuarios;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class ventanaUsuario extends JFrame {

	private JTextField tDocumento,tApellido,tNombre,tUsuario,tTelefono,tCorreo,tEstado;
	private  JPanel contentPane;
	private JLabel cerrarV;
	private  JButton aceptarB,modificarB ;
    	  	
	private Coordinar cordina;
	vistaUsuario vista= new vistaUsuario();
    daoUsuario dao= new daoUsuario();
    usuarios user= new usuarios();
    
    ArrayList<usuarios>listaPersonas;
	
    public void setCoordinar(Coordinar coordina) {
		this.cordina=coordina;
	}
	
	public ventanaUsuario() {
		setUndecorated(true);
		setBounds(100, 100, 450, 361);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(169, 169, 169));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titulo = new JLabel("Ingrese Usuario");
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo.setForeground(Color.ORANGE);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 20));
		titulo.setBounds(117, 0, 200, 30);
		contentPane.add(titulo);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(10, 44, 80, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblApellido.setBounds(10, 84, 80, 20);
		contentPane.add(lblApellido);
		
		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblDocumento.setBounds(10, 124, 102, 20);
		contentPane.add(lblDocumento);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblUsuario.setBounds(10, 164, 90, 20);
		contentPane.add(lblUsuario);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblTelefono.setBounds(10, 204, 80, 20);
		contentPane.add(lblTelefono);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblCorreo.setBounds(10, 244, 80, 20);
		contentPane.add(lblCorreo);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblEstado.setBounds(10, 284, 80, 20);
		contentPane.add(lblEstado);
		
		tDocumento = new JTextField();
		tDocumento.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		tDocumento.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tDocumento.setBounds(117, 124, 133, 20);
		contentPane.add(tDocumento);
		tDocumento.setColumns(10);
		
		tApellido = new JTextField();
		tApellido.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		tApellido.setColumns(10);
		tApellido.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tApellido.setBounds(117, 84, 133, 20);
		contentPane.add(tApellido);
		
		tNombre = new JTextField();
		tNombre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		tNombre.setColumns(10);
		tNombre.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tNombre.setBounds(117, 41, 133, 20);
		contentPane.add(tNombre);
		
		tUsuario = new JTextField();
		tUsuario.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		tUsuario.setColumns(10);
		tUsuario.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tUsuario.setBounds(117, 166, 133, 20);
		contentPane.add(tUsuario);
		
		tTelefono = new JTextField();
		tTelefono.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		tTelefono.setColumns(10);
		tTelefono.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tTelefono.setBounds(117, 206, 133, 20);
		contentPane.add(tTelefono);
		
		tCorreo = new JTextField();
		tCorreo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		tCorreo.setColumns(10);
		tCorreo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tCorreo.setBounds(117, 246, 133, 20);
		contentPane.add(tCorreo);
		
		tEstado = new JTextField();
		tEstado.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		tEstado.setColumns(10);
		tEstado.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tEstado.setBounds(117, 286, 133, 20);
		contentPane.add(tEstado);
		
		aceptarB = new JButton("Agregar");
		aceptarB.setOpaque(false);
		aceptarB.setBorder(new LineBorder(new Color(0, 255, 0), 5, true));
		aceptarB.setFont(new Font("Tahoma", Font.ITALIC, 12));
		aceptarB.setForeground(Color.GREEN);
		aceptarB.setBounds(308, 266, 89, 23);
		contentPane.add(aceptarB);
		
	    cerrarV = new JLabel("X");
		cerrarV.setOpaque(true);
		cerrarV.setBackground(new Color(153,217,234));
		cerrarV.setHorizontalTextPosition(SwingConstants.CENTER);
		cerrarV.setHorizontalAlignment(SwingConstants.CENTER);
		cerrarV.setFont(new Font("Tahoma", Font.ITALIC, 20));
		cerrarV.setBounds(420, 1, 30, 30);
		contentPane.add(cerrarV);
		
		modificarB = new JButton("Modifica");
		modificarB.setOpaque(false);
		modificarB.setActionCommand("Modifica");
		modificarB.setForeground(new Color(32, 178, 170));
		modificarB.setFont(new Font("Tahoma", Font.ITALIC, 12));
		modificarB.setBorder(new LineBorder(new Color(30, 144, 255), 5, true));
		modificarB.setBounds(308, 230, 89, 23);
		contentPane.add(modificarB);
		
		setLocationRelativeTo(null);
		setResizable(false);
		
		CerrarVentana();
		aceptarDatos();
		modificarDatos();
	}
	private void CerrarVentana() {
		
		MouseListener llamadita= new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			if(e.getSource()== cerrarV) {
				setVisible(false);
			}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {
				cerrarV.setBackground(new Color(153,217,234));
				cerrarV.setForeground(new Color(0,162,232));
				cerrarV.setFont(new Font("Tahoma", Font.ITALIC, 20));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cerrarV.setBackground(new Color(0,162,232));
				cerrarV.setForeground(new Color(153,217,234));
				cerrarV.setFont(new Font("Tahoma", Font.ITALIC, 20));	
			}};
			cerrarV.addMouseListener(llamadita);
	}
	public void modificarDatos() {
    ActionListener modifica= new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			   System.out.println("modificando");
		       try {
							if(tDocumento.getText().equals("") || tNombre.getText().equals("") || tApellido.getText().equals("")
									|| tUsuario.getText().equals("") || tTelefono.getText().equals("")
									|| tCorreo.getText().equals("") || tEstado.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "¡CAMPOS VACIOS!");
							   return;
							}
							cordina.usuarioC().setDocumento(tDocumento.getText());
							cordina.usuarioC().setNombres(tNombre.getText());
							cordina.usuarioC().setApellidos(tApellido.getText());
							cordina.usuarioC().setUsuarios(tUsuario.getText());
							cordina.usuarioC().setTelefono(tTelefono.getText());
							cordina.usuarioC().setCorreo(tCorreo.getText());
							cordina.usuarioC().setEstado(tEstado.getText());
							if(dao.modificarUsuario(cordina.usuarioC())) { 
								cordina.construyeTabla();
								   limpiar();        
				                    JOptionPane.showMessageDialog(null, "Se agregó correctamente");
							}else {
								JOptionPane.showMessageDialog(null, "¡Falló!");				
							}
						}catch(Exception ex){
							JOptionPane.showMessageDialog(null, "¡ERROR! NO SE PUDO MODIFICAR.");				}
					}};
					modificarB.addActionListener(modifica);
	}
	public void aceptarDatos() {
	
		ActionListener boto= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("siuuuu1");            	  
               try {
					if(tDocumento.getText().equals("") || tNombre.getText().equals("") || tApellido.getText().equals("")
							|| tUsuario.getText().equals("") || tTelefono.getText().equals("")
							|| tCorreo.getText().equals("") || tEstado.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "¡CAMPOS VACIOS!");
					   return;
					}
					usuarios user= new usuarios();
					user.setDocumento(tDocumento.getText());
					user.setNombres(tNombre.getText());
					user.setApellidos(tApellido.getText());
					user.setUsuarios(tUsuario.getText());
					user.setTelefono(tTelefono.getText());
					user.setCorreo(tCorreo.getText());
					user.setEstado(tEstado.getText());
					if(dao.insertarUsuario(user)) { 
						cordina.construyeTabla();
						cordina.mostrarVistaUsuario();
						      
		                   limpiar();        
		                    JOptionPane.showMessageDialog(null, "Se agregó correctamente");
					}else {
						JOptionPane.showMessageDialog(null, "¡Falló!");				
					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "¡ERROR! NO SE PUDO AGREGAR DATOS.");				}
			}};
			aceptarB.addActionListener(boto);
	}
	public void limpiar() {
		tDocumento.setText("");
		tNombre.setText("");
		tApellido.setText("");
		tUsuario.setText("");
		tTelefono.setText("");
		tCorreo.setText("");
		tEstado.setText("");
	}
	public JTextField gettDocumento() {
		return tDocumento;
	}

	public JTextField gettApellido() {
		return tApellido;
	}

	public JTextField gettNombre() {
		return tNombre;
	}

	public JTextField gettUsuario() {
		return tUsuario;
	}

	public JTextField gettTelefono() {
		return tTelefono;
	}

	public JTextField gettCorreo() {
		return tCorreo;
	}

	public JTextField gettEstado() {
		return tEstado;
	}
	public ArrayList<usuarios> getListaPersonas() {
		return listaPersonas;
	}
	public JButton getAceptar() {
		return this.aceptarB;
	}
	public JButton getModifica() {
		return this.modificarB;
	}
 }
