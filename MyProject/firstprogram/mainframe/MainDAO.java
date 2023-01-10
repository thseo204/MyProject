package mainframe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import listPanel.BigCtgVo;
import listPanel.ProcessedFoodVo;
import productCompareFrame.NutrientVo;

public class MainDAO {
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
	static String user = "taehwa";
	static String password = "pass";

	public static Connection con;
	public static Statement stmt;
	public static ResultSet rs;
	public static ResultSet rs2;

	private int bigCtgN;
	private ArrayList<BigCtgVo> bigCtglist;

	private int slcCtgN;
	private ArrayList<ProcessedFoodVo> list;

//	private ArrayList<NutrientVo> nutriList;

	// memberDao 로그인 시 필요한 쿼리, 사용자 이름 반환
	public String listLoginIdPw(String id, String pw) {
		String name = "";

		try {
			String query = "SELECT * FROM MEMBER_INFO ";
			if (id != null && pw != null) {
				query += "where id = '" + id + "' and pwd = '" + pw + "'";
			}
			System.out.println("SQL : " + query);

			rs = stmt.executeQuery(query);

			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				name = null;
			} else {
				rs.previous(); // 커서를 이전 위치로 되돌리기
				String query2 = "SELECT name from member_info where id = '" + id + "'";
				String member_name = "";
				System.out.println("listLoginIdPw().SQL : " + query2);
				rs2 = stmt.executeQuery(query2);

				while (rs2.next()) { // 해당 결과가 있으면 조회해오는 것
//						String member_id = rs.getString("id");
//						String member_pw = rs.getString("pwd");

					member_name = rs2.getString("name");
					System.out.println("***" + member_name);

					name = member_name;
				}
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return name;
	}
	
	// 로그인한 멤버의 생년월일 추출하여 나이 반환
	public String listAge(String id) {
		String age = "";
		String barth = "";
		try {
			
			String query = "SELECT * FROM MEMBER_INFO " +
					"where ID = '" + id + "'";
			System.out.println("SQL : " + query);
			
			rs = stmt.executeQuery(query);
			
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());
			
			if (rs.getRow() == 0) {
			} else {
				rs.previous(); // 커서를 이전 위치로 되돌리기
				rs.next();
				barth = rs.getString("BARTH");
				
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		SimpleDateFormat format = new SimpleDateFormat("YYMMDD");
		String today = format.format(new Date());
		String yy = today.substring(0, 2);
		String mm = today.substring(2, 4);
		String dd = today.substring(4, 6);
		System.out.println(today);
		System.out.println("yy = " + yy);
		System.out.println("mm = " + mm);
		System.out.println("dd = " + dd);
		System.out.println(barth.charAt(0) - '0');
		
		String useryy = barth.substring(0, 2);
		String usermm = barth.substring(2, 4);
//		String userdd = barth.substring(4, 6);
		
		if(barth.charAt(0) - '0' > yy.charAt(0) - '0') {
			useryy = "19" + useryy;
		} else {
			useryy = "20" + useryy;
		}
		yy = "20" + yy;
		
		System.out.println(Integer.valueOf(usermm) + "<" + Integer.valueOf(mm));
		
		if(Integer.valueOf(usermm) < Integer.valueOf(mm)) {
			System.out.println(Integer.valueOf(yy) + "-" + Integer.valueOf(useryy));
			age = String.valueOf(Integer.valueOf(yy) - Integer.valueOf(useryy));
		} else {
			System.out.println(Integer.valueOf(yy) + "-" + Integer.valueOf(useryy) + "-" + 1);
			age = String.valueOf(Integer.valueOf(yy) - Integer.valueOf(useryy) - 1);
		}
		
		return age;
	}
	// 사용자id 로 gender 추출하여 반환
	public String listGender(String id) {
		String gender = "";
		try {
			
			String query = "SELECT * FROM MEMBER_INFO " +
					"where ID = '" + id + "'";
			System.out.println("SQL : " + query);
			
			rs = stmt.executeQuery(query);
			
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());
			
			if (rs.getRow() == 0) {
			} else {
				rs.previous(); // 커서를 이전 위치로 되돌리기
				rs.next();
				gender = rs.getString("GENDER");
				
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return gender;
	}

	// join DAO 회원가입시 필요한 쿼리
	public boolean listJoinInsert(String id, String pwd, String email, String name, String gender, String barth) {

		boolean result = false;

		try {
			String query = "insert into member_info";
			if (id.equals(null) || pwd.equals(null) || email.equals(null) || name.equals(null) || gender.equals(null)
					|| barth.equals(null)) {
				result = false;
			} else {
				query += " values ('" + id + "', '" + pwd + "', '" + email + "', '" + name + "', '" + gender + "', '"
						+ barth + "')";
				result = true;
			}
			System.out.println("SQL : " + query);

			stmt.execute(query);

		} catch (Exception e) {
			e.getStackTrace();
		}
		return result;
	}

	// idDAO 아이디 중복확인 체크하는 쿼리
	public boolean possibleId(String id) {
		boolean possible = false;

		try {
			String query = "SELECT * FROM MEMBER_INFO ";
			if (id != null) {
				query += "where id = '" + id + "'";
			}
			System.out.println("SQL : " + query);

			rs = stmt.executeQuery(query);

			rs.last();
			System.out.println("possibleID().rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				possible = true;
			} else {
				possible = false;
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
		return possible;
	}

	// bigCTG DAO

	// 카테고리만 조회
	public ArrayList<BigCtgVo> bigCtgList() throws SQLException, ClassNotFoundException {
		ArrayList<BigCtgVo> bigCtg = new ArrayList<BigCtgVo>();

		String sql = "SELECT distinct big_CTG FROM PROCESSED_FOOD";
		rs = stmt.executeQuery(sql);

		while (rs.next()) {
			BigCtgVo vo = new BigCtgVo();
			vo.setBigCtg(rs.getString("Big_CTG"));
			bigCtg.add(vo);
		}
		if (rs != null)
			rs.close();
		if (stmt != null)
			rs.close();
		if (con != null)
			rs.close();

		return bigCtg;
	}

	// 해당 카테고리 별 갯수
	public String ctgNum(String ctgStr) {
		try {
			String sql = "SELECT Food_code FROM PROCESSED_FOOD where Big_ctg = '" + ctgStr + "'";
			rs = stmt.executeQuery(sql);

			rs.last();
			System.out.println("ctgNum().rs1.getRow() : " + rs.getRow());
			// big_ctg 항목이 몇개인지 rs.getRow() 를 통해 알 수 있음.

			bigCtgN = rs.getRow();
			rs.beforeFirst();
		} catch (SQLException e) {
			e.getStackTrace();
		}

		return bigCtgN + "";
	}

	public ArrayList<BigCtgVo> listBigCtg() {
//			String big_ctg = "가공두부";
		bigCtglist = new ArrayList<BigCtgVo>();

		try {
			String query = "SELECT distinct big_CTG \n" + "FROM PROCESSED_FOOD";

			System.out.println("SQL2 : " + query);

			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("listBigCtg().rs1.getRow() : " + rs.getRow());
			// big_ctg 항목이 몇개인지 rs.getRow() 를 통해 알 수 있음.

//				n = rs1.getRow();
			if (rs.getRow() == 0) {

			} else {
				rs.beforeFirst(); // 커서를 처음으로 되돌리기
//					rs1.previous(); // 커서를 이전 위치로 되돌리기

				while (rs.next()) { // 해당 결과가 있으면 조회해오는 것
					String bigCtg = rs.getString("Big_CTG");

					BigCtgVo data = new BigCtgVo(bigCtg);
					System.out.println(bigCtg);
					bigCtglist.add(data);
				}
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
		return bigCtglist;
	}

	public ArrayList<BigCtgVo> getbigCtgList() {
		return bigCtglist;
	}

	// processedFoodDAO
	// 해당 카테고리에 전체 항목 조회(list 프레임에 사용)
	public ArrayList<ProcessedFoodVo> listMainShow(String big_ctg) {
		list = new ArrayList<ProcessedFoodVo>();

		try {

			String query2 = "SELECT pf.food_code, FOOD_NAME, pf.DETAIL_CTG, pf.MANUFACTURER, n.\"Kcal\" \n"
					+ "FROM PROCESSED_FOOD pf, NUTRIENT n ";
			if (big_ctg != null) {
				query2 += "WHERE pf.food_code = n.FOOD_CODE AND rownum <= 8 and pf.BIG_CTG = '" + big_ctg + "'\n"
						+ "ORDER BY FOOD_NAME";
			}
			System.out.println("SQL2 : " + query2);

			rs = stmt.executeQuery(query2);
			rs.last();
			System.out.println("listMainShow().rs1.getRow() : " + rs.getRow());
			// big_ctg 항목이 몇개인지 rs.getRow() 를 통해 알 수 있음.

			if (rs.getRow() == 0) {

			} else {
				rs.beforeFirst(); // 커서를 처음으로 되돌리기
//					rs1.previous(); // 커서를 이전 위치로 되돌리기

				while (rs.next()) { // 해당 결과가 있으면 조회해오는 것
					String foodCode = rs.getString("FOOD_CODE");
					String foodName = rs.getString("FOOD_NAME");
					String detailCtg = rs.getString("DETAIL_ctg");
					String manufacturer = rs.getString("MANUFACTURER");
					int kcal = rs.getInt("Kcal");

					System.out.println("[food_code = " + foodCode + "][food_name = " + foodName + "][detail_Ctg = "
							+ detailCtg + "][manufacturer = " + manufacturer + "][kcal = " + kcal + "]");
						
					ProcessedFoodVo data = new ProcessedFoodVo(foodCode, foodName, detailCtg, manufacturer, kcal);
					list.add(data);
				}
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
		return list;
	}

	public ArrayList<ProcessedFoodVo> list(String big_ctg) {
		list = new ArrayList<ProcessedFoodVo>();

		try {

			String query2 = "SELECT pf.food_code, FOOD_NAME, pf.DETAIL_CTG, pf.MANUFACTURER, n.\"Kcal\" \n"
					+ "FROM PROCESSED_FOOD pf, NUTRIENT n ";
			if (big_ctg != null) {
				query2 += "WHERE pf.food_code = n.FOOD_CODE and pf.BIG_CTG = '" + big_ctg + "'\n"
						+ "ORDER BY FOOD_NAME";
			}
			System.out.println("SQL2 : " + query2);

			rs = stmt.executeQuery(query2);
			rs.last();
			System.out.println("list().rs1.getRow() : " + rs.getRow());
			// big_ctg 항목이 몇개인지 rs.getRow() 를 통해 알 수 있음.

			slcCtgN = rs.getRow();
			if (rs.getRow() == 0) {

			} else {
				rs.beforeFirst(); // 커서를 처음으로 되돌리기

				while (rs.next()) { // 해당 결과가 있으면 조회해오는 것
					String foodCode = rs.getString("FOOD_CODE");
					String foodName = rs.getString("FOOD_NAME");
					String detailCtg = rs.getString("DETAIL_ctg");
					String manufacturer = rs.getString("MANUFACTURER");
					int kcal = rs.getInt("Kcal");

					System.out.println("[food_code = " + foodCode + "][food_name = " + foodName + "][detail_Ctg = "
							+ detailCtg + "][manufacturer = " + manufacturer + "][kcal = " + kcal + "]");
//						
//						
					ProcessedFoodVo data = new ProcessedFoodVo(foodCode, foodName, detailCtg, manufacturer, kcal);
					list.add(data);
				}
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
		return list;
	}

	// compare 에 쓰일 데이터
	public ProcessedFoodVo compareData(String Food_code) {
		ProcessedFoodVo slcData = null;

		String query1 = "";
		String query2 = "";
		try {
			// g or mL 단위 알아오는 쿼리
			query1 = "SELECT UNIT\n" + "FROM NUTRIENT \n" + "WHERE FOOD_CODE = '" + Food_code + "'";

			rs = stmt.executeQuery(query1);
			rs.next();
			String unit = rs.getString("unit");
			System.out.println(unit);

			rs.beforeFirst();

			// 해당 단위에 알맞은 쿼리 실행
			if (unit.equals("g")) {
				query2 = "SELECT MANUFACTURER, FOOD_NAME, BIG_CTG, DETAIL_CTG, n.TOTAL_G, n.PORTION_SIZE, n.\"Kcal\" \n"
						+ "FROM processed_food p, NUTRIENT n\n" + "WHERE p.FOOD_CODE = n.FOOD_CODE AND n.FOOD_CODE = '"
						+ Food_code + "'";

			} else if (unit.equals("mL")) {
				query2 = "SELECT MANUFACTURER, FOOD_NAME, BIG_CTG, DETAIL_CTG, n.TOTAL_ML, n.PORTION_SIZE, n.\"Kcal\" \n"
						+ "FROM processed_food p, NUTRIENT n\n" + "WHERE p.FOOD_CODE = n.FOOD_CODE AND n.FOOD_CODE = '"
						+ Food_code + "'";
			}
			System.out.println("단위 : " + unit);
			System.out.println("SQL2 : " + query2);
			System.out.println("------------------");
			rs = stmt.executeQuery(query2);
			rs.last();
			System.out.println("rs1.getRow() : " + rs.getRow());

//			int rowN = rs.getRow();
			if (rs.getRow() == 0) {
					
			} else {
				rs.beforeFirst(); // 커서를 처음으로 되돌리기
					
				while (rs.next()) { // 해당 결과가 있으면 조회해오는 것
					String manufacturer = rs.getString("MANUFACTURER");
					String foodName = rs.getString("FOOD_NAME");
					String bigCtg = rs.getString("BIG_CTG");
					String detailCtg = rs.getString("DETAIL_CTG");
					String portionSize = rs.getString("PORTION_SIZE");
					int kcal = rs.getInt("Kcal");
					String total = "";
					if (unit.equals("g")) {
						total = rs.getString("TOTAL_G");
					} else if (unit.equals("mL")) {
						total = rs.getString("TOTAL_ML");
					}
					System.out.println("제조사 = [" + manufacturer + "], 제품이름 = [" + foodName + "], 대분류 = [" + bigCtg
							+ "],\n 소분류 = [" + detailCtg + "], 총내용량 = [" + total + " " + unit + "], 일회제공량 = ["
							+ portionSize + "], 열량 = [" + kcal + "]");

					slcData = new ProcessedFoodVo(manufacturer, foodName, bigCtg, detailCtg, total, portionSize, kcal);
					slcData.setUnit(unit);
				}
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
		return slcData;
	}

	public ArrayList<NutrientVo> nutriList(String FoodCode1, String FoodCode2, String unit) {
		ArrayList<NutrientVo> nutriList = new ArrayList<NutrientVo>();
		String query1 = "";
		NutrientVo vo = null;

		try {
			// foodCode1 의 영양소 내역 추출
			query1 = "SELECT *\n" + "FROM NUTRIENT\n" + "WHERE FOOD_CODE = '" + FoodCode1 + "'";

			rs = stmt.executeQuery(query1);
			System.out.println("SQL 1 : " + query1);

			System.out.println("------------------");
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			int k = 0;
			rs.beforeFirst(); // 커서를 처음으로 되돌리기

			while (rs.next()) { // 해당 결과가 있으면 조회해오는 것
				System.out.println("+++++++" + k + "+++++++++");
				String[] nutri = new String[73];

				String foodCode = rs.getString("FOOD_CODE");
				int PortionSize = rs.getInt("PORTION_SIZE");
				String total = "";

				if (unit.equals("g")) {
					total = rs.getString("TOTAL_G");
				} else if (unit.equals("mL")) {
					total = rs.getString("TOTAL_ML");
				}

				int kcal = rs.getInt("Kcal");

				for (int i = 0; i < nutri.length; i++) {
					nutri[i] = (rs.getString("nutry" + i)); // 각영양소의 값 가지고오기
				}

				System.out.print("코드 = [" + foodCode + "], 1회제공량 = [" + PortionSize + "], total = [" + total
						+ "],\nkcal = [" + kcal + "],");

				for (int i = 0; i < nutri.length; i++) {
					System.out.println("영양소[" + i + "] = [" + nutri[i] + "]");

				}
				vo = new NutrientVo(foodCode, PortionSize, total, kcal, nutri);
				nutriList.add(vo);
				k++;
			}

			// foodCode1 의 영양소 내역 추출
			query1 = "SELECT *\n" + "FROM NUTRIENT\n" + "WHERE FOOD_CODE = '" + FoodCode2 + "'";

			rs = stmt.executeQuery(query1);

			System.out.println("SQL 1 : " + query1);

			// 해당 단위에 알맞은 쿼리 실행
			System.out.println("------------------");
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			rs.beforeFirst(); // 커서를 처음으로 되돌리기

			while (rs.next()) { // 해당 결과가 있으면 조회해오는 것
				System.out.println("+++++++" + k + "+++++++++");
				String[] nutri = new String[73];

				String foodCode = rs.getString("FOOD_CODE");
				int PortionSize = rs.getInt("PORTION_SIZE");
				String total = "";

				if (unit.equals("g")) {
					total = rs.getString("TOTAL_G");
				} else if (unit.equals("mL")) {
					total = rs.getString("TOTAL_ML");
				}

				int kcal = rs.getInt("Kcal");

				for (int i = 0; i < nutri.length; i++) {
					nutri[i] = (rs.getString("nutry" + i)); // 각영양소의 값 가지고오기
				}

				System.out.print("코드 = [" + foodCode + "], 1회제공량 = [" + PortionSize + "], total = [" + total
						+ "],\nkcal = [" + kcal + "],");

				for (int i = 0; i < nutri.length; i++) {
					System.out.println("영양소[" + i + "] = [" + nutri[i] + "]");

				}
				vo = new NutrientVo(foodCode, PortionSize, total, kcal, nutri);
				nutriList.add(vo);
				k++;
			}

			// KorName 의 영양소 내역(이름) 추출
			query1 = "SELECT *\n" + "FROM NUTRIENT\n" + "WHERE FOOD_CODE = 'KorName'";

			rs = stmt.executeQuery(query1);

			System.out.println("SQL 1 : " + query1);

			// 해당 단위에 알맞은 쿼리 실행
			System.out.println("------------------");
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			rs.beforeFirst(); // 커서를 처음으로 되돌리기

			while (rs.next()) { // 해당 결과가 있으면 조회해오는 것
				System.out.println("+++++++" + k + "+++++++++");
				String[] nutri = new String[73];

				String foodCode = rs.getString("FOOD_CODE");
				int PortionSize = rs.getInt("PORTION_SIZE");
				String total = "";

				if (unit.equals("g")) {
					total = rs.getString("TOTAL_G");
				} else if (unit.equals("mL")) {
					total = rs.getString("TOTAL_ML");
				}

				int kcal = rs.getInt("Kcal");

				for (int i = 0; i < nutri.length; i++) {
					nutri[i] = (rs.getString("nutry" + i)); // 각영양소의 값 가지고오기
				}

				System.out.print("코드 = [" + foodCode + "], 1회제공량 = [" + PortionSize + "], total = [" + total
						+ "],\nkcal = [" + kcal + "],");

				for (int i = 0; i < nutri.length; i++) {
					System.out.println("영양소[" + i + "] = [" + nutri[i] + "]");

				}
				vo = new NutrientVo(foodCode, PortionSize, total, kcal, nutri);
				nutriList.add(vo);
				k++;
			}
		} catch (Exception e) {

		}
		return nutriList;
	}
	
	// Detail 식품 항목 조회DB
	public String[] nutriList(String FoodCode) {
		String query1 = "";
		String[] nutri = null;

		try {
			// foodCode1 의 영양소 내역 추출
			query1 = "SELECT *\n" + "FROM NUTRIENT\n" + "WHERE FOOD_CODE = '" + FoodCode + "'";

			rs = stmt.executeQuery(query1);
			System.out.println("SQL 1 : " + query1);

			System.out.println("------------------");
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			int k = 0;
			rs.beforeFirst(); // 커서를 처음으로 되돌리기

			while (rs.next()) { // 해당 결과가 있으면 조회해오는 것
				System.out.println("+++++++" + k + "+++++++++");
				nutri = new String[73];

				for (int i = 0; i < nutri.length; i++) {
					nutri[i] = (rs.getString("nutry" + i)); // 각영양소의 값 가지고오기
				}

				for (int i = 0; i < nutri.length; i++) {
					System.out.println("영양소[" + i + "] = [" + nutri[i] + "]");

				}
				k++;
			}
		} catch(Exception e) {
			
		}
		return nutri;
	}
	
	// user NutrientDietaryReferenceVo 성별.연령별 권장 섭취량DB
	// 해당 유저의 1일 섭취 kcal 반환
	public int userKcal(String gender, String age) {
		int kcal = 0;
		try {
			String query = "SELECT * \n"
					+ "FROM NUTRIENT_DIETARY_REFERENCE\n"
					+ "WHERE GENDER = '" + gender 
					+ "' AND AGE = '" + age + "'";
			
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow : " + rs.getRow());
			
			if(rs.getRow() == 0) {
				
			}else {
				rs.beforeFirst();
				rs.next();
				kcal = rs.getInt("KCAL");
			}
		}catch(Exception e) {
			
		}
		
		return kcal;
	}

	public String[] userNutriList(String gender, String age) {
		String[] nutri = null;
		String query1 = "";

		try {
			// foodCode1 의 영양소 내역 추출
			query1 = "SELECT * \n"
					+ "FROM NUTRIENT_DIETARY_REFERENCE\n"
					+ "WHERE GENDER = '" + gender + "' AND AGE = '" + age + "'";

			rs = stmt.executeQuery(query1);
			System.out.println("SQL 1 : " + query1);

			System.out.println("------------------");
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			int k = 0;
			rs.beforeFirst(); // 커서를 처음으로 되돌리기

			while (rs.next()) { // 해당 결과가 있으면 조회해오는 것
				System.out.println("+++++++" + k + "+++++++++");
				nutri = new String[73];

				for (int i = 0; i < nutri.length; i++) {
					nutri[i] = (rs.getString("nutry" + i)); // 각영양소의 값 가지고오기
				}

				for (int i = 0; i < nutri.length; i++) {
					System.out.println("영양소[" + i + "] = [" + nutri[i] + "]");

				}
				k++;
			}
		} catch (Exception e) {

		}
		return nutri;
	}
	
	public int getSlcCtgN() {
		return slcCtgN;
	}

	public ArrayList<ProcessedFoodVo> getList() {
		return list;
	}

	public MainDAO() {

	}

	public static void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			System.out.println("statement create success.");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

//	public static void main(String[] args) {
//		MainDAO dao = new MainDAO();
//		dao.connDB();
////		dao.nutriList("P053364", "P010002", "g");
////		int age = dao.listAge("aaa123");
////		String gender = dao.listGender("syh");
//		int kcal = dao.userKcal("여", "32");
//		String[] str = dao.userNutriList("여", "32");
////		System.out.println(kcal);
//	}
}
