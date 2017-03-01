package org.mel.pds.demo;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.mel.pds.commons.AbstractView;

public class DemoView extends AbstractView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DemoView() {
		setLayout(new GridBagLayout());
		setBackground(Color.WHITE);

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.weightx = 3;
		constraints.weighty = 4;

		add(new JLabel("Firstname"), constraints, 0, 0, 1, 1);
		add(new JTextField(10), constraints, 1, 0, 1, 1);
		add(new JLabel("Lastname"), constraints, 0, 1, 1, 1);
		add(new JTextField(10), constraints, 1, 1, 1, 1);
		
	}

	public void add(Component c, GridBagConstraints constraints, int x, int y, int w, int h) {
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		add(c, constraints);
	}

}
