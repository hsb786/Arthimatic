
/** 输入两个递增排序的链表，合并这两个链表并使新链表中的节点人是按照递增排序的。
 * @Description:合并两个排序的链表
 * @author: husb
 * @date: 2018年4月12日 下午2:47:00
 */
public class T17 {
	public static class ListNode {
		int data;
		ListNode next;

		public ListNode() {

		}

		public ListNode(int value) {
			this.data = value;
		}
	}

	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(7);
		head1.next = node1;
		node1.next = node2;
		node2.next = node3;

		ListNode head2 = new ListNode(2);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(8);
		head2.next = node5;
		node5.next = node6;
		node6.next = node7;
		ListNode result = merge(head1, head2);
		while (result != null) {
			System.out.print(result.data + " ");
			result = result.next;
		}
	}

	public static ListNode merge(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		if (list1.data < list2.data) {
			list1.next = merge(list1.next, list2);
			return list1;
		} else {
			list2.next = merge(list1, list2.next);
			return list2;
		}
	}

	public static ListNode mergeSortedList(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		ListNode mergeHead = null;
		ListNode current = null;
		if (list1.data <= list2.data) {
			mergeHead = current = list1;
			list1 = list1.next;
		} else {
			mergeHead = current = list2;
			list2 = list2.next;
		}
		while (list1 != null && list2 != null) {
			if (list1.data <= list2.data) {
				current.next = list1;
				current = current.next;
				list1 = list1.next;
			} else {
				current.next = list2;
				current = current.next;
				list2 = list2.next;
			}
		}
		if (list1 == null) {
			current.next = list2;
		} else {
			current.next = list1;
		}
		return mergeHead;
	}
}
