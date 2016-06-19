package com.dsquirek.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node implements GNode {

	String name;
	List<GNode> children = new ArrayList<GNode>();

	public Node(String name) {
		this.name = name;
	}

	public void addChild(Node node) {
		this.children.add(node);
	}

	public void addChild(String name) {
		this.children.add(new Node(name));
	}

	public String getName() {
		return name.toUpperCase();
	}

	public GNode[] getChildren() {
		return children.stream().toArray(GNode[]::new);
	}

	public List<GNode> walkGraph(GNode node) {
		List<GNode> nodes = new ArrayList<>();
		List<GNode> children = Arrays.asList(node.getChildren());
		if (children.size() == 0) {
			nodes.add(node);
		} else {
			children.forEach(x -> {
				nodes.addAll(walkGraph(x));
			});
			nodes.add(node);
		}
		return nodes;
	}

	public List<List<GNode>> paths(GNode node) {
		List<GNode> nodes = new ArrayList<>();
		nodes.add(node);
		List<List<GNode>> paths = new ArrayList<>();
		List<GNode> children = Arrays.asList(node.getChildren());
		if (children.size() == 0) {
			paths.add(nodes);
		} else {
			children.forEach(x -> paths.addAll(paths(x)));
			paths.forEach(x -> x.addAll(nodes));
		}
		return paths;
	}
}
