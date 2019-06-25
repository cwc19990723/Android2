package com.example.day_xiangmu;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ZhuceActivity extends Activity implements OnClickListener {

	private EditText ed_zhang;
	private EditText ed_mima;
	private Button bt_zhuce;
	
	Handler hand = new Handler(){

		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 1://注册成功跳到主页面
				Intent intent = new Intent(ZhuceActivity.this,GuanggaoActivity.class);
				intent.putExtra("n", name);
				startActivity(intent);
				break;
			case 0:
				Toast.makeText(ZhuceActivity.this, "此用户已经注册", Toast.LENGTH_LONG).show();
				break;
				
			default:
				break;
			}
			
		};
	};
	private String name;
	private EditText ed_qrmm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		
		ed_zhang = (EditText) findViewById(R.id.ed_zhang);
		ed_mima = (EditText) findViewById(R.id.ed_mima);
		ed_qrmm = (EditText) findViewById(R.id.ed_qrmm);
		bt_zhuce = (Button) findViewById(R.id.bt_zhuce);
		
		bt_zhuce.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v) {
		name = ed_zhang.getText().toString();
		String paw = ed_mima.getText().toString();
		String queren = ed_qrmm.getText().toString();
		if(!name.isEmpty()&&!paw.isEmpty()&&!queren.isEmpty()){
			//判断两次密码是否一致
			if(paw.equals(queren)){
				//一致是否 符合 判断密码条件
				if(name.matches("[0-9]{6}")&&paw.matches("[0-9a-zA-Z]{9,18}")){
					//如果符合的话就注册
					zhuceUser(name,paw);
					finish();   
				}else {
					Toast.makeText(ZhuceActivity.this, "格式不正确", Toast.LENGTH_LONG).show();
				}
			}else {
				Toast.makeText(ZhuceActivity.this, "两次密码不一样", Toast.LENGTH_LONG).show();
			}
		}else {
			Toast.makeText(ZhuceActivity.this, "账号或者密码不能为空", Toast.LENGTH_LONG).show();
		}
		
	}
	
	//自定义注册方法
	private void zhuceUser(final String name,final String paw) {
		//1.创建线程
		//2.提交账号密码
		//3.获得响应  注册是否成功
		new Thread(){
			public void run() {
				int what = 0;
				try {
					URL url = new URL("http://192.168.1.34:8080/Store/register");
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					//post 请求提交
					con.setRequestMethod("POST");
					con.setDoOutput(true);//提交
					con.setDoInput(true);
					
					//获取输出流提交数据  提交账号和密码
					OutputStream out = con.getOutputStream();
					//少量数据 拼接字符串
					String path = "user="+name+"psw="+paw;
					out.write(path.getBytes());
					
					//获取响应
					InputStream in = con.getInputStream();
					StringBuffer sb = new StringBuffer();
					byte [] by = new byte [1024];
					int a = 0;
					while ((a=in.read(by))!=-1) {
						sb.append(new String(by,0,a));
					}
					Log.i("msg", "msg"+sb.toString());
					String string = sb.toString();
					
					if(!string.isEmpty()){
						what = Integer.parseInt(string);
					}
					//发送给handleMessage
					hand.sendEmptyMessage(what);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		}.start();
		
	}

}
