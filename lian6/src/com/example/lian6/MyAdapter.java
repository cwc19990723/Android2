package com.example.lian6;

import java.util.List;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{
	
	private List<Ccc> list;
	private Context context;
	
	public MyAdapter(List<Ccc> list, Context context) {
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
			
			vh.it_tu = (ImageView) convertView.findViewById(R.id.it_tu);
			vh.it_bt = (TextView) convertView.findViewById(R.id.it_bt);
			vh.it_nr = (TextView) convertView.findViewById(R.id.it_nr);
			
			convertView.setTag(vh);
		}else {
			vh = (ViewHolder) convertView.getTag();
		}
		
		Ccc ccc = (Ccc) getItem(position);
		
		vh.it_tu.setImageResource(list.get(position).getImage());
		vh.it_bt.setText(list.get(position).getName());
		vh.it_nr.setText(list.get(position).getContent());
		
		return convertView;
	}
	
	class ViewHolder{
		
		ImageView it_tu;
		TextView it_bt;
		TextView it_nr;
		
	}

}
