package com.example.day7_xiangce;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {

	private ImageView a_tu;
	private Button a_xiangce;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		a_tu = (ImageView) findViewById(R.id.a_tu);
		a_xiangce = (Button) findViewById(R.id.a_xiangce);
		
		a_xiangce.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		
	}
	//打开相机
	public void openxiangce(){
		Intent intent = new Intent();
		intent.addCategory(intent.CATEGORY_OPENABLE);
		intent.setType("image/*");
	}
}
