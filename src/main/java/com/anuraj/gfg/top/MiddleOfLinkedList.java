package com.anuraj.gfg.top;

public class MiddleOfLinkedList {

	private Node head;

	static class Node {
		int key;
		Node next;

		public Node(int key) {
			this.key = key;
			next = null;
		}
	}

	// insert new node at front of list
	void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	// insert new node at last of list
	void insert(int data) {
		if (head == null){
			head = new Node(data);
			return;
		}

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new Node(data);
	}

	void findMiddle() {
		Node fast = head;
		Node slow = head;
		if (head == null)
			return;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		System.out.println("Middle of list is: " + slow.key);

	}

	public static void main(String[] args) {
		MiddleOfLinkedList list = new MiddleOfLinkedList();
		list.insert(6);
		list.printList();
		list.findMiddle();
		list.insert(5);
		list.printList();
		list.findMiddle();
		list.insert(4);
		list.printList();
		list.findMiddle();
		list.insert(3);
		list.printList();
		list.findMiddle();
		list.insert(2);
		list.printList();
		list.findMiddle();
		list.insert(1);
		list.printList();
		list.findMiddle();

	}

	void printList() {
		Node node = head;
		while (node != null) {
			System.out.print(node.key + " ");
			node = node.next;
		}
		System.out.println();
	}

}
