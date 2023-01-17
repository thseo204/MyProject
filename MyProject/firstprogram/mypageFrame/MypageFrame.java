package mypageFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import mainFrame.ImagePanel;
import mainFrame.MainDAO;
import mainFrame.MyButton;
import mainFrame.MyFont;
import mainFrame.MyFrame;
import mainFrame.MyTextField;
import mypageDateFrame.MypageDateFrame;

public class MypageFrame extends MouseAdapter {
	private static final long serialVersionUID = 1L;
	private MyFrame f;
	private ImagePanel p;// userPhotoP;
	private MyButton mBtn;
	private MyFont mfont;
	private JPanel northP, southP, nutriP, eatP, btnInP1, btnInP2, photoP;
	private MyTextField titleTf, nameTf, ageGenderTf, nutriPTf, yearTf, monthTf;
	private JButton btnNutriInfo, btnEatInfo, btnBefore, btnNext, btnPhoto;
	private JLabel lbInBtn1, lbInBtn2;
	
	private JTable nutriTable, calTable;
	private JScrollPane nutriPane, calPane;
	private String userId, userName, userGender, userAge, today, yyyyStr, mmStr, ddStr;
	private String[] header = { " ", " ", " ", " " };
	private String[] headerCal = { " ", " ", " ", " ", " ", " ", " " };
	private DefaultTableModel model1, model2;
	private MyCalender mCal;
	private String[] calWeekName;
	private String[][] calDate;
	private String[] userNutriList;
	private String[] userKorNutriList, eatNutriList;
	private int todayYear, todayMonth, todayDate;
	private MainDAO DAO;
	private ImageIcon imgUser, imgUserC;

	public MypageFrame() {
		f = new MyFrame("제품 리스트_[뉴트리베터]");
		p = new ImagePanel(new ImageIcon(f.getBackImg()).getImage());
		
//		imgHomeC = new ImageIcon("./Button_image/NutriBetterC_Title.PNG");
		imgUser = new ImageIcon("./Button_image/userPhotoImage.png");
		mBtn = new MyButton();
		
		imgUserC = mBtn.changeImageSize(imgUser, 80, 80);
	
		btnPhoto = new JButton(mBtn.changeImageSize(imgUserC, 85, 80));
		
		photoP = new JPanel();
		
		DAO = new MainDAO();
//		DAO.connDB();

		northP = new JPanel();
		southP = new JPanel();
		nutriP = new JPanel();
		eatP = new JPanel();
		btnInP1 = new JPanel();
		btnInP2 = new JPanel();

		mfont = new MyFont();
		titleTf = new MyTextField("마이페이지", 20);
		btnNutriInfo = new JButton("");
		btnEatInfo = new JButton("");
		lbInBtn1 = new JLabel("영양소별 일일권장섭취량", JLabel.CENTER);
		lbInBtn2 = new JLabel("나의 섭취 내역", JLabel.CENTER);

		btnBefore = new JButton();
		btnNext = new JButton();
		
		SimpleDateFormat format = new SimpleDateFormat("YYYYMMDD");
		today = format.format(new Date()); // 현재날짜 가져오기
		yyyyStr = today.substring(0, 4);
		mmStr = today.substring(4, 6);
		ddStr = today.substring(6, 8);
		todayYear = Integer.valueOf(yyyyStr);
		todayMonth = Integer.valueOf(mmStr);
		todayDate = Integer.valueOf(ddStr);
		
		
	}

