package com.example.lian10;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText a_ed;
	private Button a_read;
	private Button a_cun;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		a_ed = (EditText) findViewById(R.id.a_ed);
		a_cun = (Button) findViewById(R.id.a_cun);
		a_read = (Button) findViewById(R.id.a_read);
		
		a_cun.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SharedPreferences sp = getSharedPreferences("name", MODE_PRIVATE);
				Editor edit = sp.edit();
				String ed = a_ed.getText().toString();
				edit.putString("namea", ed);
				edit.commit();
			}
		});
		
		a_read.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SharedPreferences sp = getSharedPreferences("name", MODE_PRIVATE);
				String string = sp.getString("namea", "∂¡»°≤ªµΩ");
				a_ed.setText(string);
			}
		});
		
	}
}
