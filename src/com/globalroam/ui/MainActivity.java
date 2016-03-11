package com.globalroam.ui;

import com.globalroam.utils.DialogUtils;
import com.globalroam.utils.DialogUtils.OkListener;
import com.globalroam.widgets.BaseActivity;
import com.globalroam.widgets.R;
import com.globalroam.widgets.R.layout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ImageView iv = (ImageView) findViewById(R.id.circle_image);
		// iv.setImageResource(R.drawable.im_2);

		// GRLetterListView letterListView = (GRLetterListView)
		// findViewById(R.id.letterListView);
		// letterListView.setOnTouchingLetterChangedListener(new
		// GRLetterListView.OnTouchingLetterChangedListener() {
		//
		// @Override
		// public void onTouchingLetterChanged(String s) {
		// // TODO Auto-generated method stub
		// Toast.makeText(MainActivity.this, s.toString(), 0).show();
		// }
		// });
	}

	public void OKDialog(View v) {
		DialogUtils.showOKDialog(this, "title", "content...", null);
	}

	public void OKCancelDialog(View v) {
		DialogUtils.showOKCancelDialog(this, "title", "content...", new OkListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "�����ok", 0).show();

			}
		}, null);
	}

	public void ItemsDialog(View v) {
		DialogUtils.showItemsDialog(this, "title..", new String[] { "items1", "items2", "items3", "items4" }, v,
				new android.widget.AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(), ""+id, 0).show();
					}
				}

		);
	}

}