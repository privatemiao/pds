package org.mel.pds;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String FRAME_TITLE = "Welcome Pandora Daemon Server";
	private static final Dimension DIMENSION = new Dimension(600, 400);

	public MainFrame() throws HeadlessException {
		setTitle(FRAME_TITLE);

		setJMenuBar(createMenuBar());
		setContentPane(createContentPane());

		setSize(DIMENSION);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private Container createContentPane() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(true);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		for (int i = 0; i < 200; i ++){
			scrollPane.add(new JLabel("Welcome " + (i + 1) ));
		}
		
		
		
		
		panel.setBackground(Color.WHITE);
		return panel;
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		//first menu.
		JMenu menu = new JMenu("A Menu");
		menuBar.add(menu);
		
		return menuBar;
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

}
