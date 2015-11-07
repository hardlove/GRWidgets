package com.globalroam.utils;


import com.globalroam.widgets.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Log;

public class GRFontsLoader {

	private static final String TAG = "GRFontsLoader";
	private static final String[] fontsPath = {
											"fonts/dinpro_bold.ttf",
											"fonts/dinpro_light.ttf",
											"fonts/dinpro_medium.ttf",
											"fonts/dinpro_regular.ttf"
									    	};
	
	private static final Typeface[] fonts = new Typeface[fontsPath.length];
	
	
	// fonts index
	public static final int FONT_TYPE_DINPRO_BOLD = 0;
	public static final int FONT_TYPE_DINPRO_LIGHT = 1;
	public static final int FONT_TYPE_DINPRO_MEDIUM = 2;
	public static final int FONT_TYPE_DINPRO_REGULAR = 3;
	
	

	
	public static String getTypefaceName (int fontIndex) {
		
		String fontName = null;
		switch (fontIndex) {
		case FONT_TYPE_DINPRO_BOLD:
			fontName = "dinpro_bold";
			break;
		case FONT_TYPE_DINPRO_LIGHT:
			fontName = "dinpro_light";
			break;
		case FONT_TYPE_DINPRO_MEDIUM:
			fontName = "dinpro_medium";
			break;
		case FONT_TYPE_DINPRO_REGULAR:
			fontName = "dinpro_regular";
			break;

		default:
			fontName = "sorry,we are not fond the fons.";
			break;
		}
		
		return fontName;
		
	}


	public static Typeface getTypefaceByName(Context context, String typefaceName) {
		
		
		int fontIndex = getTypefaceIndexByName(context, typefaceName);
		
		return getTypefaceByIndex(context, fontIndex);
		
	}
	
	public static Typeface getTypefaceByIndex(Context context,int fontIndex) {
		if(fonts[fontIndex]==null){
			fonts[fontIndex] = Typeface.createFromAsset(context.getAssets(), fontsPath[fontIndex]);
		}
		
		return fonts[fontIndex];
	}

	
	private static int getTypefaceIndexByName(Context context, String typeFaceName) {
		int fontIndex = GRFontsLoader.FONT_TYPE_DINPRO_MEDIUM;// default

		if(TextUtils.isEmpty(typeFaceName)){
			throw new NullPointerException(typeFaceName+"is empty.");
		}
		
		
		Resources res = context.getResources();
		if (typeFaceName.equals(res.getString(R.string.dinpro_bold))) {
			
			fontIndex = GRFontsLoader.FONT_TYPE_DINPRO_BOLD;

		} else if (typeFaceName.equals(res.getString(R.string.dinpro_light))) {

			fontIndex = GRFontsLoader.FONT_TYPE_DINPRO_LIGHT;
		} else if (typeFaceName.equals(res.getString(R.string.dinpro_medium))) {

			fontIndex = GRFontsLoader.FONT_TYPE_DINPRO_MEDIUM;
		} else if (typeFaceName.equals(res.getString(R.string.dinpro_regular))) {

			fontIndex = GRFontsLoader.FONT_TYPE_DINPRO_REGULAR;
		}else {
			
			Log.w(TAG,"not fond the typeface,so we use the default type:"+getTypefaceName(fontIndex));
		}

		return fontIndex;

	}

}
