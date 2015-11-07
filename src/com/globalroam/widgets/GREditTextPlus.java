package com.globalroam.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;

import com.globalroam.utils.GRFontsLoader;

public class GREditTextPlus extends EditText {

	public GREditTextPlus(Context context) {
		super(context);
		
	}

	public GREditTextPlus(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		if(isInEditMode()){
			
		}else {
			setCustomFont(context, attrs);
		}
	}

	

	private void setCustomFont(Context context, AttributeSet attrs) {
		
		
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.GREditTextPlus);
		String fontName = a.getString(R.styleable.GREditTextPlus_textFont);
		
		if (TextUtils.isEmpty(fontName)) {

			return;
		}

		setTypeface(GRFontsLoader.getTypefaceByName(context, fontName));
		
		a.recycle();
	}


}
