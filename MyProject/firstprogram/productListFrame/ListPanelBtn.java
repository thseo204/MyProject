package productListFrame;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import mainFrame.MyFont;

public class ListPanelBtn {
	private JPanel p, pInBtn, pInMiniBtn;
	private JButton btn, btnTotal;
	private JLabel lbName, lbManu, lbKcal, lbPercent1, lbPercent2, lbSelcet;
	private MyFont mfont;
	private String manu, name, kcal, percent, foodCode;
	private Border border;
	
//	private JFrame f;
	
	public ListPanelBtn() {
//		f = new JFrame();
//		f.setSize(460, 150);
//		f.setDefaultCloseOperation(0);
		
		p = new JPanel();
		p.setSize(460, 75);
		p.setLayout(null);
//		p.setBackground(Color.white);
		p.setBackground(null);
		pInBtn = new JPanel();
		pInBtn.setSize(460, 75);
		pInBtn.setLayout(null);
		pInBtn.setBackground(Color.white);
		pInBtn.setBounds(0, 0, 460, 75);
		
		border = new LineBorder(Color.white, 3, true);
		
		mfont = new MyFont();
		// 버튼 이미지아이콘으로 넣기
		btnTotal = new JButton();
		btnTotal.setBackground(null);
		btnTotal.setBounds(0, 0, 460, 75);
//		btnTotal.setForeground(Color.darkGray);
//		btnApply.setBackground(Color.DARK_GRAY);
//		btnTotal.setBorder(new LineBorder(Color.orange, 1, true));
		btnTotal.setFocusPainted(true);
		
		pInMiniBtn= new JPanel();
		pInMiniBtn.setSize(80, 50);
		pInMiniBtn.setLayout(null);
//		pInMiniBtn.setBackground(Color.lightGray);
		pInMiniBtn.setBackground(null);
		pInMiniBtn.setBounds(0, 0, 80, 50);
		
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
		lbSelcet = new JLabel("선택", JLabel.CENTER);
	}
	
	public void setListPanel(String manu, String name, String kcal, String percent, String foodCode) {
		lbManu.setText(manu);
		lbName.setText(name);
		lbKcal.setText(kcal + "Kcal");
		lbPercent1.setText("일일 권장량 대비 ");
		lbPercent2.setText(percent + "%");
		
		this.manu = manu;
		this.name = name;
		this.kcal = kcal;
		this.foodCode = foodCode;
		this.percent = percent;
		// 일일권장량 대비
	}
	
	public void startListPanel() {
		
		lbManu.setFont(mfont.setFont(10));
		lbManu.setBounds(30, 25, 85, 12);
		lbManu.setForeground(Color.lightGray);
		lbName.setFont(mfont.setFont(15));
		lbName.setBounds(125, 22, 140, 20);
//		lbCtg.setFont(mfont.setFont4());
//		lbCtg.setBounds(125, 8, 80, 8);
		lbKcal.setFont(mfont.setFont(13));
		lbKcal.setBounds(290, 12, 80, 15);
		lbPercent1.setFont(mfont.setFont(11));
		lbPercent1.setBounds(275, 32, 100, 11);
		lbPercent1.setForeground(Color.orange);
		lbPercent2.setFont(mfont.setFont(11));
		lbPercent2.setBounds(320, 42, 50, 11);
		lbPercent2.setForeground(Color.orange);
		lbSelcet.setFont(mfont.setFont(11));
		lbSelcet.setBounds(0, 16, 50, 11);
		lbSelcet.setForeground(Color.black);
		
		btn.setBounds(385, 7, 55, 50);
		
//		btn.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				if(lbSelcet.getText().equals("선택")) {
//					lbSelcet.setText("V");
//					lbSelcet.setForeground(Color.orange);
//				} else {
//					lbSelcet.setText("선택");
//					lbSelcet.setForeground(Color.black);
//				}
//			}
//		});
		pInMiniBtn.add(lbSelcet);
		p.setBorder(border);
		pInBtn.setBorder(border);
		pInMiniBtn.setBorder(border);
		btn.add(pInMiniBtn);
//		p.add(lbCtg);
		pInBtn.add(lbManu);
		pInBtn.add(lbName);
		pInBtn.add(lbKcal);
		pInBtn.add(lbPercent1);
		pInBtn.add(lbPercent2);
		pInBtn.add(btn);
//		p.add(lbManu);
//		p.add(lbName);
//		p.add(lbKcal);
//		p.add(lbPercent1);
//		p.add(lbPercent2);
//		p.add(btn);
		btnTotal.add(pInBtn);
		p.add(btnTotal);
		
//		f.add(p);
//		f.setVisible(true);
	}
	
	public void setFoodCode(String foodCode) {
		this.foodCode = foodCode;
	}
	public JPanel getPanel() {
		return p;
	}
	
	public JButton getMiniBtn() {
		return btn;
	}
	
	public JButton getTotalBtn() {
		return btnTotal;
	}
	
	public String getLbName() {
		return lbName.getText();
	}
	
	public String getBtnFoodCode() {
		return foodCode;
	}
	
	public void setLbSelect(String lbSelect) {
		this.lbSelcet.setText(lbSelect);
	}
	public JLabel getLbSelect() {
		return lbSelcet;
	}
	
//	public static void main(String[] args) {
//		ListPanelBtn lpb = new ListPanelBtn();
//		lpb.setListPanel("농심", "새우깡", "450", "15", "P");
//		lpb.startListPanel();
//	}
}
