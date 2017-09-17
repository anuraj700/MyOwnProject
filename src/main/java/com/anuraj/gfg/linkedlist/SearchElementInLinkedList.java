package com.anuraj.gfg.linkedlist;

public class SearchElementInLinkedList {

	Lnode head;

	// at head
	void push(int data) {

		Lnode newNode = new Lnode(data);
		newNode.next = head;
		head = newNode;

	}

	boolean searchIteratively(int key) {
		Lnode temp = head;
		while (temp != null) {
			if (temp.data == key) {
				return true;
			}
			temp = temp.next;

		}
		return false;

	}

	boolean getCountRecurr(Lnode head, int key) {

		if (head == null) {
			return false;
		}
		if (head.data == key) {
			return true;
		}
		return getCountRecurr(head.next, key);

	}

	boolean searchRecurrsively(int key) {
		return getCountRecurr(head, key);
	}

	public static void main(String[] args) {
		SearchElementInLinkedList llist = new SearchElementInLinkedList();
		llist.push(11);
		llist.push(31);
		llist.push(21);
		llist.push(22);
		llist.push(10);

		System.out.println("Count of nodes is " + llist.searchIteratively(10));
		System.out
				.println("Count of nodes is " + llist.searchRecurrsively(111));
	}

	void printList() {

		Lnode last = head;
		while (last != null) {
			System.out.print(last.data + " ");
			last = last.next;
		}
	}

}
