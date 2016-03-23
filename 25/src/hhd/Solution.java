package hhd;

public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if(head==null) return head; 
		if(k==1) return head;
		ListNode fi = head;
		ListNode la = new ListNode(0);
		ListNode ans = head;
		boolean getit = true;
		while (true) {
			ListNode tmp = head;
			int i = 0;
			while (++i < k) {
				if (head==null||head.next == null) {
					la.next = tmp;
					return fi;
				} else
					head = head.next;
			}
			i = 0;
			head = tmp;
			ListNode tmphead = null;
			ListNode tmphead2 = null;
			while (++i < k) {
				tmphead2 = head.next;
				head.next = tmphead;
				tmphead = head;
				head = tmphead2;
			}
			tmphead2 = head.next;
			head.next = tmphead;
			fi = head;
			if (getit){
				ans = fi;
				getit=false;
			}
				
			else
				la.next = fi;
			la = tmp;
			la.next = null;
			head=tmphead2;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		ListNode l1 = a.new ListNode(1);
		l1.next = a.new ListNode(2);
		//l1.next.next =a.new ListNode(3);
		a.reverseKGroup(l1, 2);
		

	}

}
