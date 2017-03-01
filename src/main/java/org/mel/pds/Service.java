package org.mel.pds;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.mel.pds.Node.Module;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Service {

	private List<Node> nodes = null;
	private Map<String, Node> nodeIndex = new HashMap<>();
	private MainFrame mainFrame = null;

	Service(MainFrame mainFrame) {
		this.mainFrame = mainFrame;

		ObjectMapper mapper = new ObjectMapper();
		try {
			Node node = mapper.readValue(getClass().getResourceAsStream("menu.json"), Node.class);
			if (node != null && node.getNodes().size() > 0) {
				nodes = node.getNodes();
			}
			if (CollectionUtils.isEmpty(nodes)) {
				nodes = Collections.emptyList();
			} else {
				indexNodes();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.mainFrame.setNodes(nodes);
		this.mainFrame.setMenuListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				Node node = nodeIndex.get(event.getActionCommand());
				if (StringUtils.isEmpty(event.getActionCommand()) || node == null){
					mainFrame.showMessage("This operation not pair yet!");
					return;
				}
				
				Module module = node.getModule();
				if (module == null){
					mainFrame.showMessage("This operation not ready yet!");
					return;
				}
				
				try {
					Class<?> modelClass = Class.forName(module.getModel());
					Class<?> viewClass = Class.forName(module.getView());
					Container container = (Container) viewClass.newInstance();
					if (modelClass == null){
						Class.forName(module.getController()).getConstructor(viewClass).newInstance(container);
					}else{
						Class.forName(module.getController()).getConstructor(viewClass, modelClass).newInstance(container, modelClass.newInstance());
					}
					mainFrame.setContentPane(container);
					mainFrame.repaint();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		this.mainFrame.setUpUI();
	}

	private void indexNodes() {
		if (CollectionUtils.isEmpty(nodes)){
			return;
		}
		
		for (Node node : nodes) {
			nodeIndex.put(node.getId(), node);
			if (!CollectionUtils.isEmpty(node.getNodes())){
				indexSubNodes(node.getNodes());
			}
		}
			
	}


	private void indexSubNodes(List<Node> nodes) {
		for (Node node : nodes) {
			nodeIndex.put(node.getId(), node);
			if (!CollectionUtils.isEmpty(node.getNodes())){
				indexSubNodes(node.getNodes());
			}
		}
	}

	public List<Node> getNodes() {
		return nodes == null ? Collections.emptyList() : nodes;
	}

}
