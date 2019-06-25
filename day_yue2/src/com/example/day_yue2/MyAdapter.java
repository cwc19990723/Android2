package com.example.day_yue2;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{
	
	private Context context;
	private List<User> list;

	public MyAdapter(Context context, List<User> list) {
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
			
			vh.it_tu = (ImageView) convertView.findViewById(R.id.it_tu);
			vh.it_name = (TextView) convertView.findViewById(R.id.it_name);
			vh.it_yiyuanname = (TextView) convertView.findViewById(R.id.it_yiyuanname);
			vh.it_jibie = (TextView) convertView.findViewById(R.id.it_jibie);
			vh.it_zhicheng = (TextView) convertView.findViewById(R.id.it_zhicheng);
			vh.it_keshi = (TextView) convertView.findViewById(R.id.it_keshi);
			
			convertView.setTag(vh);
		}else {
			vh = (ViewHolder) convertView.getTag();
		}
		
		MyTask task = new MyTask(vh.it_tu);
		task.execute(list.get(position).getImgurl());
		vh.it_name.setText(list.get(position).getName());
		vh.it_yiyuanname.setText(list.get(position).getHosptail());
		vh.it_jibie.setText(list.get(position).getLevel());
		vh.it_keshi.setText(list.get(position).getDepartment());
		vh.it_zhicheng.setText(list.get(position).getTitle());
		
		return convertView;
	}
	
	class ViewHolder{
		ImageView it_tu;
		TextView it_name;
		TextView it_zhicheng;
		TextView it_yiyuanname;
		TextView it_keshi;
		TextView it_jibie;
	}

}
