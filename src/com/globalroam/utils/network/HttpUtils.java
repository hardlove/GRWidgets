package com.globalroam.utils.network;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import android.content.Context;

public class HttpUtils {

	/**
	 * 检查当前网络是否已连接
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isNetWorkConnected(Context context) {
		return NetWorkUtils.isNetWorkConnected(context);

	}

	/**
	 * 检查当前连接的网络类型
	 * 
	 * @param context
	 * @return 0：Mobile网路；1：Wifi网络；2：其它类型的网络；-1：没有连接到网络
	 */
	public static int getCurrentNetWorkType(Context context) {

		return NetWorkUtils.getCurrentNetWorkType(context);
	}

	/**
	 * 生成网络请求的URL
	 * 
	 * @param baseUrl
	 *            基本的URL路径
	 * @param params
	 *            携带的参数
	 * @return
	 */
	public static String createParamsUrl(String baseUrl,
			Map<String, String> params) {
		if (params != null && !params.isEmpty()) {
			Set<Entry<String, String>> set = params.entrySet();
			String key = null;
			String value = null;
			StringBuffer temp = new StringBuffer();
			int i = 0;
			for (Entry<String, String> entry : set) {
				key = entry.getKey();
				value = entry.getValue();
				if (i == 0) {
					temp.append("?").append(key).append("=").append(value);
				} else {
					temp.append(key).append("=").append(value);
				}
				i++;
			}
			return baseUrl + temp.toString();

		}

		return baseUrl;
	}

	// 测试回滚
}