	public void startFrame() {
		f.startMyFrmae();
		f.startBackBtn();
		f.backBtnDispose();

		nameTf = new MyTextField(userName + " 님", 23);
		ageGenderTf = new MyTextField("만 " + userAge + "세 (" + userGender + ")", 15);
		nutriPTf = new MyTextField("* 만 " + userAge + "세 " + userGender + "성 기준", 15);
		
		
		northP.setLayout(null);
		northP.setBounds(0, 70, 500, 130);
		northP.setBackground(Color.WHITE);
		southP.setLayout(null);
		southP.setBounds(0, 200, 500, 365);
//		southP.setBackground(Color.WHITE);
//		southP.setBackground(new Color(255,250,240));

		nutriP.setLayout(null);
		nutriP.setBounds(4, 25, 492, 345);
		nutriP.setBackground(new Color(255, 250, 240));

		eatP.setLayout(null);
		eatP.setBounds(4, 25, 492, 345);
//		eatP.setBackground(new Color(255,255,240));
		eatP.setBackground(new Color(255, 255, 240));

		titleTf.getJTf().setFont(mfont.setFont(20));
		nameTf.getJTf().setFont(mfont.setFont(20));
		ageGenderTf.getJTf().setFont(mfont.setFont(20));
		titleTf.getJTf().setForeground(Color.GRAY);
		titleTf.getJTf().setBounds(30, 10, 100, 17);
		nameTf.getJTf().setBounds(180, 48, 120, 20);
		ageGenderTf.getJTf().setBounds(180, 82, 150, 20);
		
		btnPhoto.setBounds(0, 0, 80, 80);
		photoP.setLayout(null);
		photoP.setBounds(70, 35, 80, 80);

		nutriPTf.getJTf().setFont(mfont.setFont(13));
		nutriPTf.getJTf().setForeground(Color.GRAY);
		nutriPTf.getJTf().setBounds(20, 10, 200, 15);
		nutriPTf.getJTf().setBackground(null);

		// 클릭되었을때 버튼 색 혹은 버튼 테두리 색 바뀌게 하기
		btnNutriInfo.setBounds(5, 0, 245, 27);
		btnNutriInfo.setForeground(Color.darkGray);
//		btnNutriInfo.setBorder(new LineBorder(new Color(210,180,140), 3, true));
		btnEatInfo.setBounds(250, 0, 245, 27);
		btnEatInfo.setForeground(Color.darkGray);
//		btnEatInfo.setBorder(new LineBorder(new Color(210,180,140), 3, true));
		btnNutriInfo.setBorder(new LineBorder(Color.DARK_GRAY, 3, true));
		btnEatInfo.setBorder(new LineBorder(Color.lightGray, 3, true));

		btnBefore.setBounds(150, 13, 30, 20);
		btnBefore.setForeground(Color.DARK_GRAY);
		btnBefore.setBorder(new LineBorder(new Color(210, 180, 140), 2, false));
		btnNext.setBounds(300, 13, 30, 20);
		btnNext.setForeground(Color.DARK_GRAY);
		btnNext.setBorder(new LineBorder(new Color(210, 180, 140), 2, false));

		JPanel panelInBeforeBtn = new JPanel();
		JPanel panelInNextBtn = new JPanel();
		panelInBeforeBtn.setLayout(null);
		panelInNextBtn.setLayout(null);
		panelInBeforeBtn.setBackground(new Color(210, 180, 140));
		panelInNextBtn.setBackground(new Color(210, 180, 140));
		
		JLabel lbInBeforeBtn =  new JLabel("<", JLabel.CENTER);
		JLabel lbInNextBtn =  new JLabel(">", JLabel.CENTER);
		lbInBeforeBtn.setBounds(0, 0, 25, 15);
		lbInNextBtn.setBounds(0, 0, 25, 15);
		lbInBeforeBtn.setFont(mfont.setFont(20));
		lbInNextBtn.setFont(mfont.setFont(20));
		lbInBeforeBtn.setForeground(Color.white);
		lbInNextBtn.setForeground(Color.white);
		panelInBeforeBtn.add(lbInBeforeBtn);
		panelInNextBtn.add(lbInNextBtn);
		btnBefore.add(panelInBeforeBtn);
		btnNext.add(panelInNextBtn);
		
		btnInP1.setLayout(null);
		btnInP1.setBounds(0, 0, 245, 27);
		btnInP1.setBackground(Color.DARK_GRAY);
		btnInP2.setLayout(null);
		btnInP2.setBounds(0, 0, 245, 27);
		btnInP2.setBackground(Color.WHITE);

		lbInBtn1.setFont(mfont.setFont(13));
		lbInBtn2.setFont(mfont.setFont(13));
		lbInBtn1.setBounds(0, 0, 245, 20);
		lbInBtn1.setForeground(Color.WHITE);
		lbInBtn2.setBounds(0, 0, 245, 20);
		lbInBtn2.setForeground(Color.GRAY);

		btnInP1.add(lbInBtn1);
		btnInP2.add(lbInBtn2);
		btnNutriInfo.add(btnInP1);
		btnEatInfo.add(btnInP2);

		btnNutriInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				southP.setBackground(new Color(255,250,240));
				btnInP1.setBackground(Color.DARK_GRAY);
				btnInP2.setBackground(Color.WHITE);
				lbInBtn1.setForeground(Color.WHITE);
				lbInBtn2.setForeground(Color.GRAY);
				btnNutriInfo.setBorder(new LineBorder(Color.DARK_GRAY, 3, true));
				btnEatInfo.setBorder(new LineBorder(Color.lightGray, 3, true));
				eatP.setVisible(false);
				nutriP.setVisible(true);
			}
		});
		btnEatInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				southP.setBackground(new Color(255,255,240));
				btnInP1.setBackground(Color.WHITE);
				btnInP2.setBackground(Color.DARK_GRAY);
				lbInBtn1.setForeground(Color.GRAY);
				lbInBtn2.setForeground(Color.WHITE);
				btnNutriInfo.setBorder(new LineBorder(Color.lightGray, 3, true));
				btnEatInfo.setBorder(new LineBorder(Color.DARK_GRAY, 3, true));
				nutriP.setVisible(false);
				eatP.add(calPane);
				eatP.add(btnBefore);
				eatP.add(yearTf.getJTf());
				eatP.add(monthTf.getJTf());
				eatP.add(btnNext);
				eatP.setVisible(true);
				southP.add(eatP);
			}
		});

		btnBefore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String yearStr = yearTf.getJTf().getText();
				String monthStr = monthTf.getJTf().getText();
				int year = Integer.valueOf(yearStr);
				int month = Integer.valueOf(monthStr);

				if (month == 1) {
					year--;
					month = 12;
					yearTf.getJTf().setText(year + "");
					monthTf.getJTf().setText(month + "");
				} else {
					month--;
					if (month < 10) {
						monthTf.getJTf().setText("0" + month + "");
					} else {
						monthTf.getJTf().setText(month + "");
					}
				}
				setCal(year, month);
