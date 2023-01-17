package individualInfoPolicyFrame;

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

public class IndividualInfoPolicyFrame {
	private MyFrame f;
	private ImagePanel p;
	private MyFont mfont;
	private MyTextField mTf;
	private JScrollPane scroll;
	private JTextArea textArea;
	private JButton btnOk;
	
	public IndividualInfoPolicyFrame() {
		f = new MyFrame("[뉴트리베터]_개인정보처리방침");
		p = new ImagePanel(new ImageIcon(f.getBackImg()).getImage());
		mfont = new MyFont();
		mTf = new MyTextField("개인정보처리방침", 18);
		btnOk = new JButton("확인");
		textArea = new JTextArea("뉴트리베터 개인정보 처리방침\n"
				+ "\n"
				+ "\n"
				+ "뉴트리베터는 개인정보보호법에 따라 뉴트리베터 서비스(이하 “서비스”) 이용자의 개인정보 보호 및 권익을 보호하고 개인정보와 관련한 이용자의 고충을 원활하게 처리할 수 있도록 다음과 같은 처리방침을 두고 있습니다.\n"
				+ "\n"
				+ "\n"
				+ "1. 개인정보 수집 목적 및 방식\n"
				+ "“회사”는 다음의 목적을 위하여 개인정보를 처리하고 있으며, 다음의 목적 이외의 용도로는 이용하지 않습니다. \n"
				+ "- 수집 목적: 고객 가입신청 확인 및 수락, 고객에 대한 “서비스” 제공에 따른 본인 식별·인증, 회원자격 유지·관리, 민원사무 처리, 마케팅 및 광고, “서비스” 유효성 확인, 접속빈도 파악 등 회원의 “서비스” 이용에 대한 통계 등\n"
				+ "\n"
				+ "\n"
				+ "2. 개인정보의 처리 및 보유기간\n"
				+ "① “회사”는 정보주체로부터 개인정보를 수집할 때 동의를 얻은 개인정보 보유·이용기간 또는 법령에 따른 개인정보 보유·이용기간 내에서 개인정보를 처리·보유합니다.\n"
				+ "② 구체적인 개인정보 처리 및 보유 기간은 다음과 같습니다.\n"
				+ "\n"
				+ "- 고객 가입 및 관리 : 고객의 가입신청일로부터 회원계약의 해지일까지\n"
				+ "- 소비자의 불만 또는 분쟁처리에 관한 기록 : 3년, 신용정보의 수집/처리 및 이용 등에 관한 기록 : 3년, 대금결제 및 재화 등의 공급에 관한 기록 : 5년, 계약 또는 청약철회 등에 관한 기록 : 5년, 표시/광고에 관한 기록 : 6개월, 접속에 관한 기록 : 1년\n"
				+ "\n"
				+ "3. 개인정보의 제3자 제공\n"
				+ "“회사”는 정보주체의 별도 동의, 법률의 특별한 규정 등 개인정보 보호법 제17조에 해당하는 경우 외에는 개인정보를 제3자에게 제공하지 않습니다.\n"
				+ "\n"
				+ "4. 개인정보처리의 위탁\n"
				+ "① “회사”는 개인정보 처리업무를 위탁하고 있지 않습니다.\n"
				+ "② 위탁업무의 내용이나 수탁자가 변경될 경우에는 지체없이 본 개인정보 처리방침을 통하여 공개하도록 하겠습니다.\n"
				+ "\n"
				+ "5. 정보주체와 법정대리인의 권리․의무 및 행사방법\n"
				+ "정보주체는 “회사”에 대해 언제든지 다음 각 호의 개인정보 보호 관련 권리를 행사할 수 있습니다.\n"
				+ "1) 개인정보 열람요구\n"
				+ "2) 개인정보에 오류 등이 있을 경우 정정 요구\n"
				+ "3) 삭제요구\n"
				+ "4) 처리정지 요구\n"
				+ "\n"
				+ "\n"
				+ "6. 처리하는 개인정보 항목\n"
				+ "“회사”는 다음의 개인정보 항목을 처리하고 있습니다.\n"
				+ "- 고객의 회원 ID, 이메일, 성명, 성별, 생년월일, 접속 IP 정보, 기기정보, “서비스” 이용 기록, 접속 로그 (자동수집)\n"
				+ "\n"
				+ "7. 개인정보의 파기\n"
				+ "① “회사”는 개인정보 보유기간의 경과, 처리목적 달성 등 개인정보가 불필요하게 되었을 때에는 지체없이 해당 개인정보를 파기합니다.\n"
				+ "② “회사”는 다음의 방법으로 개인정보를 파기합니다.\n"
				+ "- 전자적 파일 : 파일 삭제 및 디스크 등 저장매체 포맷\n"
				+ "③ 휴면 계정의 개인정보 파기절차\n"
				+ "- “회사”는 관련 법령에 따라 “서비스”에 1년 이상 로그인하지 않은 계정은 개인정보보호를 위하여 해당 회원의 개인정보를 휴면 계정으로 전환 및 별도 관리합니다.\n"
				+ "- 휴면 처리되는 회원정보 : 회원가입 시 또는 회원정보 수정으로 수집/관리되는 모든 정보\n"
				+ "- “회사”는 휴면 계정의 개인정보 분리·저장 기간이 도래하기 1개월 전에 이메일 등을 통해 해당 이용자에게 관련 내용을 공지합니다.\n"
				+ "- 휴면 처리된 계정의 개인정보는 분리 보관 시작으로부터 3년이 경과하면 지체없이 파기합니다.\n"
				+ "\n"
				+ "8. 개인정보의 안전성 확보조치\n"
				+ "“회사”는 개인정보의 안전성 확보를 위해 다음과 같은 조치를 취하고 있습니다.\n"
				+ "\n"
				+ "- 관리적 조치 : 내부관리계획 수립․시행, 직원․종업원 등에 대한 정기적 교육\n"
				+ "- 기술적 조치 : 개인정보처리시스템(또는 개인정보가 저장된 컴퓨터)의 비밀번호 설정 등 접근권한 관리, 백신소프트웨어 등 보안프로그램 설치, 개인정보가 저장된 파일의 암호화\n"
				+ "- 물리적 조치 : 개인정보가 저장․보관된 장소의 접속시간, 출입통제 등\n"
				+ "\n"
				+ "9. 개인정보 자동 수집 장치의 설치∙운영 및 거부에 관한 사항\n"
				+ "“회사”는 이용자의 정보를 수시로 저장하고 찾아내는 “쿠키(cookie)” 등을 사용합니다. \"쿠키(cookie)\"란 사이트 접속 시 이용자의 저장장치에 전송하는 특별한 텍스트 파일(text file)을 말합니다. 쿠키는 웹사이트가 이용자의 컴퓨터 인터넷 브라우저로 전송하는 소량의 정보이며, 컴퓨터 디스크에 저장됩니다. 모바일 애플리케이션과 같이 쿠키 기술을 사용할 수 없는 경우에는 쿠키와 유사한 기능을 수행하는 기술(광고식별자 등)을 사용할 수도 있습니다.\n"
				+ "\n"
				+ "- 쿠키 등 사용 목적 로그인 식별/이용자의 사용 기록/기존 홈페이지 방문 또는 앱 사용 회수 파악 등을 통한 개인 맞춤 “서비스” 제공 등을 위해 쿠키를 운용합니다. 이용자는 쿠키 설치에 대한 선택권을 가지고 있습니다.\n"
				+ "- 쿠키 설정 거부 방법 쿠키 설정을 거부하는 방법으로는 이용자가 사용하는 앱이나 웹 브라우저의 옵션을 선택함으로써 모든 쿠키를 허용하거나 쿠키를 저장할 때마다 확인을 거치거나, 모든 쿠키의 저장을 거부할 수 있습니다.\n"
				+ "\n"
				+ "10. 개인정보 보호책임자\n"
				+ "“회사”는 개인정보 처리에 관한 업무를 총괄해서 책임지고, 개인정보 처리와 관련한 정보주체의 불만처리 및 피해구제를 처리하기 위하여 아래와 같이 개인정보 보호책임자를 지정하고 있습니다.\n"
				+ "\n"
				+ "▶ 개인정보 보호책임자\n"
				+ "\n"
				+ "성명 : 서태화\n"
				+ "소속 및 직위 : Product 본부 / 소프트웨어개발자\n"
				+ "연락처 : 010-7677-1754, thseo204@gmail.com\n"
				+ "\n"
				+ "기타 개인정보침해에 관한 신고나 상담이 필요하신 경우에는 아래 기관에 문의하여 주시기 바랍니다.\n"
				+ "개인정보침해신고센터(privacy.kisa.or.kr / 국번없이 118)\n"
				+ "대검찰청 사이버수사과(www.spo.go.kr / 국번없이 1301)\n"
				+ "경찰청 사이버안전국(www.cyber.go.kr / 국번없이 182)\n"
				+ "개인정보 분쟁조정위원회(www.kopico.go.kr/ 1833-6972)");
		scroll = new JScrollPane(textArea);
	}
	
	public void startFrame() {
		f.startMyFrmae();
		f.startBackBtn();
		f.backBtnDispose();
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
				f.getMyFrame().dispose();
			}
		});
		
		
		btnOk.setFont(mfont.setPlainFont(12));
		
		mTf.getJTf().setFont(mfont.setFont(18));
		mTf.getJTf().setBounds(25, 80, 140, 20);
		btnOk.setBounds(400, 520, 80, 30);
		
		p.add(btnOk);
		p.add(scroll);
		p.add(mTf.getJTf());
		p.add(f.getBackBtn());
		f.getMyFrame().add(p);
		f.getMyFrame().setVisible(true);
	}
	
	public static void main(String[] args) {
		IndividualInfoPolicyFrame plf = new IndividualInfoPolicyFrame();
		plf.startFrame();
	}
}
