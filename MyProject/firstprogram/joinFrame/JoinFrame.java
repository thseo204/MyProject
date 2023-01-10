package joinFrame;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import clauseFrame.ClauseFrame;
import individualInfoPolicyFrame.IndividualInfoPolicyFrame;
import loginframe.LoginFrame;
import mainframe.ImagePanel;
import mainframe.MainDAO;
import mainframe.MyButton;
import mainframe.MyFont;
import mainframe.MyFrame;

public class JoinFrame {
	private MyFrame f;
	private MyButton myBtn;
	private JTextField resTfId, resTfPwd, resTfEmail;
	private MyFont mfont;
	private ImagePanel p;
	private JLabel joinTitle, lbId, lbPwd, lbRePwd, lbEmail, lbName, lbGender, lbBarth, lb1, lb2, lb3;
	private MyFont tfId, tfPwd, tfRePwd, tfEmail, tfName, tfBarth;
	private JButton btnCheckId, btnJoin, btnClause, btnIndividual;
	private JRadioButton[] gender;
	private ButtonGroup group;
	private boolean idCheck;
	private String genderStr;
	private JCheckBox agree;
	
	
	public JoinFrame() {
		f = new MyFrame("[뉴트리베터]_회원가입");
		myBtn = new MyButton();
		mfont = new MyFont();

		p = new ImagePanel(new ImageIcon(f.getBackImg()).getImage());
		
		
		joinTitle = new JLabel("[뉴트리베터 회원가입]", JLabel.CENTER);
		lbId = new JLabel("아이디", JLabel.RIGHT);
		lbPwd = new JLabel("비밀번호", JLabel.RIGHT);
		lbRePwd = new JLabel("비밀번호 확인", JLabel.RIGHT);
		lbEmail = new JLabel("이메일", JLabel.RIGHT);
		lbName = new JLabel("이름", JLabel.RIGHT);
		lbGender = new JLabel("성별", JLabel.RIGHT);
		lbBarth = new JLabel("생년월일", JLabel.RIGHT);
		
		tfId = new MyFont();
		tfPwd = new MyFont();
		tfRePwd = new MyFont();
		tfEmail = new MyFont();
		tfName = new MyFont();
		gender = new JRadioButton[2];
		gender[0] = new JRadioButton("남      |");
		gender[1] = new JRadioButton("여 ");
		tfBarth = new MyFont();
		
		group = new ButtonGroup();
		group.add(gender[0]);
		group.add(gender[1]);
		
		btnCheckId = new JButton("중복확인");
		resTfId = new JTextField("");
		resTfPwd = new JTextField("");
		resTfEmail = new JTextField("올바른 형식이 아닙니다.");
		idCheck = false;
		
		btnClause = new JButton("서비스 약관");
		btnIndividual = new JButton("개인정보 수집 및 이용");
		btnJoin = new JButton("회원가입");
		
		lb1 = new JLabel("뉴트리베터에서 제공하는 ", JLabel.RIGHT);
		lb2 = new JLabel(",", JLabel.CENTER);
		lb3 = new JLabel("에 동합니다.", JLabel.LEFT);
		
		agree = new JCheckBox("");
		
		resTfId = new JTextField("") { // text field 테두리 제거
			private static final long serialVersionUID = 1L;

			public void setBorder(Border border) {
				
			}
		};
		resTfPwd = new JTextField("") { // text field 테두리 제거
			private static final long serialVersionUID = 1L;
			
			public void setBorder(Border border) {
				
			}
		};
		resTfEmail = new JTextField("") { // text field 테두리 제거
			private static final long serialVersionUID = 1L;

			public void setBorder(Border border) {
				
			}
		};

	}
	
	public void startFrame() {
		f.startMyFrmae();
		f.setMyFrameSize(370, 700);
		f.startBackBtn();
		f.backBtnMainStart();

		String korExp = "^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]$"; // 한글만 허용
		String engExp = "^[a-zA-Z]$"; // 영문자만 허용(대.소문자 모두)
//		String numExp = "^[0-9]+$"; // 숫자만 허용
		
		tfId.setTf("아이디 입력");
		tfPwd.setPTf("비밀번호 입력");
		tfRePwd.setPTf("비밀번호 확인");
		tfEmail.setTf("이메일 입력");
		tfName.setTf("이름 입력");
		tfBarth.setTf("생년월일 6자리(ex_900101)");
		
		tfId.getTf().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if(!((0x61 <= c && c <= 0x7A) || (0x41 <= c && c <= 0x5A) || (0x30 <= c && c <= 0x39))) {
					// 영문(소문자) ok!, 영문(대문자) ok!, 숫자 ok!
					ke.consume(); 
				}
			}
		});
		
		// 이름 입력란에 숫자 입력시 제한.
		tfName.getTf().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
