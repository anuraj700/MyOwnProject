package com.anuraj.gfg.linkedlist;

public class LengthOfLinkedList {

	Lnode head;

	// at head
	void push(int data) {

		Lnode newNode = new Lnode(data);
		newNode.next = head;
		head = newNode;

	}

	int getCountIteratively(){
		int count =0;
		Lnode temp = head;
		while(temp!=null){
			temp=temp.next;
			count++;
		}
		return count;
		
		
	}
	int getCountRecurr(Lnode head){
		
		if(head==null){
			return 0;
		}
		return 1+getCountRecurr(head.next);
			
	}
	
	int getCountRecurrsively(){
		return getCountRecurr(head);
	}
	
	public static void main(String[] args) {
		LengthOfLinkedList llist = new LengthOfLinkedList();
		llist.push(1);
		llist.push(3);
		llist.push(1);
		llist.push(2);
		llist.push(1);

		System.out.println("Count of nodes is " + llist.getCountIteratively());
		System.out.println("Count of nodes is " + llist.getCountRecurrsively());
	}

	void printList() {

		Lnode last = head;
		while (last != null) {
			System.out.print(last.data + " ");
			last = last.next;
		}
	}

}
