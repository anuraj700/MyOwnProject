package com.anuraj.gfg.linkedlist;

public class DetectLoopInLinkedList {

	Lnode head;

	// at head
	void push(int data) {

		Lnode newNode = new Lnode(data);
		newNode.next = head;
		head = newNode;

	}

	int detectLoop(){
		if(head ==null)
			return 0;
		
		Lnode slow= head;
		Lnode fast = head;
		
		while(slow !=null && fast!=null && fast.next !=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow.data == fast.data){
				System.out.println("\nthere is loop");
				return 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		DetectLoopInLinkedList llist = new DetectLoopInLinkedList();
		llist.push(5);
		llist.push(4);
		llist.push(3);
		llist.push(2);
		llist.push(1);
		System.out.println("\nOriginal is:\n");
		llist.printList();
		llist.head.next.next.next.next.next = llist.head.next;
		llist.detectLoop();
	}

	void printList() {

		Lnode last = head;
		while (last != null) {
			System.out.print(last.data + " ");
			last = last.next;
		}
	}

}
