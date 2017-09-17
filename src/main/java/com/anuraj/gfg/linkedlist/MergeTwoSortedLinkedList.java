package com.anuraj.gfg.linkedlist;

public class MergeTwoSortedLinkedList {

	Lnode mergeRecursively(Lnode head1, Lnode head2) {

		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		if (head1.data < head2.data) {
			head1.next = mergeRecursively(head1.next, head2);
			return head1;
		} else {
			head2.next = mergeRecursively(head1, head2.next);
			return head2;
		}

	}

	Lnode mergeIteratively(Lnode head1, Lnode head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		if (head1.data < head2.data) {
			return mergeUtil(head1, head2);
		} else {
			return mergeUtil(head2, head1);
		}
	}

	Lnode mergeUtil(Lnode h1, Lnode h2) {

		if (h1.next == null) {
			h1.next = h2;
			return h1;
		}

		Lnode curr1 = h1;
		Lnode next1 = h1.next;

		Lnode curr2 = h2;
		Lnode next2 = h2.next;

		while (next1 != null && next2 != null) {
			// if curr2 lies in between curr1 and next1
			// then do curr1->curr2->next1
			if (curr2.data > curr1.data && curr2.data < next1.data) {
				next2 = curr2.next;
				curr1.next = curr2;
				curr2.next = next1;
				// now let curr1 and curr2 to point
				// to their immediate next pointers
				curr1 = curr2;
				curr2 = next2;
			} else {
				if (next1.next != null) {
					next1 = next1.next;
					curr1 = curr1.next;

				} else {
					next1.next = curr2;
					return h1;
				}
			}
		}
		return h1;
	}

	Lnode mergeIterativelyLokesh(Lnode head1, Lnode head2) {

		Lnode mergeHead = null;
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		Lnode next1 = head1;
		Lnode next2 = head2;

		if (head1.data < head2.data) {
			mergeHead = head1;
			next1 = head1.next;
		} else {
			mergeHead = head2;
			next2 = head2.next;
		}

		Lnode result = mergeHead;

		while (next1 != null && next2 != null) {
			if (next1.data < next2.data) {
				result.next = next1;
				next1 = next1.next;
				result = result.next;
			} else {
				result.next = next2;
				next2 = next2.next;
				result = result.next;

			}
		}

		if (next1 == null && next2 != null) {
			result.next = next2;
		}
		if (next2 == null && next1 != null) {
			result.next = next1;
		}

		return mergeHead;
	}

	public static void main(String[] args) {
		MergeTwoSortedLinkedList llist = new MergeTwoSortedLinkedList();
		Lnode head1 = new Lnode(1);
		head1.next = new Lnode(3);
		head1.next.next = new Lnode(5);
		System.out.println("\nOriginal first is:\n");
		llist.printList(head1);
		Lnode head2 = new Lnode(0);
		head2.next = new Lnode(2);
		head2.next.next = new Lnode(4);
		head2.next.next.next = new Lnode(8);
		System.out.println("\nOriginal second is:\n");
		llist.printList(head2);

		// System.out.println("\nMerged recurssivle is:\n");
		// Lnode mergeList = llist.mergeRecursively(head1, head2);
		// llist.printList(mergeList);

		System.out.println("\nMerged iteratively is:\n");
		Lnode mergeList2 = llist.mergeIterativelyLokesh(head1, head2);
		llist.printList(mergeList2);
	}

	void printList(Lnode head) {

		Lnode last = head;
		while (last != null) {
			System.out.print(last.data + " ");
			last = last.next;
		}
	}

}
