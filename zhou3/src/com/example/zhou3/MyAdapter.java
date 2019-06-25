package com.example.zhou3;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import bean.User;
import bean.forecast;

public class MyAdapter extends BaseAdapter{
	
	private List<forecast> list;
	private Context context;
	
	public MyAdapter(List<forecast> list, Context context) {
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
			vh.it_riqi = (TextView) convertView.findViewById(R.id.it_riqi);
			vh.it_gaowen = (TextView) convertView.findViewById(R.id.it_gaowen);
			vh.it_diwen = (TextView) convertView.findViewById(R.id.it_diwen);
			vh.it_fengli = (TextView) convertView.findViewById(R.id.it_fengli);
			vh.it_fengxiang = (TextView) convertView.findViewById(R.id.it_fengxiang);
			vh.it_tianqi = (TextView) convertView.findViewById(R.id.it_tianqi);
			
			convertView.setTag(vh);
		}else {
			vh = (ViewHolder) convertView.getTag();
		}
		
		/*MyTask task = new MyTask(vh.it_tu);
		task.execute(list.get(position).get);*/
		
		vh.it_riqi.setText(list.get(position).getWeek());
		vh.it_gaowen.setText(list.get(position).getHigh());
		vh.it_diwen.setText(list.get(position).getLow());
		vh.it_fengli.setText(list.get(position).getFl());
		vh.it_fengxiang.setText(list.get(position).getFx());
		vh.it_tianqi.setText(list.get(position).getType());
		
		return convertView;
	}
	
	class ViewHolder{
		ImageView it_tu;
		TextView it_riqi;
		TextView it_gaowen;
		TextView it_diwen;
		TextView it_fengli;
		TextView it_fengxiang;
		TextView it_tianqi;
	}

}
