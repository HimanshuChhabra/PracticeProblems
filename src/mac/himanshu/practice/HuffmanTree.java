package mac.himanshu.practice;

import java.util.*;
import mac.himanshu.practice.Profiler;

public class HuffmanTree {

	private HashMap<String, Integer> hashTable = new HashMap<String, Integer>();
	private LinkedHashMap<String, Integer> sortedTable = new LinkedHashMap<String, Integer>();
	private HashMap<String, String> linkNodeMap = new HashMap<String, String>();
	private HashMap<String, Integer> linkValueMap = new HashMap<String, Integer>();
	private List<String> keys = new ArrayList<String>();
	private String input;
	private final int INITIAL_COUNTER = 1;
	private String finalNode = null;

	public void inputText(String input) {
		this.input = input;
	}

	public void countCharacters() {
		Profiler.startProfililng();
		int i = input.length() - 1;
		while (i >= 0) {
			String key = input.charAt(i) + "";
			if (!hashTable.isEmpty() && hashTable.containsKey(key)) {
				int countValue = hashTable.get(key);
				countValue++;
				hashTable.put(key, countValue);
			} else {
				hashTable.put(key, INITIAL_COUNTER);
			}
			i--;
		}
		sortedTable = sortTable(hashTable);
		linkNodes(sortedTable);

		Profiler.stopProfiling();
	}

	public LinkedHashMap<String, Integer> sortTable(Map<String, Integer> hashTable) {
		Profiler.startProfililng();
		LinkedHashMap<String, Integer> sortedTable = new LinkedHashMap<String, Integer>();
		List<String> keyList = new ArrayList<String>(hashTable.keySet());
		List<Integer> valueList = new ArrayList<Integer>(hashTable.values());
		Collections.sort(keyList);
		Collections.sort(valueList);
		Iterator<Integer> iterateValues = valueList.iterator();
		while (iterateValues.hasNext()) {
			int sortedvalue = iterateValues.next();

			Iterator<String> iterateKeys = keyList.iterator();

			while (iterateKeys.hasNext()) {
				String key = iterateKeys.next();
				int unsortedValue = hashTable.get(key);
				if (sortedvalue == unsortedValue) {
					sortedTable.put(key, sortedvalue);
					keyList.remove(key);
					break;
				}

			}
		}
		Profiler.stopProfiling();
		return sortedTable;
	}

	public void linkNodes(Map<String, Integer> sortedTable) {
		Profiler.startProfililng();
		keys.addAll(sortedTable.keySet());
		String newNode = keys.get(0) + keys.get(1);
		int newValue = sortedTable.get(keys.get(0)) + sortedTable.get(keys.get(1));
		int length = keys.size();
		while (length > 0) {
			if (!keys.isEmpty()) {
				linkNodeMap.put(keys.get(0), newNode);
				linkValueMap.put(keys.get(0), 0);
				linkNodeMap.put(keys.get(1), newNode);
				linkValueMap.put(keys.get(1), 1);
				this.sortedTable.remove(keys.get(0));
				this.sortedTable.remove(keys.get(1));
				this.sortedTable.put(newNode, newValue);
				keys.removeAll(keys);
				length -= 2;
				if (this.sortedTable.size() > 1) {
					sortedTable = sortTable(this.sortedTable);
					linkNodes(sortedTable);
				} else {
					linkNodeMap.put(newNode, newNode);
				}
			} else {
				return;
			}

		}
		if (finalNode == null) {
			finalNode = newNode;
			// System.out.println(linkNodeMap);
			// System.out.println(linkValueMap);
		}
		Profiler.stopProfiling();
	}

	public String encoding() {
		Profiler.startProfililng();
		int i = 0;
		String code = "";
		while (i < input.length()) {
			code += fetchCode(input.charAt(i) + "", finalNode);
			i++;
		}
		Profiler.stopProfiling();
		return code;
	}

	public StringBuilder fetchCode(String letter, String finalNode) {
		String code;
		StringBuilder finalCode = null;
		String linkedToNode = linkNodeMap.get(letter);
		code = linkValueMap.get(letter) + "";
		while (!linkedToNode.equals(finalNode)) {
			code += linkValueMap.get(linkedToNode) + "";
			linkedToNode = linkNodeMap.get(linkedToNode);
		}
		finalCode = new StringBuilder(code);
		finalCode = finalCode.reverse();
		return finalCode;
	}

	public String decode(String encodedCode) {
		Profiler.startProfililng();
		int i = 0;
		String code = null;
		String currentNode = finalNode;
		String decodedText = "";
		while (i < encodedCode.length()) {
			code = encodedCode.charAt(i) + "";
			for (Map.Entry<String, String> entry : linkNodeMap.entrySet()) {
				String node = entry.getKey();
				if (currentNode.equals(entry.getValue()) && !currentNode.equals(node)) {
					if (linkValueMap.get(node) == Integer.parseInt(code)) {
						if (!isleafNode(node)) {
							currentNode = node;
						} else {
							decodedText += node;
							currentNode = finalNode;
						}
						break;
					}
				}
			}
			i++;
		}
		Profiler.stopProfiling();
		return decodedText;
	}

	public boolean isleafNode(String node) {
		return (node.length() == 1 ? true : false);
	}

	public static void main(String[] args) {
		HuffmanTree hf = new HuffmanTree();
		// hf.inputText("abbcccdddd");
		hf.inputText("aaaaaabbbbcccccccccc");
		hf.countCharacters();
		// System.out.println(hf.hashTable);
		// System.out.println(hf.sortedTable);

		String code = hf.encoding();
		System.out.println(code);
		System.out.println(hf.decode(code));

		Profiler.displayProfilingReport();

	}

}
