package com.globalroam.ui;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.globalroam.adapter.Bean;
import com.globalroam.adapter.GRBaseAdapter;
import com.globalroam.adapter.ViewHolder;
import com.globalroam.widgets.R;

public class MyAdapter extends GRBaseAdapter<Bean> {


	public MyAdapter(List<Bean> mDatas, Context context, int itemLayoutId) {
		super(mDatas, context, itemLayoutId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = ViewHolder.get(context, convertView, parent, R.layout.list_item_sigle, position);
		return holder.getConvertView();
	}

	@Override
	protected void convert(ViewHolder holder, Bean t) {
		// TODO Auto-generated method stub
		holder.setText(R.id.list_item_sigle_tv, t.getName());
	}

}
