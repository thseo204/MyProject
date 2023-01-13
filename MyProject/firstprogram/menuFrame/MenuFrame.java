package menuFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import clauseFrame.ClauseFrame;
import individualInfoPolicyFrame.IndividualInfoPolicyFrame;
import joinFrame.JoinFrame;
import loginFrame.LoginFrame;
import mainFrame.ImagePanel;
import mainFrame.MainFrame;
import mainFrame.MyButton;
import mainFrame.MyFont;
import mainFrame.MyFrame;
import mainFrame.MyTextField;
import mypageFrame.MypageFrame;
import productCompareFrame.ProductCompareFrame;
import productListFrame.ProductListFrame;

public class MenuFrame {
	private MyFrame f;
	private ImagePanel p;
	private MyFont mfont;
	private MyButton myBtn;
	private MyTextField mTfTitle, mTfLine;
	private JButton btnLogin, btnJoin, btnLogout, btnMyPage, btnHome, btnList, btnClause, btnIndividual;
//	private JButton btnCompare;
	private String id, gender, age, nameLb;
	
	public MenuFrame() {
		f = new MyFrame("[뉴트리베터]_메뉴");
		mfont = new MyFont();
		mTfTitle = new MyTextField("메 뉴", 40);
		mTfLine = new MyTextField("------------", 30);
		p = new ImagePanel(new ImageIcon(f.getBackImg()).getImage());

		myBtn = new MyButton();
		btnLogin = new JButton("로그인");
		btnJoin = new JButton("회원가입");
		btnLogout = new JButton("로그아웃");
		btnMyPage = new JButton("마이페이지");
		btnHome = new JButton("홈");
		btnList = new JButton("제품 리스트");
//		btnCompare = new JButton("제품 비교");

		btnClause = new JButton("서비스 이용약관 |");
		btnIndividual = new JButton("개인정보 처리방침");

	}

	public void startFrame(boolean logOn) {
		f.startMyFrmae();
		f.getMyFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setMyFrameSize(400, 500);
		f.startBackBtn();
//		f.backBtnDispose();
		
		f.getBackBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(logOn == false) {
					f.backBtnMainStart();
				} else {
					MainFrame mf = new MainFrame(id, nameLb, gender, age);
					mf.startFrame();
					f.getMyFrame().setVisible(false);
				}
			}
		});
		p.setLayout(null);
		p.setSize(400, 500);

		myBtn.nudeButtonOption(btnLogout, 20);
		myBtn.nudeButtonOption(btnMyPage, 20);
		
		myBtn.nudeButtonOption(btnLogin, 20);
		myBtn.nudeButtonOption(btnJoin, 20);
		myBtn.nudeButtonOption(btnHome, 20);
		myBtn.nudeButtonOption(btnList, 20);
//		myBtn.nudeButtonOption(btnCompare, 20);
		myBtn.blueButtonOption(btnClause);
		myBtn.blueButtonOption(btnIndividual);

		mTfTitle.getJTf().setBounds(166, 80, 120, 40);
		mTfLine.getJTf().setBounds(110, 110, 180, 40);
		btnLogin.setBounds(110, 150, 180, 40);
		btnJoin.setBounds(110, 190, 180, 40);
		btnHome.setBounds(110, 230, 180, 40);
		btnList.setBounds(110, 270, 180, 40);
//		btnCompare.setBounds(110, 310, 180, 40);
		btnClause.setBounds(110, 410, 100, 10);
		btnIndividual.setBounds(205, 410, 100, 10);
		
		btnLogout.setBounds(110, 150, 180, 40);
		btnMyPage.setBounds(110, 190, 180, 40);

		mTfTitle.getJTf().setFont(mfont.setFont(30));
		mTfLine.getJTf().setFont(mfont.setFont(30));
		mTfLine.setMTfColor(Color.LIGHT_GRAY);
		btnLogin.setFont(mfont.setFont(20));
		btnJoin.setFont(mfont.setFont(20));
		btnHome.setFont(mfont.setFont(20));
		btnList.setFont(mfont.setFont(20));
//		btnCompare.setFont(mfont.setFont(20));
		btnClause.setFont(mfont.setFont(11));
		btnIndividual.setFont(mfont.setFont(11));
		
		btnLogout.setFont(mfont.setFont(20));
		btnMyPage.setFont(mfont.setFont(20));
		
		if (logOn == false) {
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						LoginFrame lf = new LoginFrame();
						lf.startFrame();
						f.getMyFrame().setVisible(false);
					} catch (Exception e1) {

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
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MainFrame mf = new MainFrame();
					mf.LOGON = logOn;
					mf.startFrame();
					f.getMyFrame().setVisible(false);
				}
			});
			
			p.add(btnLogin);
			p.add(btnJoin);
			
		} else {
			btnLogout.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MainFrame mf = new MainFrame();
					mf.LOGON = false;
					mf.startFrame();
					f.getMyFrame().setVisible(false);
				}
			});
			btnMyPage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println(id + "  " +  nameLb + "  " +  gender +"  " + age);
					MypageFrame mf = new MypageFrame();
					mf.setUserInfo(id, nameLb, gender, age);
					mf.startFrame();
				}
			});
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					f.getMyFrame().setVisible(false);
				}
			});
			p.add(btnLogout);
			p.add(btnMyPage);
		}
		// 로그인 후 메뉴에 있는 홈 버튼을 클릭하였을 때 로그인 된 사용자의 이름을 가지고 메인화면으로 가는것 구현 아직 못함.
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mf = new MainFrame(id, nameLb, gender, age);
				mf.LOGON = true;
				mf.startFrame();
				f.getMyFrame().setVisible(false);
			}
		});
		btnList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(logOn == false) {
					JOptionPane.showMessageDialog(null, "로그인 후 이용해주세요.");
					
				} else {
					ProductListFrame plf = new ProductListFrame(nameLb, id, gender, age);
					plf.startFrame();
					f.getMyFrame().setVisible(false);
				}
			}
		});
//		btnCompare.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(logOn == false) {
//					JOptionPane.showMessageDialog(null, "로그인 후 이용해주세요.");
//					
//				} else {
//					ProductCompareFrame pcf = new ProductCompareFrame();
//					pcf.startFrame();
//					f.getMyFrame().setVisible(false);
//				}
//			}
//		});
		btnClause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClauseFrame cf = new ClauseFrame();
				cf.startFrame();
			}
		});
		btnIndividual.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IndividualInfoPolicyFrame idf = new IndividualInfoPolicyFrame();
				idf.startFrame();
			}
		});
		p.add(f.getBackBtn());
		p.add(mTfTitle.getJTf());
		p.add(mTfLine.getJTf());

		p.add(btnHome);
		p.add(btnList);
//		p.add(btnCompare);
		p.add(btnClause);
		p.add(btnIndividual);

		f.getMyFrame().add(p);
		f.getMyFrame().setVisible(true);
	}

	public void setGenderAge(String id, String gender, String age) {
		this.id = id;
		this.gender = gender;
		this.age = age;
	}
	
	public void setNameLb(String nameLb) {
		this.nameLb = nameLb;
	}
	
//	public static void main(String[] args) {
//		MenuFrame mf = new MenuFrame();
//		mf.startFrame();
//	}
}
