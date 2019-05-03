package com.wx.demo.model.response;
/**
 * 音乐消息
 */
public class MusicMessage extends Message {
	// 音乐
	private Music Music;
 
	public Music getMusic() {
		return Music;
	}
 
	public void setMusic(Music music) {
		Music = music;
	}
}
