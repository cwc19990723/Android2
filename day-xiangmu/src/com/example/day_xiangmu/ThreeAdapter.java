package com.example.day_xiangmu;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ThreeAdapter extends BaseAdapter{
	
	private Context context;
	private List<User> list;

	public ThreeAdapter(Context context, List<User> list) {
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
			convertView = LayoutInflater.from(context).inflate(R.layout.threeitem, null);
			vh = new ViewHolder();
			
			vh.c_tu1 = (ImageView) convertView.findViewById(R.id.c_tu1);
			vh.c_zi1 = (TextView) convertView.findViewById(R.id.c_zi1);
			vh.c_zi2 = (TextView) convertView.findViewById(R.id.c_zi2);
		
			convertView.setTag(vh);
		}else {
			vh = (ViewHolder) convertView.getTag();
		}
		
		User user = list.get(position);
		
		vh.c_tu1.setImageResource(user.getImg());
		vh.c_zi1.setText(user.getName());
		vh.c_zi2.setText(user.getTrave());
		
		return convertView;
	}
	
	class ViewHolder{
		ImageView c_tu1;
		TextView c_zi1;
		TextView c_zi2;
	}

}
