package com.ax.recyclerviewdemo.item.ad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.ax.recyclerviewdemo.ContextUtils;
import com.ax.recyclerviewdemo.R;
import com.ax.recyclerviewdemo.item.BaseViewHolder;
import com.ax.recyclerviewdemo.item.ItemViewBinder;

/**
 * Created by VERTU on 2018/4/28.
 */

public class ADItemViewBinder implements ItemViewBinder<ADItemBean, ADItemViewBinder.ADViewHolder> {
	@Override
	public ADViewHolder onCreateViewHolder(LayoutInflater inflater, ViewGroup parent) {
		return new ADViewHolder(inflater.inflate(R.layout.recycle_item_ad, parent, false));
	}

	@Override
	public void onBindViewHolder(ADViewHolder viewHolder, final ADItemBean adItemBean) {
		viewHolder.iv.setImageResource(adItemBean.resource);
		viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(ContextUtils.getApplication(), "resource:"+adItemBean.resource, Toast.LENGTH_SHORT).show();
			}
		});
	}

	static class ADViewHolder extends BaseViewHolder {
		ImageView iv;

		public ADViewHolder(View itemView) {
			super(itemView);
			iv = itemView.findViewById(R.id.iv_item_ad);
		}
	}
}
