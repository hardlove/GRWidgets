package com.globalroam.widgets;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import com.globalroam.utils.GRImageUtils;

public class GRImageViewPlus extends ImageView {
	
	private static final String TAG = "GRImageViewPlus";
	private static final int TYPE_OF_RECTANGLE = 1;
	private static final int TYPE_OF_CIRCLE = 2;
	private int curentType;
	private int outLineWidth;
	private int outLineColor;
	

	public GRImageViewPlus(Context context) {
		super(context);
		
	}

	public GRImageViewPlus(Context context, AttributeSet attrs) {
		super(context, attrs);

			
		setImageType(context, attrs);
		
	}

	
	
	@Override
	public void setImageResource(int resId) {
		super.setImageResource(resId);
		refeshDrawable();
		
		
	}
	
	@Override
	public void setImageBitmap(Bitmap bm) {
		super.setImageBitmap(bm);
		refeshDrawable();
		
	}
	
	@Override
	public void setImageDrawable(Drawable drawable) {
		
		if(curentType == TYPE_OF_CIRCLE){
			drawable = GRImageUtils.getCircleDrawableWithOutLine(drawable,outLineWidth,outLineColor);
		}
		
		
		super.setImageDrawable(drawable);

	}
	
	@Override
	public void setImageURI(Uri uri) {
		super.setImageURI(uri);
		refeshDrawable();
	}
	
	
	
	
	
	private void refeshDrawable(){
		if(curentType == TYPE_OF_CIRCLE){
			setImageDrawable(getDrawable());
		}
		
	}

	private void setImageType(Context context, AttributeSet attrs) {
		
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.GRImagePlus);
		
		curentType =  a.getInt(R.styleable.GRImagePlus_imageType, TYPE_OF_RECTANGLE);//default rectangle type
		if(curentType == TYPE_OF_CIRCLE){
			
			outLineWidth = a.getDimensionPixelSize(R.styleable.GRImagePlus_outLineWidth, 2);
			outLineColor = a.getColor(R.styleable.GRImagePlus_outLineColor, Color.WHITE);
			
			setImageDrawable(getDrawable());
		}
		
		a.recycle();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		Log.i(TAG, "curentType: " + curentType);

	}
	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.draw(canvas);
	}
	

}
