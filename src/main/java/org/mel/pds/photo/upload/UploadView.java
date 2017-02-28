package org.mel.pds.photo.upload;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.mel.pds.commons.AbstractView;

public class UploadView extends AbstractView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton btn;

	public UploadView() {
		add(new JLabel("Photo.Upload"));
		btn = new JButton("PressMe");
		setOpaque(true);
	}

	public void setBtnListener(ActionListener listener) {
		btn.addActionListener(listener);
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

}
