import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下：
 * 请实现他的两个函数appendTail和deleteHead， 
 * 分别完成在队列尾部插入节点和在队列头部删除节点的功能。
 * @Description:用两个栈实现队列
 * @author: husb
 * @date: 2018年4月10日 下午1:05:01
 */
public class T07 {

	private static Stack<Object> stack1 = new Stack<Object>();
	private static Stack<Object> stack2 = new Stack<Object>();

	public static void main(String[] args) {
		appendTail(1);
		appendTail(2);
		appendTail(3);
		deleteHead();
		deleteHead();
		appendTail(4);
		deleteHead();
		appendTail(5);
		deleteHead();
		deleteHead();
		deleteHead();
	}

	/**
	 * @Description: stack1用来存放压入的元素
	 * @author: husb   
	 * @date: 2018年4月10日 下午1:19:07 
	 */
	public static void appendTail(Object item) {
		stack1.push(item);
	}

	public static void deleteHead() {
		//当stack2中有数据，直接弹出
		if (!stack2.isEmpty()) {
			System.out.println("栈顶:" + stack2.pop());
			return;
		} else {
			//stack2压入stack1弹出的数据,这样stack2就是一个队列
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		if (!stack2.isEmpty()) {
			System.out.println("栈顶:" + stack2.pop());
		} else {
			System.out.println("栈中没有元素");
		}
	}
}
