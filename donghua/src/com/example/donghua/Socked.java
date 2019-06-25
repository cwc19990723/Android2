package com.example.donghua;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class Socked extends Activity {

	private RelativeLayout socked;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_socked);
		
		socked = (RelativeLayout) findViewById(R.id.socked);
		
		socked.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Socked.this,CActivity.class));
				overridePendingTransition(R.anim.torinht,R.anim.toleft);
			}
		});
	}
}
