package com.example.day6_intentchuanzhi;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	private Button a_fa;
	private EditText a_edname;
	private EditText a_edage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		a_fa = (Button) findViewById(R.id.a_btfa);
		a_edname = (EditText) findViewById(R.id.a_edname);
		a_edage = (EditText) findViewById(R.id.a_edage);
		
		a_fa.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		//��ȡ���������
		String name = a_edname.getText().toString();
		String age = a_edage.getText().toString();
		
		ArrayList<User> al = new ArrayList<User>();
		
		//ʹ�������������ͱ���Ҫ ���л�  Serializable�ӿ�
		User user = new User(name, Integer.valueOf(age));
		al.add(user);
		
		Intent intent = new Intent(MainActivity.this,BActivity.class);
		
		al.add(new User("С��",17));
		
		//���л� 
		intent.putExtra("1", al);//���Դ���һ���ӿ� ʵ�ʴ����� �ӿڵ�ʵ�������
		
		startActivity(intent);
		
		/*startActivity(new Intent(MainActivity.this,BActivity.class));*/
	}
}
