package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

public class EncabezadoTabla implements TableCellRenderer {
	
	public EncabezadoTabla() {}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {	
		JComponent jComponent= null;
		JLabel etiqueta= null;
		
		if(value instanceof String){
			etiqueta= new JLabel((String) value);
			etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
			etiqueta.setPreferredSize(new Dimension(1, 36));		
			jComponent= etiqueta;
		}
		
		jComponent.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.WHITE));
		jComponent.setOpaque(true);
		jComponent.setBackground(new Color(68,68,68));
		jComponent.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 12));
		jComponent.setForeground(new Color(210,210,210));
		
		return jComponent;
	}
	
}