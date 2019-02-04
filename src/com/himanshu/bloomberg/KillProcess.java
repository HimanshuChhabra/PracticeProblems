package com.himanshu.bloomberg;

import java.util.*;

public class KillProcess {

	public static void main(String[] args) {
		killProcess(Arrays.asList(1), Arrays.asList(0), 1);

	}

	public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

		if (pid == null || ppid == null || pid.size() != ppid.size())
			return null;

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		List<Integer> result = new ArrayList<Integer>();

		// Preparing the HashMap
		for (int i = 0; i < pid.size(); i++) {
			Integer childID = pid.get(i);
			Integer parentID = ppid.get(i);

			if (map.containsKey(parentID)) {
				map.get(parentID).add(childID);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(childID);
				map.put(parentID, list);
			}
		}
		Queue<List<Integer>> queue = new LinkedList<List<Integer>>();

		result.add(kill);

		if (map.get(kill) != null)
			queue.add(map.get(kill));

		while (!queue.isEmpty()) {
			List<Integer> list = queue.poll();
			for (Integer id : list) {
				result.add(id);

				if (map.get(id) != null)
					queue.add(map.get(id));
			}
		}

		return result;
	}
}
