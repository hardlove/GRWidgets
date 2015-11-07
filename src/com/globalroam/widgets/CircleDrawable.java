package com.globalroam.widgets;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

public class CircleDrawable extends Drawable{
	
	private Paint mPaint;  
	private Paint linePaint;
    private int mWidth;  
    private Bitmap mBitmap ;   
    private float lineWidth;
  
    public CircleDrawable(Bitmap bitmap ,float lineWidth, int lineColor)  
    {  
        mBitmap = bitmap ;   
        BitmapShader bitmapShader = new BitmapShader(bitmap, TileMode.CLAMP,  
                TileMode.CLAMP);  
        mPaint = new Paint();  
        mPaint.setAntiAlias(true);  
        mPaint.setShader(bitmapShader);  
        mWidth = Math.min(mBitmap.getWidth(), mBitmap.getHeight());  
        
        
		linePaint = new Paint();
		this.lineWidth = lineWidth;
		linePaint.setAntiAlias(true);
		linePaint.setStyle(Paint.Style.STROKE);
		linePaint.setStrokeWidth(this.lineWidth);
		linePaint.setColor(lineColor);
    }
    
    public CircleDrawable(Bitmap bitmap)  
    {  
       this(bitmap, 0, 0x00000000);
    }
  
 
    @Override  
    public void draw(Canvas canvas)  
    {  
    	
		float x = mWidth / 2;
		canvas.drawCircle(x, x, x, mPaint);

		canvas.drawCircle(x, x, x - lineWidth / 2, linePaint);
    }  
  
  

	@Override  
    public int getIntrinsicWidth()  
    {  
        return mWidth;  
    }  
  
    @Override  
    public int getIntrinsicHeight()  
    {  
        return mWidth;  
    }  
  
    @Override  
    public void setAlpha(int alpha)  
    {  
        mPaint.setAlpha(alpha);  
        linePaint.setAlpha(alpha);  
    }  
  
    @Override  
    public void setColorFilter(ColorFilter cf)  
    {  
        mPaint.setColorFilter(cf); 
        linePaint.setColorFilter(cf);
    }  
  
    @Override  
    public int getOpacity()  
    {  
        return PixelFormat.TRANSLUCENT;  
    }  

}
