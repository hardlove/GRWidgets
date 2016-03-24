package com.globalroam.messageplus.modle.net.protocol.elementImpl;

import java.util.List;

import org.xmlpull.v1.XmlSerializer;

import com.globalroam.messageplus.modle.net.protocol.Element;
import com.globalroam.messageplus.modle.net.protocol.Leaf;

/**
 * 用户登录请求
 * @author Administrator
 *
 */
public class UserLoginElement extends Element{
	private Leaf actpassword = new Leaf("actpassword");
	@Override
	public void serializableElement(XmlSerializer serializer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTransactionType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Leaf> initLeafList(List<Leaf> list) {
		//将Element中用到的叶子对象全部添加到list容器中
		list.add(actpassword);
		return list;
	}

}
