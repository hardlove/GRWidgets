package com.globalroam.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

import com.globalroam.utils.GRFontsLoader;

public class GRTextViewPlus extends TextView {

	public GRTextViewPlus(Context context) {
		super(context);
	}
	

	public GRTextViewPlus(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		if (isInEditMode()) {

		} else {
			setCustomFont(context, attrs);
		}
	}



	private void setCustomFont(Context context, AttributeSet attrs) {

		TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.GRTextViewPlus);

		String fontName = a.getString(R.styleable.GRTextViewPlus_textFont);

		if (TextUtils.isEmpty(fontName)) {
			
			return;
		}
		
		Typeface tf = GRFontsLoader.getTypefaceByName(context, fontName);
		
		setTypeface(tf);
		
		a.recycle();
		
	}

}
