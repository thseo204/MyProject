package productListFrame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import listPanel.BigCtgComboBox;
//import listPanel.BigCtgDAO;
//import listPanel.ProcessedFoodDAO;
import listPanel.ProcessedFoodVo;
import mainFrame.ImagePanel;
import mainFrame.MainDAO;
import mainFrame.MyButton;
import mainFrame.MyFont;
import mainFrame.MyFrame;
import mainFrame.MyTextField;
import menuFrame.MenuFrame;
import productCompareFrame.ProductCompareFrame;
import productDetailInfoFrame.ProductDetailFrame;

// 해당 카테고리의 총 제품 갯수가 5 이하일때 갯수 이외의 CardListPBtn 은 나오지 않게 해야함!
public class ProductListFrame extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel cardPanel;
	private JPanel[] card;

	private MyFrame f;
	private ImagePanel p;
	private MyFont mfont;
	private MyTextField mTf;
	private MyButton myBtn;
	private ImageIcon imgMenu, imgMenuC, cMenu, imgSearch, imgSearchC, cSearch;
	private JButton btnMenu, btnSearch, btnNext, btnPre, btnCompare;
	private MyTextField totalNum, slcTf1, slcTf2;
	private int ctgNum, cardNum;

	private BigCtgComboBox comboBox;
	private ProductListFrame cardDemo;
	private ListPanelBtn[] listPBtn;
	private int j = 0, k = 0, dex, userKcal;
	private int[] index;
	private String ctgStr, slcStr1, slcStr2, codeStr1, codeStr2, name, id, gender, age;
	private boolean slcB1, slcB2;
	private LineBorder borderOrange, borderGray;

	private MainDAO DAO = new MainDAO();
	private ArrayList<ProcessedFoodVo> listFood;
