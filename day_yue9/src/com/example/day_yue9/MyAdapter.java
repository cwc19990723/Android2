package com.example.day_yue9;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import bean.lol;

public class MyAdapter extends BaseAdapter{
	
	private Context context;
	private List<lol> list;

	public MyAdapter(Context context, List<lol> list) {
		super();
		this.context = context;
		this.list = list;
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
			
			vh.it_name = (TextView) convertView.findViewById(R.id.it_name);
			vh.it_zhiye = (TextView) convertView.findViewById(R.id.it_zhiye);
			vh.it_address = (TextView) convertView.findViewById(R.id.it_address);
			
			convertView.setTag(vh);
		}else {
			vh = (ViewHolder) convertView.getTag();
		}
		
		vh.it_name.setText(list.get(position).getName());
		vh.it_zhiye.setText(list.get(position).getJob());
		vh.it_address.setText(list.get(position).getLocation());
		
		return convertView;
	}
	
	class ViewHolder{
		TextView it_name;
		TextView it_zhiye;
		TextView it_address;
	}

}
