//package listPanel;
//// 이렇게 안하고 각각 패널로 만들어서해보는중
//import java.awt.BorderLayout;
//import java.awt.Frame;
//import java.awt.GridLayout;
//import java.util.ArrayList;
//import java.util.Iterator;
//
//import javax.swing.Icon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//public class MainList extends ProcessedFoodDAO{
//	private ArrayList<ProcessedFoodVo> list;
//	private JPanel p, inP;
//	private JButton[] btn;
//	private JLabel[] lbName, lbCtg, lbManu, lbKcal;
//	
//	private JFrame f;
//	
//	
//	public MainList(String big_ctg) {
//		f = new JFrame();
//		list = super.list(big_ctg);
//		p = new JPanel();
//		inP = new JPanel();
//		btn = new JButton[super.getN()];
//		lbName = new JLabel[super.getN()];
//		lbCtg = new JLabel[super.getN()];
//		lbManu = new JLabel[super.getN()];
//		lbKcal = new JLabel[super.getN()];
//		
//		setBtn();
//		
//		list = super.getList();
//	}
//	
//	public void startListPanel() {
//		f.setLayout(new BorderLayout());
//		f.setSize(500, 600);
//		f.setResizable(false);
//		f.setLocationRelativeTo(null);
//		p.setLayout(new GridLayout(super.getN(), 2, 100, 0));
//		
//		for(int i = 0; i < super.getN(); i++) {
//			
//			inP.add(lbName[i]);
//			inP.add(lbCtg[i]);
//			inP.add(lbManu[i]);
//			inP.add(lbKcal[i]);
//			btn[i].setSize(200, 60);
//			btn[i].add(inP);
//			p.add(btn[i]);
//		}
//		
//		f.add(p);
//		f.setVisible(true);
//	}
//	
//	public void setBtn() {
//		
//		Iterator<ProcessedFoodVo> iterator = list.iterator();
//		int i = 0;
////		while(iterator.hasNext()) {
//////			System.out.println(iterator.next().getFoodName());
////			System.out.println("----------");
////			
////			String name = iterator.next().getFoodName();
////			String ctg = iterator.next().getDetailCtg();
////			String manu = iterator.next().getManufacturer();
////			String kcal = iterator.next().getKcal() + "";
////			lbName[i] = new JLabel(name);
////			lbCtg[i] = new JLabel(ctg);
////			lbManu[i]= new JLabel(manu);
////			lbKcal[i] = new JLabel(kcal);
////			i++;
////		}
//		while(iterator.hasNext()) {
//			btn[i] = new JButton();
//			lbName[i++] = new JLabel(iterator.next().getFoodName());
//		}
//		i = 0;
//		while(iterator.hasNext()) {
//			lbCtg[i++] = new JLabel(iterator.next().getDetailCtg());
//		}
//		i = 0;
//		while(iterator.hasNext()) {
//			lbManu[i++]= new JLabel(iterator.next().getManufacturer());
//		}
//		i = 0;
//		while(iterator.hasNext()) {
//			lbKcal[i++] = new JLabel(iterator.next().getKcal() + "");
//		}
//	}
//	
////	public JPanel startListPanel() {
////		p.setLayout(new GridLayout(super.getN()/2, 2));
////		
////		for(int i = 0; i < super.getN(); i++) {
////			btn[i].add(lbName[i]);
////			btn[i].add(lbCtg[i]);
////			btn[i].add(lbManu[i]);
////			btn[i].add(lbKcal[i]);
////			p.add(btn[i]);
////		}
////		
////		return p;
////	}
//	
//	public static void main(String[] args) {
//		MainList ml = new MainList("가공두부");
//		ml.startListPanel();
//	}
//	
//}
