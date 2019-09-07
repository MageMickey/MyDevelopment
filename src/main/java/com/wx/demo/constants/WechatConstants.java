package com.wx.demo.constants;

import com.wx.demo.model.timing.AccessTokenThread;

//静态常量类
public class WechatConstants {
    //公众号appid
    public static final String APPID = "";

    //公众号appsecert
    public static final String APPSECRET = "";

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

    //网页授权
    public static final String WEB_AUTHORIZE_URL= "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";

    /**
     * 将所需要的参数填入后得到的网页授权url
     * @param redirect_uri 授权后重定向的回调链接地址
     * @param isSilence 是否为静默方式
     * @param state 可选
     * @return
     */
    public static String getWeb_authorize_url(String redirect_uri,boolean isSilence,String state){
        return WEB_AUTHORIZE_URL.replace("APPID", APPID)
                .replace("REDIRECT_URI",redirect_uri)
                .replace("SCOPE",isSilence?"snsapi_base":"snsapi_userinfo")
                .replace("STATE",state);
    }
    //网页授权code获取access_token的url
    public static final String WEB_AUTHORIZE_CODE_URL =  "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

    /**
     * 网页授权获取code后将code填入后的url
     * @param code
     * @return
     */
    public static String getWeb_authorize_code_url(String code){
        return WEB_AUTHORIZE_CODE_URL.replace("APPID", APPID)
                .replace("SECRET",APPSECRET)
                .replace("CODE",code);
    }
    //网页授权access_token用户基本信息
    public static final String WEB_AUTHORIZE_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

    /**
     * 网页授权获取access_token与openid后填入得url
     * @param access_token 网页授权access_token（与基本的access_token不同）
     * @param openid （用户唯一标识openid）
     * @return
     */
    public static String getWeb_authorize_access_token_url(String access_token,String openid){
        return WEB_AUTHORIZE_ACCESS_TOKEN_URL.replace("ACCESS_TOKEN",access_token)
                .replace("OPENID",openid);
    }
    public static void main(String[] args){
        System.out.println(WechatConstants.getWeb_authorize_url(
                "http://cg7bgz.natappfree.cc/test/authorizeInfo",
                false,
                ""));
    }

}
