package com.anuraj.gfg.linkedlist;

public class ReverseLinkedListInGroupOfSize {
	Lnode head;

	// at head
	void push(int data) {

		Lnode newNode = new Lnode(data);
		newNode.next = head;
		head = newNode;

	}
	
	Lnode reverse(Lnode head, int k){
		Lnode prev = null;
		Lnode curr = head;
		Lnode next = null;
		int count =0;
		while(count <k && curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		
		if(next!= null)
			head.next = reverse(next,k);
		
		return prev;
	}
	
	public static void main(String[] args) {
		ReverseLinkedListInGroupOfSize llist = new ReverseLinkedListInGroupOfSize(); 
        
        /* Constructed Linked List is 1->2->3->4->5->6-> 
           7->8->8->9->null */
        llist.push(9); 
        llist.push(8); 
        llist.push(7); 
        llist.push(6); 
        llist.push(5); 
        llist.push(4); 
        llist.push(3); 
        llist.push(2); 
        llist.push(1); 
          
        System.out.println("Given Linked List"); 
        llist.printList(); 
          
        llist.head = llist.reverse(llist.head, 4); 
  
        System.out.println("Reversed list"); 
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
