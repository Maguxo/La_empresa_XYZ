package DAO;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class GestionaCelda extends DefaultTableCellRenderer {

	private String contiene= "texto";
	private Font normal= new Font("Verdana",Font.PLAIN,12);
	private Font boult= new Font("Verdana",Font.BOLD,12);
	private JLabel imagen= new  JLabel();
	private Coordinar cordina;

	 public void setCoordinar(Coordinar coordina) {
			this.cordina=coordina;
		}

	public GestionaCelda() {}
	public GestionaCelda(String text) {
		this.contiene= text;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		Color colorS= new Color(153,217,234);
		Color colorN= new Color(185,185,185);
		
		if(isSelected) {
			this.setBackground(colorS);
		}else {
			this.setBackground(colorN);
		}
		
		if(contiene.equals("texto")) {
           if(hasFocus) {
        	   this.setFont(normal);
           }else {
        	   this.setFont(boult);
           }
           this.setHorizontalAlignment(JLabel.CENTER);
           this.setText((String) value);
           this.setBackground((isSelected) ? colorS : colorN);
		   this.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 12));
		   return this;
		}
		
		if(contiene.equals("texto")) {
	           if(hasFocus) {
	        	   this.setFont(boult);
	           }else {
	        	   this.setFont(normal);
	           }
	           this.setHorizontalAlignment(JLabel.CENTER);
	           this.setText((String) value);
	           this.setBackground((isSelected) ? colorS : colorN);
			   this.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 12));
			   return this;
			}

		if(contiene.equals("ima")) {
	           if(String.valueOf(value).equals("modifica")) {
	        	   
	        	   imagen.setIcon(imaModificar());
	           }else if(String.valueOf(value).equals("elimina")) {
	        	   imagen.setIcon(imaEliminar());
	           }else if(String.valueOf(value).equals("activo") || String.valueOf(value).equals("Activo")
	        		   ||String.valueOf(value).equals("si") || String.valueOf(value).equals("Si")) {
	        	   imagen.setIcon(ichulo());             
	           }else if(String.valueOf(value).equals("No") || String.valueOf(value).equals("no")
	        		   ||String.valueOf(value).equals("NoActivo") || String.valueOf(value).equals("noactivo")) {
	        	   imagen.setIcon(ierror());             
	           }
	           imagen.setHorizontalAlignment(JLabel.CENTER);
	           imagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
	           return imagen;
			}
		return this;
	}
     private ImageIcon ierror() {
		
		ImageIcon Imag0= new ImageIcon(getClass().getResource("/imagenes/ierror.png"));
		ImageIcon Ima= new ImageIcon(Imag0.getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH));
		return Ima;	
	}
    private ImageIcon ichulo() {
		
		ImageIcon Ima0= new ImageIcon(getClass().getResource("/imagenes/ichulo.png"));
		ImageIcon Ima= new ImageIcon(Ima0.getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH));
		return Ima;	
	}
	private ImageIcon imaModificar() {
		
		ImageIcon Ima1= new ImageIcon(getClass().getResource("/imagenes/bmodificar.png"));
		ImageIcon Ima= new ImageIcon(Ima1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		return Ima;	
	}
    private ImageIcon imaEliminar(){
		
		ImageIcon Ima2= new ImageIcon(getClass().getResource("/imagenes/beliminar.png"));
		ImageIcon Im2= new ImageIcon(Ima2.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		return Im2;	
	}
}
