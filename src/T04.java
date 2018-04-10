
/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @Description: 替换空格
 * @author: husb
 * @date: 2018年4月10日 下午12:06:09
 */
public class T04 {

	public static void main(String[] args) {
		String string1 = "We are happy.";
		System.out.println(replaceSpace(string1));
	}

	/**
	 * beginIndex记录比较起始下标，spaceIndex记录空格下标。
	 * 添加beginIndex到spaceIndex的数据到StringBuilder中。
	 * beginIndex设为spaceIndex；spaceIndex重新计算
	 * @author: husb   
	 * @date: 2018年4月10日 下午12:26:55 
	 */
	public static String replaceSpace(String str) {
		//一开始想到的办法，一个字符一个字符的比，
		//这样会创建多个string对象,String.valueOf()内部是通过new String()来实现的。
		/*
		 * char[] chars = str.toCharArray(); StringBuilder sb = new StringBuilder(); for
		 * (char c : chars) { sb.append(c == ' ' ? "%20" : String.valueOf(c)); }
		 */
		StringBuilder sb = new StringBuilder();
		int beginIndex = 0;
		int spaceIndex = str.indexOf(" ", beginIndex);
		while (spaceIndex > 0) {
			sb.append(str.substring(beginIndex, spaceIndex)).append("%20");
			beginIndex = spaceIndex + 1;
			spaceIndex = str.indexOf(" ", beginIndex);
		}
		sb.append(str.substring(beginIndex, str.length()));
		return sb.toString();
	}
}
