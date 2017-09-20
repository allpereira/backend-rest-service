package br.com.allpereira.utils;

public class JsonResult {
	public enum JsonResultCode {
		SUCCESS, ERROR, DONE
	}

	private String message;
	private Object data;
	private JsonResultCode code;

	public JsonResult(String message, Object data, JsonResultCode code) {
		this.message = message;
		this.data = data;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public JsonResultCode getCode() {
		return code;
	}

	public void setCode(JsonResultCode code) {
		this.code = code;
	}

}
