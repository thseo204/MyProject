//package dbUtil;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import joinFrame.JoinVo;
//import loginframe.MemberVo;
//
//public class MemberInfoDaoImpl implements MemberInfoDAO{
//	private DBUtil dbUtil = DBUtil.getInstance();
//	private static MemberInfoDAO memberInfoDAO = new MemberInfoDaoImpl();
//	
//	@Override
//	public int insert(JoinVo joinVo) throws SQLException {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		int ret = 0;
//		
//		try {
//			conn = dbUtil.getConnection();
//			String sql = "insert into memberinfo values(?, ?, ?, ?, ?, ?)";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, joinVo.getId());
//			pstmt.setString(2, joinVo.getPwd());
//			pstmt.setString(3, joinVo.getEmail());
//			pstmt.setString(4, joinVo.getName());
//			pstmt.setString(5, joinVo.getGender());
//			pstmt.setString(6, joinVo.getBarth());
//		} finally {
//			dbUtil.close(pstmt, conn);
//		} 
//		return ret;
//	}
//	
//	@Override
//	public String select(String id, String pw) throws SQLException {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String name = "";
//		
//		try {
//			conn = dbUtil.getConnection();
//			String sql = "select * from MEMBER_INFO where id = %s, pwd = %s";
//			String q = String.format(sql, id, pw);
////			pstmt = conn.prepareStatement(sql);
//			
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				name = rs.getString("name");
//			}
////			while(rs.next()) {
////				MemberVo memberVo = new MemberVo();
////				memberVo.setId(rs.getString("id"));
////				memberVo.setPwd(rs.getString("pwd"));
////				memberVo.setName(rs.getString("name"));
//////				list.add(memberVo);
////			}
//			
//		} finally {
//			dbUtil.close(rs, pstmt, conn);
//		}
//		
//		return name;
//	}
//
////	@Override
////	public String select() throws SQLException {
////		// TODO Auto-generated method stub
////		return null;
////	}
//}
