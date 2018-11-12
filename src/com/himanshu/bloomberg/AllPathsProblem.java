package com.himanshu.bloomberg;

import java.util.*;

public class AllPathsProblem {
	static List<List<Integer>> result = new ArrayList<List<Integer>>();
	static LinkedList<Integer> path = new LinkedList<Integer>();

	public static void main(String[] args) {
		int graph[][] = { { 1, 2 }, { 3 }, { 3 }, {} };
		
		System.out.println(allPathsSourceTarget(graph));
	}

	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {

		DFS(graph, 0, graph.length - 1);

		return result;
	}

	public static void DFS(int[][] graph, int node, int target) {
		path.add(node);
		if (node == target) {
			result.add(path);
			path = new LinkedList<Integer>(path);
			path.removeLast();
			return;
		}

		for (int i = 0; i < graph[node].length; i++) {
			DFS(graph, graph[node][i], target);
		}

		path.removeLast();
	}

}
