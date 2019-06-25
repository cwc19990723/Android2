package com.example.day7_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	private Button a_zc;
	private EditText a_zhang;
	private EditText a_mi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		a_zc = (Button) findViewById(R.id.a_zc);
		a_zhang = (EditText) findViewById(R.id.a_zhang);
		a_mi = (EditText) findViewById(R.id.a_mi);
		
		a_zc.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		 Intent intent = new Intent(MainActivity.this,BActivity.class);
		 startActivityForResult(intent, 100);
		 
	}
	
	 		@Override
	 		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	 			super.onActivityResult(requestCode, resultCode, data);
	 			if(requestCode==100&&resultCode==200){
	 				String zhang = data.getStringExtra("zh");
	 				String mm = data.getStringExtra("mm");
	 				a_zhang.setText(zhang);
	 				a_mi.setText(mm);
	 			}
	 			
	 		}
}
