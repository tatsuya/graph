package com.tatsuyaoiw.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {
	@Test
	public void testTrie() throws Exception {
		Trie trie = new Trie();

		trie.put("she", 0);
		trie.put("sells", 1);
		trie.put("sea", 2);
		trie.put("shells", 3);
		trie.put("by", 4);
		trie.put("the", 5);
		trie.put("sea", 6);
		trie.put("shore", 7);

		assertEquals(0, trie.get("she"));
		assertEquals(1, trie.get("sells"));
		assertEquals(6, trie.get("sea")); // overwritten
		assertEquals(3, trie.get("shells"));
		assertEquals(4, trie.get("by"));
		assertEquals(5, trie.get("the"));
		assertEquals(6, trie.get("sea"));
		assertEquals(7, trie.get("shore"));
	}
}