package listPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mainFrame.MainDAO;
import mainFrame.MyFont;
import productDetailInfoFrame.ProductDetailFrame;

public class TotalListPanel extends BigCtgComboBox implements ActionListener{
	private JPanel pCenter, pNorth, pTotal;
	private JButton btnMore;
	private MyFont mfont;
	private MiniPanelBtn[] mini;
//	private int n;
	private String id, gender, age;
	private boolean logState;
	
	public TotalListPanel() {
		super();

		pTotal = new JPanel();
		pTotal.setLayout(null);
		pTotal.setSize(500, 340);
//		pTotal.setBackground(Color.white);
		pTotal.setBackground(new Color(255,250,240));
		pNorth = new JPanel();
//		pNorth.setBackground(Color.white);
		pNorth.setBackground(new Color(255,250,240));
		pNorth.setLayout(null);
		pNorth.setSize(480, 40);
		pNorth.setLocation(0, 0);
		pCenter = new JPanel();
		pCenter.setLayout(new GridLayout(4, 2, 5, 5));
		pCenter.setSize(480, 260);
		pCenter.setLocation(0, 40);
//		pCenter.setBackground(Color.white);
		pCenter.setBackground(new Color(255,250,240));

		mfont = new MyFont();

		btnMore = new JButton("더보기>");
		btnMore.setFont(mfont.setFont(15));
		btnMore.setForeground(Color.gray);
		btnMore.setBounds(390, 5, 100, 30);
		btnMore.setBorder(null);
		mini = new MiniPanelBtn[8];
		for (int i = 0; i < 8; i++) {
			mini[i] = new MiniPanelBtn();
//			mini[i].getMiniBtn().setBackground(new Color(255,250,240));
			mini[i].getMiniBtn().setBackground(null);
		}

	}

	public void startTotalPanel(String ctgStr) {
		MainDAO DAO = new MainDAO(); //
		ArrayList<ProcessedFoodVo> listFood = DAO.listMainShow(ctgStr);
//		n = DAO.getSlcCtgN();
		System.out.println("********해당 카테고리 <<" + ctgStr + ">> 의 행 갯수");

		int j = 0;
		System.out.println("MiniPanelBtn 생성 완료");
		Iterator<ProcessedFoodVo> iter = listFood.iterator();
		System.out.println(iter.hasNext());
		while (j < 8) {
//			iter.next();
			if (listFood.isEmpty()) {
				break;
			} else {
				try {
					iter.next();
					String foodCode = listFood.get(j).getFoodCode();
					String name = listFood.get(j).getFoodName();
					String ctg = listFood.get(j).getDetailCtg();
					String manu = listFood.get(j).getManufacturer();
					String kcal = listFood.get(j).getKcal() + "";
					System.out.println("****************" + j + "***************");
					System.out.print(name + "\t");
					System.out.print(ctg + "\t");
					System.out.print(manu + "\t");
					System.out.println(kcal + "\t");
					mini[j].setMiniPanel(foodCode, name, ctg, manu, kcal + "Kcal");
					mini[j].startMiniPanel();
//					System.out.println("[" + n + "]");
				} catch (Exception e) {

				}
			}
			j++;
		}
		
		for (int i = 0; i < 8; i++) {
			mini[i].getMiniBtn().setText(i + "");
			mini[i].getMiniBtn().addActionListener(this);
		}
		
		for (int i = 0; i < 8; i++) {
			pCenter.add(mini[i].getMiniBtn());
		}
		pNorth.add(super.getComboBox());
		pNorth.add(btnMore);
		pTotal.add(pNorth);
		pTotal.add(pCenter);

	}
	
	public void setLogon(boolean logState) {
		this.logState = logState;
	}
	
	public void setGenderAge(String id, String gender, String age) {
		this.id = id;
		this.gender = gender;
		this.age = age;
	}

	public JPanel getPanel() {
		return pTotal;
	}

	public void resetTLPanel() {
		for (int i = 0; i < 8; i++) {
			mini[i].setMiniPanel("", "", "", "", "");
		}
	}
	
	public JButton getBtnMore() {
		return btnMore;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(logState == false) {
			JOptionPane.showMessageDialog(null, "로그인 후 이용해주세요.");
		}else {
		String btnNum = e.getActionCommand();
		System.out.println("선택된 버튼 번호 : " + btnNum);
		
		String foodCode = mini[Integer.valueOf(btnNum)].getBtnFoodCode();
		
		ProductDetailFrame df = new ProductDetailFrame();
		df.setFoodCode(foodCode);
		df.setGenderAge(id, gender, age);
		df.startFrame();
		}
	}
	
}
