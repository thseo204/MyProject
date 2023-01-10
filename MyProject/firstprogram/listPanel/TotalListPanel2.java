//package listPanel;
//
//import java.awt.BorderLayout;
//import java.awt.GridLayout;
//import java.util.ArrayList;
//import java.util.Iterator;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//
//public class TotalListPanel2 {
//	private JScrollPane scroll;
//	private JPanel pBig, pNorth, pSouth;
////	private BigCtgVo vo;
//	private BigCtgDAO dao;
//	private ArrayList<BigCtgVo> list;
//	private MiniPanelBtn[] mini;
//	private Iterator<BigCtgVo> iterBigCtg;
//	private int n;
//
//	private JFrame f;
//
//	public TotalListPanel2() {
//		f = new JFrame();
//		f.setSize(540, 300);
//		f.setResizable(false);
//		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		
//		pBig = new JPanel(new BorderLayout());
//		pNorth = new JPanel(null);
//		pSouth = new JPanel(new GridLayout(4, 2, 5, 5));
//		
//		pNorth.setSize(60, 260);
//		pSouth.setSize(480, 260);
//		
//		scroll = new JScrollPane(pSouth);
//		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
//
//		dao = new BigCtgDAO();
//		list = dao.list();
////		setBigctg();
//
//	}
//
//	public void startTotalPanel() {
//		ProcessedFoodDAO dao = new ProcessedFoodDAO();
//		ArrayList<ProcessedFoodVo> listFood = dao.list(getBigCtg());
//		n = dao.getN();
//		System.out.println("********해당 카테고리 <<" + getBigCtg() + ">> 의 행 갯수" + n);
//		mini = new MiniPanelBtn[n];
////		for(int i = 0; i < n; i++) {
////			mini[i] = new MiniPanelBtn();
////		}
//		int j = 0;
//		System.out.println("MiniPanelBtn 생성 완");
//		Iterator<ProcessedFoodVo> iter = listFood.iterator();
//		System.out.println(iter.hasNext());
//		while(iter.hasNext()) {
//			try{
//			iter.next();
//			String name = iter.next().getFoodName();
//			String ctg = iter.next().getDetailCtg();
//			String manu = iter.next().getManufacturer();
//			String kcal = iter.next().getKcal() + "";
//			System.out.println("****************" + j + "***************");
//			System.out.print(name + "\t");
//			System.out.print(ctg + "\t");
//			System.out.print(manu + "\t");
//			System.out.println(kcal + "\t");
//			mini[j]= new MiniPanelBtn(name, ctg, manu, kcal);
//			j++;
//			}catch (Exception e) {
//
//			}
//		}
////		mini[0].getMiniBtn().setBounds(50, 230, 200, 60);
////		mini[1].getMiniBtn().setBounds(250, 230, 200, 60);
//		for (int i = 0; i < 8; i++) {
//			p.add(mini[i].getMiniBtn());
//		}
//
//		f.add(p);
//		f.setVisible(true);
//		removeIter();
//	}
//
//	public String getBigCtg() {
//		iterBigCtg = list.iterator();
//		String bigCtg = "";
////		int n = dao.getN();
//		if (iterBigCtg.hasNext()) {
//			bigCtg = iterBigCtg.next().getBigCtg();
//		}
//		System.out.println("**********" + bigCtg);
//		return bigCtg;
//	}
//	
//	public JPanel getPanel() {
//		return p;
//	}
//
//	public void removeIter() {
//		iterBigCtg.remove();
//	}
//
////	public void setBigctg() {
////		dao = new BigCtgDAO();
////		list = dao.list();
//////		n = dao.getN();
////	}
//
//	public static void main(String[] args) {
//		TotalListPanel tlp = new TotalListPanel();
//		tlp.startTotalPanel();
//	}
//}
