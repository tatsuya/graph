package com.tatsuyaoiw.graph;

public class Graph {
	private int V;
	private int E = 0;

	private LinkedList[] adj;

	/**
	 * Create an empty graph with V vertices
	 */
	public Graph(int V) {
		this.V = V;
		adj = new LinkedList[V];

		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList();
		}
	}

	/**
	 * Add an edge v-w
	 */
	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	/**
	 * Vertices adjacent to v
	 */
	Iterable<Integer> adj(int v) {
		return adj[v];
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
	 * String representation
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int v = 0; v < adj.length; v++) {
			for (Integer w : adj[v]) {
				builder.append(v).append('-').append(w).append('\n');
			}
		}
		return builder.toString();
	}
}
