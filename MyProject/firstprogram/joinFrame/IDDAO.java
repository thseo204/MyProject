//package joinFrame;
//
//import mainframe.MainDAO;
//
//public class IDDAO extends MainDAO{
//
//	public boolean possible(String id) {
//		boolean possible = false;
//		
//		try {
//			connDB();
//
//			String query = "SELECT * FROM MEMBER_INFO ";
//			if (id != null) {
//				query += "where id = '" + id + "'";
//			}
//			System.out.println("SQL : " + query);
//
//			rs = stmt.executeQuery(query);
//
//			rs.last();
//			System.out.println("rs.getRow() : " + rs.getRow());
//
//			if (rs.getRow() == 0) {
//				possible = true;
//			} else {
//				possible = false;
//			}
//
//		} catch (Exception e) {
//			e.getStackTrace();
//		}
//		return possible;
//	}
//}
