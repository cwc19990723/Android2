package com.example.lian2;

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
import android.widget.Toast;

public class BActivity extends Activity implements OnClickListener {

	private EditText b_age;
	private EditText b_sex;
	private Button ok;
	private Button update;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		
		b_age = (EditText) findViewById(R.id.b_age);
		b_sex = (EditText) findViewById(R.id.b_sex);
		ok = (Button) findViewById(R.id.b_ok);
		update = (Button) findViewById(R.id.b_update);
		
		ok.setOnClickListener(this);
		update.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.b_ok:
			ok();
			break;
		case R.id.b_update:
			update();
			break;

		default:
			break;
		}
	}

	private void update() {
		View view = LayoutInflater.from(BActivity.this).inflate(R.layout.dialog, null);
		final EditText edage = (EditText) view.findViewById(R.id.b_age);
		b_age.setText(BActivity.this.b_age.getText().toString());
		final EditText edsex = (EditText) view.findViewById(R.id.b_sex);
		b_sex.setText(BActivity.this.b_sex.getText().toString());
		
		Button btok = (Button) view.findViewById(R.id.b_ok);
		Button b_qu = (Button) view.findViewById(R.id.b_qu);
		
		final AlertDialog dialog = new AlertDialog.Builder(BActivity.this)
				.setView(view)
				.create();
				dialog.show();
		
		//确认
		btok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String sex = edsex.getText().toString();
				b_sex.setText(sex);
				String age = edage.getText().toString();
				b_age.setText(age);
				dialog.cancel();
			}
		});
		//取消
		b_qu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog.cancel();
			}
		});
		
	}

	private void ok() {
		String age = b_age.getText().toString();
		String sex = b_sex.getText().toString();
		
		Toast.makeText(BActivity.this, "性别为"+sex+"\n"+"年龄为"+age+"\n", Toast.LENGTH_SHORT).show();
	}
}
