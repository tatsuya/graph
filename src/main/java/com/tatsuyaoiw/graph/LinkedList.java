package com.tatsuyaoiw.graph;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList implements Iterable<Integer> {
	private Node head;
	private int N;

	private class Node {
		private Integer data;
		private Node next;

		private Node(int data) {
			this.data = data;
		}
	}

	public LinkedList() {
		head = null;
		N = 0;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return N;
	}

	/**
	 * Add the item to this linked list.
	 */
	public void add(int data) {
		Node tmp = head;
		head = new Node(data);
		head.next = tmp;
		N++;
	}

	/**
	 * Returns an iterator over elements of type {@code T}.
	 *
	 * @return an Iterator.
	 */
	@Override
	public Iterator<Integer> iterator() {
		return new ListIterator<>(head);
	}

	private class ListIterator<T> implements Iterator<T> {
		private Node current;

		public ListIterator(Node head) {
			this.current = head;
		}

		/**
		 * Returns {@code true} if the iteration has more elements.
		 * (In other words, returns {@code true} if {@link #next} would
		 * return an element rather than throwing an exception.)
		 *
		 * @return {@code true} if the iteration has more elements
		 */
		@Override
		public boolean hasNext() {
			return current != null;
		}

		/**
		 * Returns the next element in the iteration.
		 *
		 * @return the next element in the iteration
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T data = (T) current.data;
			current = current.next;
			return data;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
