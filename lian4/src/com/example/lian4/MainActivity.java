package com.example.lian4;

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

public class MainActivity extends Activity implements OnClickListener {

	private Button update;
	private AlertDialog dialog;
	private TextView a_tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		a_tv = (TextView) findViewById(R.id.a_tv);
		update = (Button) findViewById(R.id.a_update);
		
		update.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.a_update:
			update();
			break;

		default:
			break;
		}
	}

	private void update() {
		
		View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog, null);
		
		final EditText log_ev = (EditText) view.findViewById(R.id.a_ev);
		String tv = a_tv.getText().toString();
		log_ev.setText(tv);
		a_tv.setText(MainActivity.this.a_tv.getText().toString());
		Button log_quxiao = (Button) view.findViewById(R.id.a_quxiao);
		Button log_update = (Button) view.findViewById(R.id.a_update);
		
		dialog = new AlertDialog.Builder(MainActivity.this)
		.setView(view)
		.create();
		dialog.show();
		
		log_quxiao.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog.cancel();
			}
		});
		
		log_update.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String string2 = log_ev.getText().toString();
				a_tv.setText(string2);
				
				/*String string = a_tv.getText().toString();
				log_ev.setText(string);*/
				dialog.cancel();
			}
		});
		
	}

}
