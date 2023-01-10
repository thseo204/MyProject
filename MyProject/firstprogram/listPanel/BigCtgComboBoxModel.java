//package listPanel;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import javax.swing.DefaultComboBoxModel;
//
//public class BigCtgComboBoxModel extends DefaultComboBoxModel<String>{
//	private ArrayList<BigCtgVo> list;
//	
//	public BigCtgComboBoxModel() throws ClassNotFoundException, SQLException{
//		BigCtgDAO dao = new BigCtgDAO();
//		list = dao.bigCtgList();
//	}
//	
//	public int getSize() {
//		return list.size();
//	}
//
//	public String getElementAt(int index) {
//		BigCtgVo vo = list.get(index);
//		String bigCtgStr = vo.getBigCtg();
//		return bigCtgStr;
//	}
//}
