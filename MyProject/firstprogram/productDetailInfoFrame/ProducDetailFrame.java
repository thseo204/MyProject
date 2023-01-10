package productDetailInfoFrame;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import listPanel.ProcessedFoodVo;
import mainframe.ImagePanel;
import mainframe.MainDAO;
import mainframe.MyFont;
import mainframe.MyFrame;
import mainframe.MyTextField;
import productCompareFrame.NutrientVo;

public class ProducDetailFrame {
	private MyFrame f;
	private ImagePanel p;
	private JPanel northP, southP;
	private MyTextField manuTf, nameTf, nutriListTf;
	private MyFont mfont;
	private JTable slcTable, nutriTable;
	private JScrollPane slcPane, nutriPane;

	private String codeStr;

	private String[] header1 = { " ", " ", " ", " ", " " };
	private String[] header2 = { " ", " ", " ", " " };

	private String gender, age;
	private int userKcal;

	private MainDAO DAO = new MainDAO();
	private ProcessedFoodVo slcData;

	public ProducDetailFrame() {

		f = new MyFrame("제품 리스트_[뉴트리베터]");
		p = new ImagePanel(new ImageIcon(f.getBackImg()).getImage());

		northP = new JPanel();
		southP = new JPanel();
		mfont = new MyFont();

	}

