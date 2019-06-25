package com.example.zuo_day4;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
		
		ViewHolder vh = null;
		if(convertView==null){
			vh = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
			
			vh.it_zi1 = (TextView) convertView.findViewById(R.id.it_zi1);
			vh.it_zi2 = (TextView) convertView.findViewById(R.id.it_zi2);
			vh.it_zi3 = (TextView) convertView.findViewById(R.id.it_zi3);
			vh.it_zi4 = (TextView) convertView.findViewById(R.id.it_zi4);
			
			convertView.setTag(vh);
		}else {
			vh = (ViewHolder) convertView.getTag();
		}
		
		vh.it_zi1.setText(list.get(position).getName());
		vh.it_zi2.setText(list.get(position).getAge());
		vh.it_zi3.setText(list.get(position).getClassname());
		vh.it_zi4.setText(list.get(position).getSchoolname());
		
		return convertView;
	}
	
	class ViewHolder{
		TextView it_zi1;
		TextView it_zi2;
		TextView it_zi3;
		TextView it_zi4;
	}

}