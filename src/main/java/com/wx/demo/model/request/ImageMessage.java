package com.wx.demo.model.request;
/**
 * 图片消息
 */
public class ImageMessage extends Message {
	// 图片链接
	private String PicUrl;
 
	public String getPicUrl() {
		return PicUrl;
	}
 
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
}

