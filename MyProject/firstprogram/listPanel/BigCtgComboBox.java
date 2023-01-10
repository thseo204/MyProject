package listPanel;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import mainframe.MainDAO;
import mainframe.MyFont;

public class BigCtgComboBox {
	private JComboBox comboBox;
	private ArrayList<BigCtgVo> list;
	private MyFont mfont;
	
	
	public BigCtgComboBox(){
		
		mfont = new MyFont();
//		BigCtgDAO dao = new BigCtgDAO();
		MainDAO DAO = new MainDAO(); //
		list = DAO.listBigCtg();//
		
		comboBox = new JComboBox(list.toArray());
//		comboBox.addItemListener(new ItemListener() {
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				if(e.getStateChange() == ItemEvent.SELECTED) {
//					try {
//						ProcessedFoodDAO dao = new ProcessedFoodDAO();
//						dao.list(comboBox.getSelectedItem().toString());
//						
//					}catch(Exception e1) {
//						e1.printStackTrace();
//					}
//				}
//			}
//		});
		
		comboBox.setFont(mfont.setFont(15));
		comboBox.setBounds(5, 10, 200, 30);
		
	}
	
	public String getComboBoxItem() {
		return comboBox.getSelectedItem().toString();
	}
	
	public JComboBox<Object> getComboBox() {
		return comboBox;
	}
	
	public String getList(int index) {
		BigCtgVo vo = list.get(index);
		return vo.getBigCtg();
	}

	
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		BigCtgComboBox com = new BigCtgComboBox();
//		
//	}
}
