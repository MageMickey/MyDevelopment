package com.wx.demo.model;

//access_token实体类
public class AccessToken {
    //access_toekn凭证
    private String  access_token;
    //有效时间
    private int expires_in;

    public AccessToken(String access_token, int expires_in) {
        this.access_token = access_token;
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

}
