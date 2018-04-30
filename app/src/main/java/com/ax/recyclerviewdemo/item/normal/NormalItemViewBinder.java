package com.ax.recyclerviewdemo.item.normal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ax.recyclerviewdemo.ContextUtils;
import com.ax.recyclerviewdemo.R;
import com.ax.recyclerviewdemo.item.BaseViewHolder;
import com.ax.recyclerviewdemo.item.ItemViewBinder;

/**
 * Created by VERTU on 2018/4/28.
 */

public class NormalItemViewBinder implements ItemViewBinder<NormalItemBean, NormalItemViewBinder.NormalViewHolder> {
	@Override
	public NormalViewHolder onCreateViewHolder(LayoutInflater inflater, ViewGroup parent) {
		return new NormalViewHolder(inflater.inflate(R.layout.recycle_item_normal, parent, false));
	}

	@Override
	public void onBindViewHolder(NormalViewHolder viewHolder, final NormalItemBean normalItemBean) {
		viewHolder.tv.setText(normalItemBean.content);
		viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(ContextUtils.getApplication(), "content:"+normalItemBean.content, Toast.LENGTH_SHORT).show();
			}
		});

	}

	static class NormalViewHolder extends BaseViewHolder {
		TextView tv;

		public NormalViewHolder(View itemView) {
			super(itemView);
			tv = itemView.findViewById(R.id.tv);
		}
	}

}
