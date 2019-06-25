package com.example.day_xiangmu;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ShiyongAdapter extends BaseAdapter{
	
	private Context context;
	private List<Travel> list;

	public ShiyongAdapter(Context context, List<Travel> list) {
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
			convertView = LayoutInflater.from(context).inflate(R.layout.ruanjian_item, null);
			vh = new ViewHolder();
			
			vh.image = (ImageView) convertView.findViewById(R.id.ruanjian_tu);
			vh.name = (TextView) convertView.findViewById(R.id.ruanjian_shuguo);
			
			convertView.setTag(vh);
		}else {
			vh = (ViewHolder) convertView.getTag();
		}
		
		Travel travel = list.get(position);
		
		vh.image.setImageResource(travel.getImage());
		vh.name.setText(travel.getName());
		
		return convertView;
	}
	
	class ViewHolder{
		ImageView  image;
		TextView name;
	}

}
