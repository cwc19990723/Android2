package com.example.day4_touming;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ImageView im_tu;
	private TextView te_shu;
	private SeekBar sk_shu;
	private Button bt_jia;
	private Button bt_jian;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		im_tu = (ImageView) findViewById(R.id.im_tu);
		
		te_shu = (TextView) findViewById(R.id.te_shu);
		
		sk_shu = (SeekBar) findViewById(R.id.sk_shu);
		//为SeekBar设置监听
		sk_shu.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				//修改图片透明度
				im_tu.setAlpha(progress*1.0f/seekBar.getMax());
				//为ListView设置进度条
				te_shu.setText(String.valueOf(progress*1.0f/seekBar.getMax()));
			}
		});
		
		bt_jia = (Button) findViewById(R.id.bt_jia);
		bt_jia.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sk_shu.incrementProgressBy(10);
			}
		});
		
		bt_jian = (Button) findViewById(R.id.bt_jian);
		bt_jian.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sk_shu.incrementProgressBy(-10);
			}
		});
	}
}
