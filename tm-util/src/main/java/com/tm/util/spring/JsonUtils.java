package com.tm.util.spring;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;

public class JsonUtils {

	private static ObjectMapper mapper;
	private static Gson gson;
	
	public static String toJson(Object pojoObj) {
		getGson();
		return gson.toJson(pojoObj);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object toPojo(String jsonObj, Class target) throws JsonParseException, JsonMappingException, IOException {
		getMapper();
		return mapper.readValue(jsonObj, target);
	}
	
	private static void getMapper() {
		if(mapper == null) {
			SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss aa");
			mapper = new ObjectMapper();
			mapper.setDateFormat(format);
			mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		}
	}
	
	private static void getGson() {
		if(gson == null) {
			gson = new Gson();
		}
	}
}