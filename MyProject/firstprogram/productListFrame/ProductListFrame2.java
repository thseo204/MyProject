//package productListFrame;
//
//import java.awt.BorderLayout;
//import java.awt.CardLayout;
//import java.awt.Color;
//import java.awt.Container;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;
//import java.util.ArrayList;
//import java.util.Iterator;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//
//import listPanel.BigCtgComboBox;
//import listPanel.BigCtgDAO;
//import listPanel.ProcessedFoodDAO;
//import listPanel.ProcessedFoodVo;
//import loginmainframe.MyButton;
//import mainframe.ImagePanel;
//import mainframe.MyFont;
//import mainframe.MyFrame;
//import mainframe.MyTextField;
//import menuFrame.MenuFrame;
//
//public class ProductListFrame2 extends JPanel {
//	private static final long serialVersionUID = 1L;
//
//	private JPanel cardPanel;
//	private JPanel[] card;
//
//	private MyFrame f;
//	private ImagePanel p;
//	private MyFont mfont;
//	private MyButton myBtn;
//	private ImageIcon imgMenu, imgMenuC, cMenu, imgSearch, imgSearchC, cSearch;
//	private JButton btnMenu, btnSearch, btnNext, btnPre;
//	private MyTextField totalNum;
//	private String ctgStr;
//	private int ctgNum, N, cardNum;
//
//	private BigCtgComboBox comboBox;
////	private TestCardLayout cardDemo;
//	private ProductListFrame cardDemo;
//	private ListPanelBtn[] listPBtn;
//	private int j = 0, k = 0;
//
//	private ProcessedFoodDAO dao = new ProcessedFoodDAO();
//	private ArrayList<ProcessedFoodVo> listFood;
//	private Iterator<ProcessedFoodVo> iter;
//
//	public ProductListFrame2() {
//
//		f = new MyFrame("제품 리스트_[뉴트리베터]");
//		p = new ImagePanel(new ImageIcon(f.getBackNorthImg()).getImage());
//
//		cardPanel = new JPanel(new CardLayout());
//
//		mfont = new MyFont();
//		mfont.setTf("제품명을 검색하세요!");
//		myBtn = new MyButton();
//		totalNum = new MyTextField("", 15);
//
//		comboBox = new BigCtgComboBox();
//
//		imgMenu = new ImageIcon("./Button_image/Button_menu.PNG");
//		imgMenuC = new ImageIcon("./Button_image/ButtonC_img.PNG");
//		imgSearch = new ImageIcon("./Button_image/Search_img.PNG");
//		imgSearchC = new ImageIcon("./Button_image/SearchC_img.PNG");
//		cSearch = myBtn.changeImageSize(imgSearchC, 30, 30);
//		cMenu = myBtn.changeImageSize(imgMenuC, 30, 30);
//
//		btnMenu = new JButton(myBtn.changeImageSize(imgMenu, 30, 30));
//		btnSearch = new JButton(myBtn.changeImageSize(imgSearch, 30, 30));
//		btnNext = new JButton(">>");
//		btnPre = new JButton("<<");
//
//		ctgNum = 100;
//		setN(ctgNum);
//		setCardArr();
//		setListPBtnArr();
//		ctgStr = "과자";
//		dao = new ProcessedFoodDAO();
//		listFood = dao.list(ctgStr);
////		listFood = dao.list(ctgStr);
//
//	}
//
//	public void startFrame() {
//		f.startMyFrmae();
//
//		f.getMyFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////		cardDemo = new TestCardLayout(N, ctgStr);
//		cardDemo = new ProductListFrame();
//		cardDemo.setOpaque(true);
////		f.getMyFrame().setContentPane(cardDemo);
//		f.getMyFrame().setLocationRelativeTo(null);
////		f.getMyFrame().setSize(500, 440);
//		f.getMyFrame().setSize(500, 600);
//		f.getMyFrame().setResizable(false);
//		f.getMyFrame().setLayout(new BorderLayout());
//
//		cardDemo.setPreferredSize(new Dimension(500, 440));
//		cardPanel.setPreferredSize(new Dimension(500, 395));
//
//		btnMenu.setBounds(10, 15, 30, 30);
//		mfont.getTf().setBounds(20, 80, 280, 30);
//		btnSearch.setBounds(300, 80, 30, 30);
//
////		super.getComboBox().setBounds(330, 80, 160, 30);
//		comboBox.getComboBox().setBounds(330, 80, 160, 30);
//		myBtn.buttonOption(btnSearch, cSearch);
//		myBtn.buttonOption(btnMenu, cMenu);
//		totalNum.getJTf().setFont(mfont.setFont(15));
//		totalNum.getJTf().setBounds(30, 130, 100, 20);
//		totalNum.getJTf().setBorder(null);
//
//		setListCardP(j);
//
//		btnMenu.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				MenuFrame mf = new MenuFrame();
//				mf.startFrame(true);
//			}
//		});
//		
//		// 해당 카테고리의 총 제품 갯수가 5 이하일때 갯수 이외의 CardListPBtn 은 나오지 않게 해야함!
//		comboBox.getComboBox().addItemListener(new ItemListener() {
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				if (e.getStateChange() == ItemEvent.SELECTED) {
//					try {
//						k = 0;
//						ctgStr = e.getItem().toString();
//						listFood = dao.list(ctgStr);
//						System.out.println(ctgStr + "&&&&&&&&&&&");
//						// 해당 카테고리의 제품 수
//						BigCtgDAO dao = new BigCtgDAO();
//						ctgNum = Integer.valueOf(dao.ctgNum(ctgStr));
////						if (ctgNum < 5) {
////							resetListCardP(j);
////						} else {
////						}
//						setListCardP(j);
//						totalNum.getJTf().setText("총 " + ctgNum + " 제품");
//					} catch (Exception e1) {
//						e1.printStackTrace();
//					}
//				}
//			}
//		});
//
//		CardLayout cl = (CardLayout) cardPanel.getLayout();
//		btnNext.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				j += 5;
//				if (j >= ctgNum) {
//					JOptionPane.showMessageDialog(null, "마지막 목록입니다.");
//				} else {
//					cl.next(cardPanel);
//					k += 1;
//					setListCardP(j);
//				}
//			}
//		});
//		btnPre.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				j -= 5;
//				if (j < 0) {
//					j = 0;
//					JOptionPane.showMessageDialog(null, "처음 목록입니다.");
//				} else {
//					cl.previous(cardPanel);
//					k -= 1;
//					setListCardP(j);
//				}
//			}
//		});
//
//		for (int i = 0; i < cardNum; i++) {
//			cardPanel.add(card[i]);
//		}
//		// 영역확인하기 위해 색 지정 하였음.
////		cardDemo.setBackground(Color.DARK_GRAY);
////		cardDemo.setBackground(Color.white);
//
//		btnPre.setBounds(260, 395, 40, 35);
//		btnNext.setBounds(220, 395, 40, 35);
//		
//
//		cardDemo.add(cardPanel);
//		cardDemo.add(btnPre);
//		cardDemo.add(btnNext);
//
//		p.add(btnMenu);
//		p.add(mfont.getTf());
//		p.add(comboBox.getComboBox());
//		p.add(btnSearch);
//		p.add(totalNum.getJTf());
//		f.getMyFrame().add("North", p);
//		f.getMyFrame().add("Center", cardDemo);
//		f.getMyFrame().pack();
//		f.getMyFrame().setVisible(true);
//	}
//
//	public void setCardArr() {
//		cardNum = 0;
//		if (N % 5 == 0) {
//			cardNum = N / 5;
//		} else {
//			cardNum = N / 5 + 1;
//		}
//
//		card = new JPanel[cardNum];
//
//		for (int i = 0; i < cardNum; i++) {
//			card[i] = new JPanel();
//			card[i].setLayout(null);
//		}
//	}
//
//	public void setN(int n) {
//		this.N = n;
//	}
//
//	public void setListPBtnArr() {
//		listPBtn = new ListPanelBtn[ctgNum];
//		for (int i = 0; i < ctgNum; i++) {
//			listPBtn[i] = new ListPanelBtn();
//		}
//	}
//
//	public void setListCardP(int j) {
//		int n = dao.getN();
//		System.out.println("********해당 카테고리 <<" + ctgStr + ">> 의 행 갯수" + n);
//
//		System.out.println("ListPBtn 생성 완료");
//		Iterator<ProcessedFoodVo> iter = listFood.iterator();
//		System.out.println(iter.hasNext());
//		System.out.println("[j]의 값은 -- [" + j + "] --");
//
//		int g = 0;
//
//		for (int i = 0; i < 5; i++) {
////			iter.next();
//			if (listFood.isEmpty()) {
//				break;
//			} else {
//				try {
//					iter.next();
//					String manu = listFood.get(j).getManufacturer();
//					String name = listFood.get(j).getFoodName();
//					String kcal = listFood.get(j).getKcal() + "";
//					System.out.println("****************" + j + "***************");
//					System.out.print(manu + "\t");
//					System.out.print(name + "\t");
//					System.out.println(kcal + "\t");
//					listPBtn[j].setListPanel(manu, name, kcal);
//					listPBtn[j].startListPanel();
//					System.out.println("[" + n + "]");
//					listPBtn[j].getPanel().setBounds(20, 80 * g++, 460, 75);
//					card[k].add(listPBtn[j].getPanel());
//				} catch (Exception e) {
//
//				}
//			}
//			j++;
//		}
//	}
//
////	public void resetListCardP(int j) {
////		int n = dao.getN();
////
////		System.out.println("******** card Panel removeAll");
////		int g = 0;
////
////		for (int i = 0; i < listPBtn.length; i++) {
//////			iter.next();
////
////			if (listFood.isEmpty()) {
////				break;
////			} else {
////				try {
////					iter.next();
////					String manu = listFood.get(j).getManufacturer();
////					String name = listFood.get(j).getFoodName();
////					String kcal = listFood.get(j).getKcal() + "";
////					System.out.println("****************" + j + "***************");
////					System.out.print(manu + "\t");
////					System.out.print(name + "\t");
////					System.out.println(kcal + "\t");
////					listPBtn[j].setListPanel(manu, name, kcal);
////					listPBtn[j].startListPanel();
////					System.out.println("[" + n + "]");
////					listPBtn[j].getPanel().setBounds(20, 80 * g++, 460, 75);
////					card[k].removeAll();
////				} catch (Exception e) {
////
////				}
////			}
////			j++;
////		}
////	}
//
//	public static void main(String[] args) {
//		ProductListFrame plf = new ProductListFrame();
//		plf.startFrame();
//	}
//}
