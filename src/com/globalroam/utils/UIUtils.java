package com.globalroam.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.media.ExifInterface;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;


/**
 * The UtilsUI class is the UI tools for calculate Image or screen pixels or
 * other property
 * 
 * 
 * @author yongjun
 * 
 */
public class UIUtils {
	/* screen width init value is 0 */
	private static int sreenWidth = 0;
	/* screen height init value is 0 */
	private static int sreenHeight = 0;

	/**
	 * @param application
	 * @return get the screen width
	 */
	public static int getWidth(Application application) {
		if (sreenWidth <= 0) {
			readSreenInfo(application);
		}
		return sreenWidth;
	}

	
	public static int getApplicaionWidth(Context application) {
		WindowManager wm = (WindowManager) application
				.getSystemService(Context.WINDOW_SERVICE);

		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return Math.min(outMetrics.heightPixels,// 屏幕高度
		outMetrics.widthPixels);// 屏幕宽度
		
	}

	
	/**
	 * @param application
	 * @return get the screen height
	 */
	public static int getHeight(Application application) {
		if (sreenHeight <= 0) {
			readSreenInfo(application);
		}
		return sreenHeight;
	}

	/**
	 * @param context
	 *            ,get the device screen information,include the height & width
	 */
	public static void readSreenInfo(Application context) {
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);

		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		sreenHeight = outMetrics.heightPixels;// 屏幕高度
		sreenWidth = outMetrics.widthPixels;// 屏幕宽度
	}

	/**
	 * @param ctx
	 * @param title
	 *            define the dialog tile
	 * @param body
	 *            define the message content
	 */
	public static void showDialogAlert(Context ctx, String title, String body) {
		AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
		builder.setTitle(title);
		builder.setMessage(body);
		Dialog dialogDetails = builder.create();
		dialogDetails.setCanceledOnTouchOutside(true);
		dialogDetails.show();
	}

	/**
	 * @param context
	 * @param value
	 *            calculate the dip (density in point ) to pixels
	 * @return the actually pixels value
	 */
	public static int getPixByDPI(Context context, float value) {
		int mPix = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				value, context.getResources().getDisplayMetrics());
		return mPix;
	}

	/**
	 * @param srceenWidth
	 * @param singleHeight
	 * @return this method is used to get the keypad button margin
	 */
	public static int getFixMargin(int srceenWidth, int singleHeight) {

		int fixMargin = 0;

		if (srceenWidth > (singleHeight * 3) && singleHeight > 0) {

			fixMargin = (srceenWidth - (singleHeight * 3)) / 6;

		}
		return fixMargin;
	}

	/**
	 * resize the keypad layout for fit the screen
	 * 
	 * @param activity
	 * @param single_height
	 * @param screenWidth
	 * @param views
	 */
	public static void reSizeView(Activity activity, int single_height,
			int screenWidth, HashMap<Integer, View> views) {

		if (single_height == 0) {

			return;
		}

		Iterator<Integer> iterator = views.keySet().iterator();

		int margin = getFixMargin(screenWidth, single_height);

		while (iterator.hasNext()) {

			Integer key = (Integer) iterator.next();

			View view = views.get(key);

			int temp = key.intValue() % 3;

			// int pending=SceenPropertyUtil.dip2px(activity,
			// activity.getResources().getDimension(R.dimen.key_padding));

			LinearLayout.LayoutParams params = (LayoutParams) view
					.getLayoutParams();

			if (temp == 0) {

				params.leftMargin = margin;

				params.rightMargin = margin;

				view.setLayoutParams(params);

			} else if (temp == 1) {

				params.leftMargin = margin;

				params.rightMargin = margin;

				view.setLayoutParams(params);

			} else if (temp == 2) {

				params.rightMargin = margin;

				params.leftMargin = margin;

				view.setLayoutParams(params);

			}

		}
	}

	/**
	 * add touch down focus affect
	 * 
	 * @param bubbleView
	 * @param bitmap
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public static void ImageViewEffect(ImageView bubbleView, Bitmap bitmap) {
		if (true) {
			bubbleView.setImageBitmap(bitmap);
			return;
		}
		StateListDrawable states = new StateListDrawable() {
			@Override
			protected boolean onStateChange(int[] stateSet) {

				boolean isStatePressedInArray = false;
				for (int state : stateSet) {
					if (state == android.R.attr.state_selected) {
						isStatePressedInArray = true;
					}
				}

				if (isStatePressedInArray) {
					super.setColorFilter(0x99999999, Mode.MULTIPLY);
				} else {
					super.clearColorFilter();
				}

				return super.onStateChange(stateSet);
			}

			@Override
			public boolean isStateful() {
				return true;
			}
		};

		states.addState(new int[] {},
				new BitmapDrawable(bubbleView.getResources(), bitmap));
		bubbleView.setImageDrawable(states);
		// states.addState(new int[] {}, r.getDrawable(R.drawable.normal));

	}

	/**
	 * add touch down focus affect ,for viewgroup
	 * 
	 * @param bubbleView
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public static void buttonEffect(ViewGroup bubbleView) {
		if (true) {
			return;
		}
		StateListDrawable states = new StateListDrawable() {
			@Override
			protected boolean onStateChange(int[] stateSet) {

				boolean isStatePressedInArray = false;
				for (int state : stateSet) {
					if (state == android.R.attr.state_selected) {
						isStatePressedInArray = true;
					}

					if (state == android.R.attr.state_pressed) {
						isStatePressedInArray = true;
					}
				}

				if (isStatePressedInArray) {
					super.setColorFilter(0x99999999, Mode.MULTIPLY);
				} else {
					super.clearColorFilter();
				}

				return super.onStateChange(stateSet);
			}

			@Override
			public boolean isStateful() {
				return true;
			}
		};
		if (bubbleView.getBackground() != null) {
			states.addState(new int[] { android.R.attr.state_pressed },
					bubbleView.getBackground());
			states.addState(new int[] {}, bubbleView.getBackground());
			if (Build.VERSION.SDK_INT >= 16) {
				bubbleView.setBackground(states);
			} else {
				bubbleView.setBackgroundDrawable(states);
			}
		}
		// states.addState(new int[] {}, r.getDrawable(R.drawable.normal));

	}

	/**
	 * read the image property: the rotation
	 * 
	 * 
	 * @param path
	 *            image absolute path
	 * 
	 * @return the image rotate degree from the image property
	 */
	public static int readPictureDegree(String path) {
		int degree = 0;
		try {
			ExifInterface exifInterface = new ExifInterface(path);

			int orientation = exifInterface.getAttributeInt(
					ExifInterface.TAG_ORIENTATION,
					ExifInterface.ORIENTATION_NORMAL);
			switch (orientation) {
			case ExifInterface.ORIENTATION_ROTATE_90:
				degree = 90;
				break;
			case ExifInterface.ORIENTATION_ROTATE_180:
				degree = 180;
				break;
			case ExifInterface.ORIENTATION_ROTATE_270:
				degree = 270;
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return degree;
	}

	/**
	 * rotate the image
	 * 
	 * @param angle
	 * 
	 * @param bitmap
	 * 
	 * @return rotate Bitmap
	 */
	public static Bitmap rotaingImageView(int angle, Bitmap bitmap) {

		System.out.println("angle2=" + angle);
		if (angle == 0) {
			return bitmap;
		}
		// 旋转图片 动作
		Matrix matrix = new Matrix();
		;
		matrix.postRotate(angle);
		// 创建新的图片
		Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0,
				bitmap.getWidth(), bitmap.getHeight(), matrix, true);
		// mot change orginal bitmap..
		// if (bitmap!=null) {
		// bitmap.recycle();
		// bitmap=null;
		// }
		return resizedBitmap;
	}



	public static boolean isLandscape(Context context) {
		Configuration cf = context.getResources().getConfiguration(); // 获取设置的配置信�?
		int ori = cf.orientation; // 获取屏幕方向
		if (ori == Configuration.ORIENTATION_LANDSCAPE) {
			// 横屏
			return true;
		} else if (ori == Configuration.ORIENTATION_PORTRAIT) {
			// 竖屏
		}
		return false;
	}

	/**
	 * 判断当前设备是手机还是平板，代码来自 Google I/O App for Android
	 * 
	 * @param context
	 * @return 平板返回 True，手机返�? False
	 */
	public static boolean isTablet(Context context) {
		return (context.getResources().getConfiguration().screenLayout
				& Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
	}
	
	/** 
	 * 判断是否为平�? 
	 *  
	 * @return 
	 */  
	public static boolean isPad(Context context) {  
	    WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);  
	    Display display = wm.getDefaultDisplay();  
	    // 屏幕宽度  
	    float screenWidth = display.getWidth();  
	    // 屏幕高度  
	    float screenHeight = display.getHeight();  
	    DisplayMetrics dm = new DisplayMetrics();  
	    display.getMetrics(dm);  
	    double x = Math.pow(dm.widthPixels / dm.xdpi, 2);  
	    double y = Math.pow(dm.heightPixels / dm.ydpi, 2);  
	    // 屏幕尺寸  
	    double screenInches = Math.sqrt(x + y);  
	    // 大于6尺寸则为Pad  
	    if (screenInches >= 6.0) {  
	        return true;  
	    }  
	    return false;  
	}  
}
