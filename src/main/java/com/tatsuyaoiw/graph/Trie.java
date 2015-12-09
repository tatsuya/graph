package com.tatsuyaoiw.graph;

public class Trie {
	private static final int R = 256; // extended ASCII
	private Node root = new Node();

	private static class Node {
		Object value;
		Node[] next = new Node[R];
	}

	public void put(String key, Object value) {
		root = put(root, key, value, 0);
	}

	private Node put(Node node, String key, Object value, int d) {
		if (node == null) {
			node = new Node();
		}

		if (d == key.length()) {
			node.value = value;
			return node;
		}

		char c = key.charAt(d);
		node.next[c] = put(node.next[c], key, value, d+1);

		return node;
	}

	public Object get(String key) {
		Node node = get(root, key, 0);
		if (node == null) {
			return null;
		}
		return node.value;
	}

	private Node get(Node node, String key, int d) {
		if (node == null) {
			return null;
		}

		if (d == key.length()) {
			return node;
		}

		char c = key.charAt(d);
		return get(node.next[c], key, d+1);
	}

	public boolean contains(String key) {
		return get(key) != null;
	}
}
