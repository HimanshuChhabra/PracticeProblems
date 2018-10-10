package com.himanshu.blackrock;


public class BinaryLcm {

	public static void main(String[] args) {

		Node root = new Node(30);

		Node node1 = new Node(8);
		Node node2 = new Node(52);
		root.leftNode = node1;
		root.rightNode = node2;

		Node node3 = new Node(3);
		Node node4 = new Node(20);
		node1.leftNode = node3;
		node1.rightNode = node4;

		Node node5 = new Node(10);
		Node node6 = new Node(29);
		node4.leftNode = node5;
		node4.rightNode = node6;

		System.out.println(leastCommonAncestor(root,3,29));

	}

	public static int leastCommonAncestor(Node root,int node1 , int node2){
		if(root.leftNode.data == node1 || root.rightNode.data == node1 || root.leftNode.data == node2 || root.rightNode.data == node2)
			return root.data;
		else {
			if(root.leftNode != null) {
				return leastCommonAncestor(root.leftNode, node1, node2);
			}else {
				return leastCommonAncestor(root.rightNode, node1, node2);
			}
		}
	}
}

class Node {

	int data;
	Node leftNode;
	Node rightNode;

	public Node(int data){
		this.data = data;
		this.leftNode = null;
		this.rightNode = null;
	}
}