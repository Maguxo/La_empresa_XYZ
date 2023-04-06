package DAO;


import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ModeloTabla extends DefaultTableModel{
	
	
	private String[] titulos;
	private Object[][]  datos;
	private Coordinar cordina;
	
	public void setCoordinar(Coordinar coordina) {
		this.cordina=coordina;
	}
	public ModeloTabla(Object[][] datos, String [] titulos) {
		this.titulos= titulos;
		this.datos= datos;
		setDataVector(datos, titulos);
	
	}
	
	public ModeloTabla() {}
	
}