package productDetailInfoFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

import listPanel.ProcessedFoodVo;
import mainFrame.ImagePanel;
import mainFrame.MainDAO;
import mainFrame.MyFont;
import mainFrame.MyFrame;
import mainFrame.MyTextField;

public class ProducDetailFrame {
	private MyFrame f;
	private ImagePanel p;
	private JPanel northP, southP;
	private MyTextField manuTf, nameTf, nutriListTf;
	private MyFont mfont;
	private JTable slcTable, nutriTable;
	private JScrollPane slcPane, nutriPane;
	private JTextField tf;
	private String codeStr;
	private JButton btnApply, btnAddEat;
	private String[] header1 = { " ", " ", " ", " ", " " };
	private String[] header2 = { " ", " ", " ", " " };
	private String[] nutri;
	private String[] percentColValue;
	
	DefaultTableModel model1, model2;
	private String id, gender, age;
	private int userKcal, startCount;

	private MainDAO DAO = new MainDAO();
	private ProcessedFoodVo slcData;

	public ProducDetailFrame() {

		f = new MyFrame("제품 리스트_[뉴트리베터]");
		p = new ImagePanel(new ImageIcon(f.getBackImg()).getImage());

		northP = new JPanel();
		southP = new JPanel();
		mfont = new MyFont();
		tf = new JTextField();
		btnApply = new JButton("적용");
		btnAddEat = new JButton("오늘 섭취 음식 저장");

		
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
		nutriListTf = new MyTextField("영양성분별 분류        g/mL", 15);

		nameTf.getJTf().setFont(mfont.setFont(23));
		manuTf.getJTf().setFont(mfont.setFont(13));
		manuTf.getJTf().setForeground(Color.GRAY);
		manuTf.getJTf().setBounds(40, 4, 420, 15);
		manuTf.getJTf().setHorizontalAlignment(JLabel.LEFT);
		nameTf.getJTf().setBounds(40, 18, 420, 30);
		nameTf.getJTf().setHorizontalAlignment(JLabel.CENTER);
		nutriListTf.getJTf().setFont(mfont.setFont(15));
		nutriListTf.getJTf().setBounds(22, 5, 220, 17);
		
//		tf.setBounds(245, 45, 50, 27);
		tf.setBounds(140, 0, 50, 27);
		tf.setFont(mfont.setFont(13));
		tf.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		
//		btnApply.setBounds(315, 45, 30, 27);
		btnApply.setBounds(235, 0, 30, 27);
		btnApply.setForeground(Color.darkGray);
		btnApply.setBorder(new LineBorder(Color.DARK_GRAY, 3, true));
		//		btnApply.setFocusable(true);
//		btnApply.setContentAreaFilled(false);
//		btnApply.setFocusPainted(false);
		
		btnAddEat.setBounds(360, 0, 120, 27);
		btnAddEat.setForeground(Color.darkGray);
		btnAddEat.setBorder(new LineBorder(Color.DARK_GRAY, 3, true));

		
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

		Border border = new LineBorder(new Color(210,180,140), 1, true);

		String contents1[][] = { { "유형[대/소분류]", "총 내용량", "1회 제공량", "총 열량", "1회 제공 열량" },
				{ "[" + slcData.getBigCtg() + "] " + slcData.getDetailCtg(), totalValueStr,
						portionValue + slcData.getUnit(), totalKcal + "Kcal", portionKcalStr } };

		model1 = new DefaultTableModel(contents1, header1);
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
//		slcTable.isCellEditable(0, 2);
		slcTable.setBorder(border);
		slcTable.getTableHeader().setReorderingAllowed(false); //  컬럼의 이동 불가.
		slcTable.getTableHeader().setResizingAllowed(false); // 컬럼의 사이즈 변경 불가.
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
		slcPane.setBorder(new LineBorder(Color.white));

		String[][] contents2 = new String[75][header2.length];
		for (int i = 0; i < contents2.length; i++) {
			for (int j = 0; j < contents2[i].length; j++) {
				contents2[i][j] = "-";
				contents2[i][3] = "(권장섭취량 없음)";
			}
		}
		// nutryPane
		contents2[0][0] = "영양성분(단위)";
		contents2[0][1] = "함량";
		contents2[0][2] = "  ";
//		contents2[0][2] = "  "+ slcData.getUnit();
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

		nutri = DAO.nutriList(codeStr);
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
		
		model2 = new DefaultTableModel(contents2, header2);
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
		nutriTable.getTableHeader().setReorderingAllowed(false); //  컬럼의 이동 불가.
		nutriTable.getTableHeader().setResizingAllowed(false); // 컬럼의 사이즈 변경 불가.
		// null 값인 행 삭제
		for (int i = 2; i < model2.getRowCount(); i++) {
			System.out.println(
					"model3.getValueAt(" + i + ", 1)" + model2.getValueAt(i, 1));
			if (model2.getValueAt(i, 1) == null) {
				model2.removeRow(i--);
				// 지워지는 행의 자리를 뒷 행이 바로 채우기 때문에 지워지는 행으로부터 -1 하여 다시 탐색하기! arrayList와 비슷한 성질
			}
		}
		
		percentColValue = new String[model2.getRowCount()];

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

		nutriTable.getColumnModel().getColumn(0).setPreferredWidth(110);
//		nutriTable.getColumnModel().getColumn(1).setPreferredWidth(70);
		nutriTable.getColumnModel().getColumn(2).setPreferredWidth(90); // -35
		nutriTable.getColumnModel().getColumn(3).setPreferredWidth(120); // -55

		tf.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				try {
					char c = ke.getKeyChar();
					JTextField src = (JTextField) ke.getSource();
					
					if(src.getText().length() >= 5) { // 값 길이 제한
						ke.consume();
					} else if(!Character.isDigit(c)) { // 숫자만 입력받을 수 있도록!
						ke.consume();
					}
				} catch(ClassCastException e) {
						
					
				}
			}
		});
		
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(startCount == 0) {
					// 적용버튼 클릭 시 처음 column 값 세이브 해놓기
					for(int i = 1; i < model2.getRowCount(); i++) {
						percentColValue[i] = model2.getValueAt(i, 3) + "";
					}
				}
				
				System.out.println(tf.getText());
				
				if(!tf.getText().isEmpty()) {
					model2.setValueAt(tf.getText() + slcData.getUnit() + " 당", 0, 2);
					
					String portionStr = slcData.getPortionSize();
					double tfNum = Double.parseDouble(tf.getText());
					double portionNum = Double.parseDouble(portionStr);
					
					setTfColume(tfNum, portionNum);
					startCount++;
				} else {
					JOptionPane.showMessageDialog(null, "입력 값이 없습니다.");
				}
			}
		});
		
		// textField 에 입력한 그람수에 따른 영양소 섭취량 저장하기!!!
		// DB 에 섭취한 양의 컬럼 생성?
		btnAddEat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat format = new SimpleDateFormat("YYYYMMDD");
				String today = format.format(new Date()); // 현재날짜 가져오기
				String[] addNutriKorArr = new String[model2.getRowCount()];
				String[] addNutriArr = new String[model2.getRowCount()];
				for(int i = 1; i < model2.getRowCount(); i++) {
					addNutriKorArr[i - 1] = model2.getValueAt(i, 0) + "";
					addNutriArr[i - 1] = model2.getValueAt(i, 2) + "";
					System.out.println(addNutriKorArr[i - 1] + "--" + addNutriArr[i - 1]);
				}
				
				System.out.println("날짜["+today+"] 아이디["+ id + "] 코드[" + codeStr + "] 섭취량[" + tf.getText() + slcData.getUnit() + "] 섭취칼로리[" + model2.getValueAt(1, 2) + "]");
				JOptionPane.showMessageDialog(null, "섭취하신 양 " + tf.getText() + slcData.getUnit() + "을 저장합니다.");
				
				
				boolean addResult = DAO.listAddNutriInsert(today, id, codeStr, tf.getText() + slcData.getUnit(), addNutriKorArr, addNutriArr);
				if(addResult == true) {
					JOptionPane.showMessageDialog(null, "오늘 섭취 내역에 저장되었습니다.");
				} else {
					System.out.println("저장 실패");
				}
			}
		});
		
		nutriPane = new JScrollPane(nutriTable);
		nutriPane.setBounds(10, 20, 480, 280);
		nutriPane.setBorder(new LineBorder(Color.white));

		northP.add(manuTf.getJTf());
		northP.add(nameTf.getJTf());
		northP.add(slcPane);
		
		southP.add(tf);
		southP.add(btnApply);
		southP.add(btnAddEat);

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

	public void setGenderAge(String id, String gender, String age) {
		this.id = id;
		this.gender = gender;
		this.age = age;
	}
	
	public void setTfColume(double tfNum, double portionNum) {
		double divNum = 0.0;
		for(int i = 1; i < model2.getRowCount(); i++) {
			model2.setValueAt(percentColValue[i], i, 3);
		}
		
		if(tfNum > portionNum) {
			divNum = portionNum / tfNum;
			
			for(int i = 1; i < model2.getRowCount(); i++) {
				double nutriNum = Double.parseDouble(model2.getValueAt(i, 1) + "");
				double result = nutriNum / divNum;
				String resultStr = result + "";
				if(resultStr.length() >= 6) {
					resultStr = resultStr.substring(0, 6);
				}
				model2.setValueAt(resultStr, i, 2);
				
				String pColStr = model2.getValueAt(i, 3) + "";
				if(pColStr.length() < 8) {
					pColStr = pColStr.substring(0, pColStr.length()-1);
					double resultPercent = Double.parseDouble(pColStr) / divNum;
					String resultPercentStr = resultPercent + "";
					if(resultPercentStr.length() >= 6) {
						resultPercentStr = resultPercentStr.substring(0, 5);
					}
					model2.setValueAt(resultPercentStr + "%", i, 3);
				}
			}
		} else if(tfNum < portionNum) {
			divNum = tfNum / portionNum;
			
			for(int i = 1; i < model2.getRowCount(); i++) {
				double nutriNum = Double.parseDouble(model2.getValueAt(i, 1) + "");
				double result = nutriNum * divNum;
				String resultStr = result + "";
				if(resultStr.length() >= 6) {
					resultStr = resultStr.substring(0, 6);
				}
				model2.setValueAt(resultStr, i, 2);
				
				String pColStr = model2.getValueAt(i, 3) + "";
				if(pColStr.length() < 8) {
					pColStr = pColStr.substring(0, pColStr.length()-1);
					double resultPercent = Double.parseDouble(pColStr) * divNum;
					String resultPercentStr = resultPercent + "";
					if(resultPercentStr.length() >= 6) {
						resultPercentStr = resultPercentStr.substring(0, 5);
					}
					model2.setValueAt(resultPercentStr + "%", i, 3);
				}
			}
		} else {
			for(int i = 1; i < model2.getRowCount(); i++) {
				String resultStr = model2.getValueAt(i, 1) + "";
				if(resultStr.length() >= 6) {
					resultStr = resultStr.substring(0, 6);
				}
				model2.setValueAt(resultStr, i, 2);
			}
		}
	}

//	public static void main(String[] args) {
//		MainDAO.connDB();
//
//		ProducDetailFrame plf = new ProducDetailFrame();
//		plf.setFoodCode("P084743");
//		plf.setGenderAge("여", "32");
//		plf.startFrame();
//	}
}
