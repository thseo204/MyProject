package mypageFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MyDefaultTableCellRenderer extends DefaultTableCellRenderer{
	private static final long serialVersionUID = 1L;
	
	public MyDefaultTableCellRenderer() {
		setHorizontalTextPosition(JLabel.CENTER);
		setVerticalTextPosition(JLabel.BOTTOM);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int col) {
		JLabel lb = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

		setText(String.valueOf(value));
//		Component comp = null;
//		JPanel p = new JPanel();
//		p.setLayout(null);
//		p.setBackground(Color.gray);
//		JButton btn = new JButton();
//		btn.setSize(20, 10);
//		JLabel lb = new JLabel("총 450Kcal");
//		p.add(lb);
//		btn.add(p);
		
//		comp = btn;
		
		return lb;
		
//		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}

}
