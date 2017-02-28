package org.mel.pds.photo.upload;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class View extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton btn;

	public View() {
		add(new JLabel("Photo.Upload"));
		btn = new JButton("PressMe");
		setOpaque(true);
		setBackground(Color.BLACK);
	}

	public void setBtnListener(ActionListener listener) {
		btn.addActionListener(listener);
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

}
