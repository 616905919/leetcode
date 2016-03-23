public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0 || head.next == null)
			return head;
		ListNode tmp1 = head;
		ListNode tmp = head;
		ListNode tmp2 = null;
		int m = 1;
		while ((head = head.next) != null) {
			m++;
		}
		k %= m;
		head = tmp1;
		if (k == 0)
			return head;
		k = m-k;
		m=1;
		while (head.next != null) {
			if (k == m) {
				tmp2 = head.next;
				tmp = head;
			}
			head = head.next;
			m++;
		}
		tmp.next = null;
		head.next = tmp1;
		return tmp2;
	}
}