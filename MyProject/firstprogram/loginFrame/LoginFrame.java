package loginFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import joinFrame.JoinFrame;
import mainFrame.ImagePanel;
import mainFrame.MainDAO;
import mainFrame.MainFrame;
import mainFrame.MyButton;
import mainFrame.MyFrame;
import mainFrame.MyTextField;

public class LoginFrame extends MainFrame {
	private MyFrame f;
	private MyButton myBtn;
	private MyTextField mTfId, mTfPwd;
	private JTextField resTf;
	private ImagePanel p;
	private ImageIcon imgHome;
	private JButton btnHome, btnLogin, btnJoin;

	public LoginFrame() throws ClassNotFoundException, SQLException {
		f = new MyFrame("[뉴트리베터]_로그인");
		myBtn = new MyButton();

		p = new ImagePanel(new ImageIcon(f.getBackImg()).getImage());

		imgHome = new ImageIcon("./Button_image/NutriBetter_Title.PNG");

		btnHome = new JButton(myBtn.changeImageSize(imgHome, 150, 150));
		btnLogin = new JButton("로그인 하기");
		btnJoin = new JButton("뉴트리베터 회원가입 >");

		mTfId = new MyTextField();
		mTfPwd = new MyTextField();

		resTf = new JTextField("") { // text field 테두리 제거
			private static final long serialVersionUID = 1L;

			public void setBorder(Border border) {

			}
		};

	}

	public void startFrame() {
		f.startMyFrmae();
		f.setMyFrameSize(400, 500);
		f.startBackBtn();
		f.backBtnMainStart();

		mTfId.setTf("아이디 입력");
		mTfPwd.setPTf("비밀번호 입력");

		resTf.setForeground(Color.red);
		resTf.setEditable(false); // Text Field 수정 불가하게.

		btnHome.setBorder(null); // '홈'버튼 테두리 제거

		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.getMyFrame().dispose();
				MainFrame mf = new MainFrame();
				mf.startFrame();
			}
		});

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				MemberDAO dao = new MemberDAO();
				MainDAO DAO = new MainDAO();//
				
//				dao.getConnDB();
				String name = DAO.listLoginIdPw(mTfId.getTf().getText(), mTfPwd.getTf().getText());
				System.out.println(name);
				if (name == null) {
					resTf.setText("아이디 혹은 비밀번호가 일치하지 않습니다.");
				} else {
					LOGON = true;
					String id = mTfId.getTf().getText();
					String gender = DAO.listGender(mTfId.getTf().getText());
					String age = DAO.listAge(mTfId.getTf().getText());
					MainFrame mf = new MainFrame(id, name, gender, age);
					mf.startFrame();
					f.getMyFrame().setVisible(false);
//					stopMain();
				}
			}
		});
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JoinFrame jf = new JoinFrame();
				jf.startFrame();
				f.getMyFrame().setVisible(false);
			}
		});

		btnHome.setBounds(100, 100, 200, 100);
		mTfId.getTf().setBounds(90, 220, 220, 30);
		mTfPwd.getTf().setBounds(90, 260, 220, 30);
		resTf.setBounds(90, 290, 220, 30);
		btnLogin.setBounds(90, 330, 220, 40);
		btnJoin.setBounds(150, 360, 200, 50);

		myBtn.buttonOption(btnLogin);
		myBtn.nudeButtonOption(btnJoin);

		p.add(f.getBackBtn());
		p.add(btnHome);
		p.add(mTfId.getTf());
		p.add(mTfPwd.getTf());
		p.add(resTf);
		p.add(btnLogin);
		p.add(btnJoin);
		f.getMyFrame().add(p);
		f.getMyFrame().setVisible(true);
	}

	public void stopMain() {
		super.getFrame().setVisible(false);
	}
}
