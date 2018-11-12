package mac.himanshu.tree;
/**
 * One simple way is to generate inorder of the tree and then search for the node and return previous node and for successor return
 * next node;
 * @author himanshuchhabra
 *
 */
public class InorderPredeccessor {

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
		
		Node ans = findPredecesor(root, 16);
		if(ans != null)
			System.out.println(ans.data);
		else
			System.out.println("Not found");
	}
// before
	/**
	 * Locate the node in the tree, If it was not located root will be null, return null
	 * if found and leftsubtree exists, find the right most child node of the left subtree
	 * else return the previous node ; We keep track of the previous node, from where we took a right turn because thats
	 * the predecesor
	 * @param root
	 * @param value
	 * @return
	 */
	public static Node findPredecesor(Node root, int value) {
		Node previous = null;
		if (root != null) {

			while (root != null && root.data != value) {
				if (value <= root.data) {
					root = root.leftNode;
				} else {
					previous = root;
					root = root.rightNode;
				}
			}

			if(root != null) {
				if(root.leftNode != null) {
					return getPredecessor(root.leftNode);
				}else
					return previous;
			}
		}

		return null;
	}

	private static Node getPredecessor(Node nodeValue) {
		
		while(nodeValue.rightNode != null)
			nodeValue = nodeValue.rightNode;
		
		return nodeValue;
		
	}
}
