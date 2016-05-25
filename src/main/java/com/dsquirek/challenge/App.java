package com.dsquirek.challenge;

import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		new App().testWalkGraph();
		new App().testWalkGraphNoChildren();
		new App().wordCountTest();
	}

	public void testWalkGraph() {
		Node node1 = new Node("first");
		node1.addChild("second");

		List<GNode> nodesList = node1.walkGraph(node1);
		nodesList.forEach(x -> {
			System.out.println(x.getName());
		});
	}

	public void testWalkGraphNoChildren() {

		Node node2 = new Node("no children");

		List<GNode> nodesList2 = node2.walkGraph(node2);
		nodesList2.forEach(x -> {
			System.out.println(x.getName());
		});
	}

	public void wordCountTest() {
		FileReader reader = new FileReader("file path");
		Map<Integer, String> words = reader.getwords(
				"Hello world hello this is only only just a test, again this is only a test hello world");
		words.entrySet().forEach(x -> System.out.println(x.getValue() + " " + x.getKey()));
		System.out.println(words.size());
		System.out.println("done");
	}
}
