package com.wx.demo.menu;

import com.wx.demo.constants.WechatConstants;
import com.wx.demo.model.Menu;
import com.wx.demo.utils.WeixinUtil;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//处理菜单类
public class HandleMenu {


    /**
     * 组装菜单数据
     */
    public static String getMenu(){
        //第一栏菜单
        Menu menu1=new Menu();
        menu1.setId("A");
        menu1.setName("第一栏");
        menu1.setType("click");
        menu1.setKey("A");

        Menu menu11=new Menu();
        menu11.setId("A1");
        menu11.setName("第一栏的第一个");
        menu11.setType("click");
        menu11.setKey("A1");

        Menu menu12=new Menu();
        menu12.setId("A2");
        menu12.setName("第一栏的第二个");
        menu12.setType("click");
        menu12.setKey("A2");

        //第二栏
        Menu menu2=new Menu();
        menu2.setId("B");
        menu2.setName("第二栏");
        menu2.setType("click");
        menu2.setKey("B");

        Menu menu21=new Menu();
        menu21.setId("B1");
        menu21.setName("第二栏的第一个");
        menu21.setType("click");
        menu21.setKey("B1");



        Menu menu3=new Menu();
        menu3.setId("C");
        menu3.setName("第三栏");
        menu3.setType("view");
        menu3.setUrl("http://www.baidu.com");

        //最外一层大括号
        Map<String, Object> wechatMenuMap = new HashMap<String, Object>();

        //包装button的List
        List<Map<String, Object>> wechatMenuMapList = new ArrayList<Map<String, Object>>();

        //包装第一栏
        Map<String, Object> menuMap1 = new HashMap<String, Object>();
        Map<String, Object> menuMap11 = new HashMap<String, Object>();
        Map<String, Object> menuMap12 = new HashMap<String, Object>();
        List<Map<String, Object>> subMenuMapList1 = new ArrayList<Map<String, Object>>();


        //第一栏第一个
        menuMap11.put("name",menu11.getName());
        menuMap11.put("type",menu11.getType());
        menuMap11.put("key",menu11.getKey());
        subMenuMapList1.add(menuMap11);

        //第二栏第二个
        menuMap12.put("name",menu12.getName());
        menuMap12.put("type",menu12.getType());
        menuMap12.put("key",menu12.getKey());
        subMenuMapList1.add(menuMap12);

        menuMap1.put("name",menu1.getName());
        menuMap1.put("sub_button",subMenuMapList1);

        //包装第二栏
        Map<String, Object> menuMap2 = new HashMap<String, Object>();
        Map<String, Object> menuMap21 = new HashMap<String, Object>();
        List<Map<String, Object>> subMenuMapList2 = new ArrayList<Map<String, Object>>();

        //第二栏第一个
        menuMap21.put("name",menu21.getName());
        menuMap21.put("type",menu21.getType());
        menuMap21.put("key",menu21.getKey());
        subMenuMapList2.add(menuMap21);

        menuMap2.put("name",menu2.getName());
        menuMap2.put("sub_button",subMenuMapList2);

        //包装第三栏
        Map<String, Object> menuMap3 = new HashMap<String, Object>();
        List<Map<String, Object>> subMenuMapList3 = new ArrayList<Map<String, Object>>();

        menuMap3.put("name",menu3.getName());
        menuMap3.put("type",menu3.getType());
        menuMap3.put("url",menu3.getUrl());
        menuMap3.put("sub_button",subMenuMapList3);


        wechatMenuMapList.add(menuMap1);
        wechatMenuMapList.add(menuMap2);
        wechatMenuMapList.add(menuMap3);
        wechatMenuMap.put("button",wechatMenuMapList);
        //转换成json格式
        return  JSONObject.fromObject(wechatMenuMap).toString();
    }
    //main方法测试
    public static void main(String[] args) {
        //因为是POST请求方式，所以getMenu()创建的json数据放在httpRequest()方法的第三个参数作为参数传递
        JSONObject post = WeixinUtil.httpRequest(WechatConstants.getCreate_menu_url(), "POST", getMenu());
        System.out.println(post);
    }
}
