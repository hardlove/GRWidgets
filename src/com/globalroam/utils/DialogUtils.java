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
	 * ��ʾֻ��һ��OK��ť�ĶԻ��򣬵��OK��ť�����κδ���
	 * @param context
	 * @param title:���⣬����nullʱ������ʾtitle
	 * @param content:��ʾ����ʾ����
	 */
	public static Dialog showOKDialog(Context context,String title,String content){
		
		return showOKDialog(context, title, content, null);
		
	}
	
	/**
	 * ��ʾֻ��һ��OK��ť�ĶԻ���
	 * @param context
	 * @param title:���⣬����nullʱ������ʾtitle
	 * @param content:��ʾ����ʾ����
	 * @param okListenter:�����ť�Ļص�
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
	 * ��ʾֻ��һ����OK��Cancel�ĶԻ���
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