	public void startFrame() {
		userKcal = DAO.userKcal(gender, age);

		f.startMyFrmae();
		f.startBackBtn();
		f.backBtnDispose();

		northP.setLayout(null);
		northP.setBounds(0, 70, 500, 180);
		northP.setBackground(Color.WHITE);
		southP.setLayout(null);
		southP.setBounds(0, 250, 500, 315);
		southP.setBackground(Color.WHITE);

		manuTf = new MyTextField(slcData.getManufacturer(), 13);
		nameTf = new MyTextField(slcData.getFoodName(), 23);
		nutriListTf = new MyTextField("영양성분별 분류", 15);

		nameTf.getJTf().setFont(mfont.setFont(23));
		manuTf.getJTf().setFont(mfont.setFont(13));
		manuTf.getJTf().setForeground(Color.GRAY);
		manuTf.getJTf().setBounds(40, 20, 100, 15);
		nameTf.getJTf().setBounds(150, 15, 220, 30);
		nutriListTf.getJTf().setFont(mfont.setFont(15));
		nutriListTf.getJTf().setBounds(22, 5, 120, 17);

		double portionValue = Double.parseDouble(slcData.getPortionSize());
		double totalKcal = slcData.getKcal();
		String totalStr = slcData.getTotal();
		String totalValueStr = "";
		String portionKcalStr = "";
		if (totalStr != null && !totalStr.equals(slcData.getPortionSize())) {
			double totalValue = Double.parseDouble(slcData.getTotal());
			double divNum = portionValue / totalValue;
			double portionKcal = divNum / totalKcal;
			totalValueStr = totalValue + slcData.getUnit();
			portionKcalStr = portionKcal + "";
			if(portionKcalStr.length() >= 5) {
				portionKcalStr = portionKcalStr.substring(0, 5);
			}
			portionKcalStr += "Kcal";
		} else {
			totalValueStr = "-";
			portionKcalStr = "-";
		}

		Border border = new LineBorder(Color.white, 2, true);

		String contents1[][] = { { "유형[대/소분류]", "총 내용량", "1회 제공량", "총 열량", "1회 제공 열량" },
				{ "[" + slcData.getBigCtg() + "] " + slcData.getDetailCtg(), totalValueStr,
						portionValue + slcData.getUnit(), totalKcal + "Kcal", portionKcalStr } };

		DefaultTableModel model1 = new DefaultTableModel(contents1, header1);
		slcTable = new JTable(model1) {
			private static final long serialVersionUID = 1L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				// TODO Auto-generated method stub
				JComponent component = (JComponent) super.prepareRenderer(renderer, row, column);
				if (!isRowSelected(row)) {
					component.setBackground(row == 0 ? new Color(240, 230, 140) : Color.WHITE);
				}
				return component;
			}

			// 테이블 수정 불가능 하게.
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		tableCellCenter(slcTable);

		slcTable.setBorder(border);
		// 행 높이 지정
		slcTable.setRowHeight(45);
		slcTable.setFont(mfont.setFont(12));
		slcTable.setShowHorizontalLines(true); // 셀 수평선 유무
		slcTable.setShowVerticalLines(false); // 셀 수직선 유무
		slcTable.setGridColor(new Color(240, 230, 140));

		slcTable.getColumnModel().getColumn(0).setPreferredWidth(110);
		slcTable.getColumnModel().getColumn(4).setPreferredWidth(100);

		slcPane = new JScrollPane(slcTable);
		slcPane.setBounds(15, 50, 470, 110);
		slcPane.setBorder(border);

		String[][] contents2 = new String[75][header2.length];
		for (int i = 0; i < contents2.length; i++) {
			for (int j = 0; j < contents2[i].length; j++) {
				contents2[i][j] = "//";
				contents2[i][3] = "(권장섭취량 없음)";
			}
		}
		// nutryPane
		contents2[0][0] = "영양성분(단위)";
		contents2[0][1] = "함량";
		contents2[0][2] = "TEXTFIELD";
		contents2[0][3] = "1일영양성분기준대비(%)";

		contents2[1][0] = "총열량(Kcal)";
		contents2[1][1] = slcData.getKcal() + "";
		
		int userKcal = DAO.userKcal(gender,  age);
		double kcalPercent = slcData.getKcal() / (double)userKcal * 100;
		String kcalPerStr = kcalPercent + "";
		if(kcalPerStr.length() >= 5) {
			kcalPerStr = kcalPerStr.substring(0, 5);
		}
		kcalPerStr += "%";
		contents2[1][3] = kcalPerStr;

		String[] nutri = DAO.nutriList(codeStr);
		String[] userNutriList = DAO.userNutriList(gender, age);
		String[] userKorNutriList = DAO.userNutriList("성별", "나이");

		// 영양소 이름 0번 열에
		for (int i = 0; i < userKorNutriList.length; i++) {
			contents2[i + 2][0] = userKorNutriList[i];
			System.out.println(contents2[i + 2][0] + "\t");
		}

		// 각 영양소의 함량 1번 열에
		for (int i = 0; i < nutri.length; i++) {
			contents2[i + 2][1] = nutri[i];
			System.out.println(contents2[i + 2][1] + "\t");
		}
		
		DefaultTableModel model2 = new DefaultTableModel(contents2, header2);
		nutriTable = new JTable(model2) {
			private static final long serialVersionUID = 1L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				// TODO Auto-generated method stub
				JComponent component = (JComponent) super.prepareRenderer(renderer, row, column);
				if (!isRowSelected(row)) {
					component.setBackground(row == 0 ? new Color(240, 230, 140) : Color.WHITE);
					component.setForeground(row == 0 ? Color.black : Color.DARK_GRAY);
				}
				if (!isCellSelected(row, column)) {
					if (column == 0 && row == 0) {
						component.setForeground(Color.black);
						component.setBackground(Color.WHITE);
					}
					if (column == 0 && row != 0) {
						component.setFont(mfont.setFont(11));
						component.setForeground(Color.BLACK);
						component.setBackground(new Color(250, 235, 215));
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

		// null 값인 행 삭제
		for (int i = 2; i < model2.getRowCount(); i++) {
			System.out.println(
					"model3.getValueAt(" + i + ", 1)" + model2.getValueAt(i, 1));
			if (model2.getValueAt(i, 1) == null) {
				model2.removeRow(i--);
				// 지워지는 행의 자리를 뒷 행이 바로 채우기 때문에 지워지는 행으로부터 -1 하여 다시 탐색하기! arrayList와 비슷한 성질
			}
		}
		
		// 식품 영양성분 & user의 권장 섭취량 비교 (1일 영양성분 기준 대비 %) 
		for (int i = 2; i < model2.getRowCount(); i++) {
			for (int k = 0; k < userKorNutriList.length; k++) {
//			System.out.println("model3.getValueAt("+ i +", 1) = " + model3.getValueAt(i, 1) + "\tmodel3.getValueAt(" + i + ", 2) = " + model3.getValueAt(i, 2) + "\t" + "userKorNutriList["+k+"]" + userKorNutriList[k]);
				String slcNutri = model2.getValueAt(i, 1) + "";
				String korNutri = String.valueOf(model2.getValueAt(i, 0));
				String userKorNutri = userKorNutriList[k];
				if (korNutri.equals(userKorNutri)) {
					System.out.println(korNutri + "<------->" + userKorNutri);
					System.out.println(slcNutri + "  &&&&&&&&&  " + userNutriList[k]);
					String slcNutriValue1 = slcNutri;
					userKorNutri = userNutriList[k];
					if ((slcNutriValue1 != null) && (userKorNutri != null)) {
						double dSlcNutri = Double.parseDouble(slcNutri);
						int iUserNutri = Integer.parseInt(userNutriList[k]);
						System.out.println(dSlcNutri + "/" + iUserNutri + "*" + 100);

						double value = dSlcNutri / iUserNutri * 100;
						String str = value + "";
						if (str.length() >= 5) {
							str = str.substring(0, 5);
						}
						str += "%";
						model2.setValueAt(str, i, 3);
					}
				}
			}
		}

		// 테이블 가운데 정렬
		tableCellCenter(nutriTable);
		// 행 높이 지정
		nutriTable.setRowHeight(40);
		nutriTable.setFont(mfont.setFont(13));
		nutriTable.setBorder(border);

//		nutriTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		nutriTable.getColumnModel().getColumn(1).setPreferredWidth(50);
		nutriTable.getColumnModel().getColumn(2).setPreferredWidth(70); // -35
		nutriTable.getColumnModel().getColumn(3).setPreferredWidth(100); // -55

		nutriPane = new JScrollPane(nutriTable);
		nutriPane.setBounds(10, 20, 480, 280);
		nutriPane.setBorder(border);

		northP.add(manuTf.getJTf());
		northP.add(nameTf.getJTf());
		northP.add(slcPane);

		southP.add(nutriListTf.getJTf());
		southP.add(nutriPane);
		
		p.add(northP);
		p.add(southP);
		p.add(f.getBackBtn());
		f.getMyFrame().add(p);
		f.getMyFrame().setVisible(true);
	}

	private void tableCellCenter(JTable t) {
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = t.getColumnModel();

		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(centerRenderer);
		}
	}

	public void setFoodCode(String codeStr) {
		this.codeStr = codeStr;
		slcData = DAO.compareData(codeStr);
	}

	public void setGenderAge(String gender, String age) {
		this.gender = gender;
		this.age = age;
	}

	public static void main(String[] args) {
		MainDAO.connDB();

		ProducDetailFrame plf = new ProducDetailFrame();
		plf.setFoodCode("P084743");
		plf.setGenderAge("여", "32");
		plf.startFrame();
	}
}
