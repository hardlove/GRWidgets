package com.globalroam.ui;

import java.util.ArrayList;
import java.util.List;

import com.globalroam.adapter.base.Bean;
import com.globalroam.ui.base.BaseActivity;
import com.globalroam.ui.base.BaseFragment;
import com.globalroam.utils.DialogUtils;
import com.globalroam.utils.DialogUtils.OkListener;
import com.globalroam.utils.network.NetWorkUtils;
import com.globalroam.widgets.R;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

	private MyAdapter adapter;
	private List<Bean> mDatas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		BaseFragment fragment = new BaseFragment();

		testNetWork();

	}

	private void testNetWork() {
		boolean isConnected = NetWorkUtils.isNetWorkConnected(this);
		Log.i(TAG, "当前网络连接状态：" + (isConnected ? "连接" : "未连接"));
		int type = NetWorkUtils.getCurrentNetWorkType(this);
		Log.i(TAG, "当前的网路类型：" + NetWorkUtils.convertNetWorkType(type));
	}

	public void OKDialog(View v) {
		DialogUtils.showOKDialog(this, "title", "content...", null);
	}

	public void OKCancelDialog(View v) {
		DialogUtils.showOKCancelDialog(this, "title", "content...",
				new OkListener() {

					@Override
					public void onClick(View v) {
						Toast.makeText(getApplicationContext(), "�����ok", 0)
								.show();

					}
				}, null);
	}

	public void ItemsDialog(View v) {
		DialogUtils.showItemsDialog(this, "title..", new String[] { "items1",
				"items2", "items3", "items4" }, v,
				new android.widget.AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(), "" + id, 0)
								.show();
					}
				}

		);
	}

	public void addListView(View v) {
		ListView lv = (ListView) findViewById(R.id.listView);
		if (adapter == null) {
			if (mDatas == null) {
				mDatas = new ArrayList<Bean>();
			}
			adapter = new MyAdapter(mDatas, this, R.layout.list_item_sigle);
		}
		lv.setAdapter(adapter);
		ArrayList<Bean> temp = new ArrayList<Bean>();
		temp.add(new Bean("我是数据源"));
		adapter.addDatas(temp);
	}

	@Override
	protected void initView(Bundle savedInstanceState) {
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

	@Override
	protected void registerReceiver() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void unRegisterReceiver() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void loadDatas() {
		// TODO Auto-generated method stub

	}

}
