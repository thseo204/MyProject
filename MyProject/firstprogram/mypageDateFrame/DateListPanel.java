package mypageDateFrame;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import mainFrame.MyFont;
import mainFrame.MyTextField;

public class DateListPanel {
	private JPanel listP;
	private MyTextField manuTf, foodNameTf, amountTf, kcalTf;
	private MyFont mfont;
	
//	private JFrame f;
	
	public DateListPanel() {
//		f = new JFrame();
//		f.setLayout(null);
//		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		f.setSize(500, 600);
		

		mfont = new MyFont();
		listP = new JPanel();
	}
	
	public void startPanel(String mane, String foodName, String amount, int kcal) {
		listP.setLayout(null);
		listP.setBackground(new Color(255,255,240));
		listP.setBounds(30, 10, 430, 60);
		listP.setBorder(new LineBorder(new Color(210, 180, 140), 2, true));
		
		manuTf = new MyTextField(mane, 11);
		foodNameTf = new MyTextField(foodName, 15);
		amountTf = new MyTextField(amount, 13);
		kcalTf = new MyTextField(kcal + "kcal", 13);
		
		
		manuTf.getJTf().setFont(mfont.setFont(11));
		foodNameTf.getJTf().setFont(mfont.setFont(15));
		amountTf.getJTf().setFont(mfont.setFont(13));
		kcalTf.getJTf().setFont(mfont.setFont(13));
		manuTf.getJTf().setBounds(20, 20, 80, 15);
		foodNameTf.getJTf().setBounds(110, 20, 150, 15);
		amountTf.getJTf().setBounds(280, 20, 50, 15);
		kcalTf.getJTf().setBounds(340, 20, 80, 15);
		manuTf.getJTf().setBackground(null);
		foodNameTf.getJTf().setBackground(null);
		amountTf.getJTf().setBackground(null);
		kcalTf.getJTf().setBackground(null);
		
		listP.add(manuTf.getJTf());
		listP.add(foodNameTf.getJTf());
		listP.add(amountTf.getJTf());
		listP.add(kcalTf.getJTf());
		
//		f.add(listP);
//		f.setVisible(true);
	}
	
	public JPanel getPanel() {
		return listP;
	}
	
//	public static void main(String[] args) {
//		DateListPanel panel = new DateListPanel();
//		panel.startPanel("농심", "새우깡", "80g", 150);
//	}
}
