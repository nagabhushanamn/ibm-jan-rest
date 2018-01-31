package com;

import com.util.LinkedList;

public class App {

	public static void main(String[] args) {

		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("item-1");
		linkedList.add("item-2");

		for (String item : linkedList) {
			System.out.println(item);
		}

	}

}
