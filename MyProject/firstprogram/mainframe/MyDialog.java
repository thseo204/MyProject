package mainframe;

import java.awt.Dialog;

import javax.swing.JButton;
import javax.swing.JLabel;

public class MyDialog {
	private Dialog dLog;
	private JLabel msg;
	private JButton okBtn;
	
	public MyDialog(String title, String msg, String btn) {
		new Dialog(dLog, title);
		this.msg = new JLabel(msg);
		okBtn = new JButton(btn);
		
		this.msg.setHorizontalAlignment(JLabel.CENTER);
		
		dLog.setTitle(title);
		dLog.setSize(50, 50);
		dLog.add(this.msg, okBtn);
	}
	
	public Dialog getDialog() {
		return dLog;
	}
}
