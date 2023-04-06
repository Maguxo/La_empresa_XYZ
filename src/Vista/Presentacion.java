package Vista;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import DAO.Coordinar;

import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Color;

@SuppressWarnings("serial")
public class Presentacion extends JPanel{

    protected  static int incrementa= 0;
    private JFrame frame= null;
    private Coordinar cordina;
    
    
    public void setCoordinar(Coordinar cordina) {
    	this.cordina= cordina;
    }
    
	public Presentacion() {
		
		frame= new JFrame();
		frame.setUndecorated(true);
	    frame.setBounds(new Rectangle(100, 100, 900, 400));
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(this);
			
		JLabel cara1 = new JLabel("");
		cara1.setOpaque(true);
		cara1.setBounds(0, 0, 900, 400);
		cara1.setIcon(imaPresentacion());
        this.add(cara1);
	
		logo();
		diseño();
	}
	private void diseño() {
		
		this.setLayout(null);
		this.setBounds(0,0,900,400);
		this.setVisible(true);
		this.setBackground(new Color(49,178,240));
	}
	private ImageIcon imaPresentacion() {
		
		ImageIcon Ima1= new ImageIcon(getClass().getResource("/imagenes/presentacion.jpg"));
		ImageIcon Ima= new ImageIcon(Ima1.getImage().getScaledInstance(900, 400, Image.SCALE_SMOOTH));
		return Ima;	
	}
	private void logo() {
		
		Image imagen= new ImageIcon(getClass().getResource("/imagenes/logo2.jpg")).getImage();
	    frame.setIconImage(imagen);
	}

	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		BufferedImage imagen = imagen("src/imagenes/logoMover.png");
		
		AffineTransform at= AffineTransform.getTranslateInstance(150, -200);
		
		at.rotate(Math.toRadians(incrementa++), imagen.getWidth()/2,imagen.getHeight()/2);
		at.scale(1, 1);
	
		Graphics2D g2d= (Graphics2D) g;
		g2d.drawImage(imagen,at,this);
		repaint();
	}

	private BufferedImage imagen(String imagen) {
            
		BufferedImage im= null;
		try {
			
			im= ImageIO.read(new File(imagen));
		    }catch(Exception ex) {
		
			   System.out.print("Algo pasa\n");		
		     }
		
		return im;
	}
}