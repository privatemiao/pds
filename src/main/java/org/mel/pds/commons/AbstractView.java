package org.mel.pds.commons;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public abstract class AbstractView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	public abstract String getTitle();
	
}
