package com.wx.demo.model.request;

//文本消息
public class TextMessage extends Message{
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
