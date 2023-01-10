package productDetailInfoFrame;

import javax.swing.ImageIcon;

import mainframe.ImagePanel;
import mainframe.MyFrame;

public class ProducDetailFrame {
	private MyFrame f;
	private ImagePanel p;

	
	public ProducDetailFrame() {
		f = new MyFrame("제품 리스트_[뉴트리베터]");
		p = new ImagePanel(new ImageIcon(f.getBackImg()).getImage());

		
	}
	
	public void startFrame() {
		f.startMyFrmae();
		f.startBackBtn();
		f.backBtnDispose();

		
		
		
		p.add(f.getBackBtn());
		f.getMyFrame().add(p);
		f.getMyFrame().setVisible(true);
	}
	
	public static void main(String[] args) {
		ProducDetailFrame plf = new ProducDetailFrame();
		plf.startFrame();
	}
}
