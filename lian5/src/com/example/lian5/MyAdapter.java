package com.example.lian5;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{
	
	private List<User> list;
	private Context context;

	public MyAdapter(List<User> list, Context context) {
		super();
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View view = LayoutInflater.from(context).inflate(R.layout.item, null);
		
		ImageView it_tu = (ImageView) view.findViewById(R.id.it_tu);
		TextView it_bt = (TextView) view.findViewById(R.id.it_bt);
		TextView it_nr = (TextView) view.findViewById(R.id.it_nr);
		
		User user = (User) getItem(position);
		it_tu.setImageResource(user.getTu());
		it_bt.setText(user.getBiaoti());
		it_nr.setText(user.getNeirong());
		
		return view;
	}

}
