package com.globalroam.widgets;


import com.globalroam.utils.DialogUtils;
import com.globalroam.utils.DialogUtils.OkListener;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DialogUtils.showOKDialog(this, null,"我是内容");
       
        
//        ImageView iv = (ImageView) findViewById(R.id.circle_image);
//        iv.setImageResource(R.drawable.im_2);
        
        GRLetterListView letterListView = (GRLetterListView) findViewById(R.id.letterListView);
        letterListView.setOnTouchingLetterChangedListener(new GRLetterListView.OnTouchingLetterChangedListener() {
			
			@Override
			public void onTouchingLetterChanged(String s) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, s.toString(), 0).show();
			}
		});
    }

    public void OKCancelDialog(View v) {
		DialogUtils.showOKCancelDialog(this, "title", "content...", new OkListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "点击了ok", 0).show();
				
			}
		}, null);
	}
   
}
