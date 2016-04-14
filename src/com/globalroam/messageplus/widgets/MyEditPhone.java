package com.binghe.crm.widgets;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

import com.binghe.crm.utils.ToastUtil;

/**
 * Created by Administrator on 2016/3/14.
 * 按电话号码格式输入电话号码
 */
public class MyEditPhone extends EditText {
    private Context context;
    public MyEditPhone(Context context) {
        super(context);
        this.context = context;
        this.addTextChangedListener(textWatcher);
    }

    public MyEditPhone(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.addTextChangedListener(textWatcher);
    }

    public MyEditPhone(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.addTextChangedListener(textWatcher);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            oldL = s.length();
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            position = start;
        }

        @Override
        public void afterTextChanged(Editable s) {
            if(s.length()>oldL) {
                for (int i = 0; i < s.length(); i++) {
                    if (!(Character.isDigit(s.charAt(i)) || " ".equals(String.valueOf(s.charAt(i))))) {
                        s.delete(i, i + 1);
                    }
                    if (i == 3 && (!(" ".equals(String.valueOf(s.charAt(3)))))) {
                        s.insert(3, " ");
                    }
                    if (i == 8 && (!(" ".equals(String.valueOf(s.charAt(8)))))) {
                        s.insert(8, " ");
                    }
                    if(i==0 || i==1 || i==2 || i==4 || i==5 || i==6 || i==7 || i==9 || i==10 || i==11 || i==12 || 1==13){
                        if(!Character.isDigit(s.charAt(i))){
                            s.delete(i, i + 1);
                        }
                    }
                }
            }else{
                if(position == 3 || position == 8){
                    if((position+1) <= s.length()) {
                        s.delete(position - 1, position + 1);
                    }
                }
            }
            oldL = s.length();
        }
    };
    private int oldL;
    private int position;
}
