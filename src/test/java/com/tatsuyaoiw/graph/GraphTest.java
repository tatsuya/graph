package com.tatsuyaoiw.graph;

import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GraphTest {

	@Test
	public void testCreateFromFile() throws Exception {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("graph.txt");
		Graph graph = new Graph(is);

		assertEquals(13, graph.V());
		assertEquals(13, graph.E());
		List<Integer> vertices = new ArrayList<Integer>();
		for (Integer vertex : graph.adj(0)) {
			vertices.add(vertex);
		}
		assertEquals(4, vertices.size());
		assertEquals(6, vertices.get(0).intValue());
		assertEquals(2, vertices.get(1).intValue());
		assertEquals(1, vertices.get(2).intValue());
		assertEquals(5, vertices.get(3).intValue());
	}

	@Test
	public void testCreateAndAddEdges() throws Exception {
		Graph graph = new Graph(13);
		graph.addEdge(0, 5);
		graph.addEdge(4, 3);
		graph.addEdge(0, 1);
		graph.addEdge(9, 12);
		graph.addEdge(6, 4);
		graph.addEdge(5, 4);
		graph.addEdge(0, 2);
		graph.addEdge(11, 12);
		graph.addEdge(9, 10);
		graph.addEdge(0, 6);
		graph.addEdge(7, 8);
		graph.addEdge(9, 11);
		graph.addEdge(5, 3);

		assertEquals(13, graph.V());
		assertEquals(13, graph.E());
		List<Integer> vertices = new ArrayList<Integer>();
		for (Integer vertex : graph.adj(0)) {
			vertices.add(vertex);
		}
		assertEquals(4, vertices.size());
		assertEquals(6, vertices.get(0).intValue());
		assertEquals(2, vertices.get(1).intValue());
		assertEquals(1, vertices.get(2).intValue());
		assertEquals(5, vertices.get(3).intValue());
	}
}