//				if(Character.isDigit(c)) {// 숫자입력 시 입력 제한
//					ke.consume();
//				}
//				TextField src = (TextField) ke.getSource();
				String src = c + "";
				if(!src.matches(korExp) && !src.matches(engExp)) {
					// 이름란 한글, 영어 OK
					ke.consume();
				}
			}
		});
		
		// 생년월일 입력란에 입력 글자 갯수 제한. 숫자만 입력받을 수 있도록.
		tfBarth.getTf().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				TextField src = (TextField) ke.getSource();
				if(src.getText().length() >= 6) {
					ke.consume();
				} else if(!Character.isDigit(c)) { // 숫자만 입력받을 수 있도록!
					ke.consume();
				}
//				else if(src.getText().length() < 6){
//					tfBarth.getTf().setEditable(true);
//				}
			}
		});
		
//		lbId.setFont(mfont.setFont());
		
		lbId.setSize(50, 30);
		lbId.setFont(mfont.setFont2());
		lbPwd.setSize(50, 30);
		lbPwd.setFont(mfont.setFont2());
		lbRePwd.setSize(80, 30);
		lbRePwd.setFont(mfont.setFont2());
		lbEmail.setSize(50, 30);
		lbEmail.setFont(mfont.setFont2());
		lbName.setSize(50, 30);
		lbName.setFont(mfont.setFont2());
		lbGender.setSize(50, 30);
		lbGender.setFont(mfont.setFont2());
		lbBarth.setSize(50, 30);
		
		joinTitle.setFont(mfont.setFont(15));
		btnClause.setFont(mfont.setFont(9));
		btnIndividual.setFont(mfont.setFont(9));
		lb1.setFont(mfont.setFont(8));
		lb2.setFont(mfont.setFont(8));
		lb3.setFont(mfont.setFont(8));
		agree.setFont(mfont.setFont(8));
		lb1.setSize(90, 10);
		lb2.setSize(8, 10);
		lb3.setSize(80, 10);
		
		lbBarth.setFont(mfont.setFont2());
		myBtn.blueButtonOption(btnClause);
		myBtn.blueButtonOption(btnIndividual);
		
		
		
		resTfEmail.setForeground(Color.red);
		resTfEmail.setEditable(false); // Text Field 수정 불가하게.
		
		btnCheckId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				IDDAO dao = new IDDAO();
				MainDAO DAO = new MainDAO();
				boolean possible = DAO.possibleId(tfId.getTf().getText());
				if(possible == true) {
					resTfId.setForeground(Color.BLUE);
					resTfId.setText("사용 가능한 아이디 입니다.");
					idCheck = true;
				} else {
					resTfId.setForeground(Color.red);
					resTfId.setText("이미 사용중인 아이디 입니다.");
					idCheck = false;
				}
				resTfId.setEditable(false);
				resTfId.setBounds(110, 175, 190, 30);
				p.add(resTfId);
			}
		});
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 모든 항목이 올바르게 입력되었는지 체크하기 위한 불리언 변수 선언.
				boolean[] b = new boolean[7];
				for(int i = 0; i < b.length; i++) {
					b[i] = false;
				}
				// 아이디 중복확인 했는지 확인.
				if(idCheck == false) {
					resTfId.setForeground(Color.red);
					resTfId.setText("중복확인을 해주세요.");
				} else {
					resTfId.setForeground(Color.blue);
					resTfId.setText("사용가능한 아이디입니다.");
					b[0] = true;
					
				}
				resTfId.setBounds(110, 175, 190, 30);
				p.add(resTfId);
				// 비밀번호와 비밀번호 확인이 일치한지 확인.
				if(!tfPwd.getTf().getText().equals(tfRePwd.getTf().getText())) {
					resTfPwd.setForeground(Color.red);
					resTfPwd.setText("비밀번호가 일치하지 않습니다.");
				} else {
					resTfPwd.setForeground(Color.BLUE);
					resTfPwd.setText("비밀번호가 일치합니다.");
					b[1] = true;
				}
				resTfPwd.setBounds(110, 265, 190, 30);
				p.add(resTfPwd);
				
				// 유효한 이메일 형식인지 확인.
				if(!isEmail(tfEmail.getTf().getText())) {
					resTfEmail.setForeground(Color.red);
					resTfEmail.setText("올바르지 않은 이메일 형식입니다.");
					
				} else {
					resTfEmail.setForeground(Color.BLUE);
					resTfEmail.setText("사용가능한 이메일입니다.");
					b[2] = true;
				}
				resTfEmail.setBounds(110, 315, 190, 30);
				p.add(resTfEmail);
				// 이름 입력 확인.
				if(tfName.getTf().equals(null) && tfName.getTf().equals("이름 입력")) {
					
				} else {
					b[3] = true;
				}
				// 성별 확인.
				if(gender[0].isSelected()) {
					genderStr = "남";
					b[4] = true;
				} else if(gender[1].isSelected()){
					genderStr = "여";
					b[4] = true;
				}
				// 생년월일 6자리 맞는지 확인.
				if(tfBarth.getTf().getText().length() == 6) {
					b[5] = true;
				}
				if(agree.isSelected()) {
					b[6] = true;
				} 
				// 빈칸 있는지 확인.
				int count = 0;
				for(int i = 0; i < b.length; i++) {
					if(b[i] == true) {
						count++;
					}
				}
				if(count < b.length){
					if(b[1] == true && b[2] == true && b[3] == true && b[4] == true && b[5] == true && b[6] == false) {
						JOptionPane.showMessageDialog(null, "'서비스 약관'과 '개인정보 수집 및 이용'\n 미동의시 가입이 제한됩니다.");

					} else {
						JOptionPane.showMessageDialog(null, "빈칸 없이 입력해주세요.");
					}
				}else if(count == b.length){
//					JoinDAO dao = new JoinDAO();
					MainDAO DAO = new MainDAO(); //
					String id = tfId.getTf().getText();
					String pwd = tfPwd.getTf().getText();
					String email = tfEmail.getTf().getText();
					String name = tfName.getTf().getText();
					String gender = genderStr;
					String barth = tfBarth.getTf().getText();
					
					boolean result = DAO.listJoinInsert(id, pwd, email, name, gender, barth); //
					//회원가입이 완료되었습니다.
					if(result == true) {
						JOptionPane.showMessageDialog(null, "회원가입을 축하합니다.\n로그인페이지로 이동합니다.");
						try {
							LoginFrame lf = new LoginFrame();
							f.getMyFrame().setVisible(false);
							lf.startFrame();
						}catch(Exception e1) {
							
						}
					} else {
						JOptionPane.showMessageDialog(null, "회원가입을 실패하였습니다.");
					}
				}
				
			}
		});

		btnClause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClauseFrame cf = new ClauseFrame();
				cf.startFrame();
			}
		});
		btnIndividual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IndividualInfoPolicyFrame in = new IndividualInfoPolicyFrame();
				in.startFrame();
			}
		});
		
