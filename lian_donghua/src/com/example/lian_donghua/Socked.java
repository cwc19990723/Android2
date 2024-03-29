package com.example.lian_donghua;

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
import android.widget.RatingBar;
import android.widget.TextView;

public class Socked extends Activity {

	private Button bt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_socked);
		
		final TextView sk_name = (TextView) findViewById(R.id.sk_name);
		final TextView sk_age = (TextView) findViewById(R.id.sk_age);
		final TextView sk_address = (TextView) findViewById(R.id.sk_address);
		final RadioButton sk_nan = (RadioButton) findViewById(R.id.sk_nan);
		final RadioButton sk_nv = (RadioButton) findViewById(R.id.sk_nv);
		final CheckBox sk_lanqiu = (CheckBox) findViewById(R.id.sk_lanqiu);
		final CheckBox sk_zuqiu = (CheckBox) findViewById(R.id.sk_zuqiu);
		final CheckBox sk_yumaoqiu = (CheckBox) findViewById(R.id.sk_yumaoqiu);
		final RatingBar sk_dengji = (RatingBar) findViewById(R.id.sk_dengji);
		
		bt = (Button) findViewById(R.id.sk_bt);
		
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				View view = LayoutInflater.from(Socked.this).inflate(R.layout.dialog, null);
				
				EditText ed_name = (EditText) view.findViewById(R.id.ed_name);
				EditText ed_age = (EditText) view.findViewById(R.id.ed_age);
				EditText ed_address = (EditText) view.findViewById(R.id.ed_address);
				RadioButton rb_nan = (RadioButton) view.findViewById(R.id.rb_nan);
				RadioButton rb_nv = (RadioButton) view.findViewById(R.id.rb_nv);
				CheckBox ck_lanqiu = (CheckBox) view.findViewById(R.id.ck_lanqiu);
				CheckBox ck_zuqiu = (CheckBox) view.findViewById(R.id.ck_zuqiu);
				CheckBox ck_yumaoqiu = (CheckBox) view.findViewById(R.id.ck_yumaoqiu);
				RatingBar rb_dengji = (RatingBar) view.findViewById(R.id.rb_dengji);
				Button bt = (Button) view.findViewById(R.id.bt_bt);
				
				String name = sk_name.getText().toString();
				String age = sk_age.getText().toString();
				String address = sk_address.getText().toString();
				String nan = sk_nan.getText().toString();
				String nv = sk_nv.getText().toString();
				String lanqiu = sk_lanqiu.getText().toString();
				String zuqiu = sk_zuqiu.getText().toString();
				String yumaoqiu = sk_yumaoqiu.getText().toString();
				
				//�Ա�
				if(nan.equals("��")){
					rb_nan.setChecked(true);
				}else {
					rb_nv.setChecked(true);
				}
				//����
				if(lanqiu.contains("����")){
					sk_lanqiu.setChecked(true);
				}
				if(zuqiu.contains("����")){
					sk_zuqiu.setChecked(true);
				}
				if(yumaoqiu.contains("��ë��")){
					sk_yumaoqiu.setChecked(true);
				}
				
				//rb_dengji.setRating(Float.parseFloat(dengJi);
				AlertDialog dialog = new AlertDialog.Builder(Socked.this)
				.setView(view)
				.create();
				dialog.show();
				
				bt.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						
					}
				});
				
			}
		});
	}
}
