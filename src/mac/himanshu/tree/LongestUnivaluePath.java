package mac.himanshu.tree;

public class LongestUnivaluePath {
	static int result = 0;

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(5);
		root.left = node1;
		root.right = node2;
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(4);
		node1.left = node3;
		node1.right = node4;
		
		TreeNode node5 = new TreeNode(5);
		node2.right  = node5;
		
		TreeNode node6 = new TreeNode(4);
		node3.left = node6;
		
		calculateLongestUnivaluePath(root);
		
		System.out.println(result);
	}

	private static int calculateLongestUnivaluePath(TreeNode root) {

		if (root == null)
			return 0;
		int updatedLeft = 0, updatedRight = 0;

		int leftSubTreeValue = calculateLongestUnivaluePath(root.left);
		int rightSubTreeValue = calculateLongestUnivaluePath(root.right);

		if (root.left != null && root.left.value == root.value)
			updatedLeft = leftSubTreeValue + 1;

		if (root.right != null && root.right.value == root.value)
			updatedRight = rightSubTreeValue + 1;

		result = Math.max(result, updatedLeft + updatedRight);
	

		return Math.max(updatedLeft, updatedRight);
	}

}

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;

	public TreeNode(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}
