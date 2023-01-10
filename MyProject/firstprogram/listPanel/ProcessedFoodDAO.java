//package listPanel;
//
//import java.util.ArrayList;
//
//import mainframe.MainDAO;
//
//public class ProcessedFoodDAO extends MainDAO {
//	private int n;
//	private ArrayList<ProcessedFoodVo> list;
//
//	// 해당 카테고리에 전체 항목 조회(list 프레임에 사용)
//	public ArrayList<ProcessedFoodVo> list(String big_ctg) {
////		String big_ctg = "가공두부";
//		list = new ArrayList<ProcessedFoodVo>();
//
//		try {
//			connDB();
//
//			String query2 = "SELECT pf.food_code, FOOD_NAME, pf.DETAIL_CTG, pf.MANUFACTURER, n.\"Kcal\" \n"
//					+ "FROM PROCESSED_FOOD pf, NUTRIENT n ";
//			if (big_ctg != null) {
//				query2 += "WHERE pf.food_code = n.FOOD_CODE and pf.BIG_CTG = '" + big_ctg + "'\n"
//						+ "ORDER BY FOOD_NAME";
//			}
//			System.out.println("SQL2 : " + query2);
//
//			rs = stmt.executeQuery(query2);
//			rs.last();
//			System.out.println("rs1.getRow() : " + rs.getRow());
//			// big_ctg 항목이 몇개인지 rs.getRow() 를 통해 알 수 있음.
//
//			n = rs.getRow();
//			if (rs.getRow() == 0) {
//
//			} else {
//				rs.beforeFirst(); // 커서를 처음으로 되돌리기
////				rs1.previous(); // 커서를 이전 위치로 되돌리기
//
//				while (rs.next()) { // 해당 결과가 있으면 조회해오는 것
//					String foodCode = rs.getString("FOOD_CODE");
//					String foodName = rs.getString("FOOD_NAME");
//					String detailCtg = rs.getString("DETAIL_ctg");
//					String manufacturer = rs.getString("MANUFACTURER");
//					int kcal = rs.getInt("Kcal");
//
//					System.out.println("[food_code = " + foodCode + "][food_name = " + foodName + "][detail_Ctg = "
//							+ detailCtg + "][manufacturer = " + manufacturer + "][kcal = " + kcal + "]");
////					
////					
//					ProcessedFoodVo data = new ProcessedFoodVo(foodCode, foodName, detailCtg, manufacturer, kcal);
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
//	// compare 에 쓰일 데이터
//	public ProcessedFoodVo compareData(String Food_code) {
//		ProcessedFoodVo slcData = null;
//		
//		String query1 = "";
//		String query2 = "";
//		try {
//			connDB();
//			// g or mL 단위 알아오는 쿼리
//			query1 = "SELECT UNIT\n" + "FROM NUTRIENT \n" + "WHERE FOOD_CODE = '" + Food_code + "'";
//
//			rs = stmt.executeQuery(query1);
//			rs.next();
//			String unit = rs.getString("unit");
//			System.out.println(unit);
//
//			rs.beforeFirst();
//
//			// 해당 단위에 알맞은 쿼리 실행
//			if (unit.equals("g")) {
//				query2 = "SELECT MANUFACTURER, FOOD_NAME, BIG_CTG, DETAIL_CTG, n.TOTAL_G, n.PORTION_SIZE, n.\"Kcal\" \n"
//						+ "FROM processed_food p, NUTRIENT n\n" + "WHERE p.FOOD_CODE = n.FOOD_CODE AND n.FOOD_CODE = '"
//						+ Food_code + "'";
//
//			} else if (unit.equals("mL")) {
//				query2 = "SELECT MANUFACTURER, FOOD_NAME, BIG_CTG, DETAIL_CTG, n.TOTAL_ML, n.PORTION_SIZE, n.\"Kcal\" \n"
//						+ "FROM processed_food p, NUTRIENT n\n" + "WHERE p.FOOD_CODE = n.FOOD_CODE AND n.FOOD_CODE = '"
//						+ Food_code + "'";
//			}
//			System.out.println("단위 : " + unit);
//			System.out.println("SQL2 : " + query2);
//			System.out.println("------------------");
//			rs = stmt.executeQuery(query2);
//			rs.last();
//			System.out.println("rs1.getRow() : " + rs.getRow());
////			
//			n = rs.getRow();
//			if (rs.getRow() == 0) {
////				
//			} else {
//				rs.beforeFirst(); // 커서를 처음으로 되돌리기
//////				rs1.previous(); // 커서를 이전 위치로 되돌리기
////				
//				while (rs.next()) { // 해당 결과가 있으면 조회해오는 것
//					String manufacturer = rs.getString("MANUFACTURER");
//					String foodName = rs.getString("FOOD_NAME");
//					String bigCtg = rs.getString("BIG_CTG");
//					String detailCtg = rs.getString("DETAIL_CTG");
//					String portionSize = rs.getString("PORTION_SIZE");
//					int kcal = rs.getInt("Kcal");
//					String total = "";
//					if (unit.equals("g")) {
//						total = rs.getString("TOTAL_G");
//					} else if (unit.equals("mL")) {
//						total = rs.getString("TOTAL_ML");
//					}
//					System.out.println("제조사 = [" + manufacturer + "], 제품이름 = [" + foodName + "], 대분류 = [" + bigCtg
//							+ "],\n 소분류 = [" + detailCtg + "], 총내용량 = [" + total + " " + unit + "], 일회제공량 = ["
//							+ portionSize + "], 열량 = [" + kcal + "]");
//
//					slcData = new ProcessedFoodVo(manufacturer, foodName, bigCtg, detailCtg, total,
//							portionSize, kcal);
//					slcData.setUnit(unit);
//				}
//			}
//
//		} catch (Exception e) {
//			e.getStackTrace();
//		}
//		return slcData;
//	}
//
//	public int getN() {
//		return n;
//	}
//
//	public ArrayList<ProcessedFoodVo> getList() {
//		return list;
//	}
//
//	public static void main(String[] args) {
//		ProcessedFoodDAO dao = new ProcessedFoodDAO();
////	ArrayList<ProcessedFoodVo> list = dao.list("가공두부");
//		dao.compareData("P053364");
//		System.out.println("----------------------");
////	Iterator<ProcessedFoodVo> it = list.iterator();
////	while(it.hasNext()) {
////		System.out.println(it.next().getFoodName());
////	}
////	System.out.println(list);
//	}
//}
