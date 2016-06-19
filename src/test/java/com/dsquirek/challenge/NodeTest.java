package com.dsquirek.challenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class NodeTest {

	@Test
	public void getChildrenTest() {
		List<GNode> children = Arrays.asList(new GraphMock().startingNode.getChildren());
		assertEquals(3, children.size());
		assertEquals("B", children.get(0).getName());
		List<GNode> children2 = Arrays.asList(children.get(0).getChildren());
		assertEquals(2, children2.size());
		assertEquals("E", children2.get(0).getName());
		assertEquals("F", children2.get(1).getName());
	}

	@Test
	public void getChildrenNoChildrenReturnsArrayOfLength0Test() {
		GNode[] nodes = new Node("A").getChildren();
		assertNotNull(nodes);
		assertEquals(0, nodes.length);
	}

	@Test
	public void walkGraphTest() {
		GraphMock graph = new GraphMock();
		List<GNode> nodes = new GraphMock().startingNode.walkGraph(graph.startingNode);
		assertEquals(nodes.size(), new HashSet<>(nodes).size());
		assertEquals(10, nodes.size());
	}

	@Test
	public void pathsTest() {
		GraphMock graph = new GraphMock();
		List<List<GNode>> paths = new GraphMock().startingNode.paths(graph.startingNode);
		assertEquals(6, paths.size());
		assertEquals(3, paths.get(0).size());
		assertEquals(3, paths.get(1).size());
		assertEquals(3, paths.get(2).size());
		assertEquals(3, paths.get(3).size());
		assertEquals(3, paths.get(4).size());
		assertEquals(3, paths.get(5).size());
		assertEquals(1, paths.get(0).stream().filter(x -> x.getName().equals("A")).collect(Collectors.toList()).size());
		assertEquals(1, paths.get(1).stream().filter(x -> x.getName().equals("A")).collect(Collectors.toList()).size());
		assertEquals(1, paths.get(2).stream().filter(x -> x.getName().equals("A")).collect(Collectors.toList()).size());
		assertEquals(1, paths.get(3).stream().filter(x -> x.getName().equals("A")).collect(Collectors.toList()).size());
		assertEquals(1, paths.get(4).stream().filter(x -> x.getName().equals("A")).collect(Collectors.toList()).size());
		assertEquals(1, paths.get(5).stream().filter(x -> x.getName().equals("A")).collect(Collectors.toList()).size());
	}

}
