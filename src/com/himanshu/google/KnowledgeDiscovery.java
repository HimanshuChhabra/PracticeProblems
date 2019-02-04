package com.himanshu.google;

import java.util.*;

public class KnowledgeDiscovery {

	public static void main(String[] args) {
		String[][] equations = { { "a", "b" }, { "b", "c" } };
		double[] values = { 2.0, 3.0 };
		String[][] queries = { { "a", "c" }, { "b", "a" }, { "a", "e" }, { "a", "a" }, { "x", "x" }};

		KnowledgeDiscovery k = new KnowledgeDiscovery();
		double[] ans = k.calcEquation(equations, values, queries);
		for(double a : ans)
		System.out.print(a + ",");

	}

	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
		for (int i = 0; i < equations.length; i++) {
			graph.put(equations[i][0], new HashMap<String, Double>());
			graph.put(equations[i][1], new HashMap<String, Double>());
		}
		for (int i = 0; i < equations.length; i++) {
			graph.get(equations[i][0]).put(equations[i][1], values[i]);
			graph.get(equations[i][1]).put(equations[i][0], 1.0 / values[i]);
		}
		double[] ans = new double[queries.length];
		int a = 0;
		for (String[] s : queries) {
			ans[a++] = bfs2(graph, s);
		}
		return ans;
	}

	public double bfs(HashMap<String, HashMap<String, Double>> graph, String[] s) {
		if (!graph.containsKey(s[0])) {
			return -1.0;
		}
		HashSet<String> visit = new HashSet<>();
		HashMap<String, Double> curr = new HashMap<>();
		Deque<String> queue = new LinkedList<>();
		queue.add(s[0]);
		curr.put(s[0], 1.0);
		double ans = 1.0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String temp = queue.poll();
				double tempnum = curr.get(temp);
				if (graph.get(temp) == null) {
					return -1;
				}
				for (Map.Entry<String, Double> entry : graph.get(temp).entrySet()) {
					if (!visit.contains(entry.getKey())) {
						queue.add(entry.getKey());
						visit.add(entry.getKey());
						tempnum *= entry.getValue();
						curr.put(entry.getKey(), tempnum);
						if (entry.getKey().equals(s[1])) {
							return tempnum;
						}
						tempnum /= entry.getValue();
					}
				}
			}
		}
		return -1.0;
	}

	public double bfs2(HashMap<String, HashMap<String, Double>> graph, String[] s) {

		HashSet<String> visited = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		HashMap<String, Double> map = new HashMap<String, Double>();
		map.put(s[0], 1.0);
		queue.add(s[0]);
		while (!queue.isEmpty()) {
			String str = queue.poll();
			if (graph.containsKey(str)) {
				double currValue = map.get(str);
				if (str == s[1])
					return currValue;

				for (Map.Entry<String, Double> entry : graph.get(str).entrySet()) {
					if(!visited.contains(entry.getKey())) {
						double value = currValue * entry.getValue();
						queue.add(entry.getKey());
						map.put(entry.getKey(), value);
					}
				}
				
				visited.add(str);
			}
			
		}

		return -1;
	}

	// Using DFS
	// public double dfs(HashMap<String,HashMap<String,Double>> graph, String s,
	// String e, HashSet<String> visit, double val){
	// if(visit.contains(s)||graph.get(s)==null){
	// return 0.0;}
	// if(s.equals(e)){return val;}
	// visit.add(s);
	// double ans = 0.0;
	// for(Map.Entry<String,Double> entry: graph.get(s).entrySet()){
	// ans = dfs(graph,entry.getKey(),e,visit,val*entry.getValue());
	// if(ans!=0){break;}
	// }
	// visit.remove(s);
	// return ans;
	// }

}
