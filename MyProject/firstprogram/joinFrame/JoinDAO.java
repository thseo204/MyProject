//package joinFrame;
//
//
//import mainframe.MainDAO;
//
//public class JoinDAO extends MainDAO{
//
//	public boolean list(String id, String pwd, String email, String name, String gender, String barth) {
//		
//		boolean result = false;
//		
//		try {
//			connDB();
//
//			String query = "insert into member_info";
//			if (id.equals(null) || pwd.equals(null) || email.equals(null) || name.equals(null) || gender.equals(null) || barth.equals(null)) {
//				result = false;
//			} else {
//				query += " values ('" + id + "', '" + pwd + "', '" + email + "', '" + 
//						name +"', '" + gender + "', '" + barth + "')";
//				result = true;
//			}
//			System.out.println("SQL : " + query);
//
//			stmt.execute(query);
//
//		} catch (Exception e) {
//			e.getStackTrace();
//		}
//		return result;
//	}
//}
