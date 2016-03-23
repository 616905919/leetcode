package hhd;

public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if(head==null|| head.next == null) return head;
		ListNode re = new ListNode(0);
		ListNode tmp =re;
		while(head!=null&&head.next != null){
			re.next = head.next;
			head.next = head.next.next;
			re=re.next;
			re.next= head;
			head=head.next;
		}
		return tmp.next;
	}

}
