package com.globalroam.utils.network;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;

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
	 * @return 0：Mobile网路；1：Wifi网络；-1：没有连接到网络
	 */
	public static int getCurrentNetWorkType(Context context) {

		return NetWorkUtils.getCurrentNetWorkType(context);
	}

	/**
	 * 生成网络请求的URL(用于Get请求，直接将参数拼接在URL后面)
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
					temp.append("&").append(key).append("=").append(value);
				}
				i++;
			}
			return baseUrl + temp.toString();

		}

		return baseUrl;
	}

	private static AsyncHttpClient client = new AsyncHttpClient();
	public static final int TIME_OUT = 1000 * 3;
	static{
		client.setTimeout(TIME_OUT);//设置响应超时
	}
	public static AsyncHttpClient getHttpClient() {
		synchronized (HttpUtils.class) {
			return client;
		}
	}
	
	/*
	 * Get请求（HTTP）
	 * @param url
	 * @param params
	 * @param responseHandler
	 * @return
	 */
	public static RequestHandle get(String url, Map<String, String> params, ResponseHandlerInterface responseHandler) {
		
		return client.get(url, new RequestParams(params) , responseHandler);
	}

	/**
	 * Post请求（HTTP）
	 * @param url
	 * @param params
	 * @param responseHandler
	 * @return
	 */
	public static RequestHandle post(String url,
			Map<String, String> params, ResponseHandlerInterface responseHandler) {
		
		return client.post(url, new RequestParams(params), responseHandler);
	}
	
	/**
	 * 上传文件
	 * @throws FileNotFoundException 
	 */
	public static void uploadFile(String url, File file,FileAsyncHttpResponseHandler responseHandler) throws FileNotFoundException{
		if (file.exists() && file.length() > 0) {
			
			client.post(url, responseHandler);
		}
	}
	/**
	 * 下载文件
	 */
	public void downloadFile(){
		
	}
	
}
