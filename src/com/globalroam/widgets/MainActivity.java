package com.globalroam.widgets;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
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

   
}
