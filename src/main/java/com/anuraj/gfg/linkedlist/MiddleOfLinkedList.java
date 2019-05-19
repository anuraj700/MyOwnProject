package com.anuraj.gfg.linkedlist;

public class MiddleOfLinkedList {

	Lnode head;

	// at head
	void push(int data) {

		Lnode newNode = new Lnode(data);
		newNode.next = head;
		head = newNode;

	}
	
	int middleLoop(){
		Lnode slow = head;
		Lnode fast = head;
		while(fast!= null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;	
		}
		System.out.println("Middle is"+slow.data);
		return 1;
	}
	
	public static void main(String[] args) {
		MiddleOfLinkedList llist = new MiddleOfLinkedList();
		llist.push(5);
		llist.push(4);
		llist.push(3);
		llist.push(2);
		llist.push(1);
		llist.push(9);
		System.out.println("\nOriginal is:\n");
		llist.printList();
		llist.middleLoop();
	}
	void printList() {

		Lnode last = head;
		while (last != null) {
			System.out.print(last.data + " ");
			last = last.next;
		}
	}
}
