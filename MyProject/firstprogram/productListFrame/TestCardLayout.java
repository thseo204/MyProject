//package productListFrame;
//
//import java.awt.CardLayout;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.Iterator;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//
////import listPanel.ProcessedFoodDAO;
//import listPanel.ProcessedFoodVo;
//import mainframe.MainDAO;
//
//public class TestCardLayout extends JPanel {
//	private static final long serialVersionUID = 1L;
//
//	private JFrame frame;
//
//	private JPanel cardPanel;
//	private JPanel[] card;
//	private int N, cardNum, ctgNum;
//	private JButton btnNext, btnPre;
//	private JButton[] nextbtn, prebtn;
//
//	private TestCardLayout cardDemo;
//	private ListPanelBtn[] listPBtn;
//	private int j = 0, k = 0;
//	private String ctgStr;
//	
////	private ProcessedFoodDAO dao = new ProcessedFoodDAO();
//	private MainDAO DAO;
//	private ArrayList<ProcessedFoodVo> listFood;
//	private Iterator<ProcessedFoodVo> iter;
//
//	public TestCardLayout(int ctgNum, String ctgStr) {
//		frame = new JFrame();
//		this.ctgNum = ctgNum;
//		this.ctgStr = ctgStr;
//		
//		btnNext = new JButton(">>");
//		btnPre = new JButton("<<");
//		cardPanel = new JPanel(new CardLayout());
//		
//		
//		setN(ctgNum);
//		setCardArr();
//		setListPBtnArr();
//		
////		dao = new ProcessedFoodDAO();
//		listFood = DAO.list(ctgStr);
//
//	}
//
//	public void startCardPanel() {
//		
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		cardDemo = new TestCardLayout(N, ctgStr);
//		cardDemo.setOpaque(true);
//		frame.setContentPane(cardDemo);
//		frame.setLocationRelativeTo(null);
//		frame.setSize(500, 440);
//		
//		cardDemo.setPreferredSize(new Dimension(500, 440));
//		cardPanel.setPreferredSize(new Dimension(500, 395));
////      cardDemo.setOpaque(true);
//
//		
//		
////      for(int i = 0; i < cardNum; i++) {
////    	  for(int j = 0; j < ctgNum; j++) {
////    		  listPBtn[j].getPanel().setBounds(5, 80 * j, 460, 75);
////    		  card[i].add(listPBtn[j].getPanel());
////    	  }
////    	  cardPanel.add(card[i]);
////      }
//
////      for(int i = 0; i < cardNum; i++) {
////    	  prebtn[i].setBounds(200, 380, 40, 35);
////    	  nextbtn[i].setBounds(260, 380, 40, 35);
////    	  card[i].add(prebtn[i]);
////    	  card[i].add(nextbtn[i]);
////    	  
//////    	  cardPanel.add(card[i]);
////    	 
////      }
////		dao = new ProcessedFoodDAO();
////		listFood = dao.list(ctgStr);
////		iter = listFood.iterator();
////		startListCardP();
////    	  prebtn[i].setBounds(200, 380, 40, 35);
////    	  nextbtn[i].setBounds(260, 380, 40, 35);
////    	  card[i].add(prebtn[i]);
////    	  card[i].add(nextbtn[i]);
//		
//		setListCardP(j);
//		
//		CardLayout cl = (CardLayout) cardPanel.getLayout();
//		btnNext.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				j += 5;
//				if(j >= ctgNum) {
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
//				if(j < 0) {
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
//      for(int i = 0; i < cardNum; i++) {
////    	  card[i].add(btnNext);
////    	  card[i].add(btnPre);
//    	  cardPanel.add(card[i]);
//      }
//		cardDemo.setBackground(Color.DARK_GRAY);
//
////		for (int i = 0; i < cardNum; i++) {
////			prebtn[i].setBounds(200, 380, 40, 35);
////			nextbtn[i].setBounds(260, 380, 40, 35);
//////    	  cardPanel.add(card[i]);
////		}
//		
//		btnPre.setBounds(260, 395, 40, 35);
//		btnNext.setBounds(220, 395, 40, 35);
////      cardDemo.add(prebtn[i]);
////      cardDemo.add(nextbtn[i]);
//		cardDemo.add(cardPanel);
//		cardDemo.add(btnPre);
//		cardDemo.add(btnNext);
//		
//		
//		frame.setContentPane(cardDemo);
//		frame.pack();
//		frame.setVisible(true);
//	}
//
//	public void setCardArr() {
//		cardNum = 0;
//		if (N % 5 == 0) {
//			cardNum = N / 5;
//		} else {
//			cardNum = N / 5 + 1;
//		}
////		this.cardNum = cardNum;
//
//		card = new JPanel[cardNum];
//		nextbtn = new JButton[cardNum];
//		prebtn = new JButton[cardNum];
//
//		for (int i = 0; i < cardNum; i++) {
//			card[i] = new JPanel();
//			card[i].setLayout(null);
////			card[i].setPreferredSize(500, 395);
////			nextbtn[i] = new JButton(">");
////			prebtn[i] = new JButton("<");
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
//	public void setListCardP(int j) {
//		int n = DAO.getSlcCtgN();
//		System.out.println("********해당 카테고리 <<" + ctgStr + ">> 의 행 갯수" + n);
//
//		System.out.println("ListPBtn 생성 완료");
//		Iterator<ProcessedFoodVo> iter = listFood.iterator();
//		System.out.println(iter.hasNext());
//		System.out.println("[j]의 값은 -- [" + j + "] --");
//		
//		int g = 0;
//		for(int i = 0; i < 5; i++) {
////			iter.next();
//			if (listFood.isEmpty()) {
//				break;
//			} else {
//				try {
//					iter.next();
//					String code = listFood.get(j).getFoodCode();
//					String manu = listFood.get(j).getManufacturer();
//					String name = listFood.get(j).getFoodName();
//					String kcal = listFood.get(j).getKcal() + "";
//					System.out.println("****************" + j + "***************");
//					System.out.print(manu + "\t");
//					System.out.print(name + "\t");
//					System.out.println(kcal + "\t");
//					listPBtn[j].setListPanel(code, manu, name, kcal);
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
//	public TestCardLayout getCardDemo() {
//		return cardDemo;
//	}
//	
////	public static void main(String[] args) {
////		TestCardLayout testCard = new TestCardLayout(20, "과자");
//////		testCard.setCtgStr("과자");
////		testCard.startCardPanel();
////	}
//}