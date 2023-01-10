//package loginframe;
//
//import mainframe.MainDAO;
//
//public class MemberDAO extends MainDAO{
//	
//	
//	public String list(String id, String pw){
//		String name = "";
//		
//		try {
//			connDB();
//			
//			String query = "SELECT * FROM MEMBER_INFO ";
//			if(id != null && pw != null) {
//				query += "where id = '" + id + "' and pwd = '" + pw + "'";
//			}
//			System.out.println("SQL : " + query);
//			
//			super.rs = super.stmt.executeQuery(query);
//			
//			super.rs.last();
//			System.out.println("super.rs.getRow() : " + super.rs.getRow());
//			
//			if(super.rs.getRow() == 0) {
//				name = null;
//			} else {
//				super.rs.previous(); // 커서를 이전 위치로 되돌리기
//				String query2 = "SELECT name from member_info where id = '" + id + "'";
//				String member_name = "";
//				System.out.println("SQL : " + query2);
//				super.rs2 = stmt.executeQuery(query2);
//				
//				while(super.rs2.next()) { // 해당 결과가 있으면 조회해오는 것 
////					String member_id = rs.getString("id");
////					String member_pw = rs.getString("pwd");
//					
//					member_name = super.rs2.getString("name");
//					System.out.println("***" + member_name);
//					
//					name = member_name;
//				}
//			}
//		}catch(Exception e) {
//			e.getStackTrace();
//		}
//		return name;
//	}
//}
