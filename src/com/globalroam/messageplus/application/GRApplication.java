package com.globalroam.messageplus.application;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;

public class GRApplication extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		SocialShareInit();
		

	}

	private void SocialShareInit() {
		SocialSDKInit();
		
	}

	


	/**
	 * 友盟分析，初始化配置
	 */
	private void SocialSDKInit() {
		PlatformConfig.setWeixin("wx6280135d1d9d733c", "7f32e9dd2d9b3785c55c878e1a8b7d3b");
		// 微信 appid appsecret
		PlatformConfig.setSinaWeibo("624321006", "98f6becfda60b5c688f74b21b6b51405");//已修改
		// 新浪微博 appkey appsecret
		PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
		// QQ和Qzone appid appkey
		PlatformConfig.setAlipay("2015111700822536");
		// 支付宝 appid
		PlatformConfig.setYixin("yxc0614e80c9304c11b0391514d09f13bf");
		// 易信 appkey
		PlatformConfig.setTwitter("3aIN7fuF685MuZ7jtXkQxalyi", "MK6FEYG63eWcpDFgRYw4w9puJhzDl0tyuqWjZ3M7XJuuG7mMbO");
		// Twitter appid appkey
		PlatformConfig.setPinterest("1439206");
		// Pinterest appid
		PlatformConfig.setLaiwang("laiwangd497e70d4", "d497e70d4c3e4efeab1381476bac4c5e");
		// 来往 appid appkey

	}

	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
	}

	@Override
	public void onTrimMemory(int level) {
		// TODO Auto-generated method stub
		super.onTrimMemory(level);
	}

	@Override
	public void registerComponentCallbacks(ComponentCallbacks callback) {
		// TODO Auto-generated method stub
		super.registerComponentCallbacks(callback);
	}

	@Override
	public void unregisterComponentCallbacks(ComponentCallbacks callback) {
		// TODO Auto-generated method stub
		super.unregisterComponentCallbacks(callback);
	}

	@Override
	public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
		// TODO Auto-generated method stub
		super.registerActivityLifecycleCallbacks(callback);
	}

	@Override
	public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
		// TODO Auto-generated method stub
		super.unregisterActivityLifecycleCallbacks(callback);
	}

}
