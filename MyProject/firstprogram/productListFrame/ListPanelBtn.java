package productListFrame;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import mainframe.MyFont;

public class ListPanelBtn {
	private JPanel p;
	private JButton btn;
	private JLabel lbName, lbManu, lbKcal, lbPercent1, lbPercent2;
	private MyFont mfont;
	private String manu, name, kcal, percent, codeStr;
	private Border border;
	
//	private JFrame f;
	
	public ListPanelBtn() {
//		f = new JFrame();
//		f.setSize(460, 150);
//		f.setDefaultCloseOperation(0);
		
		p = new JPanel();
		p.setSize(460, 75);
		p.setLayout(null);
		p.setBackground(Color.white);
		
		border = new LineBorder(Color.white, 3, true);
		
		mfont = new MyFont();
		// 버튼 이미지아이콘으로 넣기
		btn = new JButton("선택");
		btn.setSize(80, 50);
		btn.setBorderPainted(true);
		btn.setOpaque(true);
		btn.isRolloverEnabled();
	
//		lbCtg = new JLabel("", JLabel.RIGHT);
		lbManu = new JLabel("", JLabel.LEFT);
		lbName = new JLabel("", JLabel.LEFT);
//		lbKcal = new JLabel("" + "Kcal", JLabel.RIGHT);
		lbKcal = new JLabel("", JLabel.RIGHT);
		lbPercent1 = new JLabel("", JLabel.RIGHT);
		lbPercent2 = new JLabel("", JLabel.RIGHT);
	}
	
	public void setListPanel(String manu, String name, String kcal, String percent, String code) {
		lbManu.setText(manu);
		lbName.setText(name);
		lbKcal.setText(kcal + "Kcal");
		lbPercent1.setText("일일 권장량 대비 ");
		lbPercent2.setText(percent + "%");
		
		this.manu = manu;
		this.name = name;
		this.kcal = kcal;
		this.codeStr = code;
		this.percent = percent;
		// 일일권장량 대비
	}
	
	public void startListPanel() {
		
		lbManu.setFont(mfont.setFont(10));
		lbManu.setBounds(30, 33, 85, 12);
		lbManu.setForeground(Color.lightGray);
		lbName.setFont(mfont.setFont(15));
		lbName.setBounds(125, 30, 140, 20);
//		lbCtg.setFont(mfont.setFont4());
//		lbCtg.setBounds(125, 8, 80, 8);
		lbKcal.setFont(mfont.setFont(13));
		lbKcal.setBounds(290, 20, 80, 15);
		lbPercent1.setFont(mfont.setFont(11));
		lbPercent1.setBounds(275, 40, 100, 11);
		lbPercent1.setForeground(Color.orange);
		lbPercent2.setFont(mfont.setFont(11));
		lbPercent2.setBounds(320, 50, 50, 11);
		lbPercent2.setForeground(Color.orange);
		btn.setBounds(390, 15, 55, 50);
		
//		btn.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				btn.setText("V");
//				btn.setBackground(new Color(10, 10, 10, 10));
//			}
//		});
		
		p.setBorder(border);
//		p.add(lbCtg);
		p.add(lbManu);
		p.add(lbName);
		p.add(lbKcal);
		p.add(lbPercent1);
		p.add(lbPercent2);
		p.add(btn);
		
//		f.add(p);
//		f.setVisible(true);
	}
	
	public JPanel getPanel() {
		return p;
	}
	
	public JButton getMiniBtn() {
		return btn;
	}
	
	public String getLbName() {
		return lbName.getText();
	}
	
	public String getCodeStr() {
		return codeStr;
	}
	
//	public static void main(String[] args) {
//		ListPanelBtn lpb = new ListPanelBtn();
//		lpb.setListPanel("농심", "새우깡", "450", "15", "P");
//		lpb.startListPanel();
//	}
}
