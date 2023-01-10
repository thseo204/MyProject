package productCompareFrame;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

//import listPanel.ProcessedFoodDAO;
import listPanel.ProcessedFoodVo;
import mainframe.ImagePanel;
import mainframe.MainDAO;
import mainframe.MyFont;
import mainframe.MyFrame;
import mainframe.MyTextField;

public class ProductCompareFrame {
	private MyFrame f;
	private ImagePanel p;
	private JPanel northP, southP;
	private JTable slcTable1, slcTable2, nutriTable;
	private JScrollPane slcPane1, slcPane2, nutriPane;
	private MyFont mfont;
	private JTextField tf;
	private JButton btnApply;
	private MyTextField manuTf1, manuTf2, nameTf1, nameTf2, vs, nutriCompareTf, gTf;
	private String codeStr1, codeStr2;
//	private ProcessedFoodDAO dao = new ProcessedFoodDAO();
	private MainDAO DAO = new MainDAO();
	private ProcessedFoodVo slcData1, slcData2;
	private JLabel lbTotal1, lbTotal2, lbKcal1, lbKcal2;

	private String[] header = { " ", " " };
	private String[] header2 = { " ", " ", " ", " ", " " };

	private String gender, age;
	private int userKcal;

	public ProductCompareFrame() {
		f = new MyFrame("제품 리스트_[뉴트리베터]");
		p = new ImagePanel(new ImageIcon(f.getBackImg()).getImage());
		northP = new JPanel();
		southP = new JPanel();
		mfont = new MyFont();

		vs = new MyTextField("VS", 20);

		nutriCompareTf = new MyTextField("영양성분별 비교       g", 12);
		tf = new JTextField();
		btnApply = new JButton("적용");
		lbTotal1 = new JLabel("lbtotal1");
		lbTotal2 = new JLabel("lbtotal2");
		lbKcal1 = new JLabel("lbkcal1");
		lbKcal2 = new JLabel("lbkcal2");

	}

	public void startFrame() {
		userKcal = DAO.userKcal(gender, age);
		f.startMyFrmae();
		f.startBackBtn();
		f.backBtnDispose();
		northP.setLayout(null);
		northP.setBounds(0, 70, 500, 200);
		northP.setBackground(Color.white);
		southP.setLayout(null);
		southP.setBounds(0, 270, 500, 285);
		southP.setBackground(Color.white);

		manuTf1 = new MyTextField(slcData1.getManufacturer(), 11);
		nameTf1 = new MyTextField(slcData1.getFoodName(), 20);
		nameTf1.getJTf().setFont(mfont.setFont(15));
		manuTf2 = new MyTextField(slcData2.getManufacturer(), 11);
		nameTf2 = new MyTextField(slcData2.getFoodName(), 20);
		nameTf2.getJTf().setFont(mfont.setFont(15));
		gTf = new MyTextField(slcData1.getUnit(), 12);

		manuTf1.getJTf().setForeground(Color.GRAY);
		manuTf1.getJTf().setBounds(20, 15, 60, 15);
		nameTf1.getJTf().setBounds(85, 10, 150, 30);

		vs.getJTf().setBounds(237, 100, 25, 20);
		vs.getJTf().setFont(mfont.setFont(20));

		manuTf2.getJTf().setForeground(Color.GRAY);
		manuTf2.getJTf().setBounds(270, 15, 60, 15);
		nameTf2.getJTf().setBounds(335, 10, 150, 30);

		lbTotal1.setBounds(150, 100, 50, 10);
		lbTotal2.setBounds(450, 100, 50, 10);
		lbKcal1.setBounds(150, 175, 50, 10);
		lbKcal2.setBounds(450, 175, 50, 10);
		
		nutriCompareTf.getJTf().setBounds(20, 5, 180, 15);
		nutriCompareTf.getJTf().setFont(mfont.setFont(15));
		tf.setBounds(130, 0, 50, 25);
		tf.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));

		btnApply.setBounds(205, 0, 30, 25);
		btnApply.setForeground(Color.darkGray);
//		btnApply.setBackground(Color.DARK_GRAY);
		btnApply.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
		btnApply.setFocusPainted(true);

		Border border = new LineBorder(Color.white, 2, true);
		// slcData1
		String contents1[][] = { { "유형[대/소분류]", "총 내용량" },
				{ "[" + slcData1.getBigCtg() + "] " + slcData1.getDetailCtg(),
						slcData1.getTotal() + slcData1.getUnit() },
				{ "1회 제공량", "총 열량" }, { slcData1.getPortionSize() + slcData1.getUnit(), slcData1.getKcal() + "" } };

		DefaultTableModel model1 = new DefaultTableModel(contents1, header);
		slcTable1 = new JTable(model1) {
			private static final long serialVersionUID = 1L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				// TODO Auto-generated method stub
				JComponent component = (JComponent) super.prepareRenderer(renderer, row, column);
				if (!isRowSelected(row)) {
					component.setBackground(row % 2 == 0 ? new Color(240, 230, 140) : Color.WHITE);
				}
				return component;
			}
			// 테이블 수정 불가능 하게.
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		
		// 총 내용량과 총 열량 옆에 비교 수치 표시
