package com.ax.recyclerviewdemo.item;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by VERTU on 2018/4/28.
 */

public interface ItemViewBinder<T, H extends RecyclerView.ViewHolder> {
	H onCreateViewHolder(LayoutInflater inflater, ViewGroup parent);

	void onBindViewHolder(H viewHolder, T t);
}
