package com.globalroam.messageplus.ui;

import java.util.Map;

import com.globalroam.messageplus.R;
import com.globalroam.messageplus.ui.base.BaseActivity;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMusic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MyShareActivity extends BaseActivity {
	
	

	

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		platforms = new SHARE_MEDIA[]{SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.QZONE,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.WEIXIN_CIRCLE};
		
	}
	private void deleteAuth(SHARE_MEDIA[] platform){
		mShareAPI = UMShareAPI.get(this);
		for (int i = 0; i < platform.length; i++) {
			mShareAPI.deleteOauth(this, platform[i], umDeleteAuthListener);
		}
	}

	private void doAuth(SHARE_MEDIA[] platform) {
		mShareAPI = UMShareAPI.get(this);
		for (int i = 0; i < platform.length; i++) {
			mShareAPI.doOauthVerify(this, platform[i], umAuthListener);
		}
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	protected void initView(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.share_layout);

	}
	public void deleteAuth(View v){
		deleteAuth(platforms);
	}
	public void doAuth(View v){
		doAuth(platforms);
	}
	
	public void openSharePlan(View v){
		
		
		UMImage image = new UMImage(this, "http://www.umeng.com/images/pic/social/integrated_3.png");
		UMusic music = new UMusic("http://music.huoxing.com/upload/20130330/1364651263157_1085.mp3");
		music.setTitle("This is music title");
		music.setThumb(new UMImage(this, "http://www.umeng.com/images/pic/social/chart_1.png"));
		UMVideo video = new UMVideo("http://video.sina.com.cn/p/sports/cba/v/2013-10-22/144463050817.html");
		String url = "http://www.umeng.com";
		
		 new ShareAction(this).setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.QZONE,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.WEIXIN_CIRCLE)
         .withText("来自友盟分享面板")
         .withMedia(image)
         .withMedia(music)
         .withMedia(video)
         .withTargetUrl(url)
         .setCallback(umShareListener)
         .open();
	}
	private UMShareAPI mShareAPI;
	
	private UMAuthListener umDeleteAuthListener = new UMAuthListener() {
		
		@Override
		public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
			// TODO Auto-generated method stub
			Toast.makeText(MyShareActivity.this, share_media + " 解除授权失败啦", Toast.LENGTH_SHORT).show();
		}
		
		@Override
		public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
			// TODO Auto-generated method stub
			Toast.makeText(MyShareActivity.this, share_media + " 解除授权失败啦", Toast.LENGTH_SHORT).show();
		}
		
		@Override
		public void onCancel(SHARE_MEDIA share_media, int i) {
			// TODO Auto-generated method stub
			Toast.makeText(MyShareActivity.this, share_media + " 解除授权失败啦", Toast.LENGTH_SHORT).show();
		}
	};
	private UMAuthListener umAuthListener = new UMAuthListener() {
		
		@Override
		public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
			
			Toast.makeText(MyShareActivity.this, share_media + " 授权失败啦", Toast.LENGTH_SHORT).show();
		}
		
		@Override
		public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
			Toast.makeText(MyShareActivity.this, share_media + " 授权成功啦", Toast.LENGTH_SHORT).show();
			
		}
		
		@Override
		public void onCancel(SHARE_MEDIA share_media, int i) {
			Toast.makeText(MyShareActivity.this, share_media + " 授权取消啦", Toast.LENGTH_SHORT).show();
			
		}
	};
	
	
	
	private UMShareListener umShareListener = new UMShareListener() {
		
		@Override
		public void onResult(SHARE_MEDIA share_media) {
			Toast.makeText(MyShareActivity.this, share_media + " 分享成功啦", Toast.LENGTH_SHORT).show();
			
		}
		
		@Override
		public void onError(SHARE_MEDIA share_media, Throwable throwable) {
			Toast.makeText(MyShareActivity.this, share_media + " 分享失败啦", Toast.LENGTH_SHORT).show();
			
		}
		
		@Override
		public void onCancel(SHARE_MEDIA share_media) {
			Toast.makeText(MyShareActivity.this, share_media + " 分享取消啦", Toast.LENGTH_SHORT).show();
			
		}
	};

	private SHARE_MEDIA[] platforms;

	@Override
	protected void loadDatas() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void registerReceiver() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void unRegisterReceiver() {
		// TODO Auto-generated method stub

	}

}
