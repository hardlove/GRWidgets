package com.globalroam.messageplus.modle.net.protocol.elementImpl;

import java.util.List;

import com.globalroam.messageplus.modle.net.protocol.Element;
import com.globalroam.messageplus.modle.net.protocol.Leaf;

/**
 * 用户登录请求
 * @author Administrator
 *
 */
public class UserLoginElement extends Element{
	


	private Leaf actpassword = new Leaf("actpassword","1943");
	private Leaf userName = new Leaf("userName","chenlu");

	@Override
	public String getTransactionType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Leaf> initLeafList(List<Leaf> list) {
		// TODO Auto-generated method stub
		list.add(actpassword);
		list.add(userName);
		return list;
	}
	

}
