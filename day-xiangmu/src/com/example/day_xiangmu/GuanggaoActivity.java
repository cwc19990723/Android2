package com.example.day_xiangmu;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class GuanggaoActivity<E> extends Activity implements OnClickListener{

	private Button bt_shezhi;
	private ListView c_lie;
	private TextView te_te;
	private ArrayList<GuangUser> list;
	private List<GuangUser> lise;
	
	Handler hand = new Handler(){

		private GuangAdapter adapter;

		public void handleMessage(android.os.Message msg) {
			list = (ArrayList<GuangUser>) msg.obj;
			//创建适配器对象
			adapter = new GuangAdapter(GuanggaoActivity.this, list);
			//连接适配器
			c_lie.setAdapter(adapter);
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_c);
		
		te_te = (TextView) findViewById(R.id.te_te);
		Intent intent = getIntent();
		String name = intent.getStringExtra("n");
		
		te_te.setText("欢迎:"+name);
		bt_shezhi = (Button) findViewById(R.id.bt_shezhi);
		c_lie = (ListView) findViewById(R.id.c_lie);
		
		bt_shezhi.setOnClickListener(this);
		
		new Thread(){
			
			public void run() {
				
				/*String json = getJson();
				 lise = JSON.parseArray(json,GuangUser.class);
				 Message message = new Message();
				 message.obj = list;
				 hand.sendMessage(message);*/
				 
				 //GuangAdapter guangAdapter = new GuangAdapter(GuanggaoActivity.this, list);
			}

			private String getJson() {
				try {
					URL url = new URL("http://192.168.1.52:8080/test1/json.txt");
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					int re = con.getResponseCode();
					if(re==200){
						InputStream in = con.getInputStream();
						StringBuffer sb = new StringBuffer();
						byte [] by = new byte [1024];
						int a =0;
						while ((a=in.read(by))!=-1) {
							sb.append(new String(by,0,a));
						}
						
						GuangUser pa = JSON.parseObject(sb.toString(),GuangUser.class);
						
						Message msg = new Message();
						msg.obj = pa;
						
						hand.sendMessage(msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return null;
			};
		}.start();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_shezhi:
			bt_shezhi();
			break;

		default:
			break;
		}
	}

	private void bt_shezhi() {
		startActivity(new Intent(this,DActivity.class));
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Toast.makeText(GuanggaoActivity.this, "登陆成功", Toast.LENGTH_LONG).show();
	}
}
