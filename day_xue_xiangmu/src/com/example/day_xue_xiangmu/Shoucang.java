package com.example.day_xue_xiangmu;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Shoucang extends Activity {

	private TextView shoucang_tv;
	private Button update;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shoucang);
		
		shoucang_tv = (TextView) findViewById(R.id.shoucang_tv);
		update = (Button) findViewById(R.id.shoucang_update);
		
		update.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				View view = LayoutInflater.from(Shoucang.this).inflate(R.layout.shoucang_dialog, null);
				final EditText shoucang_ed = (EditText) view.findViewById(R.id.shoucang_ed);
				String tv = shoucang_tv.getText().toString();
				shoucang_ed.setText(tv);
				shoucang_tv.setText(Shoucang.this.shoucang_tv.getText().toString());
				Button ok = (Button) view.findViewById(R.id.shoucang_ok);
				Button quxiao = (Button) view.findViewById(R.id.shoucang_quxiao);
				
				
				final AlertDialog dialog = new AlertDialog.Builder(Shoucang.this)
				.setView(view)
				.create();
				dialog.show();
				
				ok.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						String ed = shoucang_ed.getText().toString();
						shoucang_tv.setText(ed);
						dialog.cancel();
					}
				});
				
				quxiao.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						dialog.cancel();
					}
				});
				
			}
		});
	}
}