//		String totalStr1 = model1.getValueAt(1, 1) + "";
//		totalStr1 += "10g ^";
//		lbTotal1.setText(totalStr1);
//		lbTotal1.setForeground(Color.red);
//		model1.setValueAt(lbTotal1.getText(), 1, 1);
		
		// 테이블 가운데정렬 시키기
//		tableCellCenter(slcTable1);
		
		slcTable1.setBorder(border);
		// 행 높이 지정
		slcTable1.setRowHeight(35);
		slcTable1.setFont(mfont.setFont(12));
		slcTable1.setShowHorizontalLines(true); // 셀 수평선 유무
		slcTable1.setShowVerticalLines(false); // 셀 수직선 유무
		slcTable1.setGridColor(new Color(240, 230, 140));

		slcPane1 = new JScrollPane(slcTable1);
		slcPane1.setBounds(15, 30, 220, 160);
		slcPane1.setBorder(border);

		// slcData2
		String contents2[][] = { { "유형[대/소분류]", "총 내용량" },
				{ "[" + slcData2.getBigCtg() + "] " + slcData2.getDetailCtg(),
						slcData2.getTotal() + slcData2.getUnit() },
				{ "1회 제공량", "총 열량" }, { slcData2.getPortionSize() + slcData2.getUnit(), slcData2.getKcal() + "" } };

		DefaultTableModel model2 = new DefaultTableModel(contents2, header);
		slcTable2 = new JTable(model2) {
			private static final long serialVersionUID = 1L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				// TODO Auto-generated method stub
				JComponent component = (JComponent) super.prepareRenderer(renderer, row, column);
				if (!isRowSelected(row)) {
					component.setBackground(row % 2 == 0 ? new Color(255, 228, 225) : Color.WHITE);
				}
				return component;
			}
			// 테이블 수정 불가능 하게.
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// 테이블 가운데정렬 시키기
//		tableCellCenter(slcTable2);
		slcTable2.setBorder(border);
		// 행 높이 지정
		slcTable2.setRowHeight(35);
		slcTable2.setFont(mfont.setFont(12));

		slcTable2.setShowHorizontalLines(true); // 셀 수평선 유무
		slcTable2.setShowVerticalLines(false); // 셀 수직선 유무
		slcTable2.setGridColor(new Color(255, 228, 225));

		slcPane2 = new JScrollPane(slcTable2);
		slcPane2.setBounds(265, 30, 220, 160);
		slcPane2.setBorder(border);

		// 열 별로 사이즈 지정
