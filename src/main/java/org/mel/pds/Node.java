package org.mel.pds;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Node {
	private String title;
	private String id;
	private Module module;
	private List<Node> nodes = new ArrayList<>();

	public Node() {
	}

	public Node(String title, String id) {
		this.title = title;
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	class Module {
		private String model;
		private String view;
		private String controller;

		public Module() {

		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public String getView() {
			return view;
		}

		public void setView(String view) {
			this.view = view;
		}

		public String getController() {
			return controller;
		}

		public void setController(String controller) {
			this.controller = controller;
		}

		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}

	}

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Node node = mapper.readValue(new File("C:/Users/mel/git/pds/src/main/java/org/mel/pds/menu.json"), Node.class);
		System.out.println(node);
	}
}
