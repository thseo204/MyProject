package listPanel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mainframe.MyFont;

public class MiniPanelBtn {
	private JPanel p;
	private JButton btn;
	private JLabel lbName, lbCtg, lbManu, lbKcal;
	private MyFont mfont;
	
	public MiniPanelBtn() {
		p = new JPanel();
		p.setSize(220, 90);
		p.setLayout(null);
		
		mfont = new MyFont();
		
		btn = new JButton();
		btn.setSize(220, 90);
		btn.setBorderPainted(true);
		btn.setOpaque(true);
		btn.isRolloverEnabled();
	
		lbName = new JLabel("", JLabel.LEFT);
		lbCtg = new JLabel("", JLabel.RIGHT);
		lbManu = new JLabel("", JLabel.LEFT);
		lbKcal = new JLabel("" + "Kcal", JLabel.RIGHT);
		
//		startMiniPanel();
	}
	
	public void setMiniPanel(String name, String ctg, String manu, String kcal) {
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
		lbName.setBounds(15, 20, 140, 16);
		lbManu.setFont(mfont.setFont4());
		lbManu.setBounds(15, 8, 100, 8);
		lbCtg.setFont(mfont.setFont4());
		lbCtg.setBounds(125, 8, 80, 8);
		lbKcal.setFont(mfont.setFont(11));
		lbKcal.setBounds(125, 20, 80, 16);
		
		p.add(lbName);
		p.add(lbCtg);
		p.add(lbManu);
		p.add(lbKcal);
		btn.add(p);
		
	}
	
	public JButton getMiniBtn() {
		return btn;
	}
	
//	public void setLb(String name, String ctg, String manu, String kcal) {
//		lbName = new JLabel(name, JLabel.LEFT);
//		lbCtg = new JLabel(ctg, JLabel.RIGHT);
//		lbManu = new JLabel(manu, JLabel.LEFT);
//		lbKcal = new JLabel(kcal + "Kcal", JLabel.RIGHT);
//	}
	
//	public static void main(String[] args) {
//		MiniPanelBtn mp = new MiniPanelBtn();
//		
//	}
}

