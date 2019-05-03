package com.wx.demo.model.request;
/**
 * 音频消息
 */
public class VoiceMessage extends Message {
	// 媒体ID
	private String MediaId;
	// 语音格式
	private String Format;
 
	public String getMediaId() {
		return MediaId;
	}
 
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
 
	public String getFormat() {
		return Format;
	}
 
	public void setFormat(String format) {
		Format = format;
	}
}