//		slcMainT1.getColumnModel().getColumn(0).setPreferredWidth(110);
//		slcMainT1.getColumnModel().getColumn(1).setPreferredWidth(110);

		String[][] contents3 = new String[75][header2.length];
		for (int i = 0; i < contents3.length; i++) {
			for (int j = 0; j < contents3[i].length; j++) {
//				contents3[i][j] = new String();
				contents3[i][j] = "(권장섭취량 없음)";
			}
		}
		// nutryPane
		contents3[0][0] = "1일영양성분기준대비(%)";
		contents3[0][1] = "함량";
		contents3[0][2] = "영양성분(단위)";
		contents3[0][3] = "함량";
		contents3[0][4] = "1일영양성분기준대비(%)";

		contents3[1][0] = (slcData1.getKcal() / (double) userKcal) * 100 + "";
		if (contents3[1][0].length() >= 5) {
			contents3[1][0] = contents3[1][0].substring(0, 5);
		}
		contents3[1][0] += "%";
		contents3[1][1] = slcData1.getKcal() + "";
		contents3[1][2] = "총열량(Kcal)";
		contents3[1][3] = slcData2.getKcal() + "";
		contents3[1][4] = (slcData2.getKcal() / (double) userKcal) * 100 + "";
		if (contents3[1][4].length() >= 5) {
			contents3[1][4] = contents3[1][4].substring(0, 5);
		}
		contents3[1][4] += "%";

		int j = 0;
		ArrayList<NutrientVo> nutriList = DAO.nutriList(codeStr1, codeStr2, slcData1.getUnit());
		String[] userNutriList = DAO.userNutriList(gender, age);
		String[] userKorNutriList = DAO.userNutriList("성별", "나이");
		Iterator<NutrientVo> iter = nutriList.iterator();
		while (iter.hasNext()) {
//			iter.next();
			if (nutriList.isEmpty()) {
				break;
			} else {
				try {
					iter.next();
					String foodCode = nutriList.get(j).getFoodCode();
					int portionSize = nutriList.get(j).getPortionSize();
					String unit = nutriList.get(j).getUnit();
					String total = nutriList.get(j).getTotal();
					String kcal = nutriList.get(j).getKcal() + "";
					String[] nutry1 = nutriList.get(j).getNutry();

					System.out.println("****************" + j + "***************");
					System.out.print(foodCode + "\t");
					System.out.print(portionSize + "\t");
					System.out.print(unit + "\t");
					System.out.println(total + "\t");
					System.out.print(kcal + "\t");
					if (j == 0) {// 첫번째 셀렉한 제품
						for (int i = 0; i < contents3.length; i++) {
							contents3[i + 2][1] = nutry1[i];
//							contents3[i + 2][0] = String.valueOf((Double.valueOf(nutry1[i]) / Double.valueOf(userNutriList[i])) * 100);
							System.out.println(contents3[i + 2][1] + "\t");
						}
					} else if (j == 1) { // 두번째 셀렉한 제품
						for (int i = 0; i < contents3.length; i++) {
							contents3[i + 2][3] = nutry1[i];
//							contents3[i + 2][4] = String.valueOf((Double.valueOf(nutry1[i]) / Double.valueOf(userNutriList[i])) * 100);
							System.out.println(contents3[i + 2][3] + "\t");
						}

					} else { // 영양소 이름
						for (int i = 0; i < contents3.length; i++) {
							contents3[i + 2][2] = nutry1[i];
							System.out.println(contents3[i + 2][2] + "\t");
						}
					}
				} catch (Exception e) {

				}
				j++;
			}
		}

		DefaultTableModel model3 = new DefaultTableModel(contents3, header2);
		nutriTable = new JTable(model3) {
			private static final long serialVersionUID = 1L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				// TODO Auto-generated method stub
				JComponent component = (JComponent) super.prepareRenderer(renderer, row, column);
				if (!isRowSelected(row)) {
					component.setBackground(row == 0 ? Color.LIGHT_GRAY : Color.WHITE);
					component.setForeground(row == 0 ? Color.black : Color.DARK_GRAY);
				}
				if (!isCellSelected(row, column)) {
					if(column == 2 && row == 0) {
						component.setForeground(Color.black);
						component.setBackground(Color.WHITE);
						
					}
					if(column == 2 && row != 0) {
						component.setFont(mfont.setFont(11));
						component.setForeground(Color.BLACK);
						component.setBackground(new Color(250,235,215));
						
					}
					if((column == 0 || column == 1 )&& row == 0) {
						component.setBackground(new Color(240, 230, 140));
						if(column == 0) {
							component.setFont(mfont.setFont(10));
						}
						
					}
					if((column == 3 || column == 4 )&& row == 0) {
						component.setBackground(new Color(255, 228, 225));
						if(column == 4) {
							component.setFont(mfont.setFont(10));
						}
						
					}

				}
				return component;
			}
			// 테이블 수정 불가능 하게.
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// 테이블의 그리드 선 색상
		nutriTable.setShowHorizontalLines(true); // 셀 수평선 유무
		nutriTable.setShowVerticalLines(false); // 셀 수직선 유무
		nutriTable.setGridColor(Color.LIGHT_GRAY);
