package com.example.day_xiangmu;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GuangAdapter extends BaseAdapter{
	
	private Context context;
	private List<GuangUser> list;

	public GuangAdapter(Context context, List<GuangUser> list) {
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
			
			vh.guang_te1 = (TextView) convertView.findViewById(R.id.guang_te1);
			vh.guang_te2 = (TextView) convertView.findViewById(R.id.guang_te2);
			vh.guang_te3 = (TextView) convertView.findViewById(R.id.guang_te3);
			vh.guang_te4 = (TextView) convertView.findViewById(R.id.guang_te4);
			vh.guang_te5 = (TextView) convertView.findViewById(R.id.guang_te5);
			vh.guang_te6 = (TextView) convertView.findViewById(R.id.guang_te6);
			
			convertView.setTag(vh);
		}else {
			vh = (ViewHolder) convertView.getTag();
		}
		
		vh.guang_te1.setText(list.get(position).getGoodPingJIa()+"");
		vh.guang_te2.setText(list.get(position).getId()+"");
		vh.guang_te3.setText(list.get(position).getGoodInfo());
		vh.guang_te4.setText(list.get(position).getGoodName());
		vh.guang_te5.setText(list.get(position).getGoodNowPrice()+"");
		vh.guang_te6.setText(list.get(position).getGoodPrice()+"");
		
		MyTask myTask = new MyTask(vh.guang_tu);
		String string = list.get(position).getGoodImage();
		myTask.execute("http://192.168.1.34:8080/"+string);
		
		return convertView;
	}
	
	class ViewHolder{
		ImageView guang_tu;
		TextView guang_te1;
		TextView guang_te2;
		TextView guang_te3;
		TextView guang_te4;
		TextView guang_te5;
		TextView guang_te6;
	}

}
