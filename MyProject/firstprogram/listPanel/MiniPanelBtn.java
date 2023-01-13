package listPanel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import mainFrame.MyFont;

public class MiniPanelBtn {
	private JPanel p;
	private JButton btn;
	private JLabel lbName, lbCtg, lbManu, lbKcal;
	private MyFont mfont;
	
	private String foodCode;
	
	public MiniPanelBtn() {
		p = new JPanel();
		p.setSize(220, 90);
		p.setLayout(null);
		p.setBackground(Color.white);
//		p.setBackground(new Color(255,250,240));
//		p.setBackground(new Color(255,255,240));
		
		mfont = new MyFont();
		
		btn = new JButton();
		btn.setSize(220, 90);
		btn.setBorderPainted(true);
		btn.setOpaque(true);
		btn.isRolloverEnabled();
		
//		btn.setBorder(new LineBorder(new Color(210,180,140), 2, false));

	
		lbName = new JLabel("", JLabel.LEFT);
		lbCtg = new JLabel("", JLabel.RIGHT);
		lbManu = new JLabel("", JLabel.LEFT);
		lbKcal = new JLabel("" + "Kcal", JLabel.RIGHT);
		
//		startMiniPanel();
	}
	
	public void setMiniPanel(String foodCode, String name, String ctg, String manu, String kcal) {
		this.foodCode = foodCode;
		lbName.setText(name);
		lbCtg.setText(ctg);
		lbManu.setText(manu);
		lbKcal.setText(kcal + "Kcal");
		if(kcal.equals(null)) {
			lbKcal.setText(kcal);
		}
	}
	
	public void startMiniPanel() {
		
		lbName.setFont(mfont.setFont(11));
		lbName.setBounds(15, 22, 140, 16);
		lbManu.setFont(mfont.setFont4());
		lbManu.setBounds(15, 10, 100, 8);
		lbCtg.setFont(mfont.setFont4());
		lbCtg.setBounds(125, 10, 80, 8);
		lbKcal.setFont(mfont.setFont(11));
		lbKcal.setBounds(125, 22, 80, 16);
		
		p.add(lbName);
		p.add(lbCtg);
		p.add(lbManu);
		p.add(lbKcal);
		btn.add(p);
		
	}
	
	public JButton getMiniBtn() {
		return btn;
	}
	
	public String getBtnFoodCode() {
		return foodCode;
	}
}

