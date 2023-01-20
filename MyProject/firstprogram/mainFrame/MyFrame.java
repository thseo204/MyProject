package mainFrame;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends MyFont{
	public static boolean LOGON;
	
	protected JFrame f;
	protected ImageIcon imgFrame, imgFrameNorth, imgBefore, imgBeforeC, cBefore;
	protected Image imgBack, imgBackNorth;
	protected MyButton myBtn;
	protected JButton btnBefore;
	protected String id, name, gender, age;
	
	public MyFrame(String title) {
		super();
		f = new JFrame(title);
		myBtn = new MyButton();
		imgFrame = new ImageIcon("./Frame_image/Frame_Background.PNG");
		imgBack = myBtn.changeImageSize(imgFrame, 500, 600).getImage();
		
		imgFrameNorth = new ImageIcon("./Frame_image/FrameNorth_Background.png");
		imgBackNorth = myBtn.changeImageSize(imgFrameNorth, 500, 160).getImage();

		imgBefore = new ImageIcon("./Button_image/back_img.PNG");
		imgBeforeC = new ImageIcon("./Button_image/backC_img.PNG");

		cBefore = myBtn.changeImageSize(imgBeforeC, 30, 30);
		btnBefore = new JButton(myBtn.changeImageSize(imgBefore, 30, 30));

	}

	public void startMyFrame() {
		f.setLayout(new BorderLayout());
		f.setSize(500, 600);
		f.setResizable(false); // 프레임 사이즈 고정
		f.setLocationRelativeTo(null); // 프레인 실행시 중앙위치
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void startBackBtn() {
		myBtn.buttonOption(btnBefore, cBefore);
		btnBefore.setBounds(10, 15, 30, 30);
	}
	
	public void backBtnDispose() {
		btnBefore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getMyFrame().dispose();
			}
		});
	}
	
	public void backBtnMainStart() {
		btnBefore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getMyFrame().dispose();
//				if(LOGON == false) {
				MainFrame mf = new MainFrame();
					mf.startFrame();
//				} else if(LOGON == true) {
//					MainFrame mf = new MainFrame(id, name, gender, age);
//					mf.startFrame();
//				}
			}
		});
	}

	public void setMyFrameSize(int x, int y) {
		f.setSize(x, y);
	}

	public JFrame getMyFrame() {
		return f;
	}
	public Image getBackNorthImg() {
		return imgBackNorth;
	}
	
	
	

//	public Image getBackImg() {
//		return imgBack;
//	}
//
//	public JButton getBackBtn() {
//		return btnBefore;
//	}
}
