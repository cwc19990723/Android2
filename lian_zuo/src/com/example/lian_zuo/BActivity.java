package com.example.lian_zuo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

public class BActivity extends Activity implements OnClickListener {

	private EditText b_ed;
	private Button insert;
	private Button select;
	//private GridView gr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		
		b_ed = (EditText) findViewById(R.id.b_ed);
		insert = (Button) findViewById(R.id.bt_insert);
		select = (Button) findViewById(R.id.bt_select);
		//gr = (GridView) findViewById(R.id.gr);
		
		insert.setOnClickListener(this);
		select.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		String ed = b_ed.getText().toString();
		
		switch (v.getId()) {
		case R.id.bt_insert:
			new MySql(BActivity.this).insert(new User(0, ed));
			break;
		case R.id.bt_select:
			ArrayList<User> list = new MySql(BActivity.this).select();
			StringBuffer sb = new StringBuffer();
			for (User user : list) {
				sb.append(user.toString()+"\n");
			}
			break;

		default:
			break;
		}
	}
}
