package com.example.day_zuo_1;

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

public class BActivity extends Activity {

	private SeekBar sb;
	private ImageView tu;
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		
		sb = (SeekBar) findViewById(R.id.b_sb);
		tu = (ImageView) findViewById(R.id.b_tu);
		tv = (TextView) findViewById(R.id.b_tv);
		
		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				//获取透明度
				tu.setAlpha(progress*1.0f/seekBar.getMax());
				//获取textview数据
				tv.setText(String.valueOf((progress*1.0f/seekBar.getMax())));
			}
		});
		
		//jia
		Button jia = (Button) findViewById(R.id.b_jia);
		jia.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sb.incrementProgressBy(+10);
			}
		});
		
		//加
		Button jian = (Button) findViewById(R.id.b_jian);
		jian.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sb.incrementProgressBy(-10);
			}
		});
		
	}
}
