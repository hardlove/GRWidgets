package com.globalroam.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.globalroam.widgets.CircleDrawable;

public class GRImageUtils {

	private static final String TAG = "GRImageUtils";

	/**
	 * 
	 * @param src
	 * @return Ô²ÐÎÍ¼Æ¬,ÎÞÍâ±ß¿ò
	 */
	public static CircleDrawable getCircleDrawable(Drawable src) {

		return getCircleDrawableWithOutLine(src, 0, 0x00000000);

	}

	/**
	 * 
	 * @param src
	 * @return Ô²ÐÎÍ¼Æ¬,´øÍâ±ß¿ò
	 */
	public static CircleDrawable getCircleDrawableWithOutLine(Drawable src,
			int outLineWidth, int outLineColor) {
		CircleDrawable dst = null;

		if (src != null) {
			Bitmap bitmap = drawableToBitmap(src);
			dst = new CircleDrawable(bitmap, outLineWidth, outLineColor);
		} else {
			Log.i(TAG, "getCircleDrawable()--> src is null.");
		}
		return dst;
	}

	/**
	 * Drawable convert to Bitmap
	 */
	public static Bitmap drawableToBitmap(Drawable drawable) {
		if (drawable == null) {

			throw new NullPointerException(
					"drawableToBitmap()-->drawable is null.");
		}

		int width = drawable.getIntrinsicWidth();
		int height = drawable.getIntrinsicHeight();
		Bitmap bitmap = Bitmap.createBitmap(width, height, drawable
				.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
				: Bitmap.Config.RGB_565);
		Canvas canvas = new Canvas(bitmap);
		drawable.setBounds(0, 0, width, height);
		drawable.draw(canvas);
		return bitmap;

	}

}
