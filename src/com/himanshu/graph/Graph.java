package com.himanshu.graph;

import java.util.*;

/*
 *      1
 *     /  \
 *    2    3
 *   /\   /\
 *  4  5 6  7
 */
public class Graph<E> {

	List<Node<E>> visited = new ArrayList<Node<E>>();

	public static void main(String[] args) {

		List<Node<Integer>> node45 = new ArrayList<Node<Integer>>();
		node45.add(new Node<Integer>(4, new ArrayList<Node<Integer>>()));
		node45.add(new Node<Integer>(5, new ArrayList<Node<Integer>>()));
		Node<Integer> node2 = new Node<Integer>(2, node45);

		List<Node<Integer>> node67 = new ArrayList<Node<Integer>>();
		node67.add(new Node<Integer>(6, new ArrayList<Node<Integer>>()));
		node67.add(new Node<Integer>(7, new ArrayList<Node<Integer>>()));

		Node<Integer> node3 = new Node<Integer>(3, node67);

		List<Node<Integer>> node23 = new ArrayList<Node<Integer>>();
		node23.add(node2);
		node23.add(node3);
		Node<Integer> root = new Node<Integer>(1, node23);

		Graph<Integer> g = new Graph<Integer>();

		g.DFS(root);

		for (Node<Integer> node : g.visited)
			System.out.print(node.value + " ");
		
		g.visited.clear();
		System.out.println();

		g.BFS(root);
		for (Node<Integer> node : g.visited)
			System.out.print(node.value + " ");
		
		callTrie();

	}

	private static void callTrie() {
		
		List<Node<Character>> node45 = new ArrayList<Node<Character>>();
		node45.add(new Node<Character>('a', new ArrayList<Node<Character>>()));
		node45.add(new Node<Character>('y', new ArrayList<Node<Character>>()));
		Node<Character> node2 = new Node<Character>('m', node45);

		List<Node<Character>> node67 = new ArrayList<Node<Character>>();
		node67.add(new Node<Character>('i', new ArrayList<Node<Character>>()));

		Node<Character> node3 = new Node<Character>('l', node67);

		List<Node<Character>> node23 = new ArrayList<Node<Character>>();
		node23.add(node2);
		node23.add(node3);
		Node<Character> root = new Node<Character>('*', node23);
		
		Graph<Character> g = new Graph<Character>();
		System.out.println(g.Trie(root, "my"));
		
	}

	public void DFS(Node<E> root) {

		if (root != null) {
			visited.add(root);

			for (Node<E> child : root.nodes) {
				if (!visited.contains(child)) {
					DFS(child);
				}
			}
		}
	}

	public void BFS(Node<E> root) {
		LinkedList<Node<E>> queue = new LinkedList<Node<E>>();
		
		visited.add(root);
		queue.addLast(root);
		
		while (!queue.isEmpty()) {
			Node<E> parent = queue.removeFirst();

			for (Node<E> child : parent.nodes) {
				if (!visited.contains(child)) {
					visited.add(child);
					queue.addLast(child);
				}
			}
		}
	}
	
	public boolean Trie(Node<E> root , String prefix) {
		
		for(int i = 0 ; i < prefix.length() ; i++) {
			char ch = prefix.charAt(i);
			
			root = root.contains(ch);
			if( root == null) {
				return false;
			}
		}
		
		return true;
	}
	
}

class Node<T> {
	T value;
	List<Node<T>> nodes;

	public Node(T value, List<Node<T>> nodes) {
		this.value = value;
		this.nodes = nodes;
	}
	
	public Node<T> contains(Character ch) {
		
		for(Node<T> child : this.nodes) {
			if(child.value.equals(ch))
				return child;
		}
		
		return null;
	}
}

