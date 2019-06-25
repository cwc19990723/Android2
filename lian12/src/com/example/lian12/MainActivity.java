package com.example.lian12;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.Gson;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import bean.User;
import bean.data;
import bean.datas;

public class MainActivity extends Activity {

	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lv = (ListView) findViewById(R.id.lv_lv);
		
		new Thread(){
			public void run() {
				try {
					URL url = new URL("http://wanandroid.com/article/listproject/0/json");
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					int responseCode = con.getResponseCode();
					if(responseCode==200){
						InputStream in = con.getInputStream();
						StringBuffer sb = new StringBuffer();
						byte [] by = new byte [1024];
						int a = 0;
						while ((a=in.read(by))!=-1) {
							sb.append(new String(by,0,a));
						}
						
						Log.i("msg", "msg"+sb.toString());
						
						Gson gson = new Gson();
						User user = gson.fromJson(sb.toString(), User.class);
						data data = user.getData();
						List<datas> list = data.getDatas();
						
						Log.i("ccc", "ccc"+sb.toString());
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		}.start();
	}
}