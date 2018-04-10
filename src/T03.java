
/**
 * @Description: 二维数组的查找
 * @author: husb
 * @date: 2018年4月10日 上午11:33:16
 */
public class T03 {

	public static void main(String[] args) {
		int[][] array = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		System.out.println(find(5, array));
		System.out.println(find(7, array));
	}

	/**
	 * @Description: 从左下角开始比，查找的数字大于遍历值右移；查找的数字小于遍历值上移
	 * @author: husb   
	 * @date: 2018年4月10日 上午11:55:27 
	 */
	public static boolean find(int targer, int[][] array) {
		int rows = array.length;
		int columns = array[0].length;
		int i = rows - 1, j = 0;
		while (targer != array[i][j]) {
			if (targer > array[i][j]) {
				j++;
			} else {
				i--;
			}
			if (i < 0 || j < 0 || i > rows || j > columns) {
				return false;
			}
		}
		return true;
	}

}
