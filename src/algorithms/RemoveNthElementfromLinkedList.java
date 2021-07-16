package algorithms;

public class RemoveNthElementfromLinkedList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		ListNode eight = new ListNode(8, null);
		ListNode seven = new ListNode(7, eight);
		ListNode two = new ListNode(2, seven);
		ListNode one = new ListNode(1, two);
		ListNode head = new ListNode(3, one);

		head = removeNthFromEnd(head, 2);
		printList(head);

	}
	
	   public static void printList(ListNode head)
	    {
	        while (head != null)
	        {
	            System.out.print(head.val+" ");
	            head = head.next;
	        }
	    }

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		int size = getSize(head);
		int position = size - n;
		// If linked list is empty
		if (head == null)
			return head;

		// Store head node
		ListNode temp = head;

		// If head needs to be removed
		if (position == 0) {
			head = temp.next; // Change head
			return head;
		}

		// Find previous node of the node to be deleted
		for (int i = 0; temp != null && i < position - 1; i++)
			temp = temp.next;

		// If position is more than number of nodes
		if (temp == null || temp.next == null)
			return head;

		// Node temp->next is the node to be deleted
		// Store pointer to the next of node to be deleted
		ListNode next = temp.next.next;

		temp.next = next; // Unlink the deleted node from list
		return head;

	}

	public static int getSize(ListNode head) {
		int size = 0;
		ListNode cur = head;
		while (cur != null) {
			size++;
			cur = cur.next;
		}
		return size;
	}

}
