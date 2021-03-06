package com.genpact.flowable.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

/**
 * @author sxia
 * @Description: TODO(返回数据)
 * @date 2017-6-23 15:07
 */
public class Result extends HashMap<String, Object> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private final static int CODE_SUCCESS=0;
	private final static String SUCCESS_MSG= "Success";

	public static Result error() {
		return error(HttpStatus.INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}

	public static Result error(String msg) {
		return error(HttpStatus.INTERNAL_SERVER_ERROR, msg);
	}

	public static Result error(HttpStatus status, String msg) {
		Result r = new Result();
		r.put("code", status.value());
		r.put("msg", msg);
		return r;
	}

	public static Result ok() {
		return ok(SUCCESS_MSG);
	}

	public static Result ok(String msg) {
		Result r = new Result();
		r.put("code", CODE_SUCCESS);
		r.put("msg", msg);
		return r;
	}

	public static Result ok(Object data) {
		Result r = new Result();
		r.put("code", CODE_SUCCESS);
		r.put("msg", SUCCESS_MSG);
		r.put("data",data);
		return r;
	}

	public Result put(Map<String, Object> map) {
		super.putAll(map);
		return this;
	}

	@Override
	public Result put(String key, Object value) {
		super.put(key, value);
		return this;
	}

}
