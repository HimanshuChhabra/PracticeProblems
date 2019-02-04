package com.himanshu.google;

import java.util.Stack;

public class PaliindromeLinkedLIst {

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		node1.next = node2;
		Node node3 = new Node(3);
		node2.next = node3;
		Node node4 = new Node(3);
		node3.next = node4;
		Node node5 = new Node(2);
		node4.next = node5;
		Node node6 = new Node(1);
		node5.next = node6;
		
		System.out.println(isPalindrome(node1));
	}

	private static boolean isPalindrome(Node head) {

		if (head == null)
			return false;
		// 1. Get to the center of the LinkedList;
		Node p = head;
		Node q = head;

		while (p != null && q != null && q.next != null) {
			p = p.next;
			q = q.next.next;
		}

		Stack<Integer> stack = new Stack<Integer>();
		Node temp = head;

		while (temp != p) {
			stack.push(temp.val);
			temp = temp.next;
		}

		if (q != null && q.next == null) {
			p = p.next;
		}

		while (p != null) {
			if(stack.isEmpty())
				return false;
			
			int num = stack.pop();
			if (p.val != num)
				return false;

			p = p.next;
		}

		return true;
	}

	private static class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}
	}
}

/*
 * 1->2->3->3->2->1 1->2->3->2->1 after jumping out of the while loop, if q.next
 * != null , means even else it means odd.
 * 
 */
