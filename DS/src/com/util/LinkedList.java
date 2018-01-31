package com.util;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {

	private Node head;

	// ---------------------------------------------------

	public void add(E e) {
		Node newNode = new Node(e);

		if (head == null) {
			this.head = newNode;
		} else {
			Node lastNode;
			lastNode = head;
			while (lastNode.getNext() != null) {
				lastNode = lastNode.getNext();
			}
			lastNode.setNext(newNode);
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public E next() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

	// ---------------------------------------------------

	private class Node {
		private E _data;
		private Node next;

		public Node(E _data) {
			this._data = _data;
		}

		public Node(E _data, LinkedList<E>.Node next) {
			super();
			this._data = _data;
			this.next = next;
		}

		public E get_data() {
			return _data;
		}

		public void set_data(E _data) {
			this._data = _data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

}