//				setKcalInTodayCal();
				setKcalInAllDayCal();
			}
		});
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String yearStr = yearTf.getJTf().getText();
				String monthStr = monthTf.getJTf().getText();
				int year = Integer.valueOf(yearStr);
				int month = Integer.valueOf(monthStr);

				if (month == 12) {
					year++;
					month = 1;
					yearTf.getJTf().setText(year + "");
					monthTf.getJTf().setText("0" + month + "");
				} else {
					month++;
					if (month < 10) {
						monthTf.getJTf().setText("0" + month + "");
					} else {
						monthTf.getJTf().setText(month + "");
					}
				}
				setCal(year, month);
//				setKcalInTodayCal();
				setKcalInAllDayCal();
			}
		});

		Border border = new LineBorder(new Color(210, 180, 140), 1, true);

		String[][] contents1 = new String[75][header.length];
		for (int i = 0; i < contents1.length; i++) {
			for (int j = 0; j < contents1[i].length; j++) {
				contents1[i][j] = "-";
			}
		}
		// nutryPane
		contents1[0][0] = "영양성분(단위)";
		contents1[0][1] = "권장섭취량";
		contents1[0][2] = "현재 섭취량";
		contents1[0][3] = "비고";

		contents1[1][0] = "총 열량(Kcal)";
		int userKcal = DAO.userKcal(userGender, userAge);
		contents1[1][1] = userKcal + "Kcal";
		double eatKacl = DAO.listTodayEat(today, userId, 'k');
		contents1[1][2] = eatKacl + "";
		double divKcal = userKcal - eatKacl;
		contents1[1][3] = divKcal + "";


