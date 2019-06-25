package com.example.lian9;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add extends Activity {

	private Button ok;
	private EditText add_wangzhi;
	private EditText add_riqi;
	private EditText add_fengli;
	private EditText add_fengxiang;
	private EditText add_gaowen;
	private EditText add_diwen;
	private EditText add_tianqi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		
		add_wangzhi = (EditText) findViewById(R.id.add_wangzhi);
		add_riqi = (EditText) findViewById(R.id.add_riqi);
		add_fengli = (EditText) findViewById(R.id.add_fengli);
		add_fengxiang = (EditText) findViewById(R.id.add_fengxiang);
		add_gaowen = (EditText) findViewById(R.id.add_gaowen);
		add_diwen = (EditText) findViewById(R.id.add_diwen);
		add_tianqi = (EditText) findViewById(R.id.add_tianqi);
		
		ok = (Button) findViewById(R.id.add_ok);
		
		ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String wangzhi = add_wangzhi.getText().toString();
				String riqi = add_riqi.getText().toString();
				String fengli = add_fengli.getText().toString();
				String fengxiang = add_fengxiang.getText().toString();
				String gaowen = add_gaowen.getText().toString();
				String diwen = add_diwen.getText().toString();
				String tianqi = add_tianqi.getText().toString();
				
				forecast forecast = new forecast(wangzhi, riqi, fengli, fengxiang, gaowen, diwen, tianqi);
				
				Intent in = new Intent();
				in.putExtra("add", forecast);
				setResult(200, in);
				finish();
			}
		});
	}
}
