package com.example.day_lian;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EActivity extends Activity {

	private Button bt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_e);
		
		bt = (Button) findViewById(R.id.e_bt);
		
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(EActivity.this)
				.setTitle("��ʾ")
				.setMessage("����,��˯����")
				.setIcon(R.drawable.hj)
				.setPositiveButton("�ǵ�", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(EActivity.this, "˯�ĺ����", Toast.LENGTH_SHORT).show();
					}
				})
				.setNegativeButton("û��", null)
				.create().show();
			}
		});
	}
}
