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
		//��ť
		Button put1 = (Button) findViewById(R.id.put1);
		//Ϊ��ť���õ���¼�
		put1.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		//�����Ի���
		Builder builder = new AlertDialog.Builder(Ptduihuakuang.this);
		//�����������
		builder.setIcon(R.drawable.ic_launcher)
		.setTitle("�ҵĵ�һ���Ի���")
		.show();
	}
}
