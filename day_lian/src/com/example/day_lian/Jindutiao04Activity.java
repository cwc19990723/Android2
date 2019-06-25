package com.example.day_lian;

import android.app.Activity;import android.media.tv.TvContract.Programs;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Jindutiao04Activity extends Activity implements OnClickListener {

	private Button jia;
	private Button jian;
	private ProgressBar pg;
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jindutiao04);
		
		jia = (Button) findViewById(R.id.c_jia);
		jian = (Button) findViewById(R.id.c_jian);
		pg = (ProgressBar) findViewById(R.id.c_pg);
		tv = (TextView) findViewById(R.id.c_tv);
		
		tv.setText(pg.getProgress()+"%");
		
		jia.setOnClickListener(this);
		jian.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int progress = pg.getProgress();
		switch (v.getId()) {
		case R.id.c_jia:
			if(progress<100){
				progress +=10;
				pg.setProgress(progress);
			}
			break;
		case R.id.c_jian:
			if(progress>0){
				progress = progress-10;
				pg.setProgress(progress);
			}
			break;	

		default:
			break;
		}
		tv.setText(progress+"%");
	}
}
