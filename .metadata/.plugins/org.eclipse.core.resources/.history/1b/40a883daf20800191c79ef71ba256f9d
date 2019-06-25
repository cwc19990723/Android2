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
		//获取组件的内容
		String name = a_edname.getText().toString();
		String age = a_edage.getText().toString();
		
		ArrayList<User> al = new ArrayList<User>();
		
		//使用引用数据类型必须要 序列化  Serializable接口
		User user = new User(name, Integer.valueOf(age));
		al.add(user);
		
		Intent intent = new Intent(MainActivity.this,BActivity.class);
		
		al.add(new User("小刚",17));
		
		//序列化 
		intent.putExtra("1", al);//可以传递一个接口 实际传的是 接口的实现类对象
		
		startActivity(intent);
		
		/*startActivity(new Intent(MainActivity.this,BActivity.class));*/
	}
}
