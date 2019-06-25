package com.example.day_xiangmu;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class TiaobeijingActivity extends Activity implements OnSeekBarChangeListener,OnClickListener{

	private ImageView tiaobeijing_anniutu;
	private SeekBar tiaobeijing_sb;
	private TextView tiaobeijing_zi;
	private ImageView tiaobeijing_tu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tiaobeijing);
		
		tiaobeijing_anniutu = (ImageView) findViewById(R.id.tiaobeijing_anniutu);
		tiaobeijing_sb = (SeekBar) findViewById(R.id.tiaobeijing_sb);
		tiaobeijing_zi = (TextView) findViewById(R.id.tiaobeijing_zi);
		tiaobeijing_tu = (ImageView) findViewById(R.id.tiaobeijing_tu);
		
		tiaobeijing_sb.setOnSeekBarChangeListener(this);
		tiaobeijing_anniutu.setOnClickListener(this);
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		float f=(float)(progress/255.0);
		tiaobeijing_tu.setAlpha(f);
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		int progress = seekBar.getProgress();
		
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tiaobeijing_anniutu:
			startActivity(new Intent(TiaobeijingActivity.this,DActivity.class));
			break;

		default:
			break;
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		//初始化透明度
		SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
		float float1 = sp.getFloat("bg", 0.0f);
		int prog = (int) (float1*10.0);
		tiaobeijing_sb.setProgress(prog);
		tiaobeijing_tu.setAlpha(float1);
		
	}
	
}
