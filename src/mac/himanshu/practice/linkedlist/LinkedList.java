package mac.himanshu.practice.linkedlist;

public class LinkedList<T> {
	
	private int length;
	private Node<T> head;

	public LinkedList(Node<T> head , T t) {
		head.data = t ; 
		this.head = head;
	}
	
	public LinkedList() {
		
	}
	
	public static void main(String[] args) {
		
		LinkedList<Integer> l = new LinkedList<Integer>(new Node<Integer>() , 1);
		
		Node<Integer> head = l.getHead(); 
		l.insertAtTail(head, 2);l.insertAtTail(head, 3);l.insertAtTail(head, 4);

		// print the linked list
		System.out.println("Print Linked List");
		System.out.print("==============================\n");
		l.print();

		// insert a value at the tail;
		System.out.println("Insert a Value at the Tail");
		System.out.print("==============================\n");
		
		l.insertAtTail(head, 5).print();

		//insert a value at the head
		System.out.println("Insert a Value at the Head");
		System.out.print("==============================\n");
		l.insertAtHead(head, 0).print();

		//insert at a position
		System.out.println("Insert a Value at position 2");
		System.out.print("==============================\n");
		l.insertAtPosition(head, 6 , 2).print();
		System.out.println("Insert a Value at position 5");
		System.out.print("==============================\n");
		l.insertAtPosition(head, 7 , 5).print();

		//Delete Node
		System.out.println("Delete a Value at position 3");
		System.out.print("==============================\n");
		l.deleteNode(head, 3).print();

		//reverse Linked List
		System.out.println("Reverse Linked List");
		System.out.print("==============================\n");
		l.reverseLinkedList(head).print();
	
		
	}

	public int length() {
		return length + 1;
	}
	
	public Node<T> getHead() {
		return this.head;
	}
	
	public LinkedList<T> print() {
		Node<T> head = this.head;
		if(head == null) {
			System.out.println("Empty Linked List");
			return this;
		}

		Node<T> temp = head;
		while(true) {
			System.out.print(temp.data + " ");
			temp = temp.next;
			if(temp == null)
				break;
		}

		System.out.println("\n\n");
		return this;
	}

	public LinkedList<T> insertAtTail(Node<T> head , T data) {
		Node<T> temp = head;
		Node<T> newNode = new Node<T>();
		newNode.data = data;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		this.length++;
		this.head = head;
		return this;
	}

	public LinkedList<T> insertAtHead(Node<T> head, T data) {
		Node<T> newNode = new Node<T>();
		newNode.data = data;
		newNode.next = head;
		this.length++;
		this.head = newNode;
		
		return this;
	}

	/*
	 * Position is the index value, starts with 0 . If the Position is beyond the range of the linked list
	 * the node is appended at the tail;
	 */

	public LinkedList<T> insertAtPosition(Node<T> head , T data , int position) {
		Node<T> newNode = new Node<T>();
		newNode.data = data;
		Node<T> temp = head;
		int i = 0 ; 
		while(i != position - 1 ) {
			temp = temp.next;
			if(temp.next == null)
				break;
			i ++;
		}
		if(temp.next == null)
			temp.next = newNode;
		else {
			Node<T> oldNext = temp.next;
			temp.next = newNode;
			newNode.next = oldNext;
		}
		this.length++;
		this.head = head;
		return this;
	}

	/*
	 * Deletes the Node at the particular position, starts with 0
	 */
	public LinkedList<T> deleteNode(Node<T> head , int position) {
		Node<T> temp = head;
		int i = 0 ; 

		while(i != position -1) {
			temp = temp.next;
			if(temp.next == null)
				break;
			i++;
		}
		if(temp.next != null) {
			temp.next = temp.next.next;
			this.length--;
		}
		
		this.head = head;
		
		return this;
	}


	public LinkedList<T> reverseLinkedList(Node<T> head) {
		if(head == null)
			return null;

		Node<T> prev , move;
		prev = head;
		move = prev.next;
		prev.next = null;

		while(move != null) {
			Node<T> temp = move.next;
			move.next = prev;
			prev = move;
			move = temp;
		}
		
		this.head = prev;
		
		return this;
	}

	
	public LinkedList<T> sortLinkedList(SortLinkedList<T> list) {
		list.sort(this.head);
		return this;
	}
	
}


class Node<T>{
	T data;
	Node<T> next;
}

