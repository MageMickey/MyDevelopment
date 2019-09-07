package com.wx.demo.controller;

import com.wx.demo.constants.WechatConstants;
import com.wx.demo.utils.WeixinUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试公众号
 * @author mage on 2019/9/5
 */
@Controller
@RequestMapping("test")
public class TestController {

    private Logger log = LoggerFactory.getLogger(TestController.class);
    /**
     * 用户点击授权之后跳转的url
     * @param code 授权成功后得到的code （code作为换取access_token的票据，
     *             每次用户授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期。）
     * @param state （可选参数）
     * @return
     */
    @GetMapping("/authorizeInfo")
    @ResponseBody
    public String authorizeInfo(String code,@RequestParam(value = "state",required = false) String state){
        log.info("[code]:--[{}]",code);
        log.info("[state]:--[{}]",state);
        JSONObject get = WeixinUtil.httpRequest(WechatConstants.getWeb_authorize_code_url(code), "GET", null);
        String access_token = get.getString("access_token");
        String openid = get.getString("openid");
        log.info("[网页授权access_token]：--[{}]",access_token);
        log.info("[微信用户openid]：--[{}]",openid);
        JSONObject userInfo = WeixinUtil.httpRequest(WechatConstants.getWeb_authorize_access_token_url(access_token,openid), "GET", null);
        log.info("[用户基本信息]：--[{}]",userInfo);
        return "SUCCESS";
    }
}
