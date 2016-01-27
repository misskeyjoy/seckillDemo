package com.sohu.tv.cn.dto;

/**
 * Created by misskey on 16-1-26.
 */

/**
 *  返回到前端的json 类
 *
 * @param <T>
 */
public class Result<T> {
    private boolean success;
    private String error;
    private T data;

    public Result(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setT(T t) {
        this.data = t;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", error='" + error + '\'' +
                ", data=" + data +
                '}';
    }
}
