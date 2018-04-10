
/**
 * 请实现一个函数，输入一个整数，输出该整数二进制表示中1的个数。
 * @Description: 二进制中1的个数
 * @author: husb   
 * @date: 2018年4月10日 下午3:17:45 
 */
public class T10 {

	public static void main(String[] args) {
		System.out.println(numberOfOne(9));
		System.out.println(numberOfOne(13));
	}

	/**
	 * @Description: n&(n-1)，将二进制表示中的最低位的1变为0
	 * @author: husb   
	 * @date: 2018年4月10日 下午3:23:02 
	 */
	private static int numberOfOne(int n) {
		int count=0;
		while(n!=0) {
			n=n&(n-1);
			count++;
		}
		return count;
	}
	
}
