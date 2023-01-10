package mainframe;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import joinFrame.JoinFrame;
import listPanel.TotalListPanel;
import loginframe.LoginFrame;
import menuFrame.MenuFrame;
import productListFrame.ProductListFrame;

public class MainFrame {
	public static boolean LOGON;

	private MyFrame f;
	private MyButton myBtn;
	private MyFont mfont;
	private TotalListPanel tlPanel;
	private ImagePanel p, listP;
	private ImageIcon imgMenu, imgMenuC, cMenu, imgLogin, imgLoginC, cLogin, imgJoin, imgJoinC, cJoin, imgSearch,
			imgSearchC, cSearch, imgHome, imgHomeC, cHome;
	private JButton btnMenu, btnLogin, btnJoin, btnHome, btnSearch;

	private JLabel nameLb, welcomLb;
	private String gender;
	private String age;
	
	public MainFrame() {
		myBtn = new MyButton();
		f = new MyFrame("먹기 전에 비교하자! 식품비교프로그램 [뉴트리베터]");
		// 0 - 수평방향, 1 - 수직방향 / 바의 생성 위치, 바의 채워짐 정도, 최소값은0, 최댓값은 바가 생성되는 곳의 길이
		mfont = new MyFont();
		mfont.setTf("제품명을 검색하세요!");
		imgMenu = new ImageIcon("./Button_image/Button_menu.PNG");
		imgMenuC = new ImageIcon("./Button_image/ButtonC_img.PNG");

		imgLogin = new ImageIcon("./Button_image/Login_img.PNG");
		imgLoginC = new ImageIcon("./Button_image/LoginC_img.PNG");
		imgJoin = new ImageIcon("./Button_image/Join_img.PNG");
		imgJoinC = new ImageIcon("./Button_image/JoinC_img.PNG");
		imgSearch = new ImageIcon("./Button_image/Search_img.PNG");
		imgSearchC = new ImageIcon("./Button_image/SearchC_img.PNG");
		imgHome = new ImageIcon("./Button_image/NutriBetter_Title.PNG");
		imgHomeC = new ImageIcon("./Button_image/NutriBetterC_Title.PNG");

		p = new ImagePanel(new ImageIcon(f.getBackImg()).getImage());
		listP = new ImagePanel(new ImageIcon(f.getBackImg()).getImage());

		cMenu = myBtn.changeImageSize(imgMenuC, 30, 30);
		cLogin = myBtn.changeImageSize(imgLoginC, 50, 42);
		cJoin = myBtn.changeImageSize(imgJoinC, 60, 50);
		cSearch = myBtn.changeImageSize(imgSearchC, 30, 30);
		cHome = myBtn.changeImageSize(imgHomeC, 200, 200);

		btnMenu = new JButton(myBtn.changeImageSize(imgMenu, 30, 30));
		btnLogin = new JButton(myBtn.changeImageSize(imgLogin, 50, 42));
		btnJoin = new JButton(myBtn.changeImageSize(imgJoin, 60, 50));
		btnHome = new JButton(myBtn.changeImageSize(imgHome, 200, 200));
		btnSearch = new JButton(myBtn.changeImageSize(imgSearch, 30, 30));

	}
	public MainFrame(String name, String gender, String age){
		f = new MyFrame("먹기 전에 비교하자! 식품비교프로그램 [뉴트리베터]");
		listP = new ImagePanel(new ImageIcon(f.getBackImg()).getImage());

		myBtn = new MyButton();
		mfont = new MyFont();
		mfont.setTf("제품명을 검색하세요!");
		nameLb = new JLabel(name);
		welcomLb = new JLabel("님 환영합니다.");
		
		this.gender = gender;
		this.age = age;
		
		imgMenu = new ImageIcon("./Button_image/Button_menu.PNG");
		imgMenuC = new ImageIcon("./Button_image/ButtonC_img.PNG");
		imgSearch = new ImageIcon("./Button_image/Search_img.PNG");
		imgSearchC = new ImageIcon("./Button_image/SearchC_img.PNG");
		imgHome = new ImageIcon("./Button_image/NutriBetter_Title.PNG");
		imgHomeC = new ImageIcon("./Button_image/NutriBetterC_Title.PNG");
		
		p = new ImagePanel(new ImageIcon(f.getBackImg()).getImage());
	
		cHome = myBtn.changeImageSize(imgHomeC, 200, 200);
		cMenu = myBtn.changeImageSize(imgMenuC, 30, 30);
		cSearch = myBtn.changeImageSize(imgSearchC, 30, 30);
		btnMenu = new JButton(myBtn.changeImageSize(imgMenu, 30, 30));
		btnHome = new JButton(myBtn.changeImageSize(imgHome, 200, 200));
		btnSearch = new JButton(myBtn.changeImageSize(imgSearch, 30, 30));
		
	}

