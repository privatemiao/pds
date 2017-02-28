package org.mel.pds;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String FRAME_TITLE = "Welcome Pandora Daemon Server";
	private static final Dimension DIMENSION = new Dimension(600, 400);

	private List<Node> nodes = null;

	private ActionListener menuListener = null;

	public MainFrame() throws HeadlessException {
		setTitle(FRAME_TITLE);

		setLayout(new BorderLayout());
		setContentPane(createContentPane());

		setSize(DIMENSION);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setUpUI() {
		setJMenuBar(createMenuBar());
	}

	private Container createContentPane() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(true);
		panel.setBackground(Color.WHITE);
		return panel;
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		for (Node node : nodes) {
			menuBar.add(createJMenu(node));
		}
		return menuBar;
	}

	private JMenu createJMenu(Node node) {
		JMenu menu = new JMenu(node.getTitle());
		for (Node subNode : node.getNodes()) {
			JMenuItem menuItem = null;
			if (subNode.getNodes().size() == 0){
				menuItem = new JMenuItem(subNode.getTitle());
				menuItem.addActionListener(menuListener);
			}else{
				menuItem =  createJMenu(subNode);
			}
			menu.add(menuItem);
		}
		return menu;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public void setMenuListener(ActionListener menuListener) {
		this.menuListener = menuListener;
	}
	
	public void showMessage(String message){
		JOptionPane.showMessageDialog(this, message);
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
