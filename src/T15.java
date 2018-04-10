/**
 * @Description:链表中倒数第K个节点
 * @author: husb
 * @date: 2018年4月10日 下午7:17:56
 */
public class T15 {

	public static class ListNode {
		int data;
		ListNode next;

		public ListNode(int data) {
			this.data = data;
		}
	}

	/**
	 * 维护两个节点，后一个在前一个的后k位。
	 * 之后一起走，如果后一个节点为最后一个节点就停下
	 * @author: husb   
	 * @date: 2018年4月10日 下午7:29:09 
	 */
	public static ListNode findKthNodeFromEnd(ListNode head, int k) {
		ListNode node2 = head;
		int i = 1;
		if(k<=0) {
			System.out.println("必须从1开始");
			return null;
		}
		while (i++ < k) {
			if (node2.next == null) {
				return null;
			}
			node2 = node2.next;
		}
		while (node2.next != null) {
			head = head.next;
			node2 = node2.next;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		ListNode kNode = findKthNodeFromEnd(head, 3);
		if (kNode != null) {
			System.out.println(kNode.data);
		} else {
			System.out.println("超过链表长度");
		}
	}

}
