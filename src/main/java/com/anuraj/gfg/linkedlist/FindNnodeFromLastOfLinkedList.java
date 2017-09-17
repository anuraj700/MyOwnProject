package com.anuraj.gfg.linkedlist;

public class FindNnodeFromLastOfLinkedList {

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
	
	 void printNthFromLast(int n, int length){
		 if(length<n){
			 return;
		 }
		 Lnode temp = head;
		 
		 for(int i=1;i<length-n+1;i++){
			 temp=temp.next;
		 }
		 System.out.println("\n"+n+"th node is "+temp.data);
		 
	 }
	
	 void printNthFromLast (int n){
		 if(head==null)
			 return;
		 
		 Lnode ref=head;
		 Lnode main=head;
		 
		 for(int i=0;i<n;i++){
			 if (ref == null)
             {
                 System.out.println(n+" is greater than the no of nodes in the list");
                 return;
             }
			 ref = ref.next;
		 }
		 
		 while(ref!=null){
			 ref= ref.next;
			 main = main.next;
		 }
		 System.out.println("\n"+n+"th node is "+main.data);

		 
	 }
	public static void main(String[] args) {
		FindNnodeFromLastOfLinkedList llist = new FindNnodeFromLastOfLinkedList();
		llist.push(11);
		llist.push(32);
		llist.push(13);
		llist.push(24);
		llist.push(15);
		llist.printList();
		// with help of length O(n)
		llist.printNthFromLast(3, llist.getCountIteratively());
		// without calculating length O(n)
		llist.printNthFromLast(4);
	}

	void printList() {

		Lnode last = head;
		while (last != null) {
			System.out.print(last.data + " ");
			last = last.next;
		}
	}

}
