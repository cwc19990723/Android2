package com.example.day_4_2;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView a_name;
	private Button xiugai;
	private TextView a_phone;
	private TextView a_sex;
	private TextView a_aihao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		a_name = (TextView) findViewById(R.id.a_name);
		a_phone = (TextView) findViewById(R.id.a_phone);
		a_sex = (TextView) findViewById(R.id.a_sex);
		a_aihao = (TextView) findViewById(R.id.a_aihao);
		xiugai = (Button) findViewById(R.id.a_xiugai);
		
		xiugai.setOnClickListener(new View.OnClickListener() {
			
			private AlertDialog dialog;

			@Override
			public void onClick(View v) {
				final View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item, null);
				
				dialog = new AlertDialog.Builder(MainActivity.this).setTitle("标题")
				.setView(view)
				.create();
				dialog.show();
				
				Button it_xiugai = (Button) view.findViewById(R.id.it_xiugai);
				it_xiugai.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						
						 EditText it_name = (EditText) view.findViewById(R.id.it_name);
						 EditText it_phone = (EditText) view.findViewById(R.id.it_phone);
						 RadioButton it_nan = (RadioButton) view.findViewById(R.id.it_nan);
						 CheckBox it_zuqiu = (CheckBox) view.findViewById(R.id.it_zuqiu);
						 RadioButton it_nv = (RadioButton) view.findViewById(R.id.it_nv);
						 CheckBox it_lanqiu = (CheckBox) view.findViewById(R.id.it_lanqiu);
						 
						 String name = it_name.getText().toString();
						 String phone = it_phone.getText().toString();
						 String nan = it_nan.getText().toString();
						 String zuqiu = it_zuqiu.getText().toString();
						 String nv = it_nv.getText().toString();
						 String lanqiu = it_lanqiu.getText().toString();
						 
						 
						 a_phone.setText(phone);
						 a_name.setText(name);
						 a_sex.setText(nan);
						 a_aihao.setText(zuqiu);
						 a_sex.setText(nv);
						 a_aihao.setText(lanqiu);
						 
						 dialog.cancel();
						 /*//性别
						 RadioButton it_nan = (RadioButton) findViewById(R.id.it_nan);
						 String nan = it_nan.getText().toString();
						 a_sex.setText(nan);
						 
						 //爱好
						 CheckBox it_zuqiu = (CheckBox) findViewById(R.id.it_zuqiu);
						 String zuqiu = it_zuqiu.getText().toString();
						 a_aihao.setText(zuqiu);
						 dialog.cancel();*/
					}
				});
				
				Button quxiao = (Button) view.findViewById(R.id.it_quxiao);
				quxiao.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						dialog.cancel();
					}
				});
				
			}
		});
	}
}
