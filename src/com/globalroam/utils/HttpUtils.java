package com.globalroam.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class HttpUtils {

	/**
	 * 检查当前网络是否已连接
	 * @param context
	 * @return
	 */
	public static boolean isNetWorkConnected(Context context) {
		ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isConnected()) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * 检查当前连接的网络类型
	 * @param context
	 * @return  0：Mobile网路；1：Wifi网络；2：其它类型的网络；-1：没有连接到网络
	 */
	public static int getCurrentNetWorkType(Context context) {

		ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isConnected()) {
			int type = networkInfo.getType();
			switch (type) {
			case ConnectivityManager.TYPE_MOBILE:
				return 0;

			case ConnectivityManager.TYPE_WIFI:

				return 1;

			default:
				return 2;
			}

		} else {
			return -1;
		}

	}

}
