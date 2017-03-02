package org.mel.pds;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

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
		try {
			setIconImage(ImageIO.read(getClass().getResourceAsStream("/box-16.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setTitle(FRAME_TITLE);

		setLayout(new BorderLayout());
		setContentPane(createContentPane());

		setSize(DIMENSION);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		if (SystemTray.isSupported()) {
			createTray();
		}
	}

	private void createTray() {
		JFrame frame = this;
		SystemTray tray = SystemTray.getSystemTray();
		Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/box-16.png"));
		TrayIcon trayIcon = new TrayIcon(image, "PDS(Show/Hide)");

		PopupMenu popupMenu = new PopupMenu();
		MenuItem menuItem = new MenuItem("Exit");
		popupMenu.add(menuItem);
		trayIcon.setPopupMenu(popupMenu);

		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});

		trayIcon.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					frame.setVisible(!frame.isVisible());
				}
			}
		});
		try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void setUpUI() {
		setJMenuBar(createMenuBar());
	}

	private Container createContentPane() {
		JPanel panel = new JPanel();
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
			if (subNode.getNodes().size() == 0) {
				menuItem = new JMenuItem(subNode.getTitle());
				menuItem.addActionListener(menuListener);
				menuItem.setActionCommand(subNode.getId());
			} else {
				menuItem = createJMenu(subNode);
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

	public void showMessage(String message) {
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
