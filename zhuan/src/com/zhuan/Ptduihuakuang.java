package com.zhuan;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Ptduihuakuang extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.duihuakuang);
		//按钮
		Button put1 = (Button) findViewById(R.id.put1);
		//为按钮设置点击事件
		put1.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		//弹出对话框
		Builder builder = new AlertDialog.Builder(Ptduihuakuang.this);
		//构建本类对象
		builder.setIcon(R.drawable.ic_launcher)
		.setTitle("我的第一个对话框")
		.show();
	}
}
