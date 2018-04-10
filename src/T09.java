
/**
 * 写一个函数，输入n，求斐波那契数列的第n项
 * @Description: 斐波那契数列
 * @author: husb   
 * @date: 2018年4月10日 下午3:11:01 
 */
public class T09 {
	public static void main(String[] args) {
		System.out.println(fibonacci(5));
	}
	
	public static int fibonacci(int n) {
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		int i=1,j=2,t=0;
		while(n-->2) {
			t=i+j;
			i=j;
			j=t;
		}
		return t;
	}
}
