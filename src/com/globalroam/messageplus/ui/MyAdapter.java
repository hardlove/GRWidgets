package com.globalroam.messageplus.ui;

import java.util.List;

import com.globalroam.messageplus.R;
import com.globalroam.messageplus.adapter.base.Bean;
import com.globalroam.messageplus.adapter.base.GRBaseAdapter;
import com.globalroam.messageplus.adapter.base.ViewHolder;

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
