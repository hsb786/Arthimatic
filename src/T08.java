
/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序数组的一个旋转，输出旋转数组的最小元素。 
 * 旋转数组的特点：
 * 1，旋转之后的数组可以分为两个排序的子数组，且前面的子数组的元素都大于或等于后面子数组的元素。 
 * 2，最小或者最大元素位于两个子数组的分界
 * 
 * @Description:旋转数组的最小数字
 * @author: husb
 * @date: 2018年4月10日 下午2:06:14
 */
public class T08 {
	public static void main(String[] args) {
		int[] array1 = { 3, 4, 5, 1, 2 };
		System.out.println("升序排序数组的一个旋转数组，无重复数字：" + findMin(array1));
		int[] array2 = { 1, 2, 3, 4, 5 };
		System.out.println("升序排序数组：" + findMin(array2));
		int[] array3 = { 1 };
		System.out.println("只包含一个数字的数组：" + findMin(array3));
		int[] array4 = { 2, 4, 2, 2, 2, 2, 2 };
		System.out.println("包含重复元素的数组：" + findMin(array4));
	}

	/**
	 * 由于旋转数组的特点，前一个数组一定大于后一个数组。数组内部是升序的。
	 * 所以就可以使用二分查找。
	 * 定义minIndex为0，highIndex为length-1
	 * 若中间位大于array[minIndex]，则代表中间位处于前面部分,将minIndex设为midIndex；
	 * 小于则处于后面部分,将highIndex设为midIndex
	 * 最终minIndex位于前一个数组的最后一位，highIndex位于后一个数组的第一位
	 * 显然最小值就是highIndex所在的值。
	 * 特殊情况，但minIndex与highIndex上的值相等时，无法判断中间值是在前，还是在后。
	 * 所以只能用顺序查找
	 * @author: husb   
	 * @date: 2018年4月10日 下午2:56:26 
	 */
	public static int findMin(int[] array) {
		int lowIndex = 0;
		int highIndex = array.length - 1;
		int midIndex = (lowIndex + highIndex) / 2;
		// 当代查找数组第一位大于最后一位时，代表是旋转数组
		while (array[lowIndex] >= array[highIndex]) {
			// 临界条件 前面最后一位，后面第一位。 后面第一位就是最小值
			if (highIndex - lowIndex == 1) {
				return array[highIndex];
			}
			// 当左下标的元素等于右下标的元素时，无法判断中间位是位于前面还是后面的。
			// 只能用顺序查找
			if (array[lowIndex] == array[highIndex]) {
				return findMinInOrder(array, lowIndex, highIndex);
			}
			// 当中间位大于前面第一位时，代表处于前面
			if (array[midIndex] > array[lowIndex]) {
				lowIndex = midIndex;
			} else {
				// 否则处于后面
				highIndex = midIndex;
			}
			// 计算中间位
			midIndex = (lowIndex + highIndex) / 2;
		}
		//已排好序，返回低位即可
		return array[lowIndex];
	}

	/**
	 * @Description: 当有重复元素的时候，无法确定中间的元素是前面的还是后面的
	 * @author: husb
	 * @date: 2018年4月10日 下午2:33:52
	 */
	private static int findMinInOrder(int[] array, int lowIndex, int highIndex) {
		int result = array[lowIndex];
		for (int i = lowIndex + 1; i <= highIndex; i++) {
			if (result > array[i]) {
				result = array[i];
			}
		}
		return result;
	}
}
