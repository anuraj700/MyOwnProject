package com.anuraj.gfg.linkedlist;

public class RotateLinkedList {
	Lnode head;

	// at head
	void push(int data) {

		Lnode newNode = new Lnode(data);
		newNode.next = head;
		head = newNode;

	}
	
	void rotate(int k){
		
		if(k==0) return;
		
		Lnode current = head;
		
		int count =1;
		while(count < k && current != null){
			current = current.next;
			count++;
		}
		if(current == null)
			return;
		
		
		Lnode kthNode = current;
		
		while(current.next != null)
			current = current.next;
		
		current.next = head;
		head = kthNode.next;
		kthNode.next = null;
		
	}
	 //rotate the linked list counter-clockwise by k nodes.
	 // O(n)
	public static void main(String[] args) {
		RotateLinkedList llist = new RotateLinkedList(); 

		for (int i = 60; i >= 10; i -= 10) 
            llist.push(i); 
  
        System.out.println("Given list"); 
        llist.printList(); 
  
        llist.rotate(4); 
  
        System.out.println("Rotated Linked List"); 
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
