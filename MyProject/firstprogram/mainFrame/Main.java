package mainFrame;

import java.sql.SQLException;

public class Main{
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MainDAO.connDB();

		MainFrame mf = new MainFrame();
		mf.startFrame();
	}


}