//			if(!String.valueOf(model3.getValueAt(i, 1)).equals(null) || !userNutriList[i-2].equals(null)) {
////				System.out.println((int)Double.parseDouble(model3.getValueAt(i, 1)+"") + "/" + (int)Double.parseDouble(userNutriList[i-2]) + "*" + 100);
//				String str = String.valueOf((Double.parseDouble(model3.getValueAt(i, 1)+"")+0.1) / (Double.parseDouble(userNutriList[i-2])+0.1) * 100);
//				model3.setValueAt(str + "%", i, 0);
//			}

		// null 값이 행 삭제
		for (int i = 2; i < model3.getRowCount(); i++) {
			System.out.println(
					"model3.getValueAt(" + i + ", 1)" + model3.getValueAt(i, 1) + "\t" + model3.getValueAt(i, 3));
			if (model3.getValueAt(i, 1) == null && model3.getValueAt(i, 3) == null) {
				model3.removeRow(i--);
				// 지워지는 행의 자리를 뒷 행이 바로 채우기 때문에 지워지는 행으로부터 -1 하여 다시 탐색하기! arrayList와 비슷한 성질
			}
		}

		for (int i = 2; i < model3.getRowCount(); i++) {
			for (int k = 0; k < userKorNutriList.length; k++) {
//			System.out.println("model3.getValueAt("+ i +", 1) = " + model3.getValueAt(i, 1) + "\tmodel3.getValueAt(" + i + ", 2) = " + model3.getValueAt(i, 2) + "\t" + "userKorNutriList["+k+"]" + userKorNutriList[k]);
				String slcNutri1 = model3.getValueAt(i, 1) + "";
				String slcNutri2 = model3.getValueAt(i, 3) + "";
				String korNutri = String.valueOf(model3.getValueAt(i, 2));
				String userKorNutri = userKorNutriList[k];
				if (korNutri.equals(userKorNutri)) {
					System.out.println(korNutri + "<------->" + userKorNutri);
					System.out.println(slcNutri1 + "  &&&&&&&&&  " + userNutriList[k]);
					String slcNutriValue1 = slcNutri1;
					String slcNutriValue2 = slcNutri2;
					userKorNutri = userNutriList[k];
					if ((slcNutriValue1 != null) && (userKorNutri != null)){
						double dSlcNutri = Double.parseDouble(slcNutri1);
						int iUserNutri = Integer.parseInt(userNutriList[k]);
						System.out.println(dSlcNutri + "/" + iUserNutri + "*" + 100);
						
						double value = dSlcNutri / iUserNutri * 100;
						String str = value + "";
						if (str.length() >= 5) {
							str = str.substring(0, 5);
						}
						str += "%";
						model3.setValueAt(str, i, 0);
					}
					
					if ((slcNutriValue2 != null) && (userKorNutri != null)){
						double dSlcNutri = Double.parseDouble(slcNutri2);
						int iUserNutri = Integer.parseInt(userNutriList[k]);
						System.out.println(dSlcNutri + "/" + iUserNutri + "*" + 100);
						
						double value = dSlcNutri / iUserNutri * 100;
						String str = value + "";
						if (str.length() >= 5) {
							str = str.substring(0, 5);
						}
						str += "%";
						model3.setValueAt(str, i, 4);
					}
					
				} else {
					continue;
				}
			}
		}

		// 테이블 가운데 정렬
		tableCellCenter(nutriTable);
		// 행 높이 지정
		nutriTable.setRowHeight(30);
		nutriTable.setFont(mfont.setFont(13));
		nutriTable.setBorder(border);

		nutriTable.getColumnModel().getColumn(0).setPreferredWidth(95);
		nutriTable.getColumnModel().getColumn(1).setPreferredWidth(50);
		nutriTable.getColumnModel().getColumn(2).setPreferredWidth(70); // -35
		nutriTable.getColumnModel().getColumn(3).setPreferredWidth(50); // -55
		nutriTable.getColumnModel().getColumn(4).setPreferredWidth(95);

		nutriPane = new JScrollPane(nutriTable);
		nutriPane.setBounds(10, 20, 480, 260);
		nutriPane.setBorder(border);

		
		northP.add(manuTf1.getJTf());
		northP.add(nameTf1.getJTf());
		northP.add(vs.getJTf());
		northP.add(manuTf2.getJTf());
		northP.add(nameTf2.getJTf());
		northP.add(slcPane1);
		northP.add(slcPane2);

//		northP.add(lbTotal1);
//		northP.add(lbTotal2);
//		northP.add(lbKcal1);
//		northP.add(lbKcal2);
		
		southP.add(tf);
		southP.add(nutriCompareTf.getJTf());
		southP.add(btnApply);
		southP.add(nutriPane);

		p.add(northP);
		p.add(southP);
		p.add(f.getBackBtn());
		f.getMyFrame().add(p);
		f.getMyFrame().setVisible(true);
	}

	public void setSlcStr(String codeStr1, String codeStr2) {
		this.codeStr1 = codeStr1;
		this.codeStr2 = codeStr2;
		slcData1 = DAO.compareData(codeStr1);
		slcData2 = DAO.compareData(codeStr2);
	}

	// 테이블 가운데 정렬
	public void tableCellCenter(JTable t) {
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = t.getColumnModel();

		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(centerRenderer);
		}
	}

	public void setGenderAge(String gender, String age) {
		this.gender = gender;
		this.age = age;
	}

//	public static void main(String[] args) {
//		ProductCompareFrame plf = new ProductCompareFrame();
//		plf.setSlcStr("P053364", "P043029");
//		plf.startFrame();
//	}
}
