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
import mainframe.MyButton;
import mainframe.ImagePanel;
import mainframe.Main;
import mainframe.MainDAO;
import mainframe.MyFont;
import mainframe.MyFrame;
import mainframe.MyTextField;
import menuFrame.MenuFrame;
import productCompareFrame.ProductCompareFrame;

// 해당 카테고리의 총 제품 갯수가 5 이하일때 갯수 이외의 CardListPBtn 은 나오지 않게 해야함!
public class ProductListFrame extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel cardPanel;
	private JPanel[] card;

	private MyFrame f;
	private ImagePanel p;
	private MyFont mfont;
	private MyButton myBtn;
	private ImageIcon imgMenu, imgMenuC, cMenu, imgSearch, imgSearchC, cSearch;
	private JButton btnMenu, btnSearch, btnNext, btnPre;
	private MyTextField totalNum, slcTf1, slcTf2;
	private JButton btnCompare;
	private String ctgStr;
	private int ctgNum, cardNum;

	private BigCtgComboBox comboBox;
	private ProductListFrame cardDemo;
	private ListPanelBtn[] listPBtn;
	private int j = 0, k = 0, dex;
	private int[] index;
	private String slcStr1, slcStr2, codeStr1, codeStr2;
	private boolean slcB1, slcB2;
	private LineBorder borderOrange, borderGray;

//	private ProcessedFoodDAO dao;
	private MainDAO DAO = new MainDAO();
	private ArrayList<ProcessedFoodVo> listFood;
	private Iterator<ProcessedFoodVo> iter;
	
	private String gender;
	private String age;
	private int userKcal;

	public ProductListFrame(String gender, String age) {
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
		mfont.setTf("제품명을 검색하세요!");
		myBtn = new MyButton();
		totalNum = new MyTextField("총 11097 제품", 14);
		slcTf1 = new MyTextField("", 10);
		slcTf2 = new MyTextField("", 10);
		btnCompare = new JButton("비교하기");

		comboBox = new BigCtgComboBox();

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

		ctgStr = comboBox.getComboBoxItem();
//		listFood = DAO.list(ctgStr);
		setListFood(ctgStr);
		this.ctgNum = DAO.getSlcCtgN();
//		setCtgNum();
		setCardArr();
		setListPBtnArr();

//		dao = new ProcessedFoodDAO();
//		DAO = new MainDAO();//

	}

	public void startFrame() {
		f.startMyFrmae();
		f.backBtnDispose();
//		f.getMyFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cardDemo = new ProductListFrame(gender, age);
		cardDemo.setOpaque(true);
		f.getMyFrame().setLocationRelativeTo(null);
		f.getMyFrame().setSize(500, 600);
		f.getMyFrame().setResizable(false);
		f.getMyFrame().setLayout(new BorderLayout());

		cardDemo.setPreferredSize(new Dimension(500, 440));
		cardPanel.setPreferredSize(new Dimension(500, 395));

		btnMenu.setBounds(10, 15, 30, 30);
		mfont.getTf().setBounds(20, 80, 280, 30);
		btnSearch.setBounds(300, 80, 30, 30);

		comboBox.getComboBox().setBounds(330, 80, 160, 30);
		myBtn.buttonOption(btnSearch, cSearch);
		myBtn.buttonOption(btnMenu, cMenu);
		totalNum.getJTf().setFont(mfont.setFont(15));
		totalNum.getJTf().setBounds(30, 130, 120, 20);
		totalNum.getJTf().setBorder(null);
		slcTf1.getJTf().setFont(mfont.setFont(10));
		slcTf1.getJTf().setBounds(180, 125, 200, 13);
		slcTf1.getJTf().setBorder(null);
		slcTf1.getJTf().setForeground(new Color(204, 102, 0));
		slcTf1.getJTf().setHorizontalAlignment(JLabel.RIGHT);
		slcTf2.getJTf().setFont(mfont.setFont(10));
		slcTf2.getJTf().setBounds(180, 140, 200, 13);
		slcTf2.getJTf().setBorder(null);
		slcTf2.getJTf().setForeground(new Color(204, 51, 0));
		slcTf2.getJTf().setHorizontalAlignment(JLabel.RIGHT);
		btnCompare.setBounds(390, 120, 80, 40);

		setListCardP(j);

		btnCompare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (slcB1 == true && slcB2 == true) {
					ProductCompareFrame pcf = new ProductCompareFrame();
//					pcf.setSlcStr(slcStr1, slcStr2);
					pcf.setSlcStr(codeStr1, codeStr2);
					pcf.setGenderAge(gender, age);
					pcf.startFrame();
				} else {
					JOptionPane.showMessageDialog(null, "2가지 제품을 선택하세요.");
				}
			}
		});

		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFrame mf = new MenuFrame();
				mf.startFrame(true);
			}
		});

		CardLayout cl = (CardLayout) cardPanel.getLayout();

		// 해당 카테고리의 총 제품 갯수가 5 이하일때 갯수 이외의 CardListPBtn 은 나오지 않게 해야함!
		comboBox.getComboBox().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
