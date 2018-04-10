package com.gao.scorpio.json;

/**
 * @description JsonResp
 * @author: gaobh
 * @date: 2017/2/23
 * @version: v1.0
 */
public class JsonResp {
    public static final JsonResp Success = new JsonResp(0, null, null, null);
    public static final JsonResp Fail = new JsonResp(1, null, null, null);
    public static final int Result_Success = 0;
    public static final int Result_Fail = 1;
    private int result;
    private String error;
    private String msg;
    private Object data;

    public static JsonResp buildSuccees(Object data) {
        return new JsonResp(Result_Success, data);
    }

    public static JsonResp success() {
        return new JsonResp(Result_Success, null);
    }

    public static JsonResp success(Object data) {
        return new JsonResp(Result_Success, data);
    }

    public static JsonResp fail() {
        return new JsonResp(Result_Fail, null);
    }

    public static JsonResp fail(String msg) {
        return new JsonResp(Result_Fail, null);
    }

    public static JsonResp fail(String error, String msg) {
        return new JsonResp(Result_Fail, null);
    }

    public JsonResp(int result) {
        super();
        this.result = result;
    }

    public JsonResp(int result, Object data) {
        super();
        this.result = result;
        this.data = data;
    }

    /**
     * @param result
     * @param error
     * @param msg
     * @param data
     */
    public JsonResp(int result, String error, String msg, Object data) {
        super();
        this.result = result;
        this.error = error;
        this.msg = msg;
        this.data = data;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}


