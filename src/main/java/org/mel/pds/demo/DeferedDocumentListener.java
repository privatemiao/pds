package org.mel.pds.demo;

import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DeferedDocumentListener implements DocumentListener {
	private Timer timer;

	public DeferedDocumentListener(int delay, ActionListener listener) {
		timer = new Timer(delay, listener);
		timer.setRepeats(false);
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		timer.restart();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		timer.restart();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		timer.restart();
	}

}
