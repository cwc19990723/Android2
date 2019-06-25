package com.example.lian9;

import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Update extends Activity {

	private EditText up_wangzhi;
	private EditText up_riqi;
	private EditText up_fengli;
	private EditText up_fengxiang;
	private EditText up_gaowen;
	private EditText up_diwen;
	private EditText up_tianqi;
	private Button ok;
	private Intent in;
	private forecast forecast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_xiugai);
		
		up_wangzhi = (EditText) findViewById(R.id.up_wangzhi);
		up_riqi = (EditText) findViewById(R.id.up_riqi);
		up_fengli = (EditText) findViewById(R.id.up_fengli);
		up_fengxiang = (EditText) findViewById(R.id.up_fengxiang);
		up_gaowen = (EditText) findViewById(R.id.up_gaowen);
		up_diwen = (EditText) findViewById(R.id.up_diwen);
		up_tianqi = (EditText) findViewById(R.id.up_tianqi);
		ok = (Button) findViewById(R.id.up_ok);
		
		in = getIntent();
		forecast = (com.example.lian9.forecast) in.getSerializableExtra("up");
		
		up_wangzhi.setText(forecast.getUrl());
		up_riqi.setText(forecast.getDate());
		up_fengli.setText(forecast.getFengli());
		up_fengxiang.setText(forecast.getFengxiang());
		up_gaowen.setText(forecast.getHigh());
		up_diwen.setText(forecast.getLow());
		up_tianqi.setText(forecast.getType());
		
		ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String wangzhi = up_wangzhi.getText().toString();
				String riqi = up_riqi.getText().toString();
				String fengli = up_fengli.getText().toString();
				String fengxiang = up_fengxiang.getText().toString();
				String gaowen = up_gaowen.getText().toString();
				String diwen = up_diwen.getText().toString();
				String tianqi = up_tianqi.getText().toString();
				
				forecast.setUrl(wangzhi);
				forecast.setDate(riqi);
				forecast.setFengli(fengli);
				forecast.setFengxiang(fengxiang);
				forecast.setHigh(gaowen);
				forecast.setLow(diwen);
				forecast.setType(tianqi);
				
				in.putExtra("context", forecast);
				setResult(400, in);
				finish();
			}
		});
		
	}
}
