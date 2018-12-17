package com.qf.pojo.po;

public class LayuiReplay {
    private  int code;//默认是0  表示success
    private String msg;
    private long count;//个数
    private Object data;//数据

    @Override
    public String toString() {
        return "LayuiReplay{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public LayuiReplay() {

    }
}
