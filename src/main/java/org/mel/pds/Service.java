package org.mel.pds;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mel.pds.photo.upload.Model;
import org.mel.pds.photo.upload.View;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Service {

	private List<Node> nodes = null;
	private Map<String, MenuActionListener> menuListeners = new HashMap<>();
	private MainFrame mainFrame = null;

	Service(MainFrame mainFrame) {
		this.mainFrame = mainFrame;

		ObjectMapper mapper = new ObjectMapper();
		try {
			Node node = mapper.readValue(getClass().getResourceAsStream("menu.json"), Node.class);
			if (node != null && node.getNodes().size() > 0) {
				nodes = node.getNodes();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		prepareMenuListener();
		this.mainFrame.setNodes(nodes);
		this.mainFrame.setMenuListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MenuActionListener listener = menuListeners.get(e.getActionCommand());
				if (listener == null) {
					mainFrame.showMessage("There is not handler for this menu.");
					return;
				}
				listener.doProcess(e);
			}
		});
		this.mainFrame.setUpUI();
	}

	private void prepareMenuListener() {
		menuListeners.put("photo.upload", new MenuActionListener() {

			@Override
			public void doProcess(ActionEvent e) {
				try {
					View view = (View) Class.forName("org.mel.pds.photo.upload.View").newInstance();
					Model model = (Model) Class.forName("org.mel.pds.photo.upload.Model").newInstance();
					Object controller = Class.forName("org.mel.pds.photo.upload.Controller").getConstructor(View.class, Model.class).newInstance(view, model);
					mainFrame.setContentPane(view);
					mainFrame.repaint();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchMethodException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}

	public List<Node> getNodes() {
		return nodes == null ? Collections.emptyList() : nodes;
	}

}
