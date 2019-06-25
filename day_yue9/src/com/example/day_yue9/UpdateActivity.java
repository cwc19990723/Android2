package com.example.day_yue9;

import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import bean.lol;

public class UpdateActivity extends Activity implements OnClickListener {

	private EditText up_name;
	private EditText up_zhiye;
	private EditText up_address;
	private Button ok;
	private Button bt;
	private lol lol;
	private Intent in;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update);
		
		up_name = (EditText) findViewById(R.id.up_name);
		up_zhiye = (EditText) findViewById(R.id.up_zhiye);
		up_address = (EditText) findViewById(R.id.up_address);
		bt = (Button) findViewById(R.id.up_bt);
		ok = (Button) findViewById(R.id.up_ok);
		
		in = getIntent();
		lol = (bean.lol) in.getSerializableExtra("up");
		
		up_name.setText(lol.getName());
		up_zhiye.setText(lol.getJob());
		up_address.setText(lol.getLocation());
		
		ok.setOnClickListener(this);
		bt.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.up_ok:
			ok();
			break;
		case R.id.up_bt:
			up_name.setEnabled(true);
			up_zhiye.setEnabled(true);
			up_address.setEnabled(true);
			break;

		default:
			break;
		}
	}

	private void ok() {
		String name = up_name.getText().toString();
		String zhiye = up_zhiye.getText().toString();
		String address = up_address.getText().toString();
		
		lol.setName(name);
		lol.setJob(zhiye);
		lol.setLocation(address);
		
		in.putExtra("context", lol);
		setResult(400, in);
		finish();
	}
}
