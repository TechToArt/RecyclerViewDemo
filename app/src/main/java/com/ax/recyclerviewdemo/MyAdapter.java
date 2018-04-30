package com.ax.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ax.recyclerviewdemo.item.ItemViewBinder;

import java.util.List;


/**
 * Created by VERTU on 2018/4/28.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	List<Object> datas;
	LayoutInflater inflater;
	TypeTool typeTool;

	public MyAdapter(Context context, List<Object> datas) {
		inflater = LayoutInflater.from(context);
		this.datas = datas;
		typeTool = TypeTool.getInstance();
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		ItemViewBinder itemViewBinder = typeTool.getItemViewBinderByIndex(viewType);
		return itemViewBinder.onCreateViewHolder(inflater, parent);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		ItemViewBinder itemViewBinder = typeTool.getItemViewBinderByClass(datas.get(position).getClass());
		itemViewBinder.onBindViewHolder(holder, datas.get(position));
	}

	@Override
	public int getItemCount() {
		return datas.size();
	}

	@Override
	public int getItemViewType(int position) {
		return typeTool.indexOfClass(datas.get(position).getClass());
	}

	public void register(Class clazz, ItemViewBinder itemViewBinder) {
		typeTool.register(clazz, itemViewBinder);
	}
}
