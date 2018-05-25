package com.ssm.controller.pojo;

public class Basic {
    public int code;
    public String meg;

    public Basic(int code, String meg) {
        this.code = code;
        this.meg = meg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMeg() {
        return meg;
    }

    public void setMeg(String meg) {
        this.meg = meg;
    }
}
