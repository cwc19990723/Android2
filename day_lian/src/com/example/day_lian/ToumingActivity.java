package com.example.day_lian;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class ToumingActivity extends Activity {

	private ImageView iv;
	private SeekBar sb;
	private TextView tv;
	private Button jia;
	private Button jian;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_touming);
		
		iv = (ImageView) findViewById(R.id.tou_iv);
		sb = (SeekBar) findViewById(R.id.tou_sb);
		tv = (TextView) findViewById(R.id.tou_tv);
		
		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				//修改图片透明度
				iv.setAlpha(progress*1.0f/seekBar.getMax());
				//为Textview修改进度
				tv.setText(String.valueOf((progress*1.0f/seekBar.getMax())));
			}
		});
		jia = (Button) findViewById(R.id.tou_jia);
		jia.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sb.incrementProgressBy(-10);
			}
		});
		jian = (Button) findViewById(R.id.tou_jian);
		jian.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sb.incrementProgressBy(+10);
			}
		});
	}
}
