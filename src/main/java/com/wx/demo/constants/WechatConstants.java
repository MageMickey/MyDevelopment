package com.wx.demo.constants;

import com.wx.demo.utils.WeixinUtil;
import net.sf.json.JSONObject;
//静态常量类
public class WechatConstants {
    //公众号appid
    public static final String APPID = "你的appid";

    //公众号appsecert
    public static final String APPSECRET = "你的APPSecert";

    //获取access_token_Url
    private static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    //将appid与appsecert填入后得到的URL
    public static String getAccess_token_url(){
        return ACCESS_TOKEN_URL.replace("APPID",APPID).replace("APPSECRET",APPSECRET);
    }

    public static void main(String[] args){
        JSONObject get = WeixinUtil.httpRequest(getAccess_token_url(), "GET", null);
        System.out.println(get.toString());
    }
}
