package com.globalroam.messageplus.adapter.base;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class GRBaseAdapter<T> extends BaseAdapter {
	/**
	 * 存放数据源的容器
	 */
	private List<T> mDatas;

	public List<T> getmDatas() {
		return this.mDatas;
	}

	/**
	 * 给Adapter设置数据
	 * 
	 * @param mDatas
	 */
	public void setmDatas(List<T> mDatas) {
		if (mDatas == null) {
			throw new IllegalArgumentException(
					"The mDatas which you set is null,Please check!");
		}
		this.mDatas.clear();
		this.mDatas.addAll(mDatas);
		notifyDataSetChanged();
	}

	/**
	 * 移除数据源中指定的数据
	 * 
	 * @param mDatas
	 * @return true:移除成功，否则失败
	 */
	public boolean removeDatas(List<T> mDatas) {
		if (this.mDatas.contains(mDatas)) {
			this.mDatas.removeAll(mDatas);
			notifyDataSetChanged();
			return true;
		}
		return false;

	}

	/**
	 * 向数据源中添加数据
	 * 
	 * @param mDatas
	 * @return true:添加成功，否则失败
	 */
	public boolean addDatas(List<T> mDatas) {
		if (mDatas == null) {
			throw new IllegalArgumentException(
					"The mDatas which you add is null,Please check!");
		}
		if (!this.mDatas.contains(mDatas)) {
			this.mDatas.addAll(mDatas);
			notifyDataSetChanged();
			return true;
		}
		return false;
	}

	protected Context context;
	protected int itemLayoutId;

	public GRBaseAdapter(List<T> mDatas, Context context, int itemLayoutId) {
		super();
		this.mDatas = mDatas;
		this.context = context;
		this.itemLayoutId = itemLayoutId;
	}

	@Override
	public int getCount() {
		return mDatas == null ? 0 : mDatas.size();
	}

	@Override
	public Object getItem(int position) {
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		T bean = mDatas.get(position);

		ViewHolder holder = ViewHolder.get(context, convertView, parent,
				itemLayoutId, position);

		convert(holder, bean);

		return holder.getConvertView();
	}

	protected abstract void convert(ViewHolder holder, T bean);

}
