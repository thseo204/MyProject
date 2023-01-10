//package listPanel;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import mainframe.MainDAO;
//
//public class BigCtgDAO extends MainDAO {
//	private int n;
//	private ArrayList<BigCtgVo> list;
//
//	// 카테고리만 조회
//	public ArrayList<BigCtgVo> bigCtgList() throws SQLException, ClassNotFoundException {
//		ArrayList<BigCtgVo> bigCtg = new ArrayList<BigCtgVo>();
//
//		connDB();
//
//		String sql = "SELECT distinct big_CTG FROM PROCESSED_FOOD";
//		rs = stmt.executeQuery(sql);
//
//		while (rs.next()) {
//			BigCtgVo vo = new BigCtgVo();
//			vo.setBigCtg(rs.getString("Big_CTG"));
//			bigCtg.add(vo);
//		}
//		if (rs != null)
//			rs.close();
//		if (stmt != null)
//			rs.close();
//		if (con != null)
//			rs.close();
//
//		return bigCtg;
//	}
//
//	// 해당 카테고리 별 갯수
//	public String ctgNum(String ctgStr) {
//		try {
//			connDB();
//
//			String sql = "SELECT Food_code FROM PROCESSED_FOOD where Big_ctg = '" + ctgStr + "'";
//			rs = stmt.executeQuery(sql);
//
//			rs.last();
//			System.out.println("rs1.getRow() : " + rs.getRow());
//			// big_ctg 항목이 몇개인지 rs.getRow() 를 통해 알 수 있음.
//
//			n = rs.getRow();
//			rs.beforeFirst();
//		} catch (SQLException e) {
//			e.getStackTrace();
//		}
//
//		return n + "";
//	}
//
//	public ArrayList<BigCtgVo> list() {
////		String big_ctg = "가공두부";
//		list = new ArrayList<BigCtgVo>();
//
//		try {
//			connDB();
//
//			String query = "SELECT distinct big_CTG \n" + "FROM PROCESSED_FOOD";
//
//			System.out.println("SQL2 : " + query);
//
//			rs = stmt.executeQuery(query);
//			rs.last();
//			System.out.println("rs1.getRow() : " + rs.getRow());
//			// big_ctg 항목이 몇개인지 rs.getRow() 를 통해 알 수 있음.
//
////			n = rs1.getRow();
//			if (rs.getRow() == 0) {
//
//			} else {
//				rs.beforeFirst(); // 커서를 처음으로 되돌리기
////				rs1.previous(); // 커서를 이전 위치로 되돌리기
//
//				while (rs.next()) { // 해당 결과가 있으면 조회해오는 것
//					String bigCtg = rs.getString("Big_CTG");
//
//					BigCtgVo data = new BigCtgVo(bigCtg);
//					System.out.println(bigCtg);
//					list.add(data);
//				}
//			}
//
//		} catch (Exception e) {
//			e.getStackTrace();
//		}
//		return list;
//	}
//
////	public int getN() {
////		return n;
////	}
//
//	public ArrayList<BigCtgVo> getList() {
//		return list;
//	}
//
////	public static void main(String[] args) {
////		BigCtgDAO dao = new BigCtgDAO();
////		ArrayList<BigCtgVo> list = dao.list();
////		System.out.println("----------------------");
////		Iterator<BigCtgVo> it = list.iterator();
////		while (it.hasNext()) {
////			System.out.println(it.next().getBigCtg());
////		}
////	}
//}
