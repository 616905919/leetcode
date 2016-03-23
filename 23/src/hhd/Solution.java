package hhd;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		Comparator<ListNode> comp = new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return Integer.compare(o1.val, o2.val);
			}
		};
		Queue<ListNode> mq = new PriorityQueue<Solution.ListNode>(comp);
		ListNode tmpn = new ListNode(0);
		ListNode head = tmpn;
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null)
				mq.add(lists[i]);
		}
		while (!mq.isEmpty()) {
			ListNode oo = mq.poll();
			tmpn.next = oo;
			tmpn=tmpn.next;
			oo = oo.next;
			if(oo!=null) mq.add(oo);
		}
		head = head.next;
		return head;
	}
}
