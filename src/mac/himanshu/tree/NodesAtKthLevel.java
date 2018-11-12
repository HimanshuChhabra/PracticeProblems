package mac.himanshu.tree;

import java.util.LinkedList;
import java.util.List;

/*
 * Print all the Nodes at K'th Level from the root Node
 */
public class NodesAtKthLevel {

	public static void main(String[] args) {
		Node root = new Node(50);
		Node n1 = new Node(16);
		Node n2 = new Node(90);
		root.leftNode = n1;
		root.rightNode = n2;

		Node n3 = new Node(14);
		Node n4 = new Node(40);
		n1.leftNode = n3;
		n1.rightNode = n4;

		Node n5 = new Node(10);
		Node n6 = new Node(15);
		n3.leftNode = n5;
		n3.rightNode = n6;

		Node n7 = new Node(35);
		Node n8 = new Node(45);
		n4.leftNode = n7;
		n4.rightNode = n8;

		Node n9 = new Node(80);
		n2.leftNode = n9;

		List<Node> nodes = findNodesAtLevel(root, 3);

		for (Node node : nodes)
			System.out.print(node.data + " ");
		
		System.out.println();
		findNodes(root, 3);

	}

	public static List<Node> findNodesAtLevel(Node root, int level) {

		LinkedList<Node> current = null;
		
		if (root != null) {
			current = new LinkedList<Node>();
			current.add(root);
		}

		while (current.size() > 0) {
			if (level <= 0)
				break;

			LinkedList<Node> parents = current;
			current = new LinkedList<Node>();

			for (Node parent : parents) {
				if (parent.leftNode != null)
					current.add(parent.leftNode);
				if (parent.rightNode != null)
					current.add(parent.rightNode);
			}

			level--;
		}

		return current;
	}

	public static void findNodes(Node root, int level) {

		if (root == null)
			return;

		if (level <= 0)
			System.out.println(root.data);
		else {
			findNodes(root.leftNode, level - 1);
			findNodes(root.rightNode, level - 1);
		}

	}
}
