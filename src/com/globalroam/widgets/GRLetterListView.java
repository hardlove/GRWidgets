package com.globalroam.widgets;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.globalroam.utils.GRFontsLoader;

import android.R.integer;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;


public class GRLetterListView extends View {
	
	OnTouchingLetterChangedListener onTouchingLetterChangedListener;
	String[] letters = {"#","A","B","C","D","E","F","G","H","I","J","K","L"
			,"M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	int choose = 0;
	Paint paint = new Paint();
	Paint p = new Paint();
	boolean showBkg = false;
	public static final String TAG="LetterListView";
	
	private float mChildWidth;
	
	private Map<String,Integer> canShowList=new HashMap<String,Integer>();
	private float paddinTop = 0;
	private Context mContext;
	
	public GRLetterListView(Context context) {
		this(context, null);
	}

	public GRLetterListView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
		
	}
	
	public GRLetterListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
			this.mContext = context;
			init(context,attrs);
	}

	public void setLetters(String[] letters) {
		this.letters = letters;
	}
	
	
	
	private float singleHeight;
	private void init(Context context,AttributeSet attrs) {
		
		
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.GRLetterListView);
		
		bgColor = a.getColor(R.styleable.GRLetterListView_cellBackgroundColor, 0xff77c500);
		
		
		radius = a.getDimensionPixelSize(R.styleable.GRLetterListView_cellRadius, 3);
		a.recycle();
		
		
		paint.setColor(bgColor);
		paint.setAntiAlias(true);
		paint.setTypeface(GRFontsLoader.getTypefaceByIndex(mContext, GRFontsLoader.FONT_TYPE_DINPRO_MEDIUM));
       
		p.setColor(bgColor);
		p.setAntiAlias(true);
		
		
		
		
		getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {

			@Override
					public void onGlobalLayout() {
						if (letters == null) {
							Log.i(TAG, "maybe need insave instace...="
									+ getWidth());
							return;
						}
						int width = getWidth();

						singleHeight = getHeight() / letters.length;
						mChildWidth = singleHeight;
						
						textSize = (float)(mChildWidth*0.75);
					    paint.setTextSize(textSize);

						float offset = dip2px(mContext, 3);

						float textSize = (float) (singleHeight * 0.75);
						if (textSize > (width - 2 * offset)) {
							LayoutParams params = getLayoutParams();
							params.width = (int) (textSize + 0.5f + 2 * offset);
							setLayoutParams(params);
						}
						getViewTreeObserver().removeOnGlobalLayoutListener(this);
					}
		});
	}


	
	public String[] getLetters() {
		
      return letters;
     
	}
	@Override
	protected void onAttachedToWindow() {
		// TODO Auto-generated method stub
		super.onAttachedToWindow();
	
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		canvas.drawColor(Color.TRANSPARENT);

	    for(int i=0;i<letters.length;i++){
	       
			if (i == choose) {


				float left = (getWidth() - mChildWidth) / 2;
				float top = paddinTop + singleHeight * i;
				float right = left + mChildWidth;
				float bottom = top + singleHeight;
				RectF rectF = new RectF(left, top, right, bottom);
				canvas.drawRoundRect(rectF, radius, radius, this.p);
				paint.setColor(-1);

				paint.setFakeBoldText(true);
			}else {
				paint.setColor(bgColor);

				paint.setFakeBoldText(false);
			}
		       
	       float xPos = getWidth()/2  - paint.measureText(letters[i])/2;
	       FontMetrics fm = paint.getFontMetrics(); 
	       float textHeight = Math.abs(fm.descent + fm.ascent); 
	     
	       float yPos = singleHeight * i + singleHeight -(singleHeight-textHeight)/2-1;
	       
	       canvas.drawText(letters[i], xPos, yPos, paint);
	    
//	       paint.reset();
	    }
	   
	}
	

	  public void refresh(int position)
	  {
	    this.choose = position;
	    
	    invalidate();
	    
	  }
	  public void refreshKeyList(Map<String, Integer> alphaIndexer)
	  
	  {
		  this.canShowList=alphaIndexer; 
		  
		  
	  }
	  



	private boolean isIndexCanShow(int index){
    	
    	boolean result=false;
    	
    	if(canShowList.size()==letters.length){
    		
    		return true;
    		
    	}
    	
    	Iterator<String> iter = canShowList.keySet().iterator(); 
    	
    	while (iter.hasNext()) { 
    		
    	String key = iter.next(); 
    	
    	   if(key.equalsIgnoreCase(letters[index])){
			
			 result=true;
			 
		   }
    	}
    

    	
		return result;
    }
  
	private boolean isBottom;
	private int radius;
	private float textSize;
	private int bgColor;
	
	public void setBottom(boolean isBottom) {
	this.isBottom = isBottom;
}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		final int action = event.getAction();
	    final float y = event.getY();
	    final int oldChoose = choose;
	    final OnTouchingLetterChangedListener listener = onTouchingLetterChangedListener;
	    final int c = (int) (y/getHeight()*letters.length);
	    Log.i(TAG, "c == "+c);
		switch (action) {
		
			case MotionEvent.ACTION_DOWN:
				
				showBkg = true;

						
				if(oldChoose != c && listener != null){
					
					if(c >-1 && c< letters.length/*&&isIndexCanShow(c)*/){
				
						listener.onTouchingLetterChanged(letters[c]);

						choose = c;
						
						invalidate();
					}
				}
				
				break;
			case MotionEvent.ACTION_MOVE:
				
				if(oldChoose != c && listener != null){
					
					if(c > -1&& c< letters.length/*&&isIndexCanShow(c)*/){
	
					    listener.onTouchingLetterChanged(letters[c]);	
					
						choose = c;
						
						invalidate();
					}
				}
				break;
			case MotionEvent.ACTION_UP:
			
				break;
		}
		return true;
	}

	public void setOnTouchingLetterChangedListener(
			OnTouchingLetterChangedListener onTouchingLetterChangedListener) {
		    this.onTouchingLetterChangedListener = onTouchingLetterChangedListener;
	}

	public interface OnTouchingLetterChangedListener{
		public void onTouchingLetterChanged(String s);
	}
	
	public int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}
	
}
