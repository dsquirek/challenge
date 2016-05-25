package com.dsquirek.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Node implements GNode{
	
	String name;
	Node child;
	Node parent;
	boolean hasChild = false;
	
	public Node(String name){
		this.name = name;
	}
	
	private Node(String name, Node node){
		this.parent = node;
		this.name = name;
	}
	
	GNode getParent(Node node){
		return node.parent;
	}
	
	public void addChild(String name){
		this.child = new Node(name, this);
		this.hasChild = true;
	}

	public String getName() {
		return name;
	}

	public GNode[] getChildren() {
		List<GNode> children = new ArrayList<>();
		Node current = this;
		while(current.hasChild){
			children.add(child);
			current = child;
		}
		return children.stream().toArray(GNode[]::new);
	}
	
	public List<GNode> walkGraph(GNode node){
		List<GNode> nodes = new ArrayList<>();
		nodes.add(node);
		List<GNode> children = Arrays.asList(node.getChildren());
		nodes.addAll(children);
		return nodes;
	}

	@Override
	public List<List<GNode>> path(GNode node) {	
		List<List<GNode>> paths = new ArrayList<>();
		List<GNode> children = node.walkGraph(node);
		List<GNode> lasts = children.stream().map(x -> getLastNode(x)).collect(Collectors.toList());
		lasts.forEach(x -> {
			paths.add(backFillNodes(x));
			
		});
		return null;
	}
	
	private GNode getLastNode(GNode node){
		//running low on time so I am moving on
		return null;
	}
	
	private List<GNode> backFillNodes(GNode node){
		List<GNode> nodes = new ArrayList<>();
		while(node.getParent() != null){
			nodes.add(node);
		}
		Collections.reverse(nodes);
		return nodes;
	}

	@Override
	public GNode getParent() {
		return null;
	}

}