//	private Iterator<ProcessedFoodVo> iter;

	public ProductListFrame() {

	}

	public ProductListFrame(String name, String id, String gender, String age) {
		this.name = name;
		this.id = id;
		this.gender = gender;
		this.age = age;
		this.userKcal = DAO.userKcal(gender, age);

		f = new MyFrame("제품 리스트_[뉴트리베터]");
		p = new ImagePanel(new ImageIcon(f.getBackNorthImg()).getImage());

		cardPanel = new JPanel(new CardLayout());
		slcStr1 = "";
		slcStr2 = "";
		codeStr1 = "";
		codeStr2 = "";
		mfont = new MyFont();
		mTf = new MyTextField();
		mTf.setTf("제품명을 검색하세요!");
		myBtn = new MyButton();
		totalNum = new MyTextField("총 11097 제품", 14);
		slcTf1 = new MyTextField("", 10);
		slcTf2 = new MyTextField("", 10);
		btnCompare = new JButton("비교하기");

		imgMenu = new ImageIcon("./Button_image/Button_menu.PNG");
		imgMenuC = new ImageIcon("./Button_image/ButtonC_img.PNG");
		imgSearch = new ImageIcon("./Button_image/Search_img.PNG");
		imgSearchC = new ImageIcon("./Button_image/SearchC_img.PNG");
		cSearch = myBtn.changeImageSize(imgSearchC, 30, 30);
		cMenu = myBtn.changeImageSize(imgMenuC, 30, 30);

		btnMenu = new JButton(myBtn.changeImageSize(imgMenu, 30, 30));
		btnSearch = new JButton(myBtn.changeImageSize(imgSearch, 30, 30));
		btnNext = new JButton(">>");
		btnPre = new JButton("<<");

		borderOrange = new LineBorder(Color.orange, 3, true);
		borderGray = new LineBorder(Color.lightGray, 3, true);

		comboBox = new BigCtgComboBox();
		ctgStr = comboBox.getList(0);
		setListFood(ctgStr);
		this.ctgNum = DAO.getSlcCtgN();
		setCardArr();
		setListPBtnArr();
		cardDemo = new ProductListFrame();
//		cardDemo = new ProductListFrame();
	}

	public void startFrame() {
		f.startMyFrame();
		f.backBtnDispose();
		f.getMyFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//		comboBox = new BigCtgComboBox();
//		ctgStr = comboBox.getList(0);
//		setListFood(ctgStr);
//		this.ctgNum = DAO.getSlcCtgN();
//		setCardArr();
//		setListPBtnArr();

//		cardDemo = new ProductListFrame(name, id, gender, age);
		cardDemo.setOpaque(true);
		f.getMyFrame().setLocationRelativeTo(null);
		f.getMyFrame().setSize(500, 600);
		f.getMyFrame().setResizable(false);
		f.getMyFrame().setLayout(new BorderLayout());

		cardDemo.setPreferredSize(new Dimension(500, 440));
		cardPanel.setPreferredSize(new Dimension(500, 395));

		btnMenu.setBounds(10, 15, 30, 30);
		mTf.getTf().setBounds(20, 80, 280, 30);
		btnSearch.setBounds(300, 80, 30, 30);

		comboBox.getComboBox().setBounds(330, 80, 160, 30);
		myBtn.buttonOption(btnSearch, cSearch);
		myBtn.buttonOption(btnMenu, cMenu);
		totalNum.getJTf().setFont(mfont.setFont(15));
		totalNum.getJTf().setBounds(30, 130, 120, 20);
		totalNum.getJTf().setBorder(null);
		slcTf1.getJTf().setFont(mfont.setFont(10));
		slcTf1.getJTf().setBounds(205, 125, 200, 13);
		slcTf1.getJTf().setBorder(null);
		slcTf1.getJTf().setForeground(new Color(204, 102, 0));
		slcTf1.getJTf().setHorizontalAlignment(JLabel.RIGHT);
		slcTf2.getJTf().setFont(mfont.setFont(10));
		slcTf2.getJTf().setBounds(205, 140, 200, 13);
		slcTf2.getJTf().setBorder(null);
		slcTf2.getJTf().setForeground(new Color(204, 51, 0));
		slcTf2.getJTf().setHorizontalAlignment(JLabel.RIGHT);
		btnCompare.setBounds(410, 120, 60, 35);
		btnCompare.setFont(mfont.setFont(12));
		btnCompare.setBorder(new LineBorder(new Color(210, 180, 140), 3, true));

		setListCardP(j);
		CardLayout cl = (CardLayout) cardPanel.getLayout();

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if (mTf.getTf().getText().equals("제품명을 검색하세요!") || mTf.getTf().getText().equals(null)) {
					JOptionPane.showMessageDialog(null, "검색할 제품 이름을 입력하세요.");
				} else {
					setSearchTf(mTf.getTf().getText());
					setListCardP(j);
					ctgNum = DAO.getSlcCtgN();
					totalNum.getJTf().setText("총 " + ctgNum + " 제품");

					if (j > 0) {
						do {
							cl.previous(cardPanel);
							j -= 5;
							k -= 1;
							setListCardP(j);
						} while (j != 0 && k != 0);
					}
				}
				}catch(NullPointerException ne) {
			}
				
			}
		});

		btnCompare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (slcB1 == true && slcB2 == true) {
					ProductCompareFrame pcf = new ProductCompareFrame();
//					pcf.setSlcStr(slcStr1, slcStr2);
					pcf.setSlcStr(codeStr1, codeStr2);
					pcf.setGenderAge(gender, age);
					pcf.startFrame();
					
//					slcB1 = false;
//					slcB2 = false;
//					slcTf1.getJTf().setText("");
//					slcTf2.getJTf().setText("");

//					for (int i = 0; i < 5; i++) {
//						listPBtn[i].getMiniBtn().setBorder(borderGray);
//						listPBtn[i].setLbSelect("선택");
//						listPBtn[i].getLbSelect().setForeground(Color.black);
//					}
					
				} else {
					JOptionPane.showMessageDialog(null, "2가지 제품을 선택하세요.");
				}
			}
		});

		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFrame mf = new MenuFrame();
				mf.setGenderAge(id, gender, age);
				mf.setNameLb(name);
				mf.startFrame();
			}
		});

		// 해당 카테고리의 총 제품 갯수가 5 이하일때 갯수 이외의 CardListPBtn 은 나오지 않게 해야함!
		comboBox.getComboBox().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
//				cl.first(cardPanel);
				if (e.getStateChange() == ItemEvent.SELECTED) {
					slcB1 = false;
					slcB2 = false;
					slcTf1.getJTf().setText("");
					slcTf2.getJTf().setText("");

					for (int i = 0; i < 5; i++) {
						listPBtn[i].getMiniBtn().setBorder(borderGray);
						listPBtn[i].setLbSelect("선택");
						listPBtn[i].getLbSelect().setForeground(Color.black);
					}
					try {
						ctgStr = e.getItem().toString();
						setListFood(ctgStr);
						ctgNum = DAO.getSlcCtgN();

						System.out.println(ctgStr + "&&&&&&&&&&&");
						// 해당 카테고리의 제품 수
						setListCardP(j);
						System.out.println("k : " + k + "|| j : " + j);
						totalNum.getJTf().setText("총 " + ctgNum + " 제품");

						// comboBox 값이 바뀌면 해당 카테고리에서 cardPanel 처음으로 이동
						if (j > 0) {
							do {
								cl.previous(cardPanel);
								j -= 5;
								k -= 1;
								setListCardP(j);
							} while (j != 0 && k != 0);
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				j += 5;
				if (j >= ctgNum) {
					j -= 5;
					JOptionPane.showMessageDialog(null, "마지막 목록입니다.");
				} else {
					cl.next(cardPanel);
					k += 1;
					setListCardP(j);
				}
			}
		});
		btnPre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				j -= 5;
				if (j < 0) {
					j = 0;
					JOptionPane.showMessageDialog(null, "처음 목록입니다.");
				} else {
					cl.previous(cardPanel);
					k -= 1;
					setListCardP(j);
				}
			}
		});

		for (int i = 0; i < cardNum; i++) {
			cardPanel.add(card[i]);
		}
		cardPanel.setBackground(new Color(255, 250, 240));
		cardDemo.setBackground(new Color(255, 250, 240));
		// 영역확인하기 위해 색 지정 하였음.