//		userNutriList = DAO.userNutriList(userGender, userAge);
//		userKorNutriList = DAO.userNutriList("성별", "나이");
//		String[] eatNutriList = DAO.listTodayEat(today, userId);


		System.out.println("userGender : " + userGender + "\tuserAge : " + userAge);

		// 영양소 이름 0번 열에
		for (int i = 0; i < userKorNutriList.length; i++) {
			contents1[i + 2][0] = userKorNutriList[i];
			System.out.print("0번열 " + contents1[i + 2][0] + "\t");
		}
		System.out.println();
		// 각 영양소의 함량 1번 열에
		for (int i = 0; i < userNutriList.length; i++) {
			if(userNutriList[i] != null) {
				contents1[i + 2][1] = userNutriList[i];
			}
			if(eatNutriList[i] != null) {
				contents1[i + 2][2] = eatNutriList[i];
			}

			System.out.print("1번열 " + contents1[i + 2][1] + "\t");
			System.out.print("2번열 " + contents1[i + 2][2] + "\t");
		}
		System.out.println();
		model1 = new DefaultTableModel(contents1, header);
		nutriTable = new JTable(model1) {
			private static final long serialVersionUID = 1L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				// TODO Auto-generated method stub
				JComponent component = (JComponent) super.prepareRenderer(renderer, row, column);
				if (!isRowSelected(row)) {
					component.setBackground(row == 0 ? new Color(240, 230, 140) : Color.WHITE);
					component.setForeground(row == 0 ? Color.black : Color.DARK_GRAY);
					if (row == 1) {
						component.setBackground(new Color(255, 250, 205));
					}
				}
				if (!isCellSelected(row, column)) {
					if (column == 0 && row != 0 && row != 1) {
						component.setFont(mfont.setFont(11));
						component.setForeground(Color.BLACK);
						component.setBackground(new Color(250, 235, 215));
//						if(column == 2) {
//							component.setForeground(Color.blue);
//						}
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
		for (int i = 2; i < model1.getRowCount(); i++) {
//			System.out.println("model3.getValueAt(" + i + ", 1)" + model1.getValueAt(i, 1));
			if (model1.getValueAt(i, 1) == null && model1.getValueAt(i, 2) == null) {
				model1.removeRow(i--);
				// 지워지는 행의 자리를 뒷 행이 바로 채우기 때문에 지워지는 행으로부터 -1 하여 다시 탐색하기! arrayList와 비슷한 성질
			}
		}
//		for (int i = 0; i < model1.getRowCount(); i++) {
//			double userD = Double.parseDouble(userNutriList[i]);
//			double eatD = Double.parseDouble(eatNutriList[i]);
//			double result = userD - eatD;
//			contents1[i + 2][3] = String.valueOf(result);
//			if(contents1[i + 2][1] == null) {
//				contents1[i + 2][1] = "-";
//			} 
//		}

		// 테이블 가운데 정렬
		tableCellCenter(nutriTable);
//		MyDefaultTableCellRenderer();
//		getTableCellRendererComponent();
		// 행 높이 지정
		nutriTable.setRowHeight(40);
		nutriTable.setFont(mfont.setFont(13));
		nutriTable.setBorder(border);
		nutriTable.getTableHeader().setReorderingAllowed(false); //  컬럼의 이동 불가.
		nutriTable.getTableHeader().setResizingAllowed(false); // 컬럼의 사이즈 변경 불가.
		
		nutriTable.getColumnModel().getColumn(0).setPreferredWidth(110);
//		nutriTable.getColumnModel().getColumn(1).setPreferredWidth(70);
		nutriTable.getColumnModel().getColumn(2).setPreferredWidth(90); // -35
		nutriTable.getColumnModel().getColumn(3).setPreferredWidth(120); // -55

		nutriPane = new JScrollPane(nutriTable);
		nutriPane.setBounds(10, 30, 480, 300);
		nutriPane.setBorder(new LineBorder(Color.white));

		// 달력 ------------------------------------------------------------------
		System.out.println(today);
		System.out.println("yyyy = " + yyyyStr);
		System.out.println("mm = " + mmStr);
		System.out.println("dd = " + ddStr);

		yearTf = new MyTextField(yyyyStr, 15);
		monthTf = new MyTextField(mmStr, 15);

		yearTf.getJTf().setFont(mfont.setFont(18));
		yearTf.getJTf().setForeground(new Color(210, 180, 140));
		yearTf.getJTf().setBounds(200, 15, 50, 20);
		yearTf.getJTf().setBackground(null);
		monthTf.getJTf().setFont(mfont.setFont(18));
		monthTf.getJTf().setForeground(new Color(210, 180, 140));
		monthTf.getJTf().setBounds(260, 15, 30, 20);
		monthTf.getJTf().setBackground(null);

		setCal(todayYear, todayMonth);

		setKcalInAllDayCal();
		
		
		photoP.add(btnPhoto);
		northP.add(titleTf.getJTf());
		northP.add(photoP);
		northP.add(nameTf.getJTf());
		northP.add(ageGenderTf.getJTf());

		nutriP.add(nutriPane);
		nutriP.add(nutriPTf.getJTf());

		southP.add(btnNutriInfo);
		southP.add(btnEatInfo);
		southP.add(nutriP);
//		southP.add(eatP);

		p.add(northP);
		p.add(southP);
		p.add(f.getBackBtn());
		f.getMyFrame().add(p);
		f.getMyFrame().setVisible(true);
	}

	public void setUserInfo(String id, String name, String gender, String age) {
		userId = id;
		userName = name;
		userGender = gender;
		userAge = age;
		System.out.println("성별 : " + userGender + " 연령 : " + userAge);
		userNutriList = DAO.userNutriList(userGender, userAge);
		userKorNutriList = DAO.userNutriList("성별", "나이");
		eatNutriList = DAO.listTodayEat(today, userId);

	}

	private void tableCellCenter(JTable t) {
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = t.getColumnModel();

		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(centerRenderer);
		}
	}

	public void setCal(int year, int month) {
		mCal = new MyCalender(year, month);
		calWeekName = mCal.getWeekName();
		calDate = mCal.printMyCalender();

		String[][] contents2 = new String[calDate.length + 1][calWeekName.length];
		// 요일 이름 세팅
		for (int i = 0; i < contents2.length; i++) {
//			System.out.println(calWeekName[i] + "\t");
			contents2[0][i] = "  " + calWeekName[i];
		}
		// 날짜 셋팅
		for (int i = 1; i < contents2.length; i++) {
			for (int j = 0; j < contents2[i].length; j++) {
				contents2[i][j] = calDate[i - 1][j];
			}
		}

		model2 = new DefaultTableModel(contents2, headerCal);
		calTable = new JTable(model2) {
			private static final long serialVersionUID = 1L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				// TODO Auto-generated method stub
				JComponent component = (JComponent) super.prepareRenderer(renderer, row, column);
//				component.setFocusable(false);
				if (!isRowSelected(row)) {
					component.setBackground(row == 0 ? new Color(240, 230, 140) : Color.WHITE);
					component.setForeground(row == 0 ? Color.WHITE : Color.DARK_GRAY);
					component.setFont(row == 0 ? mfont.setFont(20) : mfont.setFont(10));
				} else {
					Object value = getModel().getValueAt(row, column);
					try {
					if(value.equals(" ")) {
//						component.setBackground(Color.green);
					} else {
						component.setBackground(row == 0 ? new Color(240, 230, 140) : Color.WHITE);
						component.setForeground(row == 0 ? Color.WHITE : Color.DARK_GRAY);
						component.setFont(row == 0 ? mfont.setFont(20) : mfont.setFont(10));
					}
					} catch(NullPointerException e) {
						
					}
					
				}
				return component;
			}

			
			
			// 테이블 수정 불가능 하게.
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// 칼로리 값이 있는 값 btn 넣어주기
		DefaultTableCellRenderer renderer = new MyRenderer();
		for(int i = 0; i < calTable.getColumnCount(); i++) {
			calTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
		}
		
		// 테이블의 그리드 선 색상
		calTable.setShowHorizontalLines(true); // 셀 수평선 유무
		calTable.setShowVerticalLines(false); // 셀 수직선 유무
		calTable.setGridColor(Color.LIGHT_GRAY);
//		calTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		calTable.getTableHeader().setReorderingAllowed(false); //  컬럼의 이동 불가.
		calTable.getTableHeader().setResizingAllowed(false); // 컬럼의 사이즈 변경 불가.
		calTable.setRowHeight(40);
		calTable.setRowHeight(0, 32);
		calTable.setFont(mfont.setFont(13));
		calTable.setBorder(new LineBorder(Color.white));
		calTable.addMouseListener(this);
		calPane = new JScrollPane(calTable);
		calPane.setBounds(10, 45, 480, 290);
		calPane.setBorder(new LineBorder(Color.white));
		
		eatP.add(calPane);
	}

	public void mouseClicked(MouseEvent e) {
		int row = calTable.getSelectedRow();
		int col = calTable.getSelectedColumn();
		String str = calTable.getModel().getValueAt(row, col)+"";
		String date = "";
		if(str.length() == 1) {
			date = "0" + str.substring(0, 1);
		} else {
			date = str.substring(0, 2);
		}
		String yyyymmdd = yearTf.getJTf().getText() + monthTf.getJTf().getText() + date;
		System.out.println("클릭한 날짜 : " + yyyymmdd + "\t");
		
		MypageDateFrame f = new MypageDateFrame();
		f.startFrame(userId, yyyymmdd);
	}
	
	// 오늘 제외한 이전 날짜들 달력에 총 칼로리 표시
	public void setKcalInAllDayCal() {
		String[] ymdArr = DAO.listUserKcalIInCal(userId);
		
		for(int k = 0; k < ymdArr.length; k++) {
			String Ymd = ymdArr[k];
			int kcal = DAO.listTodayEat(Ymd, userId, 'k');
			String yyyy = Ymd.substring(0, 4);
			String mm = Ymd.substring(4, 6);
			String dd = Ymd.substring(6, 8);
			int date = Integer.valueOf(dd);
			
			if(yearTf.getJTf().getText().equals(yyyy) && monthTf.getJTf().getText().equals(mm)) {
				for(int i = 1; i < calTable.getRowCount(); i++) {
					for(int j = 0; j < calTable.getColumnCount(); j++) {
						String dateStr = calTable.getModel().getValueAt(i, j) + "";
						if(dateStr.equals(date + "")) {
							
//							calTable.getModel().setValueAt(dateStr + " [" + kcal + "]", i, j);
							calTable.getModel().setValueAt(dateStr + "  *", i, j);

						}
					}
				}
			}
		}
	}
	
	
	
//	public class MyDefaultTableCellRenderer extends DefaultTableCellRenderer{
//		private static final long serialVersionUID = 1L;
//		
//		public MyDefaultTableCellRenderer() {
//			setHorizontalTextPosition(JLabel.CENTER);
//			setVerticalTextPosition(JLabel.BOTTOM);
//			setHorizontalAlignment(JLabel.CENTER);
//			setVerticalAlignment(JLabel.CENTER);
//		}
//		
//		@Override
//		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
//				int row, int col) {
//			JLabel lb = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
//			for(int i = 1; i < model1.getRowCount(); i++) {
//				for(int j = 0; j < model1.getColumnCount(); j++) {
//					Object res = model1.getValueAt(i, j);
//					if(res != null) {
//						int resInt = Integer.valueOf(res+"");
//						if(todayDate == resInt) {
//							setText(String.valueOf(model1.getValueAt(1, 2)));
//						}
//					}
//				}
//			}
//			return lb;
//		}
//	}
	
//	public static void main(String[] args) {
//		MypageFrame mf = new MypageFrame();
//		mf.setUserInfo("sth","신태현", "남", "21");
//		mf.startFrame();
//		mf.setKcal(12, "345");
//		mf.setCal(2023, 1);
//	}
}
