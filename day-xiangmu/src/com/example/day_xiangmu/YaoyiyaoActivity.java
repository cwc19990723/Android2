package com.example.day_xiangmu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class YaoyiyaoActivity extends Activity implements OnClickListener{

	private TextView yao_fanhui;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yaoyiyao);
		yao_fanhui = (TextView) findViewById(R.id.yao_fanhui);
		
		yao_fanhui.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.yao_fanhui:
			startActivity(new Intent(YaoyiyaoActivity.this,DActivity.class));
			break;

		default:
			break;
		}
	}
}
