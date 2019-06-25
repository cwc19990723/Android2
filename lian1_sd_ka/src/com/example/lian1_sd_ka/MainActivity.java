package com.example.lian1_sd_ka;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button bt;
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bt = (Button) findViewById(R.id.bt);
		tv = (TextView) findViewById(R.id.tv);
		
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//�ж���sd�������
				String state = Environment.getExternalStorageState();
				if(Environment.MEDIA_MOUNTED.equals(state)){
					//sd��·��
					File file = Environment.getExternalStorageDirectory();
					getFile(file);
					tv.setText(sb.toString());
				}
			}
		});
	}
	
	private	StringBuilder sb = new StringBuilder();
	
	private void getFile(File file) {
		File[] files = file.listFiles();
		for (File file2 : files) {
			String name = file2.getName();
			if(name.endsWith(".txt")){
				sb.append(name+"\n");
			}else {
				getFile(file2);
			}
		}
	}
}
