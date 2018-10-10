package mac.himanshu.tree;

public class BinaryTree{

	public static void main(String[] args) {
		Node nodes[] = new Node[10];
		for (int i = 0; i < 10; i++) {
			nodes[i] = new Node(i);
		}
		createTree(nodes);
		printChildren(nodes);
		System.out.println("\nDept of tree is : " + treeDepth(nodes[0]));
	}

	public static void createTree(Node[] nodes) {

		for (int i = 0; i < nodes.length; i++) {

			if ((i + i + 1) < nodes.length) {
				nodes[i].leftNode = nodes[i + i + 1];
			}
			if ((i + i + 2) < nodes.length) {
				nodes[i].rightNode = nodes[i + i + 2];
			} else {
				break;
			}

		}
	}

	public static void printChildren(Node[] nodes) {

		for (int i = 0; i < nodes.length; i++) {

			System.out.print(nodes[i].data);

			if (nodes[i].leftNode != null) {
				System.out.print(" has left child " + nodes[i].leftNode.data);
			} else {
				System.out.print(" No left Child");
			}

			if (nodes[i].rightNode != null) {
				System.out.println(" and right child " + nodes[i].rightNode.data);
			} else {
				System.out.println(" and No right Child");
			}
		}
	}

	public static int treeDepth(Node root) {
		if (root == null)
			return 0;
		else
			return (1 + Math.max(treeDepth(root.leftNode), treeDepth(root.rightNode)));
	}
}