//		btnBefore.setBounds(10, 15, 30, 30);
		joinTitle.setBounds(110, 80, 150, 50);
		
		lbId.setLocation(50, 150);
		tfId.getTf().setBounds(110, 150, 130, 30);
		btnCheckId.setBounds(230, 150, 80, 30);
		lbPwd.setLocation(50, 200);
		tfPwd.getTf().setBounds(110, 200, 190, 30);
		lbRePwd.setLocation(20, 240);
		tfRePwd.getTf().setBounds(110, 240, 190, 30);
		lbEmail.setLocation(50, 290);
		tfEmail.getTf().setBounds(110, 290, 190, 30);
//		resTfEmail.setBounds(110, 315, 190, 30);
		lbName.setLocation(50, 340);
		tfName.getTf().setBounds(110, 340, 190, 30);
		lbGender.setLocation(50, 380);
		gender[0].setBounds(140, 380, 90, 30);
		gender[1].setBounds(220, 380, 90, 30);
		lbBarth.setLocation(50, 420);
		tfBarth.getTf().setBounds(110, 420, 190, 30);
		
		agree.setBounds(22, 475, 25, 20);
		lb1.setLocation(50, 480);
		btnClause.setBounds(135, 480, 60, 10);
		lb2.setLocation(185, 480);
		btnIndividual.setBounds(190, 480, 100, 10);
		lb3.setLocation(285, 480);
		
		btnJoin.setBounds(110, 520, 160, 40);
		
		p.add(f.getBackBtn());
		p.add(joinTitle);
		p.add(lbId);
		p.add(btnCheckId);
		p.add(tfId.getTf());
		p.add(lbPwd);
		p.add(tfPwd.getTf());
		p.add(lbRePwd);
		p.add(tfRePwd.getTf());
		p.add(lbEmail);
		p.add(tfEmail.getTf());
		p.add(lbName);
		p.add(tfName.getTf());
		p.add(lbGender);
		p.add(gender[0]);
		p.add(gender[1]);
		p.add(lbBarth);
		p.add(tfBarth.getTf());
		p.add(agree);
		p.add(lb1);
		p.add(btnClause);
		p.add(lb2);
		p.add(btnIndividual);
		p.add(lb3);
		p.add(btnJoin);
		f.getMyFrame().add(p);
		f.getMyFrame().setVisible(true);
		
	}
	
	public boolean isEmail(String str) { // 유효한 이메일형식인지체크.
		return Pattern.matches("^[a-z0-9A-Z._-]*@[a-z0-9A-Z]*.[a-zA-Z.]*$", str);
	}
	
	public boolean isKorean(String str) {
		return Pattern.matches("[가-힣]*$", str);
	}
	
	public void itemStateChanged(ItemEvent e) {
		if(gender[0].isSelected()) {
			genderStr = "남";
		} else {
			genderStr = "여";
		}
	}
}
