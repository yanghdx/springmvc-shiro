package cn.doit123.shirodemo.utils;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.util.StringUtils;

public class ArrayHelper {

	/**
	 * Convert a array to String
	 * @param array
	 * @param seperator
	 * @return
	 */
	public static String join(Object[] array, char seperator) {
		if (array == null || array.length == 0) {
			return "";
		} else {
			StringBuilder sb = new StringBuilder();
			for (Object obj : array) {
				if (obj == null)
					continue;
				sb.append(obj.toString()).append(seperator);
			}
			return sb.deleteCharAt(sb.length()-1).toString();
		}
	}
	
	public static final int[] EMPTY_INT_ARRAY = new int[0];
	
	/**
	 * Convert a string to integer array.
	 * @param string
	 * @param seperator
	 * @return
	 */
	public static int[] toIntArray(String string, char seperator) {
		if (StringUtils.isEmpty(string)) {
			return EMPTY_INT_ARRAY;
		} else {
			String[] strs = string.split(seperator+"");
			int[] result = new int[strs.length];
			int index = 0;
			for (String str : strs ) {
				result[index++] = NumberUtils.toInt(str);
			}
			return result;
 		}
	}
 }
