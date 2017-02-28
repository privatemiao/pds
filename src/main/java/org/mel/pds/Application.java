package org.mel.pds;

public class Application {
	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		new Service(mainFrame);
		mainFrame.setVisible(true);
		
	}
}
