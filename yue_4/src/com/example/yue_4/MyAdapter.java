package com.example.yue_4;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import bean.User;
import bean.data;

public class MyAdapter extends BaseAdapter{
	
	private Context context;
	private List<data> list;
	
	public MyAdapter(Context context, List<data> list) {
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
			convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
			vh = new ViewHolder();
			
			vh.it_tv = (TextView) convertView.findViewById(R.id.it_tv);
			
			convertView.setTag(vh);
		}else {
			vh = (ViewHolder) convertView.getTag();
		}
		
		vh.it_tv.setText(list.get(position).getContent());
		
		return convertView;
	}
	
	class ViewHolder{
		TextView it_tv;
	}

}