//					cl.first(cardPanel);
					for (int i = 0; i < 5; i++) {
						listPBtn[i].getMiniBtn().setText("선택");
						listPBtn[i].getMiniBtn().setBorder(borderGray);

					}
					try {
//						k = 0;
//						j = 0;
//						cl.first(cardPanel);

//						setCtgNum();
//						setCardArr();
//						setListPBtnArr();
						ctgStr = e.getItem().toString();
//						listFood = DAO.list(ctgStr);
						setListFood(ctgStr);
						System.out.println(ctgStr + "&&&&&&&&&&&");
						// 해당 카테고리의 제품 수
						ctgNum = DAO.getSlcCtgN();
						setListCardP(j);
						totalNum.getJTf().setText("총 " + ctgNum + " 제품");
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
		// 영역확인하기 위해 색 지정 하였음.
//		cardDemo.setBackground(Color.DARK_GRAY);
//		cardDemo.setBackground(Color.white);

		btnPre.setBounds(260, 395, 40, 35);
		btnNext.setBounds(220, 395, 40, 35);

		cardDemo.add(cardPanel);
		cardDemo.add(btnPre);
		cardDemo.add(btnNext);

		p.add(btnMenu);
		p.add(mfont.getTf());
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
		}
	}

	public void setListPBtnArr() {
		listPBtn = new ListPanelBtn[ctgNum];
		index = new int[ctgNum];
		for (int i = 0; i < ctgNum; i++) {
			listPBtn[i] = new ListPanelBtn();
			listPBtn[i].getMiniBtn().addActionListener(this);
			listPBtn[i].getMiniBtn().setBorder(borderGray);
		}
	}

	public void setListCardP(int j) {
		int n = DAO.getSlcCtgN();
		System.out.println("********해당 카테고리 <<" + ctgStr + ">> 의 행 갯수" + n);

		System.out.println("ListPBtn 생성 완료");
		Iterator<ProcessedFoodVo> iter = listFood.iterator();
		System.out.println(iter.hasNext());
		System.out.println("[j]의 값은 -- [" + j + "] --");

		int g = 0;

		for (int i = 0; i < 5; i++) {

//			if (listFood.isEmpty()) {
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
					if(percentStr.length() >= 5) {
						percentStr = percentStr.substring(0, 5);
					}
					System.out.println("****************" + j + "***************");
					System.out.print(manu + "\t");
					System.out.print(name + "\t");
					System.out.println(kcal + "\t");
					index[j] = j;
					listPBtn[j].setListPanel(manu, name, kcal, percentStr, code);
					listPBtn[j].startListPanel();
					System.out.println("[" + n + "]");
					listPBtn[j].getPanel().setBounds(20, 80 * g++, 460, 75);
//					listPBtn[j].getMiniBtn().setLabel(name);
					listPBtn[j].getMiniBtn().setLabel("" + j);
					card[k].add(listPBtn[j].getPanel());
				} catch (Exception e) {

				}
				j++;
			}
		}

	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < listPBtn.length; i++) {
//			listFood.get(i)

			if (e.getActionCommand().equals("" + i)) {
				dex = i;
			}
		}
		System.out.println("dex = [" + dex + "]");
//		System.out.println(e.hashCode() + "\t" +  listPBtn[dex].getMiniBtn().hashCode());
		if (slcStr1.equals(listPBtn[dex].getLbName())) {
			slcStr1 = "";
			codeStr1 = "";
			slcB1 = false;
			slcTf1.getJTf().setText("");
//			listPBtn[dex].getMiniBtn().setText(""+ dex);
			listPBtn[dex].getMiniBtn().setBorder(borderGray);

			System.out.println("버튼 [0]개 선택, 선택된 제품 은 [" + slcStr1 + "]");
			System.out.println("              선택된 코드는 [" + codeStr1 + "]");

		} else if (slcStr2.equals(listPBtn[dex].getLbName())) {
			slcStr2 = "";
			codeStr2 = "";
			slcB2 = false;
			slcTf2.getJTf().setText("");
//			listPBtn[dex].getMiniBtn().setText(""+ dex);
			listPBtn[dex].getMiniBtn().setBorder(borderGray);

			System.out.println("버튼 [1]개 선택, 선택된 제품 은 [" + slcStr1 + "]");
			System.out.println("              선택된 코드는 [" + codeStr1 + "]");

		} else if (slcStr1.equals("")) {
			if (e.getActionCommand().equals(""+ dex)) {
				slcStr1 = listPBtn[dex].getLbName();
				codeStr1 = listPBtn[dex].getCodeStr();
				slcB1 = true;
				slcTf1.getJTf().setText("[1] " + slcStr1);
//				p.add(slcTf1.getJTf());
//				listPBtn[dex].getMiniBtn().setText("V");
				listPBtn[dex].getMiniBtn().setBorder(borderOrange);

				System.out.println("버튼 [1]개 선택, 선택된 제품 은 [" + slcStr1 + "]");
				System.out.println("              선택된 코드는 [" + codeStr1 + "]");
			}
		} else if (!slcStr1.equals("") && slcStr2.equals("")) {
			if (e.getActionCommand().equals(""+ dex)) {
				slcStr2 = listPBtn[dex].getLbName();
				codeStr2 = listPBtn[dex].getCodeStr();
				slcB2 = true;
				slcTf2.getJTf().setText("[2] " + slcStr2);
//				p.add(slcTf2.getJTf());
//				listPBtn[dex].getMiniBtn().setText("V");
				listPBtn[dex].getMiniBtn().setBorder(borderOrange);

				System.out.println("버튼 [2]개 선택, 선택된 제품 은 [" + slcStr1 + "], [" + slcStr2 + "]");
				System.out.println("              선택된 코드는 [" + codeStr1 + "], [" + codeStr2 + "]");

			}
		} else {
			JOptionPane.showMessageDialog(null, "2가지 제품만 선택 가능합니다.");
		}
	}
	
	public void setListFood(String ctgStr){
		listFood = DAO.list(ctgStr);
	}

//	public static void main(String[] args) {
//		ProductListFrame plf = new ProductListFrame("여", "32");
//		plf.startFrame();
//	}
}
