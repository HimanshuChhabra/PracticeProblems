package com.himanshu.bloomberg;

import java.util.*;

//checkout:
// https://leetcode.com/problems/lru-cache/discuss/45939/Laziest-implementation%3A-Java's-LinkedHashMap-takes-care-of-everything

public class LRUCache {
	private class Node {
		int key, value;
		Node next, prev;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

		Node() {
		}

		/*
		 * Node() { this(0,0); }
		 */
	}

	private Map<Integer, Node> cacheMap;
	private final int CAPACITY;
	private int currSize;
	Node head, tail;

	public LRUCache(int capacity) {
		CAPACITY = capacity;
		cacheMap = new HashMap<Integer, Node>();
		// head = new Node(); // can be used to mark the beginning and never change it,
		// but you cannot have 0,0
		// tail = new Node(); // can be used to mark the end and never change it, but
		// you cannot have 0,0
		currSize = 0;
	}

	/**
	 * Get Operation must return the value if it is present in the cache else return
	 * -1 Regardless, it must remove the node from its current position in the
	 * linkedList and put it to the start.
	 * 
	 * @param key
	 * @return
	 */
	public int get(int key) {
		Node n = cacheMap.get(key);

		if (n != null) {
			updateList(n);
			return n.value;
		}

		return -1;
	}

	/**
	 * Set Operation must First check if the key is already present , in that case
	 * update it with the new value. and update the position in the doubly
	 * linkedList, put the node at the front. Otherwise, create a new Node and add
	 * the key and value at the beginning of the linkedList.
	 * 
	 * Regardless, check if the currSize has overFlown the capacity of the cache, in
	 * this case remove the last Node.
	 * 
	 * @param key
	 * @param value
	 */
	public void set(int key, int value) {
		if(this.CAPACITY == 0)
			return;
		
		Node node = cacheMap.get(key);
		if (node == null) {
			 node = new Node(key, value);
			cacheMap.put(key, node);

			if (head == null) {
				head = node;
				tail = node;
			}

			insertFront(node);
			currSize++;
		} else {
			node.value = value;
			updateList(node);
		}

		if (currSize > CAPACITY) {
			currSize--;
			cacheMap.remove(tail.key);
			remove(tail);
		}
	}

	private void updateList(Node node) {
		remove(node);
		insertFront(node);

	}

	private void insertFront(Node node) {
		if (node == head)
			return;

		Node firstNode = head;
		node.next = firstNode;
		firstNode.prev = node;
		head = node;
	}

	private void remove(Node node) {
		if (head == node)
			return;

		else if (tail == node) {
			tail = tail.prev;
			tail.next = null;
		} else {
			Node before = node.prev;
			Node after = node.next;
			before.next = after;
			after.prev = before;
		}

	}

	public static void main(String[] args) {
		/*LRUCache cache = new LRUCache(2);
		cache.set(1, 1);
		cache.set(2, 2);
		cache.set(1, 10);
		int ans = cache.get(1);
		System.out.println(ans);
		ans = cache.get(3);
		System.out.println(ans);
		cache.set(3, 3);
		ans = cache.get(2);
		System.out.println(ans);
		ans = cache.get(3);
		System.out.println(ans);*/
		
		LRUCache cache = new LRUCache(1);
		cache.set(1, 1);
		cache.set(2, 2);

	}

}
