package com.himanshu.bloomberg;

public class RandomPtrDeepCopy {

	public static void main(String[] args) {
		RandomListNode a = new RandomListNode(1);
		RandomListNode b = new RandomListNode(2);
		RandomListNode c = new RandomListNode(3);
		RandomListNode d = new RandomListNode(4);

		a.next = b;
		a.random = c;

		b.next = c;
		b.random = a;

		c.next = d;
		c.random = c;

		d.next = null;
		d.random = b;


		copyRandomList2(a);
	}

	// does not modify the orifginal list , right way to do it
	public static RandomListNode copyRandomList2(RandomListNode head) {
		RandomListNode curr1 = head;
		RandomListNode head2 = null;

		if (head == null)
			return null;
		// interleaving or inserting between two nodes
		while (curr1 != null) {
			RandomListNode node = new RandomListNode(curr1.label);
			node.next = curr1.next;
			curr1.next = node;
			curr1 = curr1.next.next;
		}
		// Set head for the cloned list
		head2 = head.next;

		// Assign random Ptrs.
		curr1 = head;
		while (curr1 != null) {
			if (curr1.random != null)
				curr1.next.random = curr1.random.next;

			curr1 = curr1.next.next;
		}

		// seperating the lists
		RandomListNode old = head;
		RandomListNode clone = head2;

		while (old != null && clone != null) {
			if (old.next != null)
				old.next = old.next.next;

			if (clone.next != null)
				clone.next = clone.next.next;

			old = old.next;
			clone = clone.next;
		}

		return head2;
	}

	// does modify the original list
	public static RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode curr1 = head;
		RandomListNode next = curr1;
		RandomListNode head2 = null;
		RandomListNode curr2 = null;
		RandomListNode randPtr = null;

		while (curr1 != null) {
			RandomListNode node = new RandomListNode(curr1.label);
			if (head2 == null) {
				head2 = node;
				curr2 = head2;
				randPtr = head2;
			} else {
				curr2.next = node;
				curr2 = curr2.next;
			}

			next = curr1.next;
			curr1.next = curr2;
			curr2.random = curr1;
			curr1 = next;
		}

		while (randPtr != null) {
			randPtr.random = randPtr.random.random.next;
			randPtr = randPtr.next;
		}

		return head2;
	}

}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}