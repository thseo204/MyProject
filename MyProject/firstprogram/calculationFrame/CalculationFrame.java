package calculationFrame;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import mainFrame.ImagePanel;
import mainFrame.MainDAO;
import mainFrame.MyFont;
import mainFrame.MyFrame;
import mainFrame.MyTextField;

public class CalculationFrame extends MyFrame {
//	private MyFrame f;
	private ImagePanel p;
//	private MyFont mfont;
	private MyTextField mTf, ageTf;
	private JButton btnRun;
	private JLabel lbGender, lbAge, lbResult1, lbResult2, lbResult3;
	private JRadioButton[] gender;
	private ButtonGroup group;
	private String genderStr;
	private String id, userGender, age, name;
	
	public CalculationFrame(String id, String userGender, String age, String name) {
		super("[뉴트리베터]_성/연령별 권장 칼로리 계산");
		this.id = id;
		this.userGender = userGender;
		this.age = age;
		this.name = name;
		
//		f = new MyFrame("[뉴트리베터]_성/연령별 권장 칼로리 계산");
		p = new ImagePanel(new ImageIcon(imgBack).getImage());
//		p = new ImagePanel(new ImageIcon(f.getBackImg()).getImage());
//		mfont = new MyFont();
		mTf = new MyTextField("성/연령별 권장 칼로리 계산", 18);
		btnRun = new JButton("계산하기");
		
		lbAge = new JLabel("나이", JLabel.CENTER);
		ageTf = new MyTextField();
//		resultTf = new MyTextField("", 20);
		lbGender = new JLabel("성별", JLabel.CENTER);
		gender = new JRadioButton[2];
		gender[0] = new JRadioButton("남      |");
		gender[1] = new JRadioButton("여 ");
		
		lbResult1 = new JLabel("", JLabel.CENTER);
		lbResult2 = new JLabel("", JLabel.CENTER);
		lbResult3 = new JLabel("", JLabel.CENTER);
		
		group = new ButtonGroup();
		group.add(gender[0]);
		group.add(gender[1]);
		
	}
	
	public void startFrame() {
		startMyFrame();
		startBackBtn();
//		backBtnMainStart();
//		f.startMyFrmae();
//		f.startBackBtn();
		backBtnDispose();
		p.setLayout(null);
		
		mTf.getJTf().setFont(setFont(18));
		mTf.getJTf().setBounds(25, 80, 250, 20);
		
		ageTf.getTf().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				TextField src = (TextField) ke.getSource();
				if(src.getText().length() >= 2) {
					ke.consume();
				} else if(!Character.isDigit(c)) { // 숫자만 입력받을 수 있도록!
					ke.consume();
				}
//				else if(src.getText().length() < 6){
//					tfBarth.getTf().setEditable(true);
//				}
			}
		});
		
		lbAge.setBounds(310, 150, 80, 25);
		lbAge.setFont(setFont(25));
		ageTf.setTf("나이 입력");
		ageTf.getTf().setBounds(290, 190, 130, 30);
		lbGender.setBounds(102, 150, 80, 25);
		lbGender.setFont(setFont(25));
		gender[0].setBounds(80, 190, 90, 30);
		gender[1].setBounds(160, 190, 90, 30);
		
		btnRun.setFont(setFont(12));
		btnRun.setBounds(200, 250, 100, 50);

		lbResult1.setBounds(50, 360, 400, 30);
		lbResult1.setFont(setFont(20));
		lbResult2.setBounds(50, 390, 400, 30);
		lbResult2.setFont(setFont(20));
		lbResult3.setBounds(50, 420, 400, 30);
		lbResult3.setFont(setFont(20));
//		resultTf.getJTf().setBounds(80, 330, 300, 30);
//		resultTf.getJTf().setFont(mfont.setFont(20));
		
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean[] b = new boolean[2];
				for(int i = 0; i < b.length; i++) {
					b[i] = false;
				}
				
				if(gender[0].isSelected()) {
					genderStr = "남";
					b[0] = true;
				} else if(gender[1].isSelected()){
					genderStr = "여";
					b[0] = true;
				}
				
				if(ageTf.getTf().getText() != null) {
					b[1] = true;
				}
				// 빈칸 있는지 확인.
				int count = 0;
				for(int i = 0; i < b.length; i++) {
					if(b[i] == true) {
						count++;
					}
				}
				if(count < 2) {
					JOptionPane.showMessageDialog(null, "성별과 나이 모두 입력해주세요.");
				} else {
					MainDAO DAO = new MainDAO();
					int kcal = DAO.queryKcal(genderStr, ageTf.getTf().getText());
					lbResult1.setText(ageTf.getTf().getText() + "세, " + genderStr + "성의 ");
					lbResult2.setText("일일 권장 섭취 칼로리는");
					lbResult3.setText(kcal + "Kcal 입니다.");
//					resultTf.getJTf().setText(ageTf.getTf().getText() + "세, " + genderStr + "성의 \n일일 권장 섭취 칼로리는\n " + kcal + "Kcal 입니다.");
				}
			}
		});

		
		p.add(lbGender);
		p.add(gender[0]);
		p.add(gender[1]);
		p.add(lbAge);
		p.add(ageTf.getTf());
		p.add(btnRun);
		p.add(lbResult1);
		p.add(lbResult2);
		p.add(lbResult3);
//		p.add(resultTf.getJTf());
		p.add(mTf.getJTf());
		p.add(btnBefore);
		getMyFrame().add(p);
		getMyFrame().setVisible(true);
//		p.add(f.getBackBtn());
//		f.getMyFrame().add(p);
//		f.getMyFrame().setVisible(true);
	}
	
//	public static void main(String[] args) {
//		MainDAO.connDB();
//		CalculationFrame plf = new CalculationFrame();
//		plf.startFrame();
//	}
}
