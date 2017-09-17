package com.anuraj.gfg.linkedlist;

public class ReverseLinkedList {

	Lnode head;

	// at head
	void push(int data) {

		Lnode newNode = new Lnode(data);
		newNode.next = head;
		head = newNode;

	}

	void reverse(){
		if(head==null)
			return;
		Lnode prev=null;
		Lnode curr=head;
		Lnode next=null;
		
		while(curr !=null){
			next=curr.next;
			curr.next = prev;
			prev = curr;
			curr=next;
		}
		
		head =prev;
	}
	
	public static void main(String[] args) {
		ReverseLinkedList llist = new ReverseLinkedList();
		llist.push(11);
		llist.push(32);
		llist.push(13);
		llist.push(24);
		llist.push(15);
		System.out.println("\nOriginal is:\n");
		llist.printList();
		llist.reverse();
		System.out.println("\nReverse is:\n");
		llist.printList();;
	}

	void printList() {

		Lnode last = head;
		while (last != null) {
			System.out.print(last.data + " ");
			last = last.next;
		}
	}

}
