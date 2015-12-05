package com.tatsuyaoiw.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
	@Test
	public void test() throws Exception {
		LinkedList list = new LinkedList();
		list.add(0);
		list.add(1);
		list.add(2);
		assertEquals(3, list.size());
	}
}