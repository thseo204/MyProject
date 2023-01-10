package mainframe;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.Border;

public class MyTextField {
	private JTextField jTf;

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
	
	public void setMTfColor(Color c) {
		jTf.setForeground(c);
	}
	
	public JTextField getJTf() {
		return jTf;
	}
}
