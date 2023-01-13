package mainFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MyFont {
	private TextField tf;
	
	public MyFont() {
		tf = new TextField();
		
	}
	
	public Font setFont(int fontSize) {
		Font font = new Font("monospaced", Font.BOLD, fontSize);
		
		return font;
	}
	public Font setFont() {
		Font font = new Font("monospaced", Font.BOLD, 15);
		
		return font;
	}
	
	public Font setFont0() {
		Font font = new Font("monospaced", Font.BOLD, 30);
		
		return font;
	}
	public Font setFont1() {
		Font font = new Font("monospaced", Font.BOLD, 25);
		
		return font;
	}
	
	public Font setFont2() {
		Font font = new Font("monospaced", Font.PLAIN, 12);
		
		return font;
	}
	
	public Font setFont4() {
		Font font = new Font("monospaced", Font.PLAIN, 8);
		
		return font;
	}
	
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
}