	public void startFrame() {
		f.startMyFrmae();

		p.setLayout(null);
		p.setSize(500, 600);
		listP.setSize(500, 340);
		listP.setLayout(null);
		listP.setBackground(Color.white);

		btnHome.setBorder(null); // '홈'버튼 테두리 제거
//		btnMore1.setBorder(null); // '더보기'버튼 테두리 제거

		btnMenu.setBounds(10, 15, 30, 30);
		
		btnHome.setBounds(155, 90, 200, 150);
		mfont.getTf().setBounds(110, 255, 280, 30);
		btnSearch.setBounds(390, 255, 30, 30);
		
		

		myBtn.buttonOption(btnMenu, cMenu);

		myBtn.buttonOption(btnSearch, cSearch);
		myBtn.buttonOption(btnHome, cHome);

		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.getMyFrame().setVisible(false);
				f.getMyFrame().setVisible(true);

			}
		});

		tlPanel = new TotalListPanel();
		tlPanel.startTotalPanel("과자");

		tlPanel.getComboBox().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					try {
						tlPanel.resetTLPanel();
						tlPanel.startTotalPanel(e.getItem().toString());

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		tlPanel.getBtnMore().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(LOGON == false) {
					JOptionPane.showMessageDialog(null, "로그인 후 이용해주세요.");
				}else {
					ProductListFrame plf = new ProductListFrame(gender, age);
					plf.startFrame();
					
				}
			}
		});

		listP.add(tlPanel.getPanel());
		listP.setBounds(5, 290, 500, 300);

		p.add(btnMenu);
		
		if (LOGON == false) {
			btnLogin.setBounds(350, 15, 80, 30);
			btnJoin.setBounds(408, 15, 100, 30);
			myBtn.buttonOption(btnLogin, cLogin);
			myBtn.buttonOption(btnJoin, cJoin);
			
			btnMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MenuFrame mf = new MenuFrame();
					mf.setGenderAge(gender, age);
					mf.startFrame(LOGON);
					f.getMyFrame().setVisible(false);
				}
			});
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
			
			p.add(btnLogin);
			p.add(btnJoin);
		} else if (LOGON == true){
			nameLb.setBounds(360, 15, 40, 30);
			welcomLb.setBounds(410, 15, 140, 30);
			nameLb.setFont(mfont.setFont(15));
			welcomLb.setFont(mfont.setFont2());
			
			btnMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MenuFrame mf = new MenuFrame();
					mf.startFrame(LOGON);;
//					f.getMyFrame().setVisible(false);
				}
			});
			
			p.add(nameLb);
			p.add(welcomLb);
		}

		p.add(btnHome);
		p.add(mfont.getTf());
		p.add(btnSearch);
		p.add(listP);
		f.getMyFrame().add(p);

		f.getMyFrame().pack();

		f.getMyFrame().setVisible(true);
	}

	public void stopFrame() {
		f.getMyFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public JFrame getFrame() {
		return f.getMyFrame();
	}
}
