package mongo.util;

import com.google.gson.Gson;
import spark.ResponseTransformer;

public class JsonUtil {

	public static String toJson(Object object) {
		return new Gson().toJson(object);
	}

	public static ResponseTransformer json() {
		return JsonUtil::toJson;
	}

	public static <T> T toObject(Class<T> t, String json) {
		return new Gson().fromJson(json, t);
	}

}