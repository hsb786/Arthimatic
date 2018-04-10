/**
 * @Description: 反转链表
 * @author: husb
 * @date: 2018年4月10日 下午7:31:27
 */
public class T16 {

	public static class ListNode {
		int data;
		ListNode next;

		public ListNode(int data) {
			this.data = data;
		}
	}

	/**
	 * 维护两个节点，一个指向当前节点，一个指向下一个节点 
	 * 缺点，需要new 对象，占用内存
	 * @author: husb
	 * @date: 2018年4月10日 下午7:44:22
	 */
	private static ListNode reverseList(ListNode head) {
		ListNode result = new ListNode(head.data);
		ListNode t;
		while (head.next != null) {
			t = result;
			result = new ListNode(head.next.data);
			result.next = t;
			head = head.next;
		}
		return result;
	}

	/**
	 * @Description: 需要维护三个节点，当前，前一个，下一个
	 * @author: husb   
	 * @date: 2018年4月10日 下午7:57:58 
	 */
	private static ListNode reverseList2(ListNode head) {
		ListNode result = null;
		ListNode t = head;
		ListNode preNode = null;
		while (t != null) {
			ListNode nextNode = t.next;
			if (nextNode == null) {
				result = t;
			}
			t.next = preNode;
			preNode = t;
			t = nextNode;
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		System.out.println(reverseList2(head).next.data);
	}

}
