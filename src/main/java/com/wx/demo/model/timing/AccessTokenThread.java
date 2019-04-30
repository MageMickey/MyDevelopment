package com.wx.demo.model.timing;

import com.wx.demo.constants.WechatConstants;
import com.wx.demo.model.AccessToken;
import com.wx.demo.utils.WeixinUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时获取微信access_token的线程
 *在主函数中注解@EnableScheduling，在程序启动时就开启定时任务。
 * 每90分钟执行一次
 */
@Component
public class AccessTokenThread {
    private static Logger log = LoggerFactory.getLogger(AccessTokenThread.class);

    // 第三方用户唯一凭证
    public static AccessToken accessToken = null;
    //定时任务，90分钟执行一次
    @Scheduled(fixedDelay = 2*2700*1000)
    public void getTimingAccessToken(){
        //获取微信服务器返回的json
        JSONObject accessTokenJson = AccessTokenThread.getAccessToken();
        String access_token = accessTokenJson.getString("access_token");
        int expires_in = accessTokenJson.getInt("expires_in");
        log.info("成功获取access_token："+access_token);
        AccessTokenThread.accessToken = new AccessToken(access_token,expires_in);
    }

    public static JSONObject getAccessToken(){
        return WeixinUtil.httpRequest(WechatConstants.getAccess_token_url(), "GET", null);

    }
}
