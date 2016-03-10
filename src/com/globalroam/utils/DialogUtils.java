package com.globalroam.utils;

import com.globalroam.widgets.GRDialogPlus;
import com.globalroam.widgets.GRTextViewPlus;
import com.globalroam.widgets.R;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

public class DialogUtils {
	
	public interface CancelListener {

		void onClick(View v);

	}


	public interface OkListener {

		void onClick(View v);

	}


	/**
	 * 显示只有一个OK按钮的对话框，点击OK按钮不做任何处理
	 * @param context
	 * @param title:标题，传入null时，不显示title
	 * @param content:显示的提示内容
	 */
	public static Dialog showOKDialog(Context context,String title,String content){
		
		return showOKDialog(context, title, content, null);
		
	}
	
	/**
	 * 显示只有一个OK按钮的对话框
	 * @param context
	 * @param title:标题，传入null时，不显示title
	 * @param content:显示的提示内容
	 * @param okListenter:点击按钮的回调
	 */
	public static Dialog showOKDialog(Context context,String title,String content,final OkListener okListenter){
		final GRDialogPlus dialog = new GRDialogPlus(context,R.style.customdialog);
		View root = LayoutInflater.from(context).inflate(R.layout.dialog_ok_layout, null);
		dialog.setContentView(root);
		
		GRTextViewPlus okButton = (GRTextViewPlus) root.findViewById(R.id._ok_button);
		okButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog.dismiss();
				if(okListenter!=null){
					okListenter.onClick(v);
				}
				
			}
		});
		
		GRTextViewPlus titleTextView = (GRTextViewPlus) root.findViewById(R.id._title);
		if(TextUtils.isEmpty(title)){
			titleTextView.setVisibility(View.GONE);
		}else{
			titleTextView.setText(title);
			titleTextView.setVisibility(View.VISIBLE);
		}
		
		GRTextViewPlus contentTextView = (GRTextViewPlus) root.findViewById(R.id._reason);
		contentTextView.setText(content);
		
		dialog.show();
		
		return dialog;
	}
	
	
	/**
	 * 显示只有一个有OK和Cancel的对话框
	 * @param context
	 */
	public static Dialog showOKCancelDialog(Context context, String title,String content,final OkListener okListenter,final CancelListener cancelListener){
		final GRDialogPlus dialog = new GRDialogPlus(context,R.style.customdialog);
		View root = LayoutInflater.from(context).inflate(R.layout.dialog_ok_cancel_layout, null);
		dialog.setContentView(root);
		
		GRTextViewPlus okButton = (GRTextViewPlus) root.findViewById(R.id._ok_button);
		okButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog.dismiss();
				if(okListenter!=null){
					okListenter.onClick(v);
				}
				
			}
		});
		
		GRTextViewPlus cancelButton = (GRTextViewPlus) root.findViewById(R.id._cancel_button);
		cancelButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog.dismiss();
				if(cancelListener!=null){
					cancelListener.onClick(v);
				}
				
			}
		});
		
		GRTextViewPlus titleTextView = (GRTextViewPlus) root.findViewById(R.id._title);
		if(TextUtils.isEmpty(title)){
			titleTextView.setVisibility(View.GONE);
		}else{
			titleTextView.setText(title);
			titleTextView.setVisibility(View.VISIBLE);
		}
		
		GRTextViewPlus contentTextView = (GRTextViewPlus) root.findViewById(R.id._reason);
		contentTextView.setText(content);
		
		dialog.show();
		
		return dialog;
		
		
		
	}
	
	public static void showItemsDialog(Context context,String title,String[] items){
		
	}
	
	
	

}
