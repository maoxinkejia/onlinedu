package edu.zhangmeng.onlinedu.common.controller;

import java.util.HashMap;
import java.util.Map;

public class BaseController {

	private ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<Map<String,Object>>();
	
	public void start() {
		Map<String,Object> result  = new HashMap<String,Object>();
		threadLocal.set(result);
	}
	
	public void success(boolean success) {
		Map<String,Object> result  =  threadLocal.get();		
		result.put("success",success);
	}
	
	public void message(String message) {
		Map<String,Object> result  =  threadLocal.get();	
		result.put("message",message);
	}
	
	public void data(Object data) {
		Map<String,Object> result  =  threadLocal.get();	
		result.put("data",data);
	}
	
	public Object end() {
		Map<String,Object> result  =  threadLocal.get();	
		return result ;
	}
	
}
