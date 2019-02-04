package com.himanshu.google;

import java.util.*;

public class Autocomplete {
	private Node trieRoot;

	public Autocomplete(String[] dict) {
		trieRoot = new Node("");
		createTrie(dict);
	}

	/**
	 * For each word in the dict populate the trie Mark the end of every word as a
	 * terminal node by setting the isWord flag
	 * 
	 * @param dict
	 */
	private void createTrie(String[] dict) {
		for (String word : dict) {
			Node curr = trieRoot;
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				if (!curr.children.containsKey(ch)) {
					curr.children.put(ch, new Node(word.substring(0, i + 1)));
				}
				curr = curr.children.get(ch);

				if (i == word.length() - 1)
					curr.isWord = true;
			}
		}
	}

	/**
	 * Traverse the tree until the prefix is present in the trie Valid prefix : run
	 * a DFS in the subtree with the curr as the root node. Invalid prefix : return
	 * empty list
	 * 
	 * @param prefix
	 * @return
	 */
	public List<String> getPrefixWords(String prefix) {
		List<String> result = new ArrayList<String>();
		Node curr = trieRoot;

		for (char ch : prefix.toCharArray()) {
			if (curr.children.containsKey(ch)) {
				curr = curr.children.get(ch);
			} else {
				return result;
			}
		}
		fetchWords(curr, result);

		return result;
	}

	// Run a DFS
	private void fetchWords(Node curr, List<String> result) {
		if (curr.isWord)
			result.add(curr.prefix);

		// for every child node
		for (char ch : curr.children.keySet()) {
			fetchWords(curr.children.get(ch), result);
		}
	}

	private class Node {
		String prefix;
		boolean isWord;
		HashMap<Character, Node> children;

		Node(String prefix) {
			this.prefix = prefix;
			this.children = new HashMap<Character, Node>();
		}
	}

	public static void main(String[] args) {
		String[] dict = { "abc", "acd", "cde", "c", "a", "abpo" };
		Autocomplete auto = new Autocomplete(dict);
		System.out.println(auto.getPrefixWords("ab"));
	}

}
