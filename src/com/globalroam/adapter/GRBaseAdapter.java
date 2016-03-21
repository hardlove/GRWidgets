package com.globalroam.adapter;

import java.util.List;

import com.globalroam.widgets.R;

import android.content.Context;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GRBaseAdapter extends BaseAdapter {
	/**
	 * 存放数据源的容器
	 */
	private List<Bean> mDatas;
	
	public List<Bean> getmDatas() {
		return this.mDatas;
	}
	/**
	 * 给Adapter设置数据
	 * @param mDatas
	 */
	public void setmDatas(List<Bean> mDatas) {
		if(mDatas==null){
			throw new IllegalArgumentException("The mDatas which you set is null,Please check!");
		}
		this.mDatas.clear();
		this.mDatas.addAll(mDatas);
		notifyDataSetChanged();
	}
	/**
	 * 移除数据源中指定的数据
	 * @param mDatas
	 * @return true:移除成功，否则失败
	 */
	public boolean removeDatas(List<Bean> mDatas) {
		if(this.mDatas.contains(mDatas)){
			this.mDatas.removeAll(mDatas);
			notifyDataSetChanged();
			return true;
		}
		return false;
		
	}
	/**
	 * 向数据源中添加数据
	 * @param mDatas
	 * @return true:添加成功，否则失败
	 */
	public boolean addDatas(List<Bean> mDatas){
		if(mDatas==null){
			throw new IllegalArgumentException("The mDatas which you add is null,Please check!");
		}
		if(!this.mDatas.contains(mDatas)){
			this.mDatas.addAll(mDatas);
			notifyDataSetChanged();
			return true;
		}
		return false;
	}

	private Context context;
	private int itemLayoutId;
	
	
	


	public GRBaseAdapter(List<Bean> mDatas, Context context, int itemLayoutId) {
		super();
		this.mDatas = mDatas;
		this.context = context;
		this.itemLayoutId = itemLayoutId;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mDatas == null ? 0 : mDatas.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Bean bean = mDatas.get(position);
		
		ViewHolder holder = ViewHolder.get(context, convertView, parent, itemLayoutId, position);
		View v = holder.getView(R.id.list_item_sigle_tv);
		if(v instanceof TextView){
			((TextView) v).setText(bean.getName());
		}
		
		return holder.getmConvertView();
	}

}
