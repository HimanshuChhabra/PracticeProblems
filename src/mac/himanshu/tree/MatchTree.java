package mac.himanshu.tree;

public class MatchTree {

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
		
		boolean result = match(root,root);
		//boolean result = match(root.leftNode,root); -> false
		System.out.println(result);

	}

	private static boolean match(Node t1, Node t2) {
		
		if(t1 == null && t2 == null) return true;
		if(t1 == null || t2 == null) return false;
		if(t1.data != t2.data) return false;
		return match(t1.leftNode,t2.leftNode) && match(t1.rightNode, t2.rightNode);
	}
	/*
	public boolean isSymmetric(TreeNode root) {
	    return isMirror(root, root);
	}

	public boolean isMirror(TreeNode t1, TreeNode t2) {
	    if (t1 == null && t2 == null) return true;
	    if (t1 == null || t2 == null) return false;
	    return (t1.val == t2.val)
	        && isMirror(t1.right, t2.left)
	        && isMirror(t1.left, t2.right);
	} */

}
