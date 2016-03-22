package com.globalroam.messageplus.utils;

import com.globalroam.messageplus.R;
import com.globalroam.messageplus.widgets.GRDialogPlus;
import com.globalroam.messageplus.widgets.GRTextViewPlus;
import com.globalroam.messageplus.widgets.OptionTitleDialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;

public class DialogUtils {

	public interface CancelListener {

		void onClick(View v);

	}

	public interface OkListener {

		void onClick(View v);

	}

	/**
	 * 显示一个带有OK按钮的Dialog
	 * 
	 * @param context
	 * @param title Dialog的标题，如果传入null，则不显示title部分
	 * @param content Dialog的内容信息
	 * @return 创建的Dialog对象
	 */
	public static Dialog showOKDialog(Context context, String title, String content) {

		return showOKDialog(context, title, content, null);

	}

	/**
	 * 显示一个带有OK按钮的Dialog
	 * 
	 * @param context
	 * @param title Dialog的标题，如果传入null，则不显示title部分
	 * @param content Dialog的内容信息
	 * @param okListenter 点击OK按钮的回调
	 * @return 创建的Dialog对象
	 */
	public static Dialog showOKDialog(Context context, String title, String content, final OkListener okListenter) {
		final GRDialogPlus dialog = new GRDialogPlus(context, R.style.customDialog);
		View root = LayoutInflater.from(context).inflate(R.layout.dialog_ok_layout, null);
		dialog.setContentView(root);

		GRTextViewPlus okButton = (GRTextViewPlus) root.findViewById(R.id._ok_button);
		okButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				dialog.dismiss();
				if (okListenter != null) {
					okListenter.onClick(v);
				}

			}
		});

		GRTextViewPlus titleTextView = (GRTextViewPlus) root.findViewById(R.id._title);
		if (TextUtils.isEmpty(title)) {
			titleTextView.setVisibility(View.GONE);
		} else {
			titleTextView.setText(title);
			titleTextView.setVisibility(View.VISIBLE);
		}

		GRTextViewPlus contentTextView = (GRTextViewPlus) root.findViewById(R.id._reason);
		contentTextView.setText(content);

		dialog.show();

		return dialog;
	}
	
	/**
	 * 显示一个带有OK和Cancel按钮的Dialog
	 * 
	 * @param context
	 * @param title Dialog的标题，如果传入null，则不显示title部分
	 * @param content Dialog的内容信息
	 * @param okListenter 点击OK按钮的回调
	 * @param cancelListener 点击Cancel按钮的回调
	 * @return 创建的Dialog对象
	 */
	public static Dialog showOKCancelDialog(Context context, String title, String content, final OkListener okListenter,
			final CancelListener cancelListener) {
		final GRDialogPlus dialog = new GRDialogPlus(context, R.style.customDialog);
		View root = LayoutInflater.from(context).inflate(R.layout.dialog_ok_cancel_layout, null);
		dialog.setContentView(root);

		GRTextViewPlus okButton = (GRTextViewPlus) root.findViewById(R.id._ok_button);
		okButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				dialog.dismiss();
				if (okListenter != null) {
					okListenter.onClick(v);
				}

			}
		});

		GRTextViewPlus cancelButton = (GRTextViewPlus) root.findViewById(R.id._cancel_button);
		cancelButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				dialog.dismiss();
				if (cancelListener != null) {
					cancelListener.onClick(v);
				}

			}
		});

		GRTextViewPlus titleTextView = (GRTextViewPlus) root.findViewById(R.id._title);
		if (TextUtils.isEmpty(title)) {
			titleTextView.setVisibility(View.GONE);
		} else {
			titleTextView.setText(title);
			titleTextView.setVisibility(View.VISIBLE);
		}

		GRTextViewPlus contentTextView = (GRTextViewPlus) root.findViewById(R.id._reason);
		contentTextView.setText(content);

		dialog.show();

		return dialog;

	}

	/**
	 * 显示一个菜单选项的Dialog
	 * @param context
	 * @param title Dialog的标题
	 * @param items 菜单栏的items
	 * @param v  触发显示的View
	 * @param itemClickListener items的监听
	 * @return 创建的 Dialog对象
	 */
	public static Dialog showItemsDialog(Context context, String title, String[] items, View v,
			final OnItemClickListener itemClickListener) {
		OptionTitleDialog dialog = OptionTitleDialog.Builder(context, title, items, v, itemClickListener);
		dialog.show();
		return dialog;
	}

	/**
	 * 显示一个菜单选项的Dialog
	 * @param context
	 * @param title Dialog的标题
	 * @param items 菜单栏的items
	 * @param v  触发显示的View
	 * @param itemClickListener items的监听
	 * @return 创建的 Dialog对象
	 */
	public static Dialog showItemsDialog(Context context, String title, String[] items, View v,
			final OnItemClickListener itemClickListener, final OnDismissListener dismissListener) {
		OptionTitleDialog dialog = OptionTitleDialog.Builder(context, title, items, v, itemClickListener,
				dismissListener);
		dialog.show();
		return dialog;
	}

}
