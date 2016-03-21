package com.globalroam.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewHolder {

	private SparseArray<View> mViews;
	private View mConvertView;

	public View getmConvertView() {
		return mConvertView;
	}

	private int mPosition;

	public int getmPosition() {
		return mPosition;
	}

	private ViewHolder(Context context, ViewGroup parent, int layoutId,
			int position) {
		mViews = new SparseArray<View>();
		
		mConvertView = LayoutInflater.from(context).inflate(layoutId, null);
		this.mPosition = position;

		mConvertView.setTag(this);
	}

	public static ViewHolder get(Context context, View convertView,
			ViewGroup parent, int layoutId, int position) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder(context, parent, layoutId, position);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		return holder;
	}

	/**
	 * 通过viewId获取控件
	 * 
	 * @param viewId
	 * @return
	 */
	public <T extends View> T getView(int viewId) {
		View view = mViews.get(viewId);
		if (view == null) {
			view = mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		} 

		return (T) view;

	}
}
