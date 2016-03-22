package com.globalroam.messageplus.widgets;

import com.globalroam.messageplus.R;
import com.globalroam.messageplus.utils.GRFontsLoader;
import com.globalroam.messageplus.utils.UIUtils;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class OptionTitleDialog extends Dialog {

	public static OptionTitleDialog Builder(Context context, String title, String items[], View v,
			final OnItemClickListener itemClickListener) {

		return Builder(context, title, items, v, itemClickListener, null);
	}

	public static OptionTitleDialog Builder(Context context, String title, String items[], View v,
			final OnItemClickListener itemClickListener, OnDismissListener dismissListener) {

		return new OptionTitleDialog(context, v, title, items, itemClickListener, dismissListener);
	}

	public static boolean show = false;

	private View v;

	private void setTextStyles(TextView textView) {
		textView.setTypeface(GRFontsLoader.getTypefaceByIndex(context, GRFontsLoader.FONT_TYPE_DINPRO_REGULAR));

	}

	public OptionTitleDialog(Context context, View v, String title, String items[],
			final OnItemClickListener itemClickListener, OnDismissListener dismissListener) {
		super(context, R.style.customDialog);
		this.context = context;
		this.v = v;
		View list = View.inflate(context, R.layout.option_title_dialog_list, null);
		ListView listView = (ListView) list.findViewById(R.id._list_view);

		TextView mTitle = (TextView) list.findViewById(R.id._title);
		setTextStyles(mTitle);
		mTitle.setText(title);
		TextView mCancelTextView = (TextView) list.findViewById(R.id._delete);
		mCancelTextView.setTypeface(GRFontsLoader.getTypefaceByIndex(context, GRFontsLoader.FONT_TYPE_DINPRO_MEDIUM));
		mCancelTextView.setOnClickListener(new chatCancelListener());
		// mCancelTextView.setBackgroundResource(R.drawable.dialog_delete_btn);
		if (dismissListener != null) {
			setOnDismissListener(dismissListener);
		}
		setCanceledOnTouchOutside(false);
		OptionAdapter optionAdapter = new OptionAdapter(context, items);
		listView.setAdapter(optionAdapter);
		listView.setFocusableInTouchMode(false);
		setContentView(list);

		listView.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN: {
					int x = (int) event.getX();
					int y = (int) event.getY();
					ListView view = (ListView) v;

					int itemnum = view.pointToPosition(x, y);

					if (itemnum == AdapterView.INVALID_POSITION) {
						break;
					} else {
						int count = view.getAdapter().getCount();
						if (count <= 1) {// only one
							view.setSelector(R.drawable.dialog_bottom_btn);
						} else if (count == 2) {// two
							if (itemnum == 0) {
								view.setSelector(R.drawable.dialog_middle_btn);
							} else {
								view.setSelector(R.drawable.dialog_bottom_btn);
							}

						} else {
							if (itemnum == 0) {// first
								view.setSelector(R.drawable.dialog_middle_btn);
							} else if (itemnum == count - 1) {// last
								view.setSelector(R.drawable.dialog_bottom_btn);
							} else {// center
								view.setSelector(R.drawable.dialog_middle_btn);
							}
						}

					}

				}
					break;

				default:
					break;
				}
				return false;
			}
		});

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				itemClickListener.onItemClick(parent, view, position, id);
				dismiss();
			}
		});

	}

	@Override
	public void dismiss() {
		// TODO Auto-generated method stub
		super.dismiss();
		if (v != null) {
			v.setSelected(false);
		}

		show = false;
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		if (v != null) {
			v.setSelected(false);
		}
		super.cancel();
		show = false;
	}

	@Override
	public void show() {
		int width = (int) (UIUtils.getApplicaionWidth(context.getApplicationContext()) * 0.91);
		getWindow().setLayout(width, LayoutParams.WRAP_CONTENT);
		if (v != null) {
			v.setSelected(true);
		}
		show = true;
		super.show();
	}

	private Context context;

	class OptionAdapter extends ArrayAdapter<String> {

		public OptionAdapter(Context context, String[] items) {
			super(context, 0, items);
		}

		@Override
		public int getViewTypeCount() {
			return 3;
		}

		@Override
		public int getItemViewType(int position) {
			if (getCount() <= 1) {// only one
				return BOTTOM;
			} else if (getCount() == 2) {// two

				if (position == 0) {
					return MIDDLE;
				} else {
					return BOTTOM;
				}

			} else {
				if (position == 0) {// first
					return MIDDLE;
				} else if (position == getCount() - 1) {// last
					return BOTTOM;
				} else {
					return MIDDLE;
				}
			}
		}

		static final int TOP = 0, MIDDLE = 1, BOTTOM = 2;

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			OptionViewHolder holder;

			switch (getItemViewType(position)) {
			case TOP:
				convertView = getTopView(convertView);
				break;
			case MIDDLE:
				convertView = getMiddleView(convertView);
				break;
			case BOTTOM:
				convertView = getBottomView(convertView);
				break;
			default:
				break;
			}

			holder = (OptionViewHolder) convertView.getTag();

			setInfos(holder, getItem(position));

			return convertView;
		}

		private void setViewStyles(OptionViewHolder holder) {
			setTextStyles((TextView) holder.item.findViewById(R.id._item));
		}

		@SuppressLint("ResourceAsColor")
		private void setInfos(OptionViewHolder holder, String item) {
			TextView view = ((TextView) holder.item.findViewById(R.id._item));
			view.setText(item);

		}

		private View getBottomView(View convertView) {
			if (convertView == null) {
				convertView = View.inflate(context, R.layout.dialog_option_bottom_item, null);
				OptionViewHolder optionViewHolder = new OptionViewHolder();
				optionViewHolder.item = convertView;
				convertView.setTag(optionViewHolder);
				setViewStyles(optionViewHolder);
			}
			return convertView;
		}

		private View getTopView(View convertView) {
			if (convertView == null) {
				convertView = View.inflate(context, R.layout.dialog_option_top_item, null);
				OptionViewHolder optionViewHolder = new OptionViewHolder();
				optionViewHolder.item = convertView;
				convertView.setTag(optionViewHolder);
				//
				setViewStyles(optionViewHolder);
			}
			return convertView;
		}

		private View getMiddleView(View convertView) {
			if (convertView == null) {
				convertView = View.inflate(context, R.layout.dialog_option_item, null);
				OptionViewHolder optionViewHolder = new OptionViewHolder();
				optionViewHolder.item = convertView;
				convertView.setTag(optionViewHolder);
				setViewStyles(optionViewHolder);
			}
			return convertView;
		}

		class OptionViewHolder {

			View item;
		}
	}

	class chatCancelListener implements android.view.View.OnClickListener {

		@Override
		public void onClick(View v) {
			dismiss();
		}

	}

}
