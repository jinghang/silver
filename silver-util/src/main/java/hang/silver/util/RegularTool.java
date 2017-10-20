package hang.silver.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则工具函数
 * @author hang
 *
 */
public class RegularTool {
	
	/**
	 * 统计数字个数
	 * @param str
	 * @return
	 */
	public static int countNumber(String str) {  
        int count = 0;  
        Pattern p = Pattern.compile("\\d");  
        Matcher m = p.matcher(str);  
        while(m.find()){  
            count++;  
        }  
        return count;  
    }  
  
	/**
	 * 统计字母个数
	 * @param str
	 * @return
	 */
    public static int countLetter(String str) {  
        int count = 0;  
        Pattern p = Pattern.compile("[a-zA-Z]");  
        Matcher m = p.matcher(str);  
        while(m.find()){  
            count++;  
        }  
        return count;  
    }  
  
    /**
     * 统计汉字个数
     * @param str
     * @return
     */
    public static int countChinese(String str) {  
        int count = 0;  
        Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]");  
        Matcher m = p.matcher(str);  
        while(m.find()){  
            count++;  
        }  
        return count;  
    }  

}
