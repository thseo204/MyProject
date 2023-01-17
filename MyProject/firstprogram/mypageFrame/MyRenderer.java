package mypageFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import clauseFrame.ClauseFrame;
import mainFrame.MyButton;
import mainFrame.MyFont;

public class MyRenderer extends DefaultTableCellRenderer{
	private static final long serialVersionUID = 1L;
	private JLabel lb;
	private JButton btn = new JButton();
	private MyButton mBtn;
	
	public MyRenderer() {
		setHorizontalTextPosition(JLabel.CENTER);
		setVerticalTextPosition(JLabel.BOTTOM);
//		setHorizontalAlignment(JLabel.CENTER);
//		setVerticalAlignment(JLabel.CENTER);
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int col) {
		String valueStr = table.getValueAt(row, col) + "";
		
//		lb = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
		MyFont mFont = new MyFont();
		
		if (valueStr.length() > 4 && value != null) {
//		if (valueStr.length() > 3 && !Character.isDigit(valueStr.charAt(valueStr.length()-1)) && value != null) {
			mBtn = new MyButton();
			JPanel p = new JPanel();
			p.setLayout(null);
			ImageIcon icon = new ImageIcon("./Button_image/DonutImg.png");
			ImageIcon iconC = mBtn.changeImageSize(icon, 25, 25);
			isSelected = false;
			lb = new JLabel(valueStr.substring(0, 2));
			JLabel lb2 = new JLabel(iconC);
			
			lb.setOpaque(true);
			lb.setBackground(Color.white);
			lb.setBounds(0, 10, 30,20);
			lb.setFont(mFont.setFont(10));
			lb2.setBounds(30,7,25,25);
			p.add(lb);
			p.add(lb2);
			
			return p;
		} else if(value == null){
			table.setForeground(Color.black);
			table.setFont(mFont.setFont(10));
			isSelected = false;
			valueStr = " ";
			
			return super.getTableCellRendererComponent(table, valueStr, isSelected, hasFocus, row, col);
		} else {
			isSelected = false;
			
			return super.getTableCellRendererComponent(table, valueStr, isSelected, hasFocus, row, col);
		}
	}
	
	public JLabel getLb() {
		return lb;
	}
	
	public JButton getBtn() {
		return btn;
	}

}
