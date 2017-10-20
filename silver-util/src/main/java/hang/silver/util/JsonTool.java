package hang.silver.util;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonTool {
	
	/**
	 * 将JSON转换转换成List
	 * @param json
	 * @return
	 */
	public static <T> List<T> jsongToList(String json){
		return new Gson().fromJson(json, new TypeToken<List<T>>(){}.getType());
	}

}
