import java.util.Arrays;

/**
 * @Description:调整数组顺序使奇数位于偶数之前
 * @author: husb
 * @date: 2018年4月10日 下午7:01:18
 */
public class T14 {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3,3, 4, 5, 6, 7, 8,3,3,3,3,38, 9 };
		reorderOddEven(array);
		System.out.println(Arrays.toString(array));
	}

	/**
	 * @Description: 快速排序的思想
	 * 左边一个指针向右移，遇到偶数停止；
	 * 右边一直指针向左移，遇到奇数停止。
	 * 两个值交换
	 * @author: husb   
	 * @date: 2018年4月10日 下午7:12:45 
	 */
	private static void reorderOddEven(int[] arr) {
		int left = -1;
		int right = arr.length ;
		while (left != right&&left<=right) {
			while(arr[++left]%2!=0&&left<arr.length-1);
			while(arr[--right]%2==0&&right>=0);
			if(left<right) {
				int t=arr[left];
				arr[left]=arr[right];
				arr[right]=t;
			}
		}
	}
}
