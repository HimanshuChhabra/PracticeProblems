package com.himanshu.google;

public class MeregeLinkedList {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		node1.next = node2;
		ListNode node3 = new ListNode(1);
		node2.next = node3;
		ListNode node4 = new ListNode(1);
		node3.next = node4;

		ListNode node5 = new ListNode(1);
		ListNode node6 = new ListNode(1);
		node5.next = node6;
		ListNode node7 = new ListNode(1);
		node6.next = node7;

		mergeTwoLists(node1, node5);

	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;

		if (l2 == null)
			return l1;

		ListNode head = null;
		ListNode temp = null;
		while (l1 != null && l2 != null) {

			if (l1.val < l2.val) {
				ListNode node = new ListNode(l1.val);
				if (head == null) {
					head = node;
					temp = head;
				} else {
					temp.next = node;
					temp = temp.next;
				}
				l1 = l1.next;
			} else {
				ListNode node = new ListNode(l2.val);
				if (head == null) {
					head = node;
					temp = head;
				} else {
					temp.next = node;
					temp = temp.next;
				}
				l2 = l2.next;
			}
		}

		while (l1 != null) {
			ListNode node = new ListNode(l1.val);
			temp.next = node;
			temp = temp.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			ListNode node = new ListNode(l2.val);
			temp.next = node;
			temp = temp.next;
			l2 = l2.next;
		}

		return head;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
