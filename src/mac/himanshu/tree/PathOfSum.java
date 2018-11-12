package mac.himanshu.tree;

import java.util.*;

/*
 * Given a sum value , print the path or values of the nodes that add up to that sum
 * Using a simple In-order traversal , keep a track of the nodes being traversed using a stack
 * If the sum is final return the stack , else  pop the value. 
 */
public class PathOfSum {

	static LinkedList<Integer> stack = new LinkedList<>();
	static int sum = 0;

	public static List<Integer> getSumPath(Node root, int value) {
		if (root == null)
			return null;

		sum += root.data;
		stack.push(root.data);
		if (sum == value)
			return stack;

		List<Integer> left = getSumPath(root.leftNode, value);
		
		if (left != null)
			return left;
		
		List<Integer> right = getSumPath(root.rightNode, value);
		if (right != null)
			return right;

		sum -= root.data;
		stack.pop();

		return null;
	}

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

		System.out.println(getSumPath(root, 80)); // prints any intermediate path
		System.out.println(leafPath(root,90 )); // prints root to leaf
	}
	
	static int total = 0;
	public static boolean leafPath(Node root, int sum) {
		if(root == null)
			return false;
		total+=root.data;
		
		if(root.leftNode == null && root.rightNode == null && total == sum)
			return true;
		
		boolean result1 = leafPath(root.leftNode, sum);
		boolean result2 = leafPath(root.rightNode, sum);
		
		total-=root.data;
		
		return result1 || result2;
	}

}
