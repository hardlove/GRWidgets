package com.globalroam.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 * 用于网络连接状态的管理类
 * @author Administrator CL
 *
 */
public class NetWorkUtils {
	
	/**
	 * Mobile网络
	 */
	private static final int NETWORK_TYPE_MOBILE = 0;
	/**
	 * Wifi网络
	 */
	private static final int NETWORK_TYPE_WIFI = 1;
	/**
	 * 没有网络
	 */
	private static final int NETWORK_TYPE_NULL = -1;

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
		
		int netWorkType = NETWORK_TYPE_NULL ;
		if (networkInfo != null && networkInfo.isConnected()) {
			int type = networkInfo.getType();
			switch (type) {
			case ConnectivityManager.TYPE_MOBILE:
				netWorkType = NETWORK_TYPE_MOBILE;
				break;

			case ConnectivityManager.TYPE_WIFI:
				netWorkType = NETWORK_TYPE_WIFI;
				break;

			default:
				break;
			}

		} else {
			netWorkType = NETWORK_TYPE_NULL;
		}
		return netWorkType;

	}
	
	/**
	 * 获取网络类型标记所代表的网络类型
	 * @param type
	 * @return
	 */
	public static String convertNetWorkType(int type){
		String detail = null;
		switch (type) {
		case NETWORK_TYPE_MOBILE:
			detail = "Moblie NetWork";
			break;
		case NETWORK_TYPE_WIFI:
			detail = "Wifi NetWork";
			break;
		default:
			detail = "Fuck,there is no available network!";
			break;
		}
		return detail;
		
	}
	
	/**
	 * 如果是移动网络，检测是否是3G及以上的网络（快速网络）
	 * @param context
	 * @return
	 */
	public static boolean isFastMobileNetwork(Context context) {
		TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		switch (telephonyManager.getNetworkType()) {
		case TelephonyManager.NETWORK_TYPE_1xRTT:
			return false; // ~ 50-100 kbps
		case TelephonyManager.NETWORK_TYPE_CDMA:
			return false; // ~ 14-64 kbps
		case TelephonyManager.NETWORK_TYPE_EDGE:
			return false; // ~ 50-100 kbps
		case TelephonyManager.NETWORK_TYPE_EVDO_0:
			return true; // ~ 400-1000 kbps
		case TelephonyManager.NETWORK_TYPE_EVDO_A:
			return true; // ~ 600-1400 kbps
		case TelephonyManager.NETWORK_TYPE_GPRS:
			return false; // ~ 100 kbps
		case TelephonyManager.NETWORK_TYPE_HSDPA:
			return true; // ~ 2-14 Mbps
		case TelephonyManager.NETWORK_TYPE_HSPA:
			return true; // ~ 700-1700 kbps
		case TelephonyManager.NETWORK_TYPE_HSUPA:
			return true; // ~ 1-23 Mbps
		case TelephonyManager.NETWORK_TYPE_UMTS:
			return true; // ~ 400-7000 kbps
		case TelephonyManager.NETWORK_TYPE_EHRPD:
			return true; // ~ 1-2 Mbps
		case TelephonyManager.NETWORK_TYPE_EVDO_B:
			return true; // ~ 5 Mbps
		case TelephonyManager.NETWORK_TYPE_HSPAP:
			return true; // ~ 10-20 Mbps
		case TelephonyManager.NETWORK_TYPE_IDEN:
			return false; // ~25 kbps
		case TelephonyManager.NETWORK_TYPE_LTE:
			return true; // ~ 10+ Mbps
		case TelephonyManager.NETWORK_TYPE_UNKNOWN:
			return false;
		default:
			return false;
		}
	}
	

}
