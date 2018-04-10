
/**
 * @Description:在O(1)时间内删除链表节点
 * @author: husb
 * @date: 2018年4月10日 下午3:33:23
 */
public class T13 {

	public static class ListNode {
		public int data;
		public ListNode next = null;

		public ListNode(int data) {
			this.data = data;
		}
	}

	/**
	 * @Description: 由于时间复杂度要求为O(1)，
	 * 只能将加一个节点的值复制到要删除的节点，之后再将下一个节点删除
	 * @author: husb   
	 * @date: 2018年4月10日 下午3:43:23
	 */
	public static void deleteNode(ListNode head, ListNode node) {
		//若为头节点，则将头节点设为head.next
		if (node == head) {
			head = head.next;
		//若为未节点，只能遍历了
		} else if (node.next == null) {
			ListNode t=head;
			while(t.next!=node) {
				t=t.next;
			}
			t.next=null;
		} else {
			//若为中间节点，则将下个节点的值复制到要删除的阶段，并且移除一个节点
			node.data = node.next.data;
			node.next = node.next.next;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode tail = new ListNode(4);
		head.next = b;
		b.next = c;
		c.next = tail;
		deleteNode(head, tail);
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}

}
