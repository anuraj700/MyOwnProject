package com.anuraj.gfg.linkedlist;

public class SwapNodesInLinkedList {

	Lnode head;

	// at head
	void push(int data) {

		Lnode newNode = new Lnode(data);
		newNode.next = head;
		head = newNode;

	}

	void swapNodes(int x, int y) {
		if (head == null)
			return;

		if (x == y)
			return;

		Lnode xprev = null;
		Lnode xcurr = head;
		Lnode yprev = null;
		Lnode ycurr = head;

		while (xcurr != null && xcurr.data != x) {
			xprev = xcurr;
			xcurr = xcurr.next;
		}
		while (ycurr != null && ycurr.data != y) {
			yprev = ycurr;
			ycurr = ycurr.next;
		}
		
		if (xcurr == null || ycurr == null) {
			System.out.println("\n Inputs are missing");
			return;
		}

		if (xprev == null) {
			head = ycurr;
		} else {
			xprev.next = ycurr;
		}
		
		if (yprev == null) {
			head = xcurr;
		} else {
			yprev.next = xcurr;
		}
		
		//swap next pointers
		Lnode temp = xcurr.next;
		xcurr.next = ycurr.next;
		ycurr.next = temp;
		
	}

	public static void main(String[] args) {
		SwapNodesInLinkedList llist = new SwapNodesInLinkedList();
		llist.push(11);
		llist.push(31);
		llist.push(21);
		llist.push(22);
		llist.push(10);

		System.out.println("\n current list is");
		llist.printList();
		llist.swapNodes(11, 10);
		System.out.println("\n after swapping 11 10");
		llist.printList();
		llist.swapNodes(31, 22);
		System.out.println("\n after swapping 31 22");
		llist.printList();
		llist.swapNodes(21, 22);
		System.out.println("\n after swapping 21 22");
		llist.printList();
		llist.swapNodes(11, 31);
		System.out.println("\n after swapping 11 31");
		llist.printList();
		llist.swapNodes(21, 10);
		System.out.println("\n after swapping 21 10");
		llist.printList();

	}

	void printList() {

		Lnode last = head;
		while (last != null) {
			System.out.print(last.data + " ");
			last = last.next;
		}
	}

}
