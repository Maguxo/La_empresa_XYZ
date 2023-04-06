package Vista;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import DAO.Coordinar;
import DAO.GestionaCelda;
import DAO.ModeloTabla;
import DAO.daoUsuario;
import Modelo.Utilidades;
import Modelo.usuarios;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JTabbedPane;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class vistaUsuario extends JFrame implements MouseListener{

	private JPanel contentPane, pAdmin, pDesarrollador, pGerente, pSoporte;
	private JLabel homeL, lblNewLabel, cerrarVU; 
	private JTextField busquedaU;
	private JButton botonUB, UsuarioCrear;
	private ArrayList<usuarios> listaPersonas;
	private  ArrayList<String> titulo2;
	private JTabbedPane Tprincipal;
	private Coordinar cordina;
	private daoUsuario dao= new daoUsuario();;
    private  JScrollPane scroll,scroll2;
    private JTable tabla;
    private ModeloTabla modelo6;
    private  Object[][] data;    
    private String[] titulos;
    private String informacion[][];
    public usuarios usuario= new usuarios();
    int fila=0;
	public void setCoordinar(Coordinar coordina) {
		  this.cordina=coordina;
		}
     
    public vistaUsuario() {
    	setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setBounds(100, 100, 900, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Empresa XYZ");
		setContentPane(contentPane);
		
		logo();
		
		JLabel tituloUsuarios = new JLabel("    Usuarios");
		tituloUsuarios.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		tituloUsuarios.setOpaque(true);
		tituloUsuarios.setBackground(new Color(255, 140, 0));
		tituloUsuarios.setBounds(0, 50, 900, 35);
		contentPane.add(tituloUsuarios);
		
	    homeL = new JLabel("");
		homeL.setBounds(0, 0, 50, 50);
		homeL.setIcon(imagen());
		contentPane.add(homeL);
		
		lblNewLabel = new JLabel("> Usuarios");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 18));
		lblNewLabel.setBounds(51, 0, 100, 50);
		contentPane.add(lblNewLabel);
		
		busquedaU = new JTextField();
		busquedaU.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		busquedaU.setBounds(10, 96, 183, 35);
		contentPane.add(busquedaU);
		busquedaU.setColumns(10);
		
		botonUB = new JButton("");
		botonUB.setIcon(logoBusqueda());
		botonUB.setBounds(215, 96, 50, 35);
		contentPane.add(botonUB);
		
		UsuarioCrear = new JButton("Crear Usuario");
		UsuarioCrear.setMargin(new Insets(0, 0, 0, 0));
		UsuarioCrear.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 12));
		UsuarioCrear.setBorderPainted(false);
		UsuarioCrear.setIcon(usuarioB());
		UsuarioCrear.setBackground(Color.GREEN);
		UsuarioCrear.setVerticalTextPosition(SwingConstants.TOP);
		UsuarioCrear.setVerticalAlignment(SwingConstants.BOTTOM);
		UsuarioCrear.setBounds(760, 96, 130, 50);
	
		contentPane.add(UsuarioCrear);
		
		cerrarVU = new JLabel("X");
		cerrarVU.setBackground(Color.WHITE);
		cerrarVU.setForeground(Color.ORANGE);
		cerrarVU.setOpaque(true);
		cerrarVU.setHorizontalAlignment(SwingConstants.CENTER);
		cerrarVU.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 20));
		cerrarVU.setBounds(850, 0, 50, 50);
		contentPane.add(cerrarVU);
		
		Tprincipal = new JTabbedPane(JTabbedPane.TOP);
		Tprincipal.setOpaque(true);
		Tprincipal.setForeground(Color.DARK_GRAY);
		Tprincipal.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		Tprincipal.setBackground(Color.ORANGE);
		Tprincipal.setBounds(10, 157, 880, 200);
		contentPane.add(Tprincipal);
		
		pAdmin = new JPanel();
		pAdmin.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		Tprincipal.addTab("Administrador", null, pAdmin, null);
		pAdmin.setLayout(null);
		
		scroll= new JScrollPane();
		scroll.setBounds(new Rectangle(0, 0, 875, 168));
		pAdmin.add(scroll);
		
		tabla= new JTable();
		tabla.setVisible(true);
		tabla.setOpaque(true);
		tabla.setBorder(new BevelBorder(BevelBorder.RAISED,null,null,null,null));
        
		scroll.setViewportView(tabla);
	    construirTabla();
		
		pSoporte = new JPanel();
		pSoporte.setBackground(Color.ORANGE);
		Tprincipal.addTab("Soporte", null, pSoporte, null);		
		//encabezado(pSoporte);	
		pDesarrollador = new JPanel();
		pDesarrollador.setBackground(Color.ORANGE);
		Tprincipal.addTab("Desarrollador", null, pDesarrollador, null);
		//encabezado(pDesarrollador);
		pGerente = new JPanel();
		pGerente.setBackground(Color.ORANGE);
		pGerente.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 11));
		pGerente.setForeground(Color.BLACK);
		Tprincipal.addTab("Gerente", null, pGerente, null);
		//encabezado(pGerente);
		cerrarV();
		presionar();
	}
    
     public void construirTabla() {
     			 
     		listaPersonas= dao.consultaUsuario();
    	    titulo2= new ArrayList<>();
     		titulo2.add("N°");
    		titulo2.add("Documento");
    		titulo2.add("Nombre");
    		titulo2.add("Apellido");
    		titulo2.add("Usuario");
    		titulo2.add("Telefono");
    		titulo2.add("Correo");
    		titulo2.add("Estado");
    		titulo2.add("B-Modificar");
    		titulo2.add("B-Eliminar");
    		
    		 titulos= new String[titulo2.size()];
    		for(int i=0; i<titulos.length; i++) {
    			titulos[i]= titulo2.get(i);
    		}		
    		data= obtenerMatrizData(titulo2);
    		construirTabla(data,titulos);
    		
    		//data= cordina.obtenerMatrizData(titulo2);
    		//cordina.contruyeT(data, titulos);
    	 
    	// cordina.construirTabla();
    } 	
   
	public void construirTabla(Object[][] data, String[] titulos ) {
		modelo6= new ModeloTabla(data, titulos);
		tabla.setModel(modelo6); 	 	
 	  	tabla.getTableHeader().setReorderingAllowed(false);
		tabla.setRowHeight(43);
		tabla.setBackground(new Color(185,185,185));
		
		tabla.getColumnModel().getColumn(Utilidades.N).setCellRenderer(new GestionaCelda("texto"));;
		tabla.getColumnModel().getColumn(Utilidades.DOCUMENTO).setCellRenderer(new GestionaCelda("texto"));
		tabla.getColumnModel().getColumn(Utilidades.NOMBRE).setCellRenderer(new GestionaCelda("texto"));
		tabla.getColumnModel().getColumn(Utilidades.APELLIDO).setCellRenderer(new GestionaCelda("texto"));
		tabla.getColumnModel().getColumn(Utilidades.USUARIO).setCellRenderer(new GestionaCelda("texto"));
		tabla.getColumnModel().getColumn(Utilidades.TELEFONO).setCellRenderer(new GestionaCelda("texto"));
		tabla.getColumnModel().getColumn(Utilidades.CORREO).setCellRenderer(new GestionaCelda("texto"));
		tabla.getColumnModel().getColumn(Utilidades.ESTADO).setCellRenderer(new GestionaCelda("ima"));
		tabla.getColumnModel().getColumn(Utilidades.MODIFICAR).setCellRenderer(new GestionaCelda("ima"));
		tabla.getColumnModel().getColumn(Utilidades.ELIMINAR).setCellRenderer(new GestionaCelda("ima"));
		
		tabla.getColumnModel().getColumn(Utilidades.N).setPreferredWidth(40);
		tabla.getColumnModel().getColumn(Utilidades.DOCUMENTO).setPreferredWidth(130);
		tabla.getColumnModel().getColumn(Utilidades.NOMBRE).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(Utilidades.APELLIDO).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(Utilidades.USUARIO).setPreferredWidth(130);
		tabla.getColumnModel().getColumn(Utilidades.TELEFONO).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(Utilidades.CORREO).setPreferredWidth(250);
	    tabla.getColumnModel().getColumn(Utilidades.ESTADO).setPreferredWidth(80);
		tabla.getColumnModel().getColumn(Utilidades.MODIFICAR).setPreferredWidth(80);
		tabla.getColumnModel().getColumn(Utilidades.ELIMINAR).setPreferredWidth(80);
		tabla.addMouseListener(this);
		 
		JTableHeader jheader= tabla.getTableHeader();
		jheader.setDefaultRenderer(new EncabezadoTabla());
		tabla.setTableHeader(jheader);
	}

	private Object[][] obtenerMatrizData(ArrayList<String> titulo2) {
		
	  informacion= new String[listaPersonas.size()][titulo2.size()];
		for(int i=0; i<informacion.length;i++) {
			
			informacion[i][Utilidades.N]=String.valueOf(listaPersonas.get(i).getId());
			informacion[i][Utilidades.DOCUMENTO]= listaPersonas.get(i).getDocumento();
			informacion[i][Utilidades.NOMBRE]= listaPersonas.get(i).getNombres();
			informacion[i][Utilidades.APELLIDO]= listaPersonas.get(i).getApellidos();
			informacion[i][Utilidades.USUARIO]= listaPersonas.get(i).getUsuarios();
			informacion[i][Utilidades.TELEFONO]= listaPersonas.get(i).getTelefono();
			informacion[i][Utilidades.CORREO]= listaPersonas.get(i).getCorreo();
			informacion[i][Utilidades.ESTADO]= listaPersonas.get(i).getEstado();
			informacion[i][Utilidades.MODIFICAR]= "modifica";
			informacion[i][Utilidades.ELIMINAR]= "elimina";	
		}
		return informacion;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		int row= tabla.rowAtPoint(e.getPoint());      //usuario = new usuarios();
		int colum= tabla.columnAtPoint(e.getPoint()); 
		try {
		fila= tabla.getSelectedRow();	 
		usuario = listaPersonas.get(fila);
		try { 	
			  if(colum== Utilidades.ELIMINAR ) {
				 cordina.eliminaUsuario(usuario.getId()); 
				 cordina.construyeTabla();
				 JOptionPane.showMessageDialog(null, "Se pudo eliminar" + " " +usuario.getId()  );	
			     return;
			}else if(colum== Utilidades.MODIFICAR) {
				 
				cordina.noVisibleBAceptar();
				cordina.viisibleBModificar();
				cordina.mostrarVentanaUsuario();
				 cargarlista(usuario);
				return;
			} 
			  }catch(Exception ex) {
			    JOptionPane.showMessageDialog(null, "No se pudo ELIMINAR");
		}}catch(Exception ex) {System.out.println("eliminar jode");}}
	public void cargarlista(usuarios user) {
		cordina.documento(user);
		cordina.nombre(user);
		cordina.apellido(user);
		cordina.usuario(user);
		cordina.telefono(user);
		cordina.correo(user);
		cordina.estado(user);
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
    private void cerrarV() {
		
		MouseListener llamar= new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			 if(e.getSource()== cerrarVU) {
				 //setVisible(false);
				 cordina.quitarVistaUsuario();
			 }}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {
				cerrarVU.setBackground(Color.orange);
				cerrarVU.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cerrarVU.setBackground(Color.white);
				cerrarVU.setForeground(Color.orange);
			}};
			cerrarVU.addMouseListener(llamar);
	}
	public void presionar() {		
		
		ActionListener llamada= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cordina.noVisibleBModifica();
			 	cordina.visibleBAceptar(); 	
			    cordina.limpio();
				cordina.mostrarVentanaUsuario();		 	
			}};
			UsuarioCrear.addActionListener(llamada);
	}
	private ImageIcon usuarioB() {
		
		ImageIcon q= new ImageIcon(getClass().getResource("/imagenes/persona.jpg"));
		ImageIcon w= new ImageIcon(q.getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH));
		return w;
	}
	private ImageIcon logoBusqueda() {
		ImageIcon busquedaL= new ImageIcon(getClass().getResource("/imagenes/lupa.jpg"));
		ImageIcon busquedaLupa= new ImageIcon(busquedaL.getImage().getScaledInstance(50,35, Image.SCALE_SMOOTH));
		return busquedaLupa;
	} 
	private  ImageIcon imagen() {
		ImageIcon home= new ImageIcon(getClass().getResource("/imagenes/home.png"));
		ImageIcon homef= new ImageIcon(home.getImage().getScaledInstance(homeL.getWidth(), 40, Image.SCALE_SMOOTH));
		return homef;
	}
	public void logo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/logo2.jpg")));
	}
	
}