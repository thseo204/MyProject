package mainframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyButton {
	
	public ImageIcon changeImageSize(ImageIcon m, int x, int y) { // 아이콘 이미지 사이즈 변경하는 메소드
		Image img = m.getImage();
		Image changeImg = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		return changeIcon;
	}
	
	public void buttonOption(JButton btn,ImageIcon img) {
		btn.setRolloverIcon(img); // 버튼에 마우스가 올라갈 때 이미지 변경
		btn.setFocusPainted(false); // 버튼이 선택되었을 때 생기는 테두리 사용 안함.
		btn.setBorderPainted(false); // 버튼 테두리 설정 해제(외곽선 없애주기)		
//		btnMenu.setPreferredSize(new Dimension(50,50)); // 버튼 크기 지정
//		btnMenu.setContentAreaFilled(false); // 버튼의 내용영역 채우기 안함.
//		btnMenu.setOpaque(false); // 버튼에 이미지 외의 영역을 투명하게
//		btnMenu.setMargin(new Insets(5, 5, 5, 5));
	}
	
	public void buttonOption(JButton btn) {
		new Font("monospaced", Font.BOLD, 20);
		btn.setFocusPainted(true); // 버튼이 선택되었을 때 생기는 테두리 사용 안함.
		btn.setBorderPainted(true); // 버튼 테두리 설정 해제(외곽선 없애주기)
//		btn.setBackground(Color.DARK_GRAY);
		btn.setForeground(Color.DARK_GRAY);
	}
	
	public void nudeButtonOption(JButton btn) {
		new Font("monospaced", Font.BOLD, 8);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false); // 버튼이 선택되었을 때 생기는 테두리 사용 안함.
		btn.setBorderPainted(false); // 버튼 테두리 설정 해제(외곽선 없애주기)
		btn.setForeground(Color.DARK_GRAY);
	}
	public void nudeButtonOption(JButton btn, int fontSize) {
		new Font("monospaced", Font.BOLD, fontSize);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(true); // 버튼이 선택되었을 때 생기는 테두리 사용 안함.
		btn.setBorderPainted(false); // 버튼 테두리 설정 해제(외곽선 없애주기)
		btn.setForeground(Color.GRAY);
	}
	public void blueButtonOption(JButton btn) {
		new Font("monospaced", Font.HANGING_BASELINE, 8);

		btn.setContentAreaFilled(false);
		btn.setFocusable(false);
		btn.setBorder(null);
		btn.setForeground(Color.blue);
	}
}
