package com.example.lian_1;

import android.R.layout;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText a_age;
	private EditText a_name;
	private CheckBox a_lanqiu;
	private CheckBox a_zuqiu;
	private CheckBox a_paiqiu;
	private RadioButton a_nan;
	private RadioButton a_nv;
	private Button zhuce;
	private RadioGroup a_sex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		a_age = (EditText) findViewById(R.id.a_age);
		a_name = (EditText) findViewById(R.id.a_name);
		a_lanqiu = (CheckBox) findViewById(R.id.a_lanqiu);
		a_zuqiu = (CheckBox) findViewById(R.id.a_zuqiu);
		a_paiqiu = (CheckBox) findViewById(R.id.a_paiqiu);
		a_nan = (RadioButton) findViewById(R.id.a_nan);
		a_nv = (RadioButton) findViewById(R.id.a_nv);
		zhuce = (Button) findViewById(R.id.a_zhuce);
		a_sex = (RadioGroup) findViewById(R.id.a_sex);
		
		zhuce.setOnClickListener(new OnClickListener() {
			
			private AlertDialog dialog;

			@Override
			public void onClick(View v) {
				String age = a_age.getText().toString();
				String name = a_name.getText().toString();
				String lanqiu = a_lanqiu.getText().toString();
				String zuqiu = a_zuqiu.getText().toString();
				String paiqiu = a_paiqiu.getText().toString();
				String nan = a_nan.getText().toString();
				String nv = a_nv.getText().toString();
				
				StringBuffer buffer = new StringBuffer();
				
				buffer.append("名字为"+name+"\n");
				
				buffer.append("年龄为"+age+"\n");
				
				buffer.append("我的爱好是:");
				if(a_lanqiu.isChecked()){
					buffer.append(lanqiu+"\n");
				}
				if(a_zuqiu.isChecked()){
					buffer.append(zuqiu+"\n");
				}
				if(a_paiqiu.isChecked()){
					buffer.append(paiqiu+"\n");
				}
				
				buffer.append("我的性别是:");
				if(a_nan.isChecked()){
					buffer.append(nan+"\n");
				}
				if(a_nv.isChecked()){
					buffer.append(nv+"\n");
				}
				
				//Toast.makeText(MainActivity.this, buffer.toString(), Toast.LENGTH_SHORT).show();
				
				View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog, null);
				//名字
				EditText edname = (EditText) view.findViewById(R.id.a_name);
				edname.setText(name);
				//年龄
				EditText edage = (EditText) view.findViewById(R.id.a_age);
				edage.setText(age);
				//
				
				final CheckBox cklan = (CheckBox) view.findViewById(R.id.a_lanqiu);
				CheckBox ckzu = (CheckBox) view.findViewById(R.id.a_zuqiu);
				CheckBox ckpai = (CheckBox) view.findViewById(R.id.a_paiqiu);
				cklan.setChecked(MainActivity.this.a_lanqiu.isChecked());
				ckzu.setChecked(MainActivity.this.a_zuqiu.isChecked());
				ckpai.setChecked(MainActivity.this.a_paiqiu.isChecked());
				//获对话框中的按钮对象
				Button btzhu = (Button) view.findViewById(R.id.a_zhuce);
				
				dialog = new AlertDialog.Builder(MainActivity.this)
				.setView(view)
				.create();
				dialog.show();
				
				btzhu.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						dialog.cancel();
						MainActivity.this.a_lanqiu.setChecked(cklan.isChecked());
					}
				});
				
			}
		});
	}
}
