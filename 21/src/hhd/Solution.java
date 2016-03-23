package hhd;

public class Solution {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode an = new ListNode(0);
		ListNode head = an ;
		while(l1!=null || l2!=null)
		{
			if(l1==null) {
				an.next =l2;
				break;
			}
			if(l2 == null )
			{
				an.next = l1;
				break;
			}
			if(l1.val<l2.val) {
				an.next=l1;
				l1=l1.next;
			}
			else {
				an.next = l2;
				l2=l2.next;
			}
			an=an.next;
		}
		return head.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
