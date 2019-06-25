package com.example.day_xue_xiangmu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class Gerenxinxi extends Activity implements OnClickListener {

	private LinearLayout shezhi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gerenxinxi);
		
		shezhi = (LinearLayout) findViewById(R.id.geren_shezhi);
		
		shezhi.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.geren_shezhi:
			startActivity(new Intent(Gerenxinxi.this,Shezhi.class));
			break;

		default:
			break;
		}
	}
}
