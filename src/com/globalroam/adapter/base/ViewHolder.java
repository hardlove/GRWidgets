package com.globalroam.adapter.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {

	private SparseArray<View> mViews;
	private View mConvertView;

	public View getConvertView() {
		return mConvertView;
	}

	private int mPosition;

	public int getmPosition() {
		return mPosition;
	}

	private ViewHolder(Context context, ViewGroup parent, int layoutId,
			int position) {
		mViews = new SparseArray<View>();

		mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
				false);
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

	/**
	 * 给TextView设置文本
	 * 
	 * @param viewId
	 * @param text
	 * @return
	 */
	public ViewHolder setText(int viewId, CharSequence text) {
		View view = getView(viewId);
		if (view instanceof TextView) {
			((TextView) view).setText(text);
		}
		return this;

	}

	/**
	 * 给ImageView设置图片资源
	 * 
	 * @param viewId
	 * @param resId
	 * @return
	 */
	public ViewHolder setImageResource(int viewId, int resId) {
		View view = getView(viewId);
		if (view instanceof ImageView) {
			((ImageView) view).setImageResource(resId);
		}
		return this;
	}

	/**
	 * 给ImageView设置Bitmap
	 * @param viewId
	 * @param resId
	 * @return
	 */
	public ViewHolder setImageResource(int viewId, Bitmap bm) {
		View view = getView(viewId);
		if (view instanceof ImageView) {
			((ImageView) view).setImageBitmap(bm);
		}
		return this;
	}
	
	/**
	 * 给ImageView设置uri
	 * @param viewId
	 * @param resId
	 * @return
	 */
	public ViewHolder setImageResource(int viewId, Uri uri) {
		View view = getView(viewId);
		if (view instanceof ImageView) {
			((ImageView) view).setImageURI(uri);
		}
		return this;
	}
}
