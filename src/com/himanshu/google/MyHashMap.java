package com.himanshu.google;

import java.util.*;

public class MyHashMap {

	public static void main(String[] args) {
		HashSet s = new HashSet();
		s.add(null);
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 1);
		hashMap.put(2, 2);
		hashMap.get(1); // returns 1
		hashMap.get(3); // returns -1 (not found)
		hashMap.put(2, 1); // update the existing value
		hashMap.get(2); // returns 1
		hashMap.remove(2); // remove the mapping for 2
		hashMap.get(2); // returns -1 (not found)

	}

	/** Initialize your data structure here. */
	List<LinkedList<Node>> bucket;

	public MyHashMap() {
		bucket = new ArrayList<LinkedList<Node>>(16);

		for (int i = 0; i < 16; i++) {
			bucket.add(new LinkedList<Node>());
		}
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		if (key < 0)
			return;

		int hash = key % 16;
		LinkedList<Node> list = bucket.get(hash);
		boolean found = false;
		for (Node node : list) {
			if (node.key == key) {
				node.value = value;
				found = true;
				break;
			}
		}
		if (!found) {
			Node node = new Node(key, value);
			bucket.get(hash).add(node);
		}
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		int hash = key % 16;
		LinkedList<Node> list = bucket.get(hash);
		for (Node node : list) {
			if (node.key == key)
				return node.value;
		}

		return -1;
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		int hash = key % 16;
		LinkedList<Node> list = bucket.get(hash);
		Iterator<Node> itr = list.iterator();
		while (itr.hasNext()) {
			if (itr.next().key == key) {
				itr.remove();
				break;
			}
		}
	}
}

class Node {
	int key, value;

	Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

}
