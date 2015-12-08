package com.tatsuyaoiw.graph;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Graph {
	private static final String NEWLINE = System.getProperty("line.separator");

	private int V;
	private int E;

	private LinkedList[] adj;

	/**
	 * Create an empty graph with V vertices
	 */
	public Graph(int V) {
		init(V, 0);
	}

	public Graph(InputStream is) throws IOException {
		Scanner scanner = new Scanner(is);

		int V = scanner.nextInt();
		int E = scanner.nextInt();

		init(V, E);

		for (int i = 0; i < E; i++) {
			int v = scanner.nextInt();
			int w = scanner.nextInt();
			addEdge(v, w);
		}
	}

	private void init(int V, int E) {
		if (V < 0) {
			throw new IllegalArgumentException("Number of vertices must be non-negative");
		}
		this.V = V;

		if (E < 0) {
			throw new IllegalArgumentException("Number of edges must be non-negative");
		}
		this.E = 0;

		adj = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList();
		}
	}

	/**
	 * Number of vertices
	 */
	int V() {
		return V;
	}

	/**
	 * Number of edges
	 */
	int E() {
		return E;
	}

	/**
	 * Add an edge v-w
	 */
	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}

	/**
	 * Vertices adjacent to v
	 */
	Iterable<Integer> adj(int v) {
		return adj[v];
	}

	/**
	 * String representation
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int v = 0; v < V; v++) {
			for (int w : adj[v]) {
				builder.append(v).append('-').append(w).append(NEWLINE);
			}
		}
		return builder.toString();
	}
}
