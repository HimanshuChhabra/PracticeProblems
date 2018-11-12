package mac.himanshu.tree;

public class InorderSuccessor {

	// In a BST
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
		
		Node ans = findSuccessor(root, 80);
		if(ans != null)
			System.out.println(ans.data);
		else
			System.out.println("Not found");
	}

	/**
	 * Locate the node,
	 * if right subtree exists , find its leftMost node , this will be the successor
	 * if it does not exist , the previous node will be the successor
	 * @param root
	 * @param value
	 * @return
	 */
	public static Node findSuccessor(Node root, int value) {
		Node previous = null;
		while (root != null && root.data != value) {
			if (value <= root.data) {
				previous = root;
				root = root.leftNode;
			} else {
				root = root.rightNode;
			}
		}

		if (root != null) {
			if (root.rightNode != null)
				return getSuccessor(root.rightNode);
			else
				return previous;
		}

		return null;
	}


	
	private static Node getSuccessor(Node nodeFound) {
			while (nodeFound.leftNode != null)
				  nodeFound = nodeFound.leftNode;
		return nodeFound;
	}
}
