package com.example.day_xue_xiangmu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Tiaojiebeijing extends Activity {

	private Button ok;
	private SeekBar sb;
	private ImageView tu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tiaojiebeijing);
		
		ok = (Button) findViewById(R.id.beijing_ok);
		sb = (SeekBar) findViewById(R.id.beijing_sb);
		tu = (ImageView) findViewById(R.id.beijing_tu);
		
		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				tu.setAlpha(progress*1.0f/seekBar.getMax());
			}
		});
		
		ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
	}
}
