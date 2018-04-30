package com.ax.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ax.recyclerviewdemo.item.ad.ADItemBean;
import com.ax.recyclerviewdemo.item.ad.ADItemViewBinder;
import com.ax.recyclerviewdemo.item.normal.NormalItemBean;
import com.ax.recyclerviewdemo.item.normal.NormalItemViewBinder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	RecyclerView rv;
	MyAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rv = (RecyclerView) findViewById(R.id.rv);
		adapter = new MyAdapter(this, getDatas());
		rv.setAdapter(adapter);
		rv.setLayoutManager(new LinearLayoutManager(this));
		initData();
	}

	public void initData() {
		adapter.register(NormalItemBean.class, new NormalItemViewBinder());
		adapter.register(ADItemBean.class, new ADItemViewBinder());
	}

	public List<Object> getDatas() {
		List<Object> datas = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			datas.add(new NormalItemBean("item:" + i));
		}
		datas.add(2, new ADItemBean(R.drawable.ad1));
		datas.add(8, new ADItemBean(R.drawable.ad2));
		return datas;
	}
}
