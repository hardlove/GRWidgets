package com.globalroam.ui;

import java.util.List;

import com.globalroam.adapter.Bean;
import com.globalroam.adapter.GRBaseAdapter;
import com.globalroam.adapter.ViewHolder;
import com.globalroam.widgets.R;

import android.content.Context;

public class MyAdapter extends GRBaseAdapter<Bean> {


	
	public MyAdapter(List<Bean> mDatas, Context context, int itemLayoutId) {
		super(mDatas, context, itemLayoutId);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void convert(ViewHolder holder, Bean t) {
		// TODO Auto-generated method stub
		holder.setText(R.id.list_item_sigle_tv, t.getName());
	}

}
