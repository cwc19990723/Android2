package com.example.day4_tanchuang;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	private Button bt_xz;
	private Button bt_qr;
	private Button bt_qx;
	private AlertDialog create;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bt_xz = (Button) findViewById(R.id.bt_xz);
		
		
		//布局加载器吧xml文件价值为View对象
		View vh = LayoutInflater.from(this).inflate(R.layout.choose_item, null);
		//创建弹窗. AlertDialog
		create = new AlertDialog.Builder(this)
				.setView(vh)
				.create();
		
		bt_qr = (Button) vh.findViewById(R.id.bt_qr);
		bt_qx = (Button) vh.findViewById(R.id.bt_qx);
		
		bt_xz.setOnClickListener(this);
		bt_qr.setOnClickListener(this);
		bt_qx.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_xz:
			create.show();
			break;
		case R.id.bt_qr:
			Toast.makeText(this, "你点击了确认", Toast.LENGTH_SHORT).show();
			create.cancel();
			break;
		case R.id.bt_qx:
			Toast.makeText(this, "你点击了取消", Toast.LENGTH_SHORT).show();
			create.cancel();
			break;
		default:
			break;
		}
	}
}
