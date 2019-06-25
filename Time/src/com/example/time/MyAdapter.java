package com.example.time;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{
	
	private List<datas> list;
	private Context context;

	public MyAdapter(List<datas> list, Context context) {
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
			vh.it_zi1 = (TextView) convertView.findViewById(R.id.it_zi1);
			vh.it_zi2 = (TextView) convertView.findViewById(R.id.it_zi2);
			
			convertView.setTag(vh);
		}else {
			vh = (ViewHolder) convertView.getTag();
		}
		
		MyTask task = new MyTask(vh.it_tu);
		task.execute(list.get(position).getEnvelopePic());
		vh.it_zi1.setText(list.get(position).getSuperChapterName());
		vh.it_zi2.setText(list.get(position).getTitle());
		
		return convertView;
	}
	
	class ViewHolder{
		ImageView it_tu;
		TextView it_zi1;
		TextView it_zi2;
	}

}