//		cardDemo.setBackground(Color.DARK_GRAY);
//		cardDemo.setBackground(Color.white);

		btnPre.setBounds(260, 395, 40, 35);
		btnNext.setBounds(220, 395, 40, 35);

		cardDemo.add(cardPanel);
		cardDemo.add(btnPre);
		cardDemo.add(btnNext);

		p.add(btnMenu);
		p.add(mTf.getTf());
		p.add(comboBox.getComboBox());
		p.add(btnSearch);
		p.add(totalNum.getJTf());
		p.add(slcTf1.getJTf());
		p.add(slcTf2.getJTf());
		p.add(btnCompare);
		f.getMyFrame().add("North", p);
		f.getMyFrame().add("Center", cardDemo);
		f.getMyFrame().pack();
		f.getMyFrame().setVisible(true);
	}

	public void setCardArr() {
		cardNum = 0;
		if (ctgNum % 5 == 0) {
			cardNum = ctgNum / 5;
		} else {
			cardNum = ctgNum / 5 + 1;
		}

		card = new JPanel[cardNum];

		for (int i = 0; i < cardNum; i++) {
			card[i] = new JPanel();
			card[i].setLayout(null);
//			card[i].setBackground(Color.white);
			card[i].setBackground(new Color(255, 250, 240));
		}
	}

	public void setListPBtnArr() {
		listPBtn = new ListPanelBtn[ctgNum];
		index = new int[ctgNum];
		for (int i = 0; i < ctgNum; i++) {
			listPBtn[i] = new ListPanelBtn();
			listPBtn[i].getMiniBtn().addActionListener(this);
			listPBtn[i].getMiniBtn().setBorder(borderGray);

			listPBtn[i].getTotalBtn().setText("버튼" + i);
			listPBtn[i].getTotalBtn().setBackground(null);
			;
			listPBtn[i].getTotalBtn().addActionListener(this);
		}
	}

	@SuppressWarnings("deprecation")
	public void setListCardP(int j) {
		System.out.println("********해당 카테고리 <<" + ctgStr + ">> ");

		System.out.println("ListPBtn 생성 완료");
		Iterator<ProcessedFoodVo> iter = listFood.iterator();
		System.out.println(iter.hasNext());
		System.out.println("[j]의 값은 -- [" + j + "] --");
		System.out.println("[k]의 값은 -- [" + k + "] --");

		int g = 0;

		for (int i = 0; i < 5; i++) {

			if (!iter.hasNext()) {
				break;
			} else {
				try {
					iter.next();
					String manu = listFood.get(j).getManufacturer();
					String name = listFood.get(j).getFoodName();
					String kcal = listFood.get(j).getKcal() + "";
					String code = listFood.get(j).getFoodCode();
					double percent = ((Double.valueOf(kcal)) / userKcal) * 100;
//					String percentStr = String.valueOf(percent).substring(0, 4);
					String percentStr = String.valueOf(percent);
					if (percentStr.length() >= 5) {
						percentStr = percentStr.substring(0, 5);
					}
					System.out.println("************" + j + "***************");
					System.out.print(manu + "\t");
					System.out.print(name + "\t");
					System.out.println(kcal + "\t");
					index[j] = j;
					listPBtn[j].setListPanel(manu, name, kcal, percentStr, code);
					listPBtn[j].startListPanel();

					listPBtn[j].getPanel().setBounds(20, 80 * g++, 460, 75);
//					listPBtn[j].getMiniBtn().setLabel(name);
					listPBtn[j].getMiniBtn().setLabel("" + j);
					card[k].add(listPBtn[j].getPanel());

//					listPBtn[i].getTotalBtn().setText("버튼" + i);
//					listPBtn[i].getTotalBtn().addActionListener(this);
//					listPBtn[i].setFoodCode(code);
				} catch (Exception e) {

				}
				j++;
			}
		}
	}

	public void actionPerformed(ActionEvent e) {

		String eStr = e.getActionCommand();
		System.out.println(eStr);
		if (Character.isDigit(eStr.charAt(0))) {
			for (int i = 0; i < listPBtn.length; i++) {
//			listFood.get(i)

				if (e.getActionCommand().equals("" + i)) {
					dex = i;
				}
			}
			System.out.println("dex = [" + dex + "]");

			if (slcStr1.equals(listPBtn[dex].getLbName())) {
				slcStr1 = "";
				codeStr1 = "";
				slcB1 = false;
				slcTf1.getJTf().setText("");
				listPBtn[dex].getMiniBtn().setBorder(borderGray);
				listPBtn[dex].setLbSelect("선택");
				listPBtn[dex].getLbSelect().setForeground(Color.black);

				System.out.println("버튼 [0]개 선택, 선택된 제품 은 [" + slcStr1 + "]");
				System.out.println("              선택된 코드는 [" + codeStr1 + "]");

			} else if (slcStr2.equals(listPBtn[dex].getLbName())) {
				slcStr2 = "";
				codeStr2 = "";
				slcB2 = false;
				slcTf2.getJTf().setText("");
				listPBtn[dex].getMiniBtn().setBorder(borderGray);
				listPBtn[dex].setLbSelect("선택");
				listPBtn[dex].getLbSelect().setForeground(Color.black);

				System.out.println("버튼 [1]개 선택, 선택된 제품 은 [" + slcStr1 + "]");
				System.out.println("              선택된 코드는 [" + codeStr1 + "]");

			} else if (slcStr1.equals("")) {
				if (e.getActionCommand().equals("" + dex)) {
					slcStr1 = listPBtn[dex].getLbName();
					codeStr1 = listPBtn[dex].getBtnFoodCode();
					slcB1 = true;
					slcTf1.getJTf().setText("[1] " + slcStr1);
					listPBtn[dex].getMiniBtn().setBorder(borderOrange);
					listPBtn[dex].setLbSelect("v");
					listPBtn[dex].getLbSelect().setForeground(Color.orange);

					System.out.println("버튼 [1]개 선택, 선택된 제품 은 [" + slcStr1 + "]");
					System.out.println("              선택된 코드는 [" + codeStr1 + "]");
				}
			} else if (!slcStr1.equals("") && slcStr2.equals("")) {
				if (e.getActionCommand().equals("" + dex)) {
					slcStr2 = listPBtn[dex].getLbName();
					codeStr2 = listPBtn[dex].getBtnFoodCode();
					slcB2 = true;
					slcTf2.getJTf().setText("[2] " + slcStr2);
					listPBtn[dex].getMiniBtn().setBorder(borderOrange);
					listPBtn[dex].setLbSelect("v");
					listPBtn[dex].getLbSelect().setForeground(Color.orange);

					System.out.println("버튼 [2]개 선택, 선택된 제품 은 [" + slcStr1 + "], [" + slcStr2 + "]");
					System.out.println("              선택된 코드는 [" + codeStr1 + "], [" + codeStr2 + "]");
//				System.out.println("-------버튼 넘버 : " + listPBtn[dex].getMiniBtn().getText());
				}
			} else if (slcB1 == true && slcB2 == true) {
				JOptionPane.showMessageDialog(null, "2가지 제품만 선택 가능합니다.");
			}
		} else {
			System.out.println("선택된 버튼 번호 : " + e.getActionCommand());
			eStr = eStr.substring(2);
			int i = Integer.valueOf(eStr);
			System.out.println("선택된 버튼 i : " + i);
			String foodCode = listPBtn[i].getBtnFoodCode();

			System.out.println("선택된 푸드 코드 " + foodCode);
			ProductDetailFrame df = new ProductDetailFrame();
			df.setFoodCode(foodCode);
			df.setGenderAge(id, gender, age);
			df.startFrame();
		}
	}

	public void setListFood(String ctgStr) {
		listFood = DAO.list(ctgStr);
	}

	public void setSearchTf(String tfText) {
		mTf.getTf().setText(tfText);
		setSearchListFood(tfText);
	}

	public void setSearchListFood(String tfText) {
		listFood = DAO.listSearch(tfText);
	}

//	public static void main(String[] args) {
//		MainDAO.connDB();
//		ProductListFrame plf = new ProductListFrame("","", "여", "32");
//		plf.startFrame();
//	}
}