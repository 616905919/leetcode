package hhd;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Ans {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ans = new ListNode((l1.val + l2.val) % 10);
		int s = (l1.val + l2.val) / 10;
		ListNode p1 = null;
		ListNode p2 = ans;

		while (l1.next != null || l2.next != null) {
			if (l1.next == null && l2.next != null)
				l1.next = new ListNode(0);
			if (l2.next == null && l1.next != null)
				l2.next = new ListNode(0);
			l1 = l1.next;
			l2 = l2.next;
			p1 = new ListNode((l1.val + l2.val + s) % 10);
			s = (l1.val + l2.val + s) / 10;
			p2.next = p1;
			p2 = p1;
			// index++;
		}
		if (s == 1)
			p2.next = new ListNode(1);
		return ans;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ans and = new Ans();
		ListNode l1 = new ListNode(5);
		ListNode l3 = new ListNode(5);
		ListNode l2 = new ListNode(8);
		l1.next = l3;
		ListNode mm = and.addTwoNumbers(l1, l2);
	}

}
