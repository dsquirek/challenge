package com.dsquirek.challenge;

public class GraphMock {
	public Node startingNode;
	public int size = 10;

	public GraphMock() {
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Node f = new Node("F");
		Node g = new Node("G");
		Node h = new Node("H");
		Node i = new Node("I");
		Node j = new Node("J");
		a.addChild(b);
		a.addChild(c);
		a.addChild(d);
		b.addChild(e);
		b.addChild(f);
		c.addChild(g);
		c.addChild(h);
		c.addChild(i);
		d.addChild(j);
		this.startingNode = a;
	}

}
