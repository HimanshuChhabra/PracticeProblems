package mac.himanshu.tree;

/**
 * Merge Two Binary Trees , simply means adding up the values
 * 
 * @author himanshuchhabra
 *
 */
public class MergeBT {

	public static Node mergeTrees(Node tree1, Node tree2) {

		if (tree1 == null)
			return tree2;

		if (tree2 == null)
			return tree1;

		tree1.data += tree2.data;

		tree1.leftNode = mergeTrees(tree1.leftNode, tree2.leftNode);
		tree1.rightNode = mergeTrees(tree1.rightNode, tree2.rightNode);

		return tree1;
	}

	public static void main(String[] args) {
		Node root1 = new Node(1);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		root1.leftNode = n1;
		root1.rightNode = n2;

		Node n3 = new Node(4);
		Node n4 = new Node(5);
		n1.leftNode = n3;
		n1.rightNode = n4;

		Node root2 = new Node(5);
		Node n5 = new Node(6);
		Node n6 = new Node(7);
		root2.leftNode = n5;
		root2.rightNode = n6;

		Node ans = mergeTrees(root1, root2);

	}

}
