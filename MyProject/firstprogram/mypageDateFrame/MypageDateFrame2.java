package mypageDateFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import mainFrame.ImagePanel;
import mainFrame.MainDAO;
import mainFrame.MyFont;
import mainFrame.MyFrame;
import mainFrame.MyTextField;

public class MypageDateFrame2 {
	private MyFrame f;
	private ImagePanel p;
	private MyFont mfont;
	private MyTextField mTf;
	private String id, yyyymmdd;
	private JButton btnBefore, btnNext;
	private MyTextField yearTf, monthTf, dateTf;
	private MainDAO DAO;
	private int index;
	private DateListPanel[] listP;

	public MypageDateFrame2() {
		f = new MyFrame("[뉴트리베터]_나의 섭취 내역");
		p = new ImagePanel(new ImageIcon(f.getBackImg()).getImage());
		mfont = new MyFont();
		mTf = new MyTextField("나의 섭취 내역", 18);
		btnBefore = new JButton();
		btnNext = new JButton();

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

		mTf.getJTf().setFont(mfont.setFont(18));
		mTf.getJTf().setBounds(25, 80, 140, 20);

		btnBefore.setBounds(150, 113, 30, 20);
		btnBefore.setForeground(Color.DARK_GRAY);
		btnBefore.setBorder(new LineBorder(new Color(210, 180, 140), 2, false));
		btnNext.setBounds(300, 113, 30, 20);
		btnNext.setForeground(Color.DARK_GRAY);
		btnNext.setBorder(new LineBorder(new Color(210, 180, 140), 2, false));

		JPanel panelInBeforeBtn = new JPanel();
		JPanel panelInNextBtn = new JPanel();
		panelInBeforeBtn.setLayout(null);
		panelInNextBtn.setLayout(null);
		panelInBeforeBtn.setBackground(new Color(210, 180, 140));
		panelInNextBtn.setBackground(new Color(210, 180, 140));

		JLabel lbInBeforeBtn = new JLabel("<", JLabel.CENTER);
		JLabel lbInNextBtn = new JLabel(">", JLabel.CENTER);
		lbInBeforeBtn.setBounds(0, 0, 25, 15);
		lbInNextBtn.setBounds(0, 0, 25, 15);
		lbInBeforeBtn.setFont(mfont.setFont(20));
		lbInNextBtn.setFont(mfont.setFont(20));
		lbInBeforeBtn.setForeground(Color.white);
		lbInNextBtn.setForeground(Color.white);

		panelInBeforeBtn.add(lbInBeforeBtn);
		panelInNextBtn.add(lbInNextBtn);

		btnBefore.add(panelInBeforeBtn);
		btnNext.add(panelInNextBtn);

		btnBefore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < index; i++) {
//					p.remove(listP[i].getPanel());
//					p.validate();
					p.repaint();
				}
				
				String yearStr = yearTf.getJTf().getText();
				String monthStr = monthTf.getJTf().getText();
				String dateStr = dateTf.getJTf().getText();
				int year = Integer.valueOf(yearStr);
				int month = Integer.valueOf(monthStr);
				int date = Integer.valueOf(dateStr);

				if(date == 1) {
					month--;
					date = 31;
					if(month == 1) {
						year--;
						month = 12;
					}
					yearTf.getJTf().setText(year + "");
				} else {
					date--;
				}
				if(month < 10) {
					monthTf.getJTf().setText("0" + month);
				} else {
					monthTf.getJTf().setText(month + "");
				}
				if(date < 10) {
					dateTf.getJTf().setText("0" + date);
				}else {
					dateTf.getJTf().setText(date + "");
				}
				String yyyymmdd = "" + year + monthTf.getJTf().getText() + dateTf.getJTf().getText();
				System.out.println(yyyymmdd);
				setList(yyyymmdd);
			
			}
		});
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String yearStr = yearTf.getJTf().getText();
				String monthStr = monthTf.getJTf().getText();
				String dateStr = dateTf.getJTf().getText();
				int year = Integer.valueOf(yearStr);
				int month = Integer.valueOf(monthStr);
				int date = Integer.valueOf(dateStr);

				if(date == 31) {
					month++;
					date = 1;
					if(month == 12) {
						year++;
						month = 1;
					}
					yearTf.getJTf().setText(year + "");
				}else {
					date++;
				}
				if(month < 10) {
					monthTf.getJTf().setText("0" + month);
				} else {
					monthTf.getJTf().setText(month + "");
				}
				if(date < 10) {
					dateTf.getJTf().setText("0" + date);
				}else {
					dateTf.getJTf().setText(date + "");
				}
				String yyyymmdd = "" + year +  monthTf.getJTf().getText() + dateTf.getJTf().getText();
				System.out.println(yyyymmdd);
				setList(yyyymmdd);
			}
		});

		yearTf = new MyTextField(yyyyStr, 15);
		monthTf = new MyTextField(mmStr, 15);
		dateTf = new MyTextField(ddStr, 15);

		yearTf.getJTf().setFont(mfont.setFont(18));
		yearTf.getJTf().setForeground(new Color(210, 180, 140));
		yearTf.getJTf().setBounds(190, 115, 50, 20);
		yearTf.getJTf().setBackground(null);
		yearTf.getJTf().setBackground(Color.white);
		monthTf.getJTf().setFont(mfont.setFont(18));
		monthTf.getJTf().setForeground(new Color(210, 180, 140));
		monthTf.getJTf().setBounds(240, 115, 30, 20);
		monthTf.getJTf().setBackground(null);
		monthTf.getJTf().setBackground(Color.white);
		dateTf.getJTf().setFont(mfont.setFont(18));
		dateTf.getJTf().setForeground(new Color(210, 180, 140));
		dateTf.getJTf().setBounds(270, 115, 30, 20);
		dateTf.getJTf().setBackground(null);
		dateTf.getJTf().setBackground(Color.white);

		setList(this.yyyymmdd);

		p.add(btnBefore);
		p.add(yearTf.getJTf());
		p.add(monthTf.getJTf());
		p.add(dateTf.getJTf());
		p.add(btnNext);
		p.add(mTf.getJTf());
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
				listP[i].getPanel().setLocation(30, 150 + (70 * i));
				p.add(listP[i].getPanel());
				i++;
			}
		}

	}

	public static void main(String[] args) {
		MainDAO.connDB();
		MypageDateFrame2 f = new MypageDateFrame2();
		f.startFrame("shg", "20230113");
	}
}
