package bfcai.kaleem.databaseAPI.utils;

import java.util.HashMap;

public class Response {

	private static HashMap<String, Object> response = new HashMap<>();

	public static HashMap<String, Object> make(String msg, Integer code, Object data){
		response.put("code", code);
		response.put("message", msg);
		response.put("data", data);
		return response;
	}

	public int getCode(){
		return (int) response.get("code");
	}

	public static HashMap<String, Object> toData(){
		return response;
	}
}
