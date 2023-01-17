package mypageDateFrame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import mainFrame.ImagePanel;
import mainFrame.MainDAO;
import mainFrame.MyFont;
import mainFrame.MyFrame;
import mainFrame.MyTextField;

public class MypageDateFrame {
	private MyFrame f;
	private ImagePanel p;
	private MyFont mfont;
	private MyTextField mTf;
	private String id, yyyymmdd;
	private MyTextField yyyymmddTf;
	private MainDAO DAO;
	private int index;
	private DateListPanel[] listP;
	private JPanel scrollInPanel;
	private JScrollPane scrollP;

	public MypageDateFrame() {
		f = new MyFrame("[뉴트리베터]_나의 섭취 내역");
		p = new ImagePanel(new ImageIcon(f.getBackImg()).getImage());
		mfont = new MyFont();
		mTf = new MyTextField("나의 섭취 내역", 18);
		scrollP = new JScrollPane();
		scrollInPanel = new JPanel();
	}

	public void startFrame(String id, String yyyymmdd) {
		this.id = id;
		this.yyyymmdd = yyyymmdd;
		String yyyyStr = yyyymmdd.substring(0, 4);
		String mmStr = yyyymmdd.substring(4, 6);
		String ddStr = yyyymmdd.substring(6, 8);

		DAO = new MainDAO();

		f.startMyFrmae();
		f.startBackBtn();
		f.backBtnDispose();
		p.setLayout(null);
		scrollP.setLayout(null);
		scrollInPanel.setLayout(null);
		scrollInPanel.setBackground(Color.white);

		mTf.getJTf().setFont(mfont.setFont(18));
		mTf.getJTf().setBounds(25, 80, 140, 20);

		scrollP.setBounds(25, 140, 450, 400);
		scrollInPanel.setBounds(0, 0, 450, 400);
		
		yyyymmddTf = new MyTextField("[ " + yyyyStr + "." + mmStr + "." + ddStr + " ]", 15);

		yyyymmddTf.getJTf().setFont(mfont.setFont(18));
		yyyymmddTf.getJTf().setForeground(new Color(210, 180, 140));
		yyyymmddTf.getJTf().setBounds(170, 115, 160, 20);
		yyyymmddTf.getJTf().setBackground(null);
		yyyymmddTf.getJTf().setBackground(Color.white);
		
		setList(this.yyyymmdd);

		p.add(yyyymmddTf.getJTf());
		p.add(mTf.getJTf());
		scrollP.add(scrollInPanel);
		p.add(scrollP);
		p.add(f.getBackBtn());
		f.getMyFrame().add(p);
		f.getMyFrame().setVisible(true);
	}

	public void setList(String yyyymmdd) {
		ArrayList<MemberNutrientHistoryVo> list = DAO.listUserHistoryDate(id, yyyymmdd);

		if (list == null) {
			MyTextField nullTf = new MyTextField("저장된 섭취 내역이 없습니다.", 20);
			nullTf.getJTf().setFont(mfont.setFont(20));
			nullTf.getJTf().setBounds(120, 180, 280, 30);
			p.add(nullTf.getJTf());
		} else {

			Iterator<MemberNutrientHistoryVo> iter = list.iterator();
			index = DAO.getSlcCtgN();
			listP = new DateListPanel[index];

			for (int i = 0; i < index; i++) {
				listP[i] = new DateListPanel();
			}
			int i = 0;
			while (iter.hasNext()) {
				iter.next();
				String manu = list.get(i).getManu();
				String foodName = list.get(i).getFoodName();
				String amount = list.get(i).getAmount();
				int kcal = list.get(i).getKcal();

				listP[i].startPanel(manu, foodName, amount, kcal);
				listP[i].getPanel().setLocation(10, 10 + (70 * i));
				scrollInPanel.add(listP[i].getPanel());
//				p.add(listP[i].getPanel());
				i++;
			}
			
		}

	}

	public static void main(String[] args) {
		MainDAO.connDB();
		MypageDateFrame f = new MypageDateFrame();
		f.startFrame("shg", "20230113");
	}
}
