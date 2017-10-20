package hang.silver.util;

/**
 * 字符窜工具类
 * @author hang
 *
 */
public class StringTool {
	
	/**
	 * 替换不可插入数据库字符
	 * @param str
	 * @return
	 */
	public static String removeNonBmpUnicode(String str) {
		if (str == null) {
			return null;
		}
		str = str.replaceAll("[^\\u0000-\\uFFFF]", "");
		return str;
	}
}
