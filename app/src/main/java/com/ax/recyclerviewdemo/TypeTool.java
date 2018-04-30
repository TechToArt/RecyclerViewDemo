package com.ax.recyclerviewdemo;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.ArrayMap;

import com.ax.recyclerviewdemo.item.ItemViewBinder;

/**
 * Created by VERTU on 2018/4/28.
 */

public class TypeTool {
	private static volatile TypeTool instance;
	private ArrayMap<Class, ItemViewBinder> itemViewBinders;

	@TargetApi(Build.VERSION_CODES.KITKAT)
	private TypeTool() {
		itemViewBinders = new ArrayMap<>();
	}

	public static TypeTool getInstance() {
		if (instance == null) {
			synchronized (TypeTool.class) {
				if (instance == null) {
					instance = new TypeTool();
				}
			}
		}
		return instance;
	}

	public void register(Class clazz, ItemViewBinder itemViewBinder) {
		itemViewBinders.put(clazz, itemViewBinder);
	}

	public int indexOfClass(Class clazz) {
		return itemViewBinders.indexOfKey(clazz);
	}

	public ItemViewBinder getItemViewBinderByIndex(int index) {
		return itemViewBinders.valueAt(index);
	}

	public ItemViewBinder getItemViewBinderByClass(Class clazz) {
		return itemViewBinders.get(clazz);
	}

	public void clear() {
		itemViewBinders.clear();
	}
}
