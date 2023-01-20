package clauseFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import mainFrame.ImagePanel;
import mainFrame.MyFont;
import mainFrame.MyFrame;
import mainFrame.MyTextField;

public class ClauseFrame extends MyFrame{
//	private MyFrame f;
	private ImagePanel p;
//	private MyFont mfont;
	private MyTextField mTf;
	private JScrollPane scroll;
	private JTextArea textArea;
	private JButton btnOk;
	
	public ClauseFrame() {
		super("[뉴트리베터]_서비스 이용약관");
//		f = new MyFrame("[뉴트리베터]_서비스 이용약관");
		p = new ImagePanel(new ImageIcon(imgBack).getImage());
//		mfont = new MyFont();
		mTf = new MyTextField("서비스 이용약관", 18);
		btnOk = new JButton("확인");
		
		textArea = new JTextArea("뉴트리베터 이용약관\n"
				+ "\n"
				+ "1. 뉴트리베터 회원은 뉴트리베터가 제공하는 서비스 이용동의에 동의함으로써 뉴트리베터 서비스에 가입하고 이용할 수 있습니다.\n"
				+ "\n"
				+ "2. 본 약관은 본 서비스를 이용하고자 하는 모든 회원에게 그 효력을 발생합니다. 회사는 필요하다고 인정되는 경우 약관의 규제에 관한 법률 및 기타 관련 법령에 위배되지 않는 범위에서 본 약관의 내용을 개정할 수 있으며, 약관을 변경하는 경우에는 전 항과 같은 방법으로 그 시행일 14일 전에 회원에게 공지합니다. 다만, 회원에게 불리한 약관의 변경인 경우에는 그 적용일자 30일 전부터 공지합니다.\n"
				+ "\n"
				+ "3. 회사가 제2항에 따라 변경된 약관을 공지하면서, 회원에게 약관 변경 적용일까지 거부의사를 표시하지 아니할 경우, 약관의 변경에 동의한 것으로 간주한다는 내용을 공지하였음에도 회원이 명시적으로 약관 변경에 대한 거부의사를 표시하지 아니하면, 회원이 변경된 약관에 동의한 것으로 간주합니다. 회원은 변경된 약관 사항에 동의하지 않는 경우, 본 서비스의 이용을 중단하고 이용 계약을 해지할 수 있습니다.\n"
				+ "\n"
				+ "4. 회사는 언제든 본 서비스를 변경하거나 중단할 수 있습니다. 이 경우 회사는 변경되거나 중단될 서비스의 내용 및 일자를 회원에게 공지 및 이메일을 통해 알려드립니다.\n"
				+ "\n"
				+ "5. 회사는 다음 각 호에 해당하는 경우 본 서비스의 전부 또는 일부를 제한하거나 중지할 수 있습니다.\n"
				+ "1) 서비스용 설비의 보수 등 공사로 인한 부득이한 경우\n"
				+ "2) 회원이 본 서비스 운영을 방해하는 경우\n"
				+ "3) 정전, 제반 설비의 장애 또는 이용량의 폭주 등으로 정상적인 서비스 이용에 지장이 있는 경우\n"
				+ "4) 본 서비스의 변경 및 중단 등과 같은 특수한 사정으로 본 서비스를 유지할 수 없는 경우\n"
				+ "5) 사업상 판단에 의하여 본 서비스를 더 이상 운영하지 아니하기로 결정하는 경우\n"
				+ "6) 기타 천재지변, 국가비상사태 등 불가항력적 사유가 있는 경우\n"
				+ "\n"
				+ "6. 전 항에 의하여 본 서비스를 중단하는 경우에는 회사가 제14조에서 정한 방법으로 회원에게 공지 또는 통지합니다. 다만, 회사가 통제할 수 없는 사유로 인한 본 서비스의 중단으로 인하여 사전 공지 또는 통지가 불가능한 경우에는 그러하지 아니합니다.\n"
				+ "\n"
				+ "7. 본 약관에서 정하지 않은 사항에 대해서는 회사의 뉴트리베터 이용약관 등 규정이 적용됩니다.\n"
				+ "\n"
				+ "부칙\n"
				+ "본 약관은 2023년 1월 31부터 시행합니다.");
		scroll = new JScrollPane(textArea);
		
	}
	
	public void startFrame() {
		startMyFrame();
		startBackBtn();
		backBtnDispose();
		p.setLayout(null);
		
		textArea.setEditable(false); // 편집 불가능
		textArea.setLineWrap(true); // 행 넘기기 기능 켜기
		textArea.setWrapStyleWord(true); // 행 넘길때행의 마지막 단어가 두 행에 걸쳐 나뉘지 않도록 하기
		
		// textArea 의 테두리 선의 색과 두께 설정 가능.
		Border lineBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3);
		// textArea 와 텍스트 경계 사이에 여백을 두기 위해 emptyBorder 생성
		Border emptyBorder = BorderFactory.createEmptyBorder(20, 20, 20, 20);
		// textArea 에 lineBorder, emptyBorder 로 구성된 복함 경계선을 설정.
		textArea.setBorder(BorderFactory.createCompoundBorder(lineBorder,emptyBorder));
		
		scroll.setBounds(15, 110, 470, 400);
		// 필요할때만 수직 스크롤바가 보이도록 설정함.
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		// 수평 스크롤바사용 안함.
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getMyFrame().dispose();
			}
		});
		
		btnOk.setFont(setPlainFont(12));
		
		mTf.getJTf().setFont(setFont(18));
		mTf.getJTf().setBounds(25, 80, 140, 20);
		btnOk.setBounds(400, 520, 80, 30);
		
		p.add(btnOk);
		p.add(scroll);
		p.add(mTf.getJTf());
		p.add(btnBefore);
		getMyFrame().add(p);
		getMyFrame().setVisible(true);
	}
	
//	public static void main(String[] args) {
//		ClauseFrame plf = new ClauseFrame();
//		plf.startFrame();
//	}
}
