package listPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.swing.JButton;
import javax.swing.JPanel;

import mainframe.MainDAO;
import mainframe.MyFont;

public class TotalListPanel extends BigCtgComboBox {
	private JPanel pCenter, pNorth, pTotal;
	private JButton btnMore;
	private MyFont mfont;
	private MiniPanelBtn[] mini;
	private int n;

	public TotalListPanel() {
		super();

		pTotal = new JPanel();
		pTotal.setLayout(null);
		pTotal.setSize(500, 340);
		pNorth = new JPanel();
		pNorth.setLayout(null);
		pNorth.setSize(480, 40);
		pNorth.setLocation(0, 0);
		pCenter = new JPanel();
		pCenter.setLayout(new GridLayout(4, 2, 5, 5));
		pCenter.setSize(480, 260);
		pCenter.setLocation(0, 40);

		mfont = new MyFont();

		btnMore = new JButton("더보기>");
		btnMore.setFont(mfont.setFont(15));
		btnMore.setForeground(Color.gray);
		btnMore.setBounds(390, 5, 100, 30);
		btnMore.setBorder(null);
		mini = new MiniPanelBtn[8];
		for (int i = 0; i < 8; i++) {
			mini[i] = new MiniPanelBtn();
		}

	}

	public void startTotalPanel(String ctgStr) {
//		ProcessedFoodDAO dao = new ProcessedFoodDAO();
		MainDAO DAO = new MainDAO(); //
		ArrayList<ProcessedFoodVo> listFood = DAO.listMainShow(ctgStr);
		n = DAO.getSlcCtgN();
		System.out.println("********해당 카테고리 <<" + ctgStr + ">> 의 행 갯수" + n);

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
					String name = listFood.get(j).getFoodName();
					String ctg = listFood.get(j).getDetailCtg();
					String manu = listFood.get(j).getManufacturer();
					String kcal = listFood.get(j).getKcal() + "";
					System.out.println("****************" + j + "***************");
					System.out.print(name + "\t");
					System.out.print(ctg + "\t");
					System.out.print(manu + "\t");
					System.out.println(kcal + "\t");
					mini[j].setMiniPanel(name, ctg, manu, kcal);
					mini[j].startMiniPanel();
					System.out.println("[" + n + "]");
				} catch (Exception e) {

				}
			}
			j++;
		}
		for (int i = 0; i < 8; i++) {
			pCenter.add(mini[i].getMiniBtn());
		}
		pNorth.add(super.getComboBox());
		pNorth.add(btnMore);
		pTotal.add(pNorth);
		pTotal.add(pCenter);

	}

	public JPanel getPanel() {
		return pTotal;
	}

	public void resetTLPanel() {
		for (int i = 0; i < 8; i++) {
			mini[i].setMiniPanel("", "", "", "");
		}
	}

	public JButton getBtnMore() {
		return btnMore;
	}
}
