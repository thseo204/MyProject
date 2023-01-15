package mainFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.border.Border;

public class MyTextField {
	private JTextField jTf;
	private TextField tf;

	public MyTextField() {
		tf = new TextField();
	}
	
	public MyTextField(String str, int fontSize) {
		jTf = new JTextField("", JTextField.CENTER) { //텍스트필드 테두리제거
			private static final long serialVersionUID = 1L;

			public void setBorder(Border border) {
				
			}
		};
		
		new Font("monospaced", Font.LAYOUT_RIGHT_TO_LEFT, fontSize);
		jTf.setForeground(Color.DARK_GRAY);
		jTf.setText(str);
		jTf.setEditable(false);
	}
	
	// 검색창
	public void setTf(String str) {
		new Font("monospaced", Font.LAYOUT_RIGHT_TO_LEFT, 20);
		tf.setForeground(Color.LIGHT_GRAY);
		tf.setText(str);
		tf.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) { // 포커스 아웃 시 다시 string 보이게하기
				if(tf.getText().equals("")) {
					tf.setText(str);
				} else { // 텍스트필드 안에 문자열이 존재할 경우 그 문자열 그대로 유지
					tf.setForeground(Color.black);
				}
			}
			
			public void focusGained(FocusEvent e) { // 포커스 인 되면 String 지우기
				if(tf.getText().equals(str)) {
					tf.setText("");
				}
			}
		});
	}
	
	// 회원가입 내에 jtf
	public void setPTf(String str) {
		String inpMsg= str;
		new Font("monospaced", Font.LAYOUT_RIGHT_TO_LEFT, 20);
		tf.setForeground(Color.LIGHT_GRAY);
		tf.setText(inpMsg);
		
		tf.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) { // 포커스 아웃 시 다시 string 보이게하기
				if(tf.getText().equals("")) {
					tf.setText(inpMsg);
					tf.setEchoChar(' ');
				} else { // 텍스트필드 안에 문자열이 존재할 경우 그 문자열 그대로 유지
					tf.setForeground(Color.black);
					tf.setEchoChar('*');
				}
			}
			
			public void focusGained(FocusEvent e) { // 포커스 인 되면 String 지우기
				if(tf.getText().equals(str)) {
					tf.setText("");
				}
			}
		});
	}
	
	public TextField getTf() {
		return tf;
	}
	
	public void setMTfColor(Color c) {
		jTf.setForeground(c);
	}
	
	public JTextField getJTf() {
		return jTf;
	}
}
