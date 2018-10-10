package mac.himanshu.tree;

public class LongestCommonAncestor {

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

		System.out.println(LCABT(root, n5, n9).data);
		System.out.println(LCABST(root, n3, n4).data);
	}

	public static Node LCABT(Node root, Node p, Node q) {

		if (root == null)
			return null;

		if (root.data == p.data || root.data == q.data)
			return root;
		
		Node left = LCABT(root.leftNode, p, q);
		Node right = LCABT(root.rightNode, p, q);

		if (left != null && right != null)
			return root;

		return (left != null) ? left : right;

	}
	
	public static Node LCABST(Node root , Node p , Node q) {
		if(root != null) {
			
			if(root.data > Math.max(p.data,q.data))
				return LCABST(root.leftNode, p, q);
			else if(root.data < Math.min(p.data, q.data))
				return LCABST(root.rightNode, p, q);
			else
				return root;
		}
		
		return root;
	}

}
