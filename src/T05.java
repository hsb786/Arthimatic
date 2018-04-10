import java.util.Stack;

/**
 * 输入一个链表的头结点，从尾到头打印出每个结点的值
 * 
 * @Description:从尾到头打印链表
 * @author: husb
 * @date: 2018年4月10日 下午12:54:56
 */
public class T05 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		printListFromTailToHeadByStack(node1);
	}

	/**
	 * @Description: 使用栈存储
	 * @author: husb
	 * @date: 2018年4月10日 下午1:01:50
	 */
	public static void printListFromTailToHeadByStack(ListNode begin) {
		Stack<Integer> stack = new Stack<Integer>();
		while (begin != null) {
			stack.push(begin.val);
			begin = begin.next;
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

}

class ListNode {
	int val;
	ListNode next = null;

	public ListNode() {
	}

	public ListNode(int value) {
		this.val = value;
	}
}