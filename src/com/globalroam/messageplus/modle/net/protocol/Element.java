package com.globalroam.messageplus.modle.net.protocol;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlSerializer;


/**
 * 请求数据的封装
 * @author Administrator
 *
 */
public abstract class Element {
	/**
	 * 存放所有用到的叶子的容器
	 */
	private List<Leaf> list = new ArrayList<Leaf>();
	private String tagName = "element";
	public Element(){
		
	}
	/**
	 * 不会将所有的请求用到的叶子放到Element
	 * Element将作为所有请求的代表，Element所有请求的公共部分
	 * 公共部分：
	 * ①每个请求都需要序列化自己
	 * ②每个请求都有自己的标识
	 */
	
	/**
	 * 每个请求都需要序列化自己
	 * @param serializer
	 */
	public void serializableElement(XmlSerializer serializer){
		list.clear();
		initLeafList(list);//将子类需要序列化的叶子放在容器中
		
		if(serializer == null){
			throw new IllegalArgumentException("serializer can be null.");
		}
		try {
			serializer.startTag(null, tagName);
			for (Leaf leaf : list) {
				if(leaf != null){
					leaf.serialize(serializer);
				}
			}
			serializer.endTag(null, tagName);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
	
	public abstract  String getTransactionType();
	
	
	/**
	 * 将需要用到的叶子全部装到容器中
	 * @param list Element中需要序列化的叶子
	 * @return
	 */
	public abstract List<Leaf> initLeafList(List<Leaf> list);
	
	// 包含内容
	// 序列化
	// 特有：请求标示

	// <lotteryid>118</lotteryid>
	// private Leaf lotteryid = new Leaf("lotteryid");
	// <issues>1</issues>
	// private Leaf issues = new Leaf("issues", "1");

	// public Leaf getLotteryid() {
	// return lotteryid;
	// }

	// /**
	// * 序列化请求
	// */
	// public void serializerElement(XmlSerializer serializer) {
	// try {
	// serializer.startTag(null, "element");
	// lotteryid.serializerLeaf(serializer);
	// issues.serializerLeaf(serializer);
	// serializer.endTag(null, "element");
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	// /**
	// * 获取请求的标示
	// */
	// public String getTransactionType() {
	// return "12002";
	// }
	
	
}
