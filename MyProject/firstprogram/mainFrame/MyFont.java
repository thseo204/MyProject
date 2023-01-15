package mainFrame;

import java.awt.Font;

public class MyFont {
	
	public Font setFont(int fontSize) {
		Font font = new Font("monospaced", Font.BOLD, fontSize);
		
		return font;
	}
	
	public Font setPlainFont(int fontSize) {
		Font font = new Font("monospaced", Font.PLAIN, fontSize);
		
		return font;
	}
}
