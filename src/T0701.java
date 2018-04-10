import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 用两个队列实现一个栈
 * @author: husb
 * @date: 2018年4月10日 下午1:26:42
 */
public class T0701 {

	
	/**
	 * Queue方法: 
	 * offer() 添加一个元素，失败则返回false 
	 * pool() 移除并返回队列头部元素，无则返回null 
	 * peek() 返回头部元素  无则返回null
	 */
	private static Queue<Object> queue1 = new LinkedList<>();
	private static Queue<Object> queue2 = new LinkedList<>();

	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
		pop();
		push(4);
		pop();
		pop();
		pop();
		pop();
	}

	private static void push(Object obj) {
		if (!queue1.isEmpty()) {
			queue1.offer(obj);
		} else {
			queue2.offer(obj);
		}
		System.out.println("入栈:" + obj);
	}

	/**
	 * @Description: 将一个队列里的数据都剪切给另一个队列中，只保留最后一位。
	 * 				这样弹出的数据就是栈尾数据
	 * @author: husb   
	 * @date: 2018年4月10日 下午1:55:11 
	 */
	private static void pop() {
		if (queue1.isEmpty() && queue2.isEmpty()) {
			System.out.println("栈里没有数据");
			return;
		}
		if (queue1.isEmpty()) {
			while (queue2.size() > 1) {
				queue1.offer(queue2.poll());
			}
			System.out.println("出栈:" + queue2.poll());
			return;
		}
		while (queue1.size() > 1) {
			queue2.offer(queue1.poll());
		}
		System.out.println("出栈:" + queue1.poll());
	}

}
