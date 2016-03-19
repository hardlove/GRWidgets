package com.globalroam.utils.network;

import java.util.Map;

import android.content.Context;

public class HttpUtils {

	/**
	 * 检查当前网络是否已连接
	 * @param context
	 * @return
	 */
	public static boolean isNetWorkConnected(Context context) {
		return NetWorkUtils.isNetWorkConnected(context);
		
	}
	
	/**
	 * 检查当前连接的网络类型
	 * @param context
	 * @return  0：Mobile网路；1：Wifi网络；2：其它类型的网络；-1：没有连接到网络
	 */
	public static int getCurrentNetWorkType(Context context) {

		return NetWorkUtils.getCurrentNetWorkType(context);
	}
	
	
	
	public static String createParamsUrl(String baseUrl,Map<String, String> params){
		
		return null;
	}

	// 测试回滚
}
