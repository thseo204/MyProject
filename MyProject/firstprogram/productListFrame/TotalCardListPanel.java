//package productListFrame;
//
//import java.awt.CardLayout;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.Iterator;
//
//import javax.swing.JButton;
//import javax.swing.JPanel;
//import javax.swing.border.LineBorder;
//import javax.swing.border.TitledBorder;
//
////import listPanel.ProcessedFoodDAO;
//import listPanel.ProcessedFoodVo;
//import mainFrame.MainDAO;
//
//public class TotalCardListPanel {
//	private JPanel[] cardP;
//	private JPanel centerP, southP, p;
//	private ListPanelBtn[] listPBtn;
//	private int num;
//	private JButton btnNext, btnPrevious;
//	private CardLayout cl;
//
////	private JFrame f;
//
////	public TotalCardListPanel() {
////		
////	}
//	// 생성자의 파라매터로 제품의 총 갯수 받기.
//	public void setTotalCardListPanel(int num) {
////		f = new JFrame();
//
//		centerP = new JPanel(new CardLayout()); // 카드 담을 덱
//		southP = new JPanel();
//		p = new JPanel();
//		this.num = num;
//		setCardNum(num);
//		setListPBtn(num);
//		setListPanel("인삼/홍삼음료");
//				
//		btnNext = new JButton(">");
//		btnPrevious = new JButton("<");
//		
//
//	}
//
//	public void startPanel() {
////		f.setSize(500, 520);
////		f.setResizable(false);
////		f.setLayout(null);
////		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		
//		
//		p.setLayout(null);
//		p.setPreferredSize(new Dimension(500, 520));
//		p.setBackground(Color.darkGray);
//		
//		centerP.setBackground(Color.LIGHT_GRAY);
//		southP.setBackground(Color.yellow);
//		
//		
////		centerP.setLayout(new CardLayout());
////		centerP.setBounds(0, 5, 500, 450);
////		centerP.setBounds(0, 5, 300, 250);
//		centerP.setPreferredSize(new Dimension(300, 250));
//		southP.setLayout(null);
//		southP.setBounds(0, 455, 500, 30);
////		btnPrevious.setBounds(220, 5, 20, 20);
////		btnNext.setBounds(280, 5, 20, 20);
//		btnPrevious.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				for(int i = 0; i < cardP.length; i++) {
//					cl = (CardLayout) cardP[i].getLayout();
//				}
//				for(int i = 0; i < cardP.length; i++) {
//					cl.previous(cardP[i]);
//				}
//			}
//		});
//		btnNext.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				for(int i = 0; i < cardP.length; i++) {
//					cl = (CardLayout) cardP[i].getLayout();
//				}
//				for(int i = 0; i < cardP.length; i++) {
//					cl.next(cardP[i]);
//				}
//			}
//		});
//		
//		
//		
//		for(int i = 0; i < listPBtn.length; i++) {
//			listPBtn[i].startListPanel();
//		}
//		
//		for(int i = 0, k = 0; i < cardP.length; i++) {
//			for(int j = 0; j < 4; j++) {
//				listPBtn[k].getPanel().setBounds(5, 75 * j + 5, 460, 75);
//				listPBtn[k].getPanel().setBackground(Color.pink);
//				TitledBorder border1 = new TitledBorder(new LineBorder(Color.black),"This is Panel " + i +"!", TitledBorder.CENTER,TitledBorder.BELOW_TOP);
//				cardP[i].setBorder(border1);
//				cardP[i].add(btnNext);
//				cardP[i].add(btnPrevious);
//				centerP.add(cardP[i], "-" + i + "-");
//				System.out.println("cardP[" + i + "] 에 listPBtn [ " + k + "] 추가");
//				k++;
//			}
//		}
//		centerP.setOpaque(true);// 불투명성
////		centerP.add(cardP[0], listPBtn[0]);
////		centerP.add(cardP[0], listPBtn[1]);
////		centerP.add(cardP[0], listPBtn[2]);
////		centerP.add(cardP[0], listPBtn[3]);
//		
////		southP.add(btnNext);
////		southP.add(btnPrevious);
////		p.add(centerP);
////		p.add(southP);
////		f.add(p);
//		p.add(southP);
//		
////		f.add(p);
////		f.setContentPane(centerP);
////		f.setVisible(true);
//	}
//
//	// 해당 제품의 총 갯수 / 4 만큼의 패널 생성.
//	public void setCardNum(int num) {
//		int N = 0;
//		if (num % 4 == 0) {
//			N = num / 4;
//		} else {
//			N = num / 4 + 1;
//		}
//		cardP = new JPanel[N];
//		for (int i = 0; i < N; i++) {
//			cardP[i] = new JPanel();
//			cardP[i].setLayout(null);
//		}
//	}
//
//	public void setListPBtn(int num) {
//		listPBtn = new ListPanelBtn[num];
//		for (int i = 0; i < num; i++) {
//			listPBtn[i] = new ListPanelBtn();
//		}
//	}
//
//	public void setListPanel(String bigCtg) {
////		ProcessedFoodDAO dao = new ProcessedFoodDAO();
//		MainDAO DAO = new MainDAO();
//		ArrayList<ProcessedFoodVo> list = DAO.list(bigCtg);
//
////		System.out.println("********해당 카테고리 <<" + ctgStr + ">> 의 행 갯수" + n);
//		System.out.println("ListPanelBtn 생성 완료");
//		Iterator<ProcessedFoodVo> iter = list.iterator();
//		System.out.println(iter.hasNext());
//
//		int k = 0;
//		try {
//			while (iter.hasNext()) {
//				iter.next();
//				String code = iter.next().getFoodCode();
//				String manu = iter.next().getManufacturer();
//				String name = iter.next().getFoodName();
//				String kcal = iter.next().getKcal() + "";
////				listPBtn[k].setListPanel(code, manu, name, kcal);
//				listPBtn[k].setListPanel(manu, name, kcal, "", code);
////				listPBtn[k].startMiniPanel();
////				p.add(cardP[i], listPBtn[k]);
//				System.out.println("****************" + k++ + "***************");
//				System.out.print(manu + "\t");
//				System.out.print(name + "\t");
//				System.out.println(kcal + "\t");
//			}
//
//		} catch (Exception e) {
//
//		}
//	}
//
//	public JPanel getCardPanel() {
//		return p;
//	}
//	
////	public static void main(String[] args) {
////		TotalCardListPanel tclp = new TotalCardListPanel();
////		tclp.setTotalCardListPanel(100);
////		tclp.setListPanel("인삼/홍삼음료");
////		tclp.startPanel();
////	}
//
//}
