package hhd;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null ) return head;
		int i = 1 ; 
		ListNode tmp = head;
		while(head.next!=null){
			i++;
			head=head.next;
		}
		int s = i-n-1;
		if(s<0) return tmp.next;
		head = tmp;
		while(s!=0){
			head=head.next;
			s--;
		}
		head.next = head.next.next;
		return tmp;
	}
}
