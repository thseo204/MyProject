package listPanel;

import java.util.ArrayList;

import javax.swing.JComboBox;

import mainframe.MainDAO;
import mainframe.MyFont;

public class BigCtgComboBox {
	private JComboBox comboBox;
	private ArrayList<BigCtgVo> list;
	private MyFont mfont;
	
	
	public BigCtgComboBox(){
		
		mfont = new MyFont();
		MainDAO DAO = new MainDAO(); //
		list = DAO.listBigCtg();//
		
		comboBox = new JComboBox(list.toArray());
		
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
}
