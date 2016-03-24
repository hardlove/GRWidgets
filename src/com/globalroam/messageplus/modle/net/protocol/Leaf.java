package com.globalroam.messageplus.modle.net.protocol;

import java.io.IOException;

import org.xmlpull.v1.XmlSerializer;

public class Leaf {
	// <agenterid>889931</agenterid>
	// 处理的思路
	// ①包含的内容
	// ②序列化xml
	
	private String tagName = null;
	private String tagValue = null;
	public String getName() {
		return tagName;
	}
	public void setTagName(String name) {
		this.tagName = name;
	}
	public String getValue() {
		return tagValue;
	}
	public void setTagValue(String value) {
		this.tagValue = value;
	}
	/**
	 * 每个叶子需要指定标签名称
	 * @param name
	 */
	public Leaf(String name) {
		super();
		this.tagName = name;
	}
	
	/**
	 * 处理常量
	 * @param name
	 * @param value
	 */
	public Leaf(String name, String value) {
		super();
		this.tagName = name;
		this.tagValue = value;
	}
	
	/**
	 * 序列化叶子
	 * @param serializer
	 */
	public void serialize(XmlSerializer serializer){
		if(serializer == null){
			throw new IllegalArgumentException("serializer can be null.");
		}
		try {
			serializer.startTag(null, tagName);
			//处理序列化的一个bug，防止tagValue为空时crash
			if(tagValue == null){
				tagValue = "";
			}
			serializer.text(tagValue);
			serializer.endTag(null, tagName);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String toString() {
		return new StringBuffer().append("[").append(tagName).append(":").append(tagValue).append("]").toString();
	}
	
}
