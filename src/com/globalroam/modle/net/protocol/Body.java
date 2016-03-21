package com.globalroam.modle.net.protocol;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.xmlpull.v1.XmlSerializer;

import com.globalroam.constants.ConstantValue;
import com.globalroam.utils.DES;

import android.text.TextUtils;
import android.util.Xml;

/**
 * 消息体节点的封装
 * @author Administrator
 *
 */
public class Body {
	
	private List<Element> elements = new ArrayList<Element>();
	/******************处理服务器回复*****************/
	private String serviceBodyInsideDESInfo;//服务器端回复的body中的DES加密的信息
	private Oelement oelement = new Oelement();
	
	public String getServiceBodyInsideDESInfo() {
		return serviceBodyInsideDESInfo;
	}
	public void setServiceBodyInsideDESInfo(String serviceBodyInsideDESInfo) {
		this.serviceBodyInsideDESInfo = serviceBodyInsideDESInfo;
	}
	public Oelement getOelement() {
		return oelement;
	}
	
	/***************处理服务器回复*******************/
	
	public List<Element> getElements() {
		return elements;
	}
	/**
	 * 序列化请求
	 */
	public void serializerBody(XmlSerializer serializer){
		/**
		 * <body>
		            <elements>
		                  <element>
		                         <lotteryid>118</lotteryid>
		                         <issues>1</issues>
		                  </element>
		            </elements> 
		     </body>
		 */
		
		try {
			serializer.startTag(null, "body");
			serializer.startTag(null, "elements");
			
			for (Element item:elements) {
				item.serializableElement(serializer);
				
			}
			
			serializer.endTag(null, "elements");
			serializer.endTag(null, "body");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 获取到完整的body
	 * @return
	 */
	public String getWholeBody(){
		StringWriter writer = new StringWriter();
		XmlSerializer serializer = Xml.newSerializer();
		
		try {
			serializer.setOutput(writer);
			this.serializerBody(serializer);
			//output will be flushed
			serializer.flush();
			return writer.toString();
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getBodyInsideDESInfo(){
		
		//加密数据
		String wholeBody = getWholeBody();
		String orgDesInfo = StringUtils.substringBetween(wholeBody,  "<body>", "</body>");
		
		// 加密
		// 加密调试——2天
		// ①加密算法实现不同
		// ②加密的原始数据不同

		DES des = new DES();
		return des.authcode(orgDesInfo, "DECODE", ConstantValue.DES_PASSWORD);
	}
	

}
