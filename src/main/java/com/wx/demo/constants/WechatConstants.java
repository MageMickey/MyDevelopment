package com.wx.demo.constants;

import com.wx.demo.model.timing.AccessTokenThread;

//静态常量类
public class WechatConstants {
    //公众号appid
    public static final String APPID = "wx860bf6a8512b89e2";

    //公众号appsecert
    public static final String APPSECRET = "dfc8670351e2c467e00c159eab060349";

    //获取access_token_Url
    private static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    //将appid与appsecert填入后得到的获取access_token_Url
    public static String getAccess_token_url(){
        return ACCESS_TOKEN_URL.replace("APPID",APPID).replace("APPSECRET",APPSECRET);
    }

    //自定义创建菜单url
    public static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    //将access_token填入后得到的自定义创建菜单url
    public static String getCreate_menu_url(){
        return CREATE_MENU_URL.replace("ACCESS_TOKEN", AccessTokenThread.getAccessToken().getString("access_token"));
    }

    public static void main(String[] args){

    }

}